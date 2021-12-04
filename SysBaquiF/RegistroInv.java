
public class RegistroInv
{
    //atributos
    private int nro;
    private int cantidad;
    private String producto;
    private String codigo;
    private String fecha;
    private String movimiento; 
    
    //constructores
    public RegistroInv()
    {
        this.nro= 0;
        this.cantidad= 0;
        this.producto= "-";
        this.codigo= "-";
        this.fecha= "-";
        this.movimiento= "-";
    }
    
    
    //metodos(set/get)
    public void setNro(int nro)
    {
        this.nro= nro;
    }
    public int getNro()
    {
        return this.nro;
    }
    
    public void setCantidad(int cantidad)
    {
        this.cantidad= cantidad;
    }
    public int getCantidad()
    {
        return this.cantidad;
    }
    
    public void setProducto(String producto)
    {
        this.producto= producto;
    }
    public String getProducto()
    {
        return this.producto;
    }
    
    public void setCodigo(String codigo)
    {
        this.codigo= codigo;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    
    public void setFecha(String fecha)
    {
        this.fecha= fecha;
    }
    public String getFecha()
    {
        return this.fecha;
    }
    
    public void setMovimiento(String movimiento)
    {
        this.movimiento= movimiento;
    }
    public String getMovimiento()
    {
        return this.movimiento;
    }
}
