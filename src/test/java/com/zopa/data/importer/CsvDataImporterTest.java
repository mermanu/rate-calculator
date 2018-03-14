/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zopa.data.importer;

import com.zopa.data.entities.Lender;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author manuelmerida
 */
public class CsvDataImporterTest {

    private DataImporter dataImporter;
    private String dataSourcePath;
    private List<Lender> expResult;
    private static final String DATA_FOLDER = "/data";
    private static final String MARKET_DATA_GOOD_FORMAT_FILE = "/MarketDataGF.csv";
    private static final String MARKET_DATA_BAD_FORMAT_FILE = "/MarketDataBF.csv";
    private static final String MARKET_DATA_INVALID_DATA = "/MarketDataID.csv";
    private static final String MARKET_DATA_NOT_EXIST = "/MarketDataNotExist";

    public CsvDataImporterTest() {
    }

    @Before
    public void setUp() {
        dataImporter = new CsvDataImporter();
        File file = new File("");
        dataSourcePath = file.getAbsolutePath() + DATA_FOLDER;

        expResult = new ArrayList<>();
        expResult.add(new Lender(1, "Bob", new BigDecimal("0.075"), 640));
        expResult.add(new Lender(2, "Jane", new BigDecimal("0.069"), 480));
        expResult.add(new Lender(3, "Fred", new BigDecimal("0.071"), 520));
        expResult.add(new Lender(4, "Mary", new BigDecimal("0.104"), 170));
        expResult.add(new Lender(5, "John", new BigDecimal("0.081"), 320));
        expResult.add(new Lender(6, "Dave", new BigDecimal("0.074"), 140));
        expResult.add(new Lender(7, "Angela", new BigDecimal("0.071"), 60));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of importData method, of class CsvDataImporter.
     */
    @Test
    public void testImportDataFromCsvFileAndFormatProvided() throws Exception {
        List<Lender> result = dataImporter.importData(dataSourcePath + MARKET_DATA_GOOD_FORMAT_FILE);
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    @Test
    public void testImportDataFromCsvFileAndWrongFormat() throws Exception {
        DataImportException assertThrows = Assertions.assertThrows(DataImportException.class,
                () -> dataImporter.importData(dataSourcePath + MARKET_DATA_BAD_FORMAT_FILE));
    }

    @Test
    public void testImportDataFromCsvAndFileNotFound() throws Exception {
        DataImportException assertThrows = Assertions.assertThrows(DataImportException.class,
                () -> dataImporter.importData(dataSourcePath + MARKET_DATA_NOT_EXIST));
    }

    @Test
    public void testImportDataFromCsvAndInvalidData() throws Exception {
        DataImportException assertThrows = Assertions.assertThrows(DataImportException.class,
                () -> dataImporter.importData(dataSourcePath + MARKET_DATA_INVALID_DATA));
    }

}
