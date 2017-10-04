/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.model;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author namhee
 */
@Data
public class Transaksi {

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Buku getBuku() {
//        return buku;
//    }
//
//    public void setBuku(Buku buku) {
//        this.buku = buku;
//    }
//
//    public Pengunjung getPengunjung() {
//        return pengunjung;
//    }
//
//    public void setPengunjung(Pengunjung pengunjung) {
//        this.pengunjung = pengunjung;
//    }
//
//    public Date getTanggal_pinjam() {
//        return tanggal_pinjam;
//    }
//
//    public void setTanggal_pinjam(Date tanggal_pinjam) {
//        this.tanggal_pinjam = tanggal_pinjam;
//    }
//
//    public Date getTanggal_kembali() {
//        return tanggal_kembali;
//    }
//
//    public void setTanggal_kembali(Date tanggal_kembali) {
//        this.tanggal_kembali = tanggal_kembali;
//    }
    
    private Integer id;
    private Buku buku;
    private Pengunjung pengunjung;
    private Date tanggal_pinjam;
    private Date tanggal_kembali;
    
}
