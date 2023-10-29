/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Habitacion;
import util.MySQLConexion;

/**
 *
 * @author idmr_
 */
public class daoHabitacion {
    
    //PARA OBTENER EL LISTADO DE TODAS LAS HABITACIONES
    public List<Habitacion> listarHab() {
        List<Habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from habitaciones";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Habitacion h = new Habitacion();
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
    public String agregarHab(String tipo, String estado) {
        Connection cn = MySQLConexion.getConexion();
        String hab = "";
        try {
            String sql = "{call habAgregar(?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, tipo);
            st.setString(2, estado);
            ResultSet rs = st.executeQuery();
            rs.next(); //Para leer el numero de habitacion
            hab = rs.getString(1); //Para grabar el numero de habitacion
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hab;
    }

    //PARA OBTENER EL LISTADO DE HABITACIONES DISPONIBLES
    public List<Habitacion> listarHabDispo() {
        List<Habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from habitaciones where hab_estado='Disponible'";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Habitacion h = new Habitacion();
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
    public Habitacion buscarHabCod(String cod) {
        Habitacion h = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from habitaciones where hab_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                h = new Habitacion();
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

    /*
    //PARA OCUPAR UNA HABITACION
    public void OcuparHab(String cod){
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="update habitaciones set hab_estado='Ocupada' where hab_codigo=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1,cod);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     */
}
