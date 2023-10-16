package dao;

import modelo.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class Negocio {

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
                e.setEmp_cargo(rs.getString(6));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

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
    //PARA OBTENER LA LISTA DE CLIENTES
    public List<Cliente> listarCli() {
        List<Cliente> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from clientes";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //PARA AGREGAR UN CLIENTE
    public void agregarCli(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "insert into clientes values(?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getCli_dni());
            st.setString(2, c.getApellido());
            st.setString(3, c.getNombre());
            st.setString(4, c.getSexo());
            st.setString(5, c.getCelular());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //PARA MODIFICAR UN CLIENTE
    public void modificarCli(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update clientes set cli_apellido=?,cli_nombre=?,cli_sexo=?,cli_celular=? where cli_dni=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getApellido());
            st.setString(2, c.getNombre());
            st.setString(3, c.getSexo());
            st.setString(4, c.getCelular());
            st.setString(5, c.getCli_dni());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //PASAR NRO DE DNI CLIENTE 
    public Cliente consultaCli(int nro) {
        Connection cn = MySQLConexion.getConexion(); // nos conectamos con MySQL
        Cliente c = null; // creamos una búsqueda vacía
        String sql = "SELECT cli_dni, cli_apellido, cli_nombre, cli_sexo, cli_celular FROM clientes WHERE cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);// preparamos el SQL
            st.setInt(1, nro);
            // ResultSet, entra fila por fila para poder lograr leer los atributos
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    //PARA OBTENER UN CLIENTE POR DNI 
    //USAR ESTE METODO PORQUE EL DNI ES STRING Y ES EL METODO QUE SE USA PARA COMPROBAR SI UN CLIENTE YA ESTA REGISTRADO AL REGISTRAR ALQUILER NUEVO
    public Cliente buscarCli(String dni) {
        Cliente c = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from clientes where cli_dni=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }

    //ELIMINAR POR NRO DE DNI DE CLIENTE
    public void eliminarCli(int nro) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "delete from clientes where cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);

            st.setInt(1, nro);

            st.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //PARA FILTRAR POR DNI DE  CLIENTE
    public List<Cliente> flitrarCli(String id) {
        List<Cliente> lis = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion(); PreparedStatement st = cn.prepareStatement("SELECT cli_dni, cli_apellido, cli_nombre, cli_sexo, cli_celular FROM clientes WHERE cli_dni LIKE ?");) {
            st.setString(1, id + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCli_dni(rs.getString(1));
                    c.setApellido(rs.getString(2));
                    c.setNombre(rs.getString(3));
                    c.setSexo(rs.getString(4));
                    c.setCelular(rs.getString(5));

                    lis.add(c);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Considera manejar la excepción de una manera más apropiada aquí
        }
        return lis;
    }
/////////////////////////////////////////////////////////////////////////////////////////

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

    public Object modificarCli(String nro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        //Gráfico
    public List<Habitacion> LisVenta(int an){
        List<Habitacion> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
         String sql="{call spventa(?)}";   
         CallableStatement st=cn.prepareCall(sql);
         st.setInt(1, an);
         ResultSet rs=st.executeQuery();
         while(rs.next()){
           Habitacion p=new Habitacion();
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
