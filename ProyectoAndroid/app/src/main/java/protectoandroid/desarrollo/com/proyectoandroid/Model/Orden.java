package protectoandroid.desarrollo.com.proyectoandroid.Model;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class Orden {
    private int id;
    private String descripcion;
    private String nroOrden;
    private String cliente;
    private String latitud;
    private String longitud;

    public Orden(int id,
                 String descripcion,
            String cliente,
            String latitud,
            String longitud,
          String nroOrden){
        this.id = id;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nroOrden = nroOrden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }
}
