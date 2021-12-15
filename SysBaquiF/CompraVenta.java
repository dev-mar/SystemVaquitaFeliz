
public class CompraVenta
{
    private int opc;
    private Carrito[] carro= new Carrito[100];
    private int posCar= 0;
    
    private void alerta(String codigo, int cantidad)
    {
        String op;
        int resp;
        
        resp= Inventario.servicioDeNotificacion(codigo);
        
        if(resp == -1)
        {
            System.out.print("\nEl producto no existe.");
        }
        else
        {
            if(resp == 0)
            {
                System.out.print("\nNo se puede vender el producto.");
            }
            else
            {
                System.out.print("\n\nEsta seguro de vender el producto? (S=si) y (N=no).");    
                op= Recursos.leer.next();
                
                if( op.equalsIgnoreCase("s"))
                {
                    carro[posCar]= new Carrito(codigo, cantidad);
                    posCar++;
                }
                else
                {
                    System.out.print("\nLa venta fue cancelada.");
                }
            }
        }
        
        
    }
    
    
    
    private void verDetalleVenta()
    {
        String cod;
        int cant;
        
        System.out.print("\nDetalle de Venta.\n");
        for(int i=0; i < posCar; i++)
        {
            cod= carro[i].getCodigo();
            cant= carro[i].getCantidad();
            System.out.print(Inventario.detalleVentaProducto(cod, cant));
        }
    }
    
    private void crearCarrito()
    {
        String cod, op;
        int cant;
        
        System.out.print("\nCREAR CARRO DE COMPRAS.");
        System.out.print("\n===============================\n");
        do
        {
            System.out.print("\nIngrese codigo del producto.");
            cod= Recursos.leer.next();            
            System.out.print("\nIngrese la cantidad.");
            cant= Recursos.leer.nextInt();
            
            alerta(cod, cant);
            
            System.out.print("\n\nQuieres agregar mas productos? (S=si) y (N=no).");
            op= Recursos.leer.next();
        }while(op.equalsIgnoreCase("S"));
        
        verDetalleVenta();
        System.out.print("\n\nSu carrito de compras fue creado correctamente.");
    }
    
    private void vender()
    {
        crearCarrito();
    }    
    
    
    private void menu()
    {
        Recursos.separador();
        System.out.print("\nSISTEMA DE COMPRA Y VENTA");
        System.out.print("\n===================================");
        System.out.print("\n1.-Comprar.");
        System.out.print("\n2.-Vender.");
        System.out.print("\n0.-Salir.");
        System.out.print("\nIngrese el numero de una de las opciones");
        opc= Recursos.leer.nextInt();
        ejecutarServicio(opc);
    }
    
    private void ejecutarServicio(int op)
    {
        switch(op)
        {
            case 1:
                Recursos.separador();
                comprar();
            break;
            case 2:
                Recursos.separador();
                vender();
            break;
            case 0: 
                Recursos.separador();
                System.out.print("\nSalio del sistema de compra y ventas correctamente\n");
            break;
            default:
                Recursos.separador();
                System.out.print("\nAlerta:El numero de opcion ingresada es incorrecto.\n");
        }
    }
    
    
    public void iniciarPrograma()
    {
        do
        {
            menu();
        }while(opc != 0);
    }
    
    
    private void comprar()
    {
        String cod, nom, opc;
        int cant;        
        System.out.print("\nServicio de Compra.\n");
        System.out.print("\nIngrese codigo del producto: ");
        cod= Recursos.leer.next();
        System.out.print("\nIngrese la cantidad de compra:");
        cant= Recursos.leer.nextInt();
        
        nom= Inventario.buscarNombre(cod);        
        System.out.print("\nEsta a punto de comprar " + cant + " unidades del producto " + nom + ":");
        System.out.print("\nPresiones S para SI o N para NO:");
        opc=Recursos.leer.next();
        
        if( opc.equalsIgnoreCase("s"))
        { 
            Inventario.registrarMovimiento(cod, cant, "Compra");
            
            Recursos.separador();
            System.out.print("\nCompraste "+ cant + " unidades del producto " + nom);
        }
        else
        {
            Recursos.separador();
            System.out.print("\nLa compra fue cancelada..!!!");
        }
    }
    
    
}
