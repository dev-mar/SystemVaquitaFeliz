
public class Carrito
{
    private String codigo;
    private int cantidad;
    
    public Carrito()
    {
        this.codigo= "";
        this.cantidad= 0;
    }
    
    public Carrito(String codigo, int cantidad)
    {
        this.codigo= codigo;
        this.cantidad= cantidad;
    }
    
    public void setCodigo(String codigo)
    {
        this.codigo= codigo;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    
    public void setCantidad(int cantidad)
    {
        this.cantidad= cantidad;
    }
    public int getCantidad()
    {
        return this.cantidad;
    }
}
