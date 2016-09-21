package protectoandroid.desarrollo.com.proyectoandroid.Model;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class Orden {
    String descripcion;
    String cliente;
    String latitud;
    String longitud;
    String estado_pendiente;

    public Orden(String descripcion,
            String cliente,
            String latitud,
            String longitud,
          String estado_pendiente){
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado_pendiente = estado_pendiente;
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

    public String getEstado_pendiente() {
        return estado_pendiente;
    }

    public void setEstado_pendiente(String estado_pendiente) {
        this.estado_pendiente = estado_pendiente;
    }
}
