package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.Beans.Artistas;
import com.example.Base_Conciertos.Daos.ArtistasDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet (name = "ArtistasServlet", urlPatterns = {"/ArtistasServlet"})
public class ArtistasController extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        ArtistasDao artistasDao = new ArtistasDao();

        switch (action) {

            case "lista":
                request.setAttribute("listasArtistas", artistasDao.listaArtistas());
                view = request.getRequestDispatcher("artistas/lista.jsp");
                view.forward(request, response);
                break;
            case "editar":
                if (request.getParameter("id") != null) {
                    String artistaIdString = request.getParameter("id");
                    int artistaId = 0;
                    try {
                        artistaId = Integer.parseInt(artistaIdString);
                    } catch (NumberFormatException e) {
                        response.sendRedirect("ArtistasServlet");
                    }

                    Artistas artistas = artistasDao.obtenerArtistas(artistaId);

                    if (artistas != null) {
                        request.setAttribute("Nombre_Grupo", artistas);

                        view = request.getRequestDispatcher("artistas/formularioEditar.jsp");
                        view.forward(request, response);


                    } else {
                        response.sendRedirect("ArtistasServlet");
                    }
                } else {
                    response.sendRedirect("ArtistasServlet");
                }
                break;
            case ("borrar"):
                if (request.getParameter("id") != null) {
                    String artistaIdString = request.getParameter("id");
                    int artistaId = 0;
                    try {
                        artistaId = Integer.parseInt(artistaIdString);
                    } catch (NumberFormatException e) {
                        response.sendRedirect("ArtistasServlet");
                    }

                    Artistas artistas = artistasDao.obtenerArtistas(artistaId);

                    if (artistas != null) {
                        try {
                            artistasDao.borrarArtista(artistaId);
                            request.getSession().setAttribute("err", "Artista borrado");
                        } catch (SQLException e) {
                            request.getSession().setAttribute("err", "Error al borrar el artista");
                            e.printStackTrace();
                        }
                        response.sendRedirect(request.getContextPath() + "/ArtistasServlet");

                    }
                } else {
                    response.sendRedirect("ArtistasServlet");
                }
                break;


        }

    }
}
