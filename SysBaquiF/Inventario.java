

public class Inventario
{
    private RegistroInv[] hojaInventario;
    
    private void crearHojaInventario()
    {
        hojaInventario= new RegistroInv[100];
    }
    
    
    public void iniciarPrograma()
    {
        crearHojaInventario();
    }
}
