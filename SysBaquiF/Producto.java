
public class Producto
{
    //Atributos
    private String codigo;
    private String nombre;
    private String cantidad;
    private double precioBs;
    
    //Constructores
    public Producto()
    {
        this.codigo="";
        this.nombre="";
        this.cantidad="";
        this.precioBs=0;
    }
    
    public Producto(String codigo, String nombre, String cantidad, double precio)
    {
        this.codigo= codigo;
        this.nombre= nombre;
        this.cantidad= cantidad;
        this.precioBs= precio;
    }
    
    //Metodos (set/get)
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








