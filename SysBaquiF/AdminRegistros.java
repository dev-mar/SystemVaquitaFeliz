

public class AdminRegistros
{
    public static Producto[] produc= new Producto[9];
    public static int posVec= 4;
    
      
    
    private int menu()
    {
        int op;
        Recursos.separador();
        System.out.print("SISTEMA DE ADMINISTRACION DE PRODUCTOS");
        System.out.print("\n============================================");
        System.out.print("\n\n1.- Ver productos.");
        System.out.print("\n2.- Registrar un nuevo producto.");
        System.out.print("\n3.- Modificar un producto.");
        System.out.print("\n0.- Salir.");
        op= Recursos.leer.nextInt();
        Recursos.leer.nextLine();//limpiar
        ejecutarServicio(op);
        return op;
    }
    
    private void ejecutarServicio(int opcion)
    {
        switch(opcion)
        {
            case 1:
                Recursos.separador();    
                listarProductos();
            break;
            
            case 2:
                Recursos.separador();
                registrarProducto();
            break;
            
            case 3:
                Recursos.separador();
                modificarProducto();
            break;
            
            case 0: System.out.println("\nEl programa fue cerrado correctamente.");
            break;
            
            default: System.out.println("\nERROR:La opcion es incorrecta");
        }
    }
            
    public void iniciarPrograma()
    {
        int resp;
        precargarProductos();
        
        do
        {
          resp=  menu();
        }while(resp != 0);
                
    }
    
    
    //Resp a)
    private void precargarProductos()
    {
        produc[0]= new Producto();
        
        produc[0].setCodigo("P-101");
        produc[0].setNombre("Leche Natural");
        produc[0].setContenido("1L.");
        produc[0].setPrecioBs(8);
        
        produc[1]= new Producto("P-102", "Yogurt Frutado Durazno", "1L.", 15, 0);
        produc[2]= new Producto("P-103", "Gelatina Personal Sabor Frutilla", "100ml.", 1.5, 0);
        produc[3]= new Producto("P-104", "Leche Saborizada Chocolate", "0.9L.", 9.5, 0);
    }
    
    //Resp b)
    private void registrarProducto()
    {
        if(posVec < 9)
        {
            produc[posVec]= new Producto();
            
            System.out.print("\nIngrese código del producto: ");
            produc[posVec].setCodigo(Recursos.leer.nextLine());
            
            System.out.print("\nIngrese nombre del producto: ");
            produc[posVec].setNombre(Recursos.leer.nextLine());
            
            System.out.print("\nIngrese contenido del producto: ");
            produc[posVec].setContenido(Recursos.leer.nextLine());
            
            System.out.print("\nIngrese precio del producto: ");
            produc[posVec].setPrecioBs(Recursos.leer.nextDouble());
            Recursos.leer.nextLine();//limpiar
            
            System.out.print("\n\nEl registro se completo con exito: ");
            posVec++;
        }
        else
        {
           System.out.print("\nAlerta: Unidad de almacenamiento llena, no puedes registrar más productos "); 
        }
    }
    
    //Resp c)
    private void listarProductos()
    {
        System.out.print("\nLista de productos y sus precios\n");
        for(int i=0; i < posVec; i++)
        {
            System.out.print("\nProducto: " + produc[i].getCodigo() + " " + produc[i].getNombre() + " " + produc[i].getPrecioBs() + " Bs.");
        }
    }
    
    //Resp d)
    private int existeProducto(String cod)
    {
        int resp= -1;
        
        for(int i=0; i < posVec; i++)
        {
            if( produc[i].getCodigo().equals(cod) )
            {
                resp= i;
            }
        }
        
        return resp;
    }
    
    private void cambiarNombre(int pos, String nom)
    {
         produc[pos].setNombre(nom);
         System.out.print("\nEl nombre fue actualizado correctamente.");
    }
    
    private void cambiarPrecio(int pos, double precio)
    {
        if(precio >= 0)
        {
            produc[pos].setPrecioBs(precio);
            System.out.print("\nEl precio se modifico correctamente.");
        }
        else
        {
            System.out.print("\nERROR: El monto del precio es incorrecto.");
        }
        
    } 
    
    private void modificarProducto()
    {
        int op, verificador;
        double prec;
        String cod, nom;
        System.out.print("\nModulo de Actualizacion para Datos");
        System.out.print("\n=====================================");
        System.out.print("\n1.-Cambiar nombre de producto.");
        System.out.print("\n2.-Cambiar precio de producto.");
        System.out.print("\n0.-Cancelar.");
        op= Recursos.leer.nextInt();
        Recursos.leer.nextLine();//limpiar
        
        if(op == 1 || op == 2)
        {
            System.out.print("\n\nIngrese el código del producto: ");
            cod= Recursos.leer.next();
            Recursos.leer.nextLine();//limpiar
            
            verificador =  existeProducto(cod);
            if(verificador > -1)
            {
                switch(op)
                {
                    case 1:
                        System.out.print("\n\nNombre anterior: "+ produc[verificador].getNombre());
                        System.out.print("\n\nIngrese nuevo nombre: ");                        
                        nom= Recursos.leer.nextLine();
                        cambiarNombre(verificador, nom);
                    break;
                    
                    case 2:
                        System.out.print("\n\nPrecio anterior: "+ produc[verificador].getPrecioBs());
                        System.out.print("\n\nIngrese nuevo precio: ");
                        prec= Recursos.leer.nextDouble();
                        Recursos.leer.nextLine();//limpiar
                        cambiarPrecio(verificador, prec);
                    break;
                }
            }
            else
            {
                System.out.print("ALERTA:El producto "+cod+" no esta registrado");
            }
        }
        else
        { 
            if(op==0)
            {
            }
            else
            {
                System.out.print("ERROR:La opcion seleccionada es incorrecto.");
            }
        }
        
    }
    
}





