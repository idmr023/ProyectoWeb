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
import modelo.Alquiler;
import util.MySQLConexion;

public class daoAlquiler {
    
    //PARA OBTENER EL LISTADO DE ALQUILERES
    public List<Alquiler> listarAlq() {
        List<Alquiler> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from alquileres";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alquiler a = new Alquiler();
                a.setAlq_codigo(rs.getString(1));
                a.setHab_codigo(rs.getString(2));
                a.setCli_dni(rs.getString(3));
                a.setAlq_fechaIngreso(rs.getString(4));
                a.setAlq_fechaSalida(rs.getString(5));
                a.setEmp_codigo(rs.getString(6));
                a.setAlq_estado(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //PARA AGREGRAR UN ALQUILER
    public String agregarAlq(Alquiler a) {
        Connection cn = MySQLConexion.getConexion();
        String alq = "";
        try {
            String sql = "{call alqAgregar(?,?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, a.getHab_codigo());
            st.setString(2, a.getCli_dni());
            st.setString(3, a.getAlq_fechaIngreso());
            st.setString(4, a.getAlq_fechaSalida());
            st.setString(5, a.getEmp_codigo());
            ResultSet rs = st.executeQuery();
            rs.next();//para leer el codigo de alquiler
            alq = rs.getString(1);//para grabar el codigo de alquiler
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return alq;
    }

    //PARA OBTENER UN ALQUILER POR CODIGO
    public Alquiler buscarAlqCod(String cod) {
        Alquiler a = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select alq_codigo,a.hab_codigo,cli_dni,alq_fechaIngreso,alq_fechaSalida,emp_codigo,alq_estado,hab_tipo"
                    + "\nfrom alquileres a join habitaciones h on a.hab_codigo=h.hab_codigo where alq_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = new Alquiler();
                a.setAlq_codigo(rs.getString(1));
                a.setHab_codigo(rs.getString(2));
                a.setCli_dni(rs.getString(3));
                a.setAlq_fechaIngreso(rs.getString(4));
                a.setAlq_fechaSalida(rs.getString(5));
                a.setEmp_codigo(rs.getString(6));
                a.setAlq_estado(rs.getString(7));
                a.setHab_tipo(rs.getString(8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return a;
    }

    //PARA MODIFICAR UN ALQUILER
    public void modificarAlq(String salida, String estado, String cod) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update alquileres set alq_fechaSalida=?,alq_estado=? where alq_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, salida);
            st.setString(2, estado);
            st.setString(3, cod);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    //REPORTE DE ALQUILERES REALIZADOS POR UN CLIENTE
    public List<Alquiler> listarAlqCli(String dni) {
        List<Alquiler> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from alquileres where cli_dni=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alquiler a = new Alquiler();
                a.setAlq_codigo(rs.getString(1));
                a.setHab_codigo(rs.getString(2));
                a.setCli_dni(rs.getString(3));
                a.setAlq_fechaIngreso(rs.getString(4));
                a.setAlq_fechaSalida(rs.getString(5));
                a.setEmp_codigo(rs.getString(6));
                a.setAlq_estado(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    //FILTRAR ALQUILERES REALIZADOS POR UN CLIENTE
    public List<Alquiler> filtrarAlqCli(String dni) {
        List<Alquiler> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from alquileres where cli_dni like ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alquiler a = new Alquiler();
                a.setAlq_codigo(rs.getString(1));
                a.setHab_codigo(rs.getString(2));
                a.setCli_dni(rs.getString(3));
                a.setAlq_fechaIngreso(rs.getString(4));
                a.setAlq_fechaSalida(rs.getString(5));
                a.setEmp_codigo(rs.getString(6));
                a.setAlq_estado(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //REPORTE DE ALQUILERES REALIZADOS DE UNA HABITACION
    public List<Alquiler> listarAlqHab(String cod) {
        List<Alquiler> lista = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from alquileres where hab_codigo=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista = new ArrayList();
                Alquiler a = new Alquiler();
                a.setAlq_codigo(rs.getString(1));
                a.setHab_codigo(rs.getString(2));
                a.setCli_dni(rs.getString(3));
                a.setAlq_fechaIngreso(rs.getString(4));
                a.setAlq_fechaSalida(rs.getString(5));
                a.setEmp_codigo(rs.getString(6));
                a.setAlq_estado(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
