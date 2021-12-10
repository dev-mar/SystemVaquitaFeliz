import java.time.*;

public class Inventario
{
    public static RegistroInv[] hojaInventario= new RegistroInv[100];    
    private int opc;
    
    public static int cantProd;
    public static Producto[] produc;
    
    private void actualizarDatos()
    {
        cantProd= AdminRegistros.posVec;
        produc= AdminRegistros.produc;
    }
    
    private void ejecutarServicio(int op)
    {
        switch(op)
        {
            case 1:
                Recursos.separador();
                listarInventario();
            break;
            
            case 2: 
                String code;
                Recursos.separador();
                System.out.print("\nVERIFICAR STOCK\n");
                System.out.print("\nIngrese codigo de producto para ver su estado en stock: ");
                code= Recursos.leer.next();
                servicioDeNotificacion(code);
            break;
            
            case 3:
                Recursos.separador();
                mostrarHojaInventario();
            break;
            
            case 0:
                Recursos.separador();
                System.out.print("\nAcaba de salir del sistema de Inventarios.\n");
            break;
            
            default: 
                Recursos.separador();
                System.out.print("\nLa opcion es incorrecta.\n");
        }
    }
    
    public void iniciarPrograma()
    {
        actualizarDatos();
        
        
        do
        {
            menu();
            Recursos.separador();
        }while(opc != 0);
    }
    
    //Resp e)
    
    public static int phi= 0;
    private void crearHojaInventario()
    {
        hojaInventario= new RegistroInv[100];
    }
    
    public static void mostrarHojaInventario()
    {
        System.out.print("\n Hoja de inventario para movimientos");
        System.out.print("\n==============================================\n");
        for(int i= 0; i < phi; i++)
        {
            System.out.print("\n" + hojaInventario[i].toString());
        }
        
    }
    
    public static String buscarNombre(String cod)
    {
        String nom= "";
        for(int i= 0; i < cantProd; i++)
        {
            if(produc[i].getCodigo().equals(cod))
            {
                nom= produc[i].getNombre();
            }
        }
        return nom;
    }
    
    public static int buscarPosicion(String cod)
    {
        int pos=-1;
        for(int i= 0; i < cantProd; i++)
        {
            if(produc[i].getCodigo().equals(cod))
            {
                pos= i;
            }
        }
        return pos;
    }
    
    public static void registrarMovimiento(String codigo, int cantidad, String movimiento)
    {
        int nro, pos;
        String fecha= " " + LocalDate.now()  , nombre="";
        nro= phi + 1;
        nombre= buscarNombre(codigo);
        pos= buscarPosicion(codigo);
        
        hojaInventario[phi]= new RegistroInv(nro, fecha, codigo,nombre, movimiento, cantidad);
        
        //En esta parte usamos el metodo de el objeto Producto para cambiar su Stock.
        if(pos >= 0)
        {
            AdminRegistros.produc[pos].setMovimiento(movimiento, cantidad);
        }
        
        phi++;
    }
    
    //Resp f)
    private void servicioDeNotificacion(String cod)
    {
        int valor= -1;
        for(int i= 0; i < cantProd; i++)
        {
            if(produc[i].getCodigo().equals(cod))
            {
                valor= produc[i].getStock();
            }
        }
            
        if(valor >= 0)
        {
            if(valor == 0)
            {
                System.out.println("PRODUCTO AGOTADO – 0 Unidades.");
            }
            
            if(valor > 0 && valor < 6)
            {          
                System.out.println("PRODUCTO ESCASO - "+ valor +" Unidades.");
            }
            
            if(valor > 5)
            {            
                System.out.println("PRODUCTO DISPONIBLE - "+ valor +" Unidades.");
            }
        }
        else
        {
            System.out.println("ALERTA: El codigo del producto no existe.");
        }                
        
    }
    
    private void menu()
    {
        System.out.print("\nInventario");
        System.out.print("\n===========================");
        System.out.print("\n1.- Ver Stock General");
        System.out.print("\n2.- Verificar stock de un producto.");
        System.out.print("\n3.- Ver hoja de movimientos.");
        System.out.print("\n0.- Salir.");
        System.out.print("\n\nIngrese un numero de una de las opciones: ");
        opc= Recursos.leer.nextInt();
        ejecutarServicio(opc);
    }
    
    //Resp g)
    private void listarInventario()
    {
        System.out.print("\nINVENTARIO\n");
        for(int i=0; i < cantProd; i++)
        {
            System.out.print("\nProducto: " + produc[i].getCodigo() + " " + produc[i].getNombre() + " " + produc[i].getStock()+ " unidades");
        }
    }
}
