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
}
