package com.example.lab3141.Daos;

import com.example.lab3141.Beans.Artistas;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class ArtistasDao extends DaoBase{

    public ArrayList<Artistas> listaArtistas(){
        ArrayList<Artistas> listaArtistas = new ArrayList<>();
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM artistas")) {

            while (rs.next()){
                Artistas artistas = new Artistas();
                artistas.setIdArtistas(rs.getInt(1));
                artistas.setNombre_Grupo(rs.getString(2));
                artistas.setFecha_Creacion(rs.getDate(3));
                artistas.setTipo_musica(rs.getString(4));
                listaArtistas.add(artistas);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaArtistas;
    }

    public Artistas obtenerArtistas(int artistasId){
        Artistas artistas = null;
        String sql = "Select * FROM artistas"+
                "WHERE idArtistas = ? ";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, artistasId);

            try (ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    artistas = new Artistas();
                    artistas.setIdArtistas(rs.getInt(1));
                    artistas.setNombre_Grupo(rs.getString(2));
                    artistas.setFecha_Creacion(rs.getDate(3));
                    artistas.setTipo_musica(rs.getString(4));
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return artistas;
    }

    public void borrarArtista(int artistaId) throws SQLException{
        String sql =  "Delete FROM artistas WHERE idArtistas = ?";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, artistaId);
            pstmt.executeUpdate();
        }

    }
}