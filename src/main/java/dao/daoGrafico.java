package dao;

import java.sql.*;
import java.util.*;
import modelo.*;
import util.*;

public class daoGrafico {

    public List<habitacion> LisVenta(int an){
        List<habitacion> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
         String sql="{call spventa(?)}";   
         CallableStatement st=cn.prepareCall(sql);
         st.setInt(1, an);
         ResultSet rs=st.executeQuery();
         while(rs.next()){
           habitacion p=new habitacion();
           p.setMes(rs.getInt(1));
           p.setTotal(rs.getDouble(2));
           lis.add(p);
         }
        }catch(Exception ex){
          ex.printStackTrace();
        }
        return lis;   
       }
    //% tipo de habitacion
    public List<habitacion> LisTipo() {
        List<habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select SUM(CASE WHEN hab_estado = 'ocupada' THEN 1 ELSE 0 END) as cantidad from habitaciones group by hab_tipo";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                habitacion c = new habitacion();
                c.setHab_precio(Double.parseDouble(rs.getString(1)));            
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    public List<habitacion> LisTotalHab() {
        List<habitacion> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select count(hab_codigo) as cantidad "
                    + ", SUM(CASE WHEN hab_tipo = 'simple' THEN 1 ELSE 0 END) as simple"
                    + ", SUM(CASE WHEN hab_tipo = 'doble' THEN 1 ELSE 0 END) as doble"
                    + ", SUM(CASE WHEN hab_tipo = 'matrimonial' THEN 1 ELSE 0 END) as matrimonial"
                    + " from habitaciones";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                habitacion c = new habitacion();
                c.setHab_precio(Double.parseDouble(rs.getString(1)));          
                c.setSimple(Double.parseDouble(rs.getString(2)));          
                c.setDoble(Double.parseDouble(rs.getString(3)));          
                c.setMatrimonial(Double.parseDouble(rs.getString(4)));          
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
