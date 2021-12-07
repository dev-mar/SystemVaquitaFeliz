

public class Inventario
{
    private RegistroInv[] hojaInventario;
    private int cantProd= AdminRegistros.posVec;
    private Producto[] produc= AdminRegistros.produc;
        
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
    
    
    public void iniciarPrograma()
    {
        String c;
        crearHojaInventario();
        System.out.println("Ingrese código de producto: ");
        c= Recursos.leer.next();
        servicioDeNotificacion(c);
    }
    
    private void crearHojaInventario()
    {
        hojaInventario= new RegistroInv[100];
    }
}
