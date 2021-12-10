
public class Producto
{
    //Atributos
    private String codigo;
    private String nombre;
    private String contenido;
    private double precioBs;
    private int stock;
    
    //Constructores
    public Producto()
    {
        this.codigo="";
        this.nombre="";
        this.contenido="";
        this.precioBs=0;
        this.stock=0;
    }
    
    public Producto(String codigo, String nombre, String contenido, double precio, int stock)
    {
        this.codigo= codigo;
        this.nombre= nombre;
        this.contenido= contenido;
        this.precioBs= precio;
        this.stock= stock;
    }
    
    //Metodos (set/get)
    public void setStock(int stock)
    {
        this.stock= stock;
    }
    //Metodo que permite cambiar el valor del Stock con respecot a ser una Compra o Venta.
    public int setMovimiento(String tipo, int contenido)
    {
        int st= -1;
        if(tipo.equalsIgnoreCase("compra"))
        {
            st= this.stock + contenido;
            setStock(st);
        }
        else
        {
            if(tipo.equalsIgnoreCase("venta"))
            {
                st= this.stock - contenido;
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
    
    public void setContenido(String contenido)
    {
        this.contenido= contenido;
    }
    public String getContenido()
    {
        return this.contenido;
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








