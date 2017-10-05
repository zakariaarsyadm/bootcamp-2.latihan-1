<%-- 
    Document   : editBuku
    Created on : Oct 5, 2017, 11:34:39 AM
    Author     : namhee
--%>

<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language = "java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Buku</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/buku/ubah" method="post">
            <input type="hidden" name="id" value="${buku.id}">
            <div>
                <label for="judulBuku">Judul Buku</label>
                <input type="text" name="judulBuku" id="judulBuku" value="${buku.judulBuku}" />
            </div>
            <div>
                <label for="tahunTerbit">Tahun Terbit</label>
                <input type="number" name="tahunTerbit" id="tahunTerbit" value="${buku.tahunTerbit}"/>
            </div>
            <div>
                <label for="pengarang">Pengarang</label>
                <input type="text" name="pengarang" id="pengarang" value="${buku.pengarang}" />
            </div>
            <div>
                <label for="jumlahBuku">Jumlah Buku</label>
                <input type="text" name="jumlahBuku" id="jumlahBuku" value="${buku.jumlahBuku}"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
