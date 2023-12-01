/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.habitacion;
import util.MySQLConexion;

/**
 *
 * @author idmr_
 */
public class daoHabitacion {
    
    //PARA OBTENER EL LISTADO DE TODAS LAS HABITACIONES
    public List<habitacion> listarHab() {
        List<habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from habitaciones";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                habitacion h = new habitacion();
                h.setHab_codigo(rs.getString(1));
                h.setHab_tipo(rs.getString(2));
                h.setHab_estado(rs.getString(3));
                lista.add(h);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //PARA AGREGAR UNA HABITACION
    public String agregarHab(habitacion habi) {
        Connection cn = MySQLConexion.getConexion();
        String hab = "";
        try {
            String sql = "{call habAgregar(?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, habi.getHab_tipo());
            st.setString(2, habi.getHab_estado());
            ResultSet rs = st.executeQuery();
            rs.next(); //Para leer el numero de habitacion
            hab = rs.getString(1); //Para grabar el numero de habitacion
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hab;
    }

    //PARA OBTENER EL LISTADO DE HABITACIONES DISPONIBLES
    public List<habitacion> listarHabDispo() {
        List<habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from habitaciones where hab_estado='Disponible'";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                habitacion h = new habitacion();
                h.setHab_codigo(rs.getString(1));
                h.setHab_tipo(rs.getString(2));
                h.setHab_estado(rs.getString(3));
                lista.add(h);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //PARA OBTENER UNA HABITACION POR CODIGO
    public habitacion buscarHabCod(String cod) {
        habitacion h = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from habitaciones where hab_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                h = new habitacion();
                h.setHab_codigo(rs.getString(1));
                h.setHab_tipo(rs.getString(2));
                h.setHab_estado(rs.getString(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return h;
    }

    //PARA MODIFICAR UNA HABITACION EN SU TIPO Y ESTADO
    public void modificarHab(String tipo, String estado, String cod) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update habitaciones set hab_tipo=?,hab_estado=? where hab_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, tipo);
            st.setString(2, estado);
            st.setString(3, cod);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //MODIFICAR EL PRECIO DE LAS HABITACIONES
    public void modificarPrecioHab(double pre, String tipo) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update preciohabitaciones hab_precio=? where hab_tipo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setDouble(1, pre);
            st.setString(2, tipo);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    //PARA LIBERAR UNA HABITACION
    public void liberarHab(String cod) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update habitaciones set hab_estado='Disponible' where hab_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<habitacion> filtraHabitacion(String cad) {
        List<habitacion> lista = new ArrayList();
        String sql = "select hab_codigo, hab_tipo,hab_estado from habitaciones where hab_codigo like ?";
        try {
            PreparedStatement st = MySQLConexion.getConexion().prepareStatement(sql);
            st.setString(1, cad + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                habitacion h = new habitacion(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                lista.add(h);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    //PARA CONSULTAR EL PRECIO DE UNA HABITACION POR TIPO
    public double precioHab(String tipo){
        double precio=0;
        Connection cn = MySQLConexion.getConexion();
        try{
            String sql = "select hab_precio from preciohabitaciones where hab_tipo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, tipo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                precio = rs.getDouble(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        return precio;
    }
}
