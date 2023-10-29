package dao;

import modelo.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class daoEmpleados implements Validar{

    //PARA OBTENER EL LISTADO EMPLEADOS
    public List<Empleado> listarEmp() {
        List<Empleado> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from empleados";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setEmp_codigo(rs.getString(1));
                e.setApellido(rs.getString(2));
                e.setNombre(rs.getString(3));
                e.setSexo(rs.getString(4));
                e.setCelular(rs.getString(5));
                e.setCargo(rs.getString(6));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public int validar(Empleado emp){
        Connection cn = MySQLConexion.getConexion();
        int r = 0;
        try {
            String sql = "select * from empleados where emp_correo=? and emp_pswd=?";
            PreparedStatement st = cn.prepareStatement(sql);

            st.setString(1, emp.getEmp_correo());
            st.setString(2, emp.getPswd());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                r++;
                emp.setEmp_correo(rs.getString("emp_correo"));
                emp.setPswd(rs.getString("emp_pswd"));
            }

            if (r == 1) return 1;
            else return 0;
        } catch (SQLException ex) {
            return 0;
        }

    }
    
}
