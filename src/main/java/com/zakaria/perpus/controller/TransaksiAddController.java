/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.controller;

import com.zakaria.perpus.dao.BukuDao;
import com.zakaria.perpus.dao.PengunjungDao;
import com.zakaria.perpus.dao.TransaksiDao;
import com.zakaria.perpus.model.Buku;
import com.zakaria.perpus.model.Pengunjung;
import com.zakaria.perpus.model.Transaksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author namhee
 */
@WebServlet(urlPatterns = {"/transaksi/pinjam"})
public class TransaksiAddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TransaksiAddController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TransaksiAddController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<Buku> listBuku;
            listBuku = new BukuDao().findAll();
            List<Pengunjung> listPengunjung = new PengunjungDao().findAll();

            req.setAttribute("listBuku", listBuku);
            req.setAttribute("listPengunjung", listPengunjung);
            req.getRequestDispatcher("/transaksi/addTransaksi.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        processRequest(request, response);
        Transaksi transaksi = new Transaksi();

        try {
            Integer bukuId = Integer.valueOf(req.getParameter("bukuId"));
            transaksi.setBuku(new BukuDao().findById(bukuId));
            System.out.println(transaksi.getBuku().toString());
//            Buku buku = transaksi.getBuku();

            Integer pengunjungId = Integer.valueOf(req.getParameter("pengunjungId"));
            transaksi.setPengunjung(new PengunjungDao().findById(pengunjungId));
            new TransaksiDao().pinjamBuku(transaksi);
            
            resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/transaksi/list").toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
