
public class Producto
{
    //Atributos
    private String codigo;
    private String nombre;
    private String cantidad;
    private double precioBs;
    private int stock;
    
    //Constructores
    public Producto()
    {
        this.codigo="";
        this.nombre="";
        this.cantidad="";
        this.precioBs=0;
        this.stock=0;
    }
    
    public Producto(String codigo, String nombre, String cantidad, double precio, int stock)
    {
        this.codigo= codigo;
        this.nombre= nombre;
        this.cantidad= cantidad;
        this.precioBs= precio;
        this.stock= stock;
    }
    
    //Metodos (set/get)
    public void setStock(int stock)
    {
        this.stock= stock;
    }
    public int setMovimiento(String tipo, int cantidad)
    {
        int st= -1;
        if(tipo.equalsIgnoreCase("compra"))
        {
            st= this.stock + cantidad;
            setStock(st);
        }
        else
        {
            if(tipo.equalsIgnoreCase("venta"))
            {
                st= this.stock - cantidad;
                if(st >= 0)
                {
                    setStock(st);
                }
            }
        }
        return st;
    }
    
    public int getStock()
    {
        return this.stock;
    }
    
    
    
    public void setCodigo(String codigo)
    {
        this.codigo= codigo;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setCantidad(String cantidad)
    {
        this.cantidad= cantidad;
    }
    public String getCantidad()
    {
        return this.cantidad;
    }
    
    public void setPrecioBs(double precio)
    {
        this.precioBs= precio;
    }
    public double getPrecioBs()
    {
        return this.precioBs;
    }
}








