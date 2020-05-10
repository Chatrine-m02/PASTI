<%-- 
    Document   : index
    Created on : May 6, 2020, 11:04:52 AM
    Author     : ITD
--%>

<%@include file="header.jsp" %>
<h1>Halaman Mahasiswa</h1>
 <a href="tambah-mhs.jsp"><button class="btn-success">Tambah Mahasiswa</button></a>
    <table class="table table-bordered">
    <thead>
        <tr>
            <th>NIM</th>
            <th>Nama</th>
            <th>Jurusan</th>
            <th>Email</th>
            <th>Alamat</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <%-- start web service invocation --%>
                <hr />
                <%
    try {
     client.siakad.Mahasiswa_Service service = new client.siakad.Mahasiswa_Service();
     client.siakad.Mahasiswa port = service.getMahasiswaPort();
     // TODO process result here
     java.util.List<java.lang.Object> resultMhs = port.tampilMahasiswa();
     for (int i = 0; i < resultMhs.size(); i++) {
      out.println(resultMhs.get(i));
     }
    } catch (Exception ex) {
     // TODO handle custom exceptions here
    }
    %>
                <%-- end web service invocation --%>
                <hr />
        </tr>
    </tbody>
</table>
<%@include file="footer.jsp" %>