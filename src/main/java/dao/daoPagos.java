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
import modelo.*;
import modelo.PagoDetalle;
import util.MySQLConexion;

public class daoPagos {
    
    //PARA LISTAR LOS PAGOS POR CLIENTE
    public List<Pago> lisPag(String dni) {
        List<Pago> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from pagos where cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setPa_codigo(rs.getString(1));
                p.setPa_fecha(rs.getString(2));
                p.setCli_dni(rs.getString(3));
                p.setPa_total(rs.getDouble(4));
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    //PARA BUSCAR DETALLE DE PAGO POR CODIGO
    public List<PagoDetalle> detaPago(String cod) {
        List<PagoDetalle> lisDeta = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from pagodetalle where pa_codigo=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PagoDetalle deta = new PagoDetalle();
                deta.setPa_codigo(rs.getString(1));
                deta.setAlq_codigo(rs.getString(2));
                deta.setPaDeta_concepto(rs.getString(3));
                deta.setPaDeta_dias(rs.getInt(4));
                lisDeta.add(deta);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lisDeta;
    }
    
    //PARA AGREGAR UN PAGO
    public String agregarPago(PagoDetalle p){
        String pa = "";
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call paAgregar(?,?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, p.getAlq_codigo());
            st.setString(2, p.getCli_dni());
            st.setDouble(3, p.getPa_total());
            st.setString(4, p.getPaDeta_concepto());
            st.setInt(5, p.getPaDeta_dias());
            ResultSet rs = st.executeQuery();
            rs.next();
            pa = rs.getString(1);
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        return pa;
    }
    
    //PARA LISTAR LOS PAGOS EN EL PRESENTE AÑO
    public List<Pago> lisPagAn() {
        List<Pago> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select sum(pa_total) from pagos where year(pa_fecha)='2023'";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setPa_total(Double.parseDouble(rs.getString(1)));
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
