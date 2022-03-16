package Practica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

class Factura{
    String descripcion;
    int precio;
    Date FechaFactura;
    String Factura;
    int cantidad;

    Date date = new Date(2022,3,12);


    Factura(String descripcion,int precio/*, Date fechaFactura, String factura, int cantidad*/){
        this.descripcion=descripcion;
        this.precio=precio;
       /* this.FechaFactura=fechaFactura;
        this.Factura=factura;
        this.cantidad=cantidad;*/
    }

    int getImporte(){
        return precio;
    }
}

public class Bancaria {

    public static void main(String[] args) {
        Factura f=new Factura("ordenador",1000);
        Factura f2=new Factura("movil",300);
        Factura f3=new Factura("impresora",200);
        Factura f4=new Factura("imac",1500);

        List<Factura> lista= new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");
                return t.getImporte()>300;
            }
        };

        Factura facturaFiltro= lista.stream()
                .filter(predicado).findFirst().get();
        System.out.println("FACTURA UNICA "+facturaFiltro.getImporte());

        /*
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println(facturaFiltro.getImporte());
        */
    }

}
