<%-- 
    Document   : edit-mhs
    Created on : May 6, 2020, 12:01:01 PM
    Author     : ITD
--%>

<%@include file="header.jsp" %>
<div class="container">
    <h3>Form Edit Mahasiswa</h3>
    <form class="form-horizontal" method="post" action="proses-edit-mhs.jsp">
        <%
   try {
    client.siakad.Mahasiswa_Service service = new client.siakad.Mahasiswa_Service();
    client.siakad.Mahasiswa port = service.getMahasiswaPort();
    int nim = Integer.valueOf(request.getParameter("nim"));
    java.util.List<java.lang.Object> result = port.getMahasiswa(nim);
    for (int i = 0; i < result.size(); i++) {
     out.println(result.get(i));
    }
   } catch (Exception ex) {
   }
  %>
        <button type="submit" class="btn btn-danger">Edit</button>
    </form>
</div>
<%@include file="footer.jsp" %>