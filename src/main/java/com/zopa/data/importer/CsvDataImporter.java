/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zopa.data.importer;

import com.zopa.data.entities.Lender;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmerida
 */
public class CsvDataImporter implements DataImporter {

    private static final String COMMA_DELIMITER = ",";
    private static final Logger logger = Logger.getLogger(CsvDataImporter.class.getName());

    @Override
    public List<Lender> importData(String dataSourcePath) throws DataImportException {
        List<Lender> lendersData = new ArrayList<>();
        File dataSourceFile = new File(dataSourcePath);
        Scanner scanner = null;
        Scanner dataScanner = null;
        try {
            scanner = new Scanner(dataSourceFile);
            int index = 0;
            int id = 1;

            scanner.nextLine();
            while (scanner.hasNextLine()) {
                dataScanner = new Scanner(scanner.nextLine());
                dataScanner.useDelimiter(COMMA_DELIMITER);
                Lender lender = new Lender();

                while (dataScanner.hasNext()) {
                    String data = dataScanner.next();
                    if (index == 0) {
                        lender.setName(data);
                    } else if (index == 1) {
                        lender.setRate(new BigDecimal(data));
                    } else if (index == 2) {
                        lender.setAvailable(Integer.valueOf(data));
                    } else {
                        String invalidaDataMessage = "Invalid data:" + data;
                        logger.log(Level.SEVERE, invalidaDataMessage);
                        throw new DataImportException();
                    }
                    index++;
                }
                index = 0;
                lender.setId(id);
                lendersData.add(lender);
                id++;
            }
            System.out.println(lendersData);
        } catch (FileNotFoundException | NumberFormatException e) {
            logger.log(Level.SEVERE, null, e);
            throw new DataImportException();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (dataScanner != null) {
                dataScanner.close();
            }
        }
        return lendersData;
    }

}
