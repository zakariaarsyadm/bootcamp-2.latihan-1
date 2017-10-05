/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.dao;

import com.zakaria.perpus.KoneksiDatabase;
import com.zakaria.perpus.model.Buku;
import com.zakaria.perpus.model.Pengunjung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author namhee
 */
public class PengunjungDao {

    public void save(Pengunjung pengunjung) {

    }

    public void update(Pengunjung pengunjung) {

    }

    public void hapus(Pengunjung pengunjung) {

    }

    public List<Pengunjung> findAll() throws SQLException {

        List<Pengunjung> listPengunjung = new ArrayList<>();

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        String sql = "select id,nama,alamat from perpus.pengunjung";
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Pengunjung pengunjung = new Pengunjung();
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
            listPengunjung.add(pengunjung);
        }

        resultSet.close();
        statement.close();
        koneksi.close();

        return listPengunjung;

    }

    

    public Pengunjung findById(Integer pengunjungId) throws SQLException {

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        String sql = "select id,nama,alamat from perpus.pengunjung where id = ?";
        
        PreparedStatement statement = koneksi.prepareStatement(sql);
        statement.setInt(1, pengunjungId);
        ResultSet resultSet = statement.executeQuery();
        
        Pengunjung pengunjung = new Pengunjung();
        if (resultSet.next()) {

            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));

        }

        resultSet.close();
        statement.close();
        koneksi.close();

        return pengunjung;
    }

}
