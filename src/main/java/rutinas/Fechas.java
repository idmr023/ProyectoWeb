package rutinas;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.*;

public class Fechas {
    public static String hoyTitulo(){
        SimpleDateFormat ds=new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy");
        Date d=new Date();
        return ds.format(d);
    }
        
    public static String minFechaIngreso(){
        String d = LocalDate.now().toString();
        return d;
    }
    
    public static String minFechaSalida(){
        String d = LocalDate.now().plusDays(1).toString();
        return d;
    }
    
    public static long difFecha(String cf1, String cf2) {
        SimpleDateFormat ds=new SimpleDateFormat("yyyy-MM-dd");
        long res;
        try{ //convertir la candena a fecha
            Date d1=ds.parse(cf1);
            Date d2=ds.parse(cf2);
            Calendar t1=Calendar.getInstance();
            Calendar t2=Calendar.getInstance();
            t1.setTime(d1); t2.setTime(d2);
            res=((t2.getTimeInMillis()-t1.getTimeInMillis())/(1000*60*60*24));
        }catch(Exception ex){
        res=0;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println("Fecha de hoy: " + minFechaIngreso());
        System.out.println("Fecha de mañana: " + minFechaSalida());
    }
}
