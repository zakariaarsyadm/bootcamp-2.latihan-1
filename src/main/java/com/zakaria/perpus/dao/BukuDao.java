/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.dao;

import com.zakaria.perpus.KoneksiDatabase;
import com.zakaria.perpus.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author namhee
 */
public class BukuDao {

    public void save() throws SQLException {
        KoneksiDatabase koneksiDb = new KoneksiDatabase();
        DataSource datasource = koneksiDb.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql = "insert into perpus.buku (judul_buku,tahun_terbit,pengarang,jumlah_buku) values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, "Belajar Java Coding");
        statement.setInt(2, 2017);
        statement.setString(3, "Bandung");
        statement.setInt(4,4);
        
        statement.setString(1, "Belajar Memilih");
        statement.setInt(2, 2013);
        statement.setString(3, "Jakarta");
        statement.setInt(4,10);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update() {

    }

    public void delete() {

    }

    public List<Buku> findAll() {
        return null;
    }

    public Buku findById(Integer idBuku) {
        return null;
    }
}
