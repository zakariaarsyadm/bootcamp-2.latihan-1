<%-- 
    Document   : tambahBuku
    Created on : Oct 4, 2017, 4:31:52 PM
    Author     : namhee
--%>

<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language = "java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Buku</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/buku/new" method="post">

            <div>
                <label for="judulBuku">Judul Buku</label>
                <input type="text" name="judulBuku" id="judulBuku" />
            </div>
            <div>
                <label for="tahunTerbit">Tahun Terbit</label>
                <input type="number" name="tahunTerbit" id="tahunTerbit"/>
            </div>
            <div>
                <label for="pengarang">Pengarang</label>
                <input type="text" name="pengarang" id="pengarang" />
            </div>
            <div>
                <label for="jumlahBuku">Jumlah Buku</label>
                <input type="text" name="jumlahBuku" id="jumlahBuku"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
