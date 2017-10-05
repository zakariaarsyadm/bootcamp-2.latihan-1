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
public class BukuDao {

    public void save(Buku buku) throws SQLException {
        KoneksiDatabase koneksiDb = new KoneksiDatabase();
        DataSource datasource = koneksiDb.getDataSource();
        Connection connection = datasource.getConnection();

        String sql = "insert into perpus.buku (judul_buku,tahun_terbit,pengarang,jumlah_buku) values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, buku.getJudulBuku());
        statement.setInt(2, buku.getTahunTerbit());
        statement.setString(3, buku.getPengarang());
        statement.setInt(4, buku.getJumlahBuku());

//        statement.setString(1, "Belajar Memilih");
//        statement.setInt(2, 2013);
//        statement.setString(3, "Jakarta");
//        statement.setInt(4,10);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Buku buku) throws SQLException {
        KoneksiDatabase koneksiDb = new KoneksiDatabase();
        DataSource datasource = koneksiDb.getDataSource();
        Connection connection = datasource.getConnection();

        String sql = "update perpus.buku set judul_buku = ?, pengarang = ?, jumlah_buku = ?, tahun_terbit = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, buku.getJudulBuku());
        statement.setInt(4, buku.getTahunTerbit());
        statement.setString(2, buku.getPengarang());
        statement.setInt(3, buku.getJumlahBuku());
        statement.setInt(5, buku.getId());

//        statement.setString(1, "Belajar Memilih");
//        statement.setInt(2, 2013);
//        statement.setString(3, "Jakarta");
//        statement.setInt(4,10);
        statement.executeUpdate();
        statement.close();
        connection.close();

    }

    public void delete(Integer idBuku) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        String sql = "delete from perpus.buku where id = ?";
        PreparedStatement statement = koneksi.prepareStatement(sql);

        statement.setInt(1, idBuku);

        statement.executeUpdate();
        statement.close();
        koneksi.close();

    }

    public List<Buku> findAll() throws SQLException {
        List<Buku> listBuku = new ArrayList<>();

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        String sql = "select id,judul_buku,tahun_terbit,pengarang,jumlah_buku from perpus.buku";
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
//            System.out.println(resultSet.getInt("id"));
            //mengambil data dari database
            Buku buku = new Buku();
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));

            listBuku.add(buku); //menyimpan ke variabel listBuku
        }

        resultSet.close();
        statement.close();
        koneksi.close();

        return listBuku;
    }

    public Buku findById(Integer idBuku) throws SQLException {
//        List<Buku> listBuku = new ArrayList<>();

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        String sql = "select id,judul_buku,tahun_terbit,pengarang,jumlah_buku from perpus.buku where id = ?";
        PreparedStatement statement = koneksi.prepareStatement(sql);
        statement.setInt(1, idBuku);
        ResultSet resultSet = statement.executeQuery();
        Buku buku = new Buku();

        if (resultSet.next()) {
//            System.out.println(resultSet.getInt("id"));
            //mengambil data dari database

            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));

//            listBuku.add(buku); //menyimpan ke variabel listBuku
        }

        resultSet.close();
        statement.close();
        koneksi.close();

        return buku;
    }
}
