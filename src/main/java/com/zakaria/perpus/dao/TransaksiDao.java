/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.dao;

import com.zakaria.perpus.KoneksiDatabase;
import com.zakaria.perpus.model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author namhee
 */
public class TransaksiDao {

    public void pinjamBuku(Transaksi transaksi) throws SQLException {

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();
        koneksi.setAutoCommit(false);

        String sql = "insert into perpus.transaksi (buku_id,pengunjung_id,tanggal_pinjam) values (?,?,now())";

        PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
        preparedStatement.setInt(1, transaksi.getBuku().getId());
        preparedStatement.setInt(2, transaksi.getPengunjung().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        sql = "update perpus.buku set jumlah_buku = ? where id = ?";
        preparedStatement = koneksi.prepareStatement(sql);
        preparedStatement.setInt(1, transaksi.getBuku().getJumlahBuku()-1);
        preparedStatement.setInt(2, transaksi.getBuku().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        koneksi.commit();
        koneksi.close();
    }

}
