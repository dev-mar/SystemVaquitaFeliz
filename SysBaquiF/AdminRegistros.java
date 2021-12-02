

public class AdminRegistros
{
    private Producto[] produc= new Producto[9];
    private int posVec= 4;
    
    private void listarProductos()
    {
        System.out.print("\nLista de productos y sus precios\n");
        for(int i=0; i < posVec; i++)
        {
            System.out.print("\nProducto: " + produc[i].getNombre() + " " + produc[i].getPrecioBs() + " Bs.");
        }
    }
    
    
    private void iniciarPrograma()
    {
        precargarProductos();
        
        registrarProducto();
        
        listarProductos();
    }
    
    
    //Resp a)
    private void precargarProductos()
    {
        produc[0]= new Producto();
        
        produc[0].setCodigo("P-101");
        produc[0].setNombre("Leche Natural");
        produc[0].setCantidad("1L.");
        produc[0].setPrecioBs(8);
        
        produc[1]= new Producto("P-102", "Yogurt Frutado Durazno", "1L.", 15);
        produc[2]= new Producto("P-103", "Gelatina Personal Sabor Frutilla", "100ml.", 1.5);
        produc[3]= new Producto("P-104", "Leche Saborizada Chocolate", "0.9L.", 9.5);
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
            
            System.out.print("\nIngrese cantidad del producto: ");
            produc[posVec].setCantidad(Recursos.leer.nextLine());
            
            System.out.print("\nIngrese precio del producto: ");
            produc[posVec].setPrecioBs(Recursos.leer.nextDouble());
            
            posVec++;
        }
        else
        {
           System.out.print("\nAlerta: Unidad de almacenamiento llena, no puedes registrar más productos "); 
        }
    }
}





