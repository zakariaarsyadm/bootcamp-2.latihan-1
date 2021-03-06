/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.perpus.controller;

import com.zakaria.perpus.dao.BukuDao;
import com.zakaria.perpus.model.Buku;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = "/buku/ubah")
public class BukuUpdateController extends HttpServlet {

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
//            out.println("<title>Servlet BukuUpdateController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet BukuUpdateController at " + request.getContextPath() + "</h1>");
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
            Integer kodeBuku = Integer.valueOf(req.getParameter("kodeBuku"));
            Buku sebuahBuku = new BukuDao().findById(kodeBuku);

            req.setAttribute("buku", sebuahBuku);
            req.getRequestDispatcher("/buku/editBuku.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(BukuUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
        Buku buku = new Buku();
        buku.setId(Integer.valueOf(req.getParameter("id")));
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
//        System.out.println("POST METHOD");
        System.out.println(buku.toString());

        BukuDao bukuDao = new BukuDao();
        try {
            bukuDao.update(buku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuAddController.class.getName()).log(Level.SEVERE, null, ex);

        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/buku/");
//        resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath().));
        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
//        @Override
//        public String getServletInfo
//        
//            () {
//        return "Short description";
//        }// </editor-fold>}
    }
}
