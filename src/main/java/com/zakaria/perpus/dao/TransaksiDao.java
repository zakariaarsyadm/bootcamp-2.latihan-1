/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.dao;

import com.zakaria.perpus.KoneksiDatabase;
import com.zakaria.perpus.model.Buku;
import com.zakaria.perpus.model.Pengunjung;
import com.zakaria.perpus.model.Transaksi;
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
        preparedStatement.setInt(1, transaksi.getBuku().getJumlahBuku() - 1);
        preparedStatement.setInt(2, transaksi.getBuku().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        koneksi.commit();
        koneksi.close();
    }

    public List<Transaksi> daftarTransaksi() throws SQLException {

        String sql = "SELECT \n"
                + "b.id as id_buku,\n"
                + "b.judul_buku as judul_buku,\n"
                + "b.jumlah_buku as jumlah_buku,\n"
                + "b.tahun_terbit as tahun_terbit, \n"
                + "b.pengarang as nama_pengarang,\n"
                + "p.id as id_pengunjung,\n"
                + "p.nama as nama_pengunjung,\n"
                + "p.alamat as alamat_pengunjung,\n"
                + "t.id as id_transaksi,\n"
                + "t.tanggal_pinjam as tanggal pinjam,\n"
                + "t.tanggal_kembali as tanggal_kembali\n"
                + "FROM perpus.buku b\n"
                + "join perpus.transaksi t on b.id = t.buku_id\n"
                + "join perpus.pengunjung p on t.pengunjung_id = p.id";

        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection koneksi = dataSource.getConnection();

        List<Transaksi> listTransaksi = new ArrayList<>();
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Transaksi transaksi = new Transaksi();

            transaksi.setBuku(new Buku(
                    resultSet.getInt("id_buku"),
                    resultSet.getString("judul_buku"),
                    resultSet.getInt("tahun_terbit"),
                    resultSet.getString("nama_pengarang"),
                    resultSet.getInt("jumlah_buku")));

            transaksi.setPengunjung(new Pengunjung(
                    resultSet.getInt("id_pengunjung"),
                    resultSet.getString("nama_pengunjung"),
                    resultSet.getString("alamat_pengunjung")));

            transaksi.setId(resultSet.getInt("id_transaksi"));
            transaksi.setTanggal_pinjam(resultSet.getDate("tanggal_pinjam"));
            transaksi.setTanggal_kembali(resultSet.getDate("tanggal_kembali"));

            listTransaksi.add(transaksi);
        }
        
        resultSet.close();
        statement.close();
        koneksi.close();

        return listTransaksi;
    }

}
