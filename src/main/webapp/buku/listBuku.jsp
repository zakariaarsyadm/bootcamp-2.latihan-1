

<%@page isELIgnored = "false" contentType="text/html" pageEncoding="UTF-8" language="java"  %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Buku</title>
    </head>
    <body>
       <table>
           <thead>
               <tr>
                   <td>No</td>
                   <td>Judul Buku</td>
                   <td>Tahun Terbit</td>
                   <td>Jumlah Buku</td>
                   <td>Nama Pengarang</td>
                   <td>Aksi</td>
               </tr>
           </thead>
           <tbody>
               <c:forEach items="${listBuku}" var="sebuahBuku" varStatus="index">
                <tr>
                        <td>${index.count}</td>
                        <td>${sebuahBuku.judulBuku}</td>
                        <td>${sebuahBuku.tahunTerbit}</td>
                        <td>${sebuahBuku.jumlahBuku}</td>
                        <td>${sebuahBuku.pengarang}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/buku/delete?kodeBuku=${sebuahBuku.id}">Hapus</a></td>
                        <td><a href="${pageContext.servletContext.contextPath}/buku/ubah?kodeBuku=${sebuahBuku.id}">Ubah</a></td>
                    </tr>
           </c:forEach>
               
               
           </tbody>
           
       </table>
       
    </body>
</html>
