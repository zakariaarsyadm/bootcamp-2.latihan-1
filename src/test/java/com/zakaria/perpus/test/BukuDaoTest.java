/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.test;

import com.zakaria.perpus.dao.BukuDao;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author namhee
 */
public class BukuDaoTest extends TestCase {
//    private BukuDao bukuDao ; ->nullPointerException
    private BukuDao bukuDao = new BukuDao();
    
    @Test
    public void testSaveDataBuku() throws SQLException {
//        bukuDao.save();
    }

}
