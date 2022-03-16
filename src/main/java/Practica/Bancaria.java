package Practica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

class Factura{
    String descripcion;
    int precio;
    Date FechaFactura;
    int FacturaId;
    int cantidad;




    Factura(String descripcion,int precio, Date fechaFactura, int factura, int cantidad){
        this.descripcion=descripcion;
        this.precio=precio;
        this.FechaFactura=fechaFactura;
        this.FacturaId =factura;
        this.cantidad=cantidad;
    }

    int getImporte(){
        return precio;
    }
    Date getFechaFactura(){
        return FechaFactura;
    }
    int getCantidad(){
        return cantidad;
    }
    int getFacturaId(){
        return FacturaId;
    }
}

public class Bancaria {

    public static void main(String[] args) {
        Factura f=new Factura("ordenador",1000,new Date(122, 2, 22),1,8);
        Factura f2=new Factura("movil",300,new Date(122, 8, 30),2,2);
        Factura f3=new Factura("impresora",200,new Date(122, 5, 17),3,1);
        Factura f4=new Factura("imac",1500,new Date(122, 9, 2),4,19);

        List<Factura> lista= new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return t.getImporte()>300;
            }
        };

        Factura facturaFiltro= lista.stream()
                .filter(predicado).findFirst().get();
        System.out.println("FACTURA UNICA: Importe "+facturaFiltro.getImporte());

        /*
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println(facturaFiltro.getImporte());
        */

        Predicate<Factura> predicado2 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Date date = new Date(122, 8, 2);
                return t.getFechaFactura().after(date);
            }
        };
        Factura facturaFiltroFechaFactura= lista.stream()
                .filter(predicado2).findFirst().get();
        System.out.println("FACTURA UNICA: FechaFactura despues de una fecha deciada "+facturaFiltroFechaFactura.getFechaFactura());

        Predicate<Factura> predicado3 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Date date = new Date(122, 8, 2);
                return t.getFechaFactura().before(date);
            }
        };
        Factura facturaFiltroFechaFactura2= lista.stream()
                .filter(predicado3).findFirst().get();
        System.out.println("FACTURA UNICA: FechaFactura antes de una fecha deciada "+facturaFiltroFechaFactura2.getFechaFactura());

        Predicate<Factura> predicado4 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return t.getCantidad()==f.cantidad;
            }
        };
        Factura facturaFiltroCantidad= lista.stream()
                .filter(predicado4).findFirst().get();
        System.out.println("FACTURA UNICA: Cantidad de productos Igual a una cantidad deciada "+facturaFiltroCantidad.getCantidad());

        Predicate<Factura> predicado5 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return t.getCantidad()>f.cantidad;
            }
        };
        Factura facturaFiltroCantidad2= lista.stream()
                .filter(predicado5).findFirst().get();
        System.out.println("FACTURA UNICA: Cantidad de productos mayor a una cantidad deciada "+facturaFiltroCantidad2.getCantidad());

        Predicate<Factura> predicado6 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return t.getCantidad()<f.cantidad;
            }
        };
        Factura facturaFiltroCantidad3= lista.stream()
                .filter(predicado6).findFirst().get();
        System.out.println("FACTURA UNICA: Cantidad de productos menor a una cantidad deciada "+facturaFiltroCantidad3.getCantidad());

        Predicate<Factura> predicado7 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return t.getFacturaId()==f3.FacturaId;
            }
        };
        Factura facturaFiltroFacturaId= lista.stream()
                .filter(predicado7).findFirst().get();
        System.out.println("FACTURA UNICA: FacturaId deciada "+facturaFiltroFacturaId.getFacturaId());
    }


}
