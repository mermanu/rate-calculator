/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zopa.data.importer;

import com.zopa.data.entities.Lender;
import java.util.List;

/**
 *
 * @author manuelmerida
 */
public interface DataImporter {

    List<Lender> importData(String dataSourcePath) throws DataImportException;
}
