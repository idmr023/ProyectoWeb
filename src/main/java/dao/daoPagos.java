/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Pago;
import util.MySQLConexion;

public class daoPagos {
    
    //PARA LISTAR LOS PAGOS EXISTENTES
    public List<Pago> lisPag() {
        List<Pago> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from pagos";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setPa_codigo(rs.getString(1));
                p.setPa_fecha(rs.getString(2));
                p.setAlq_codigo(rs.getString(3));
                p.setCli_dni(rs.getString(4));
                p.setPa_total(rs.getDouble(5));
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
