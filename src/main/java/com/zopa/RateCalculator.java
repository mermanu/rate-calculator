/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zopa;

import com.zopa.data.importer.CsvDataImporter;
import com.zopa.data.importer.DataImportException;
import com.zopa.data.importer.DataImporter;

/**
 *
 * @author manuelmerida
 */
public class RateCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DataImportException {
        
        DataImporter dataImporter = new CsvDataImporter();
        dataImporter.importData(args[1]);
    }
    
}
