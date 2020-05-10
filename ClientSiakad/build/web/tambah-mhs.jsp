<%-- 
    Document   : tambah-mhs
    Created on : May 6, 2020, 11:18:28 AM
    Author     : ITD
--%>

<%@include file="header.jsp" %>
<div class="container">
    <h3>Form Tambah Mahasiswa</h3>
    <form class="form-horizontal" method="post" action="proses-tambah-mhs.jsp">
        <div class="form-group">
            <label class="control-label col-sm-1">NIM</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="nim">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-1">Nama</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="nama">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-1">Jurusan</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="jurusan">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-1">Email</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-1">Alamat</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="alamat">
            </div>
        </div>
        <button type="submit" class="btn btn-danger">Simpan</button>
    </form>
</div>
<%@include file="footer.jsp" %>
