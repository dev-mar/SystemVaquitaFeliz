
public class CompraVenta
{
    private int opc;
    private void menu()
    {
        Recursos.separador();
        System.out.print("\nSISTEMA DE COMPRA Y VENTA");
        System.out.print("\n===================================");
        System.out.print("\n1.-Comprar.");
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
        String cod;
        int cant;        
        System.out.print("\nServicio de Compra.\n");
        System.out.print("\nIngrese codigo del producto: ");
        cod= Recursos.leer.next();
        System.out.print("\nIngrese la cantidad de compra:");
        cant= Recursos.leer.nextInt();
        
        Inventario.registrarMovimiento(cod, cant, "Compra");
        
    }
    
    
}
