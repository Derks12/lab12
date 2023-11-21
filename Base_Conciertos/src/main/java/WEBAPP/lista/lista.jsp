<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Base_Conciertos.Beans.Artistas" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaArtistas" type="java.util.ArrayList<com.example.Base_Conciertos.Beans.Artistas>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <title>Lista artistas</title>
</head>
<body>
<div class='container'>

    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Lista de artistas</h1>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre del Grupo</th>
            <th>Fecha de Creacion</th>
            <th>Tipo de música</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (Artistas e : listaArtistas) {
        %>
        <tr>
            <td><%= i%>
            </td>
            <td><%= e.getNombre_Grupo()%>
            </td>
            <td><%= e.getFecha_Creacion()%>
            </td>
            <td><%= e.getTipo_musica()%>
            <td>
                <a href="<%=request.getContextPath()%>/ArtistasServlet?action=editar&id=<%= e.getIdArtistas()%>"
                   type="button" class="btn btn-primary">
                    <i class="bi bi-pencil-square"></i>
                </a>
            </td>
            <td>
                <a onclick="return confirm('¿Estas seguro de borrar?');"
                   href="<%=request.getContextPath()%>/ArtistasServlet?action=borrar&id=<%= e.getIdArtistas()%>"
                   type="button" class="btn btn-danger">
                    <i class="bi bi-trash"></i>
                </a>
            </td>
        </tr>
        <%
                i++;
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
