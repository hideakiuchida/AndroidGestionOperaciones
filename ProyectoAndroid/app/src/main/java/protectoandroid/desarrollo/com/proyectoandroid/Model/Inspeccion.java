package protectoandroid.desarrollo.com.proyectoandroid.Model;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class Inspeccion {
    String nroOrden;
    String fecha;
    String cantidadMuestra;
    String lugar;
    String latitud;
    String longitud;

    public Inspeccion(String nroOrden,
            String fecha,
            String cantidadMuestra,
            String lugar,
            String latitud,
            String longitudl){
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.cantidadMuestra = cantidadMuestra;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;

    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setCantidadMuestra(String cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
}
