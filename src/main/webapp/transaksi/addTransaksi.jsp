<%-- 
    Document   : addTransaksi
    Created on : Oct 5, 2017, 2:25:25 PM
    Author     : namhee
--%>

<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Peminjaman Buku</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/transaksi/pinjam" method="post">
            <div>
                <label for="bukuId">Pilih Buku</label>
                <select name="bukuId" id="bukuId">
                    <c:forEach items="${listBuku}" var="b">
                        <option value="${b.id}">${b.judulBuku} (${b.jumlahBuku})</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="pengunjungId">Pilih Pengunjung</label>
                <select name="pengunjungId" id="pengunjungId">
                    <c:forEach items="${listPengunjung}" var="p">
                        <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>


            <div>
                <button type="submit">submit</button>
                <button type="reset">reset</button>
            </div>
        </form>
    </body>
</html>
