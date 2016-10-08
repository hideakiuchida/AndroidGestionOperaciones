package protectoandroid.desarrollo.com.proyectoandroid.Model;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class Inspeccion {
    private int id;
    private String nroInspect;
    private String fecha;
    private int cantidadMuestra;
    private String lugar;

    public Inspeccion(int id,
                      String nroInspect,
            String fecha,
                      int cantidadMuestra,
            String lugar){
        this.id = id;
        this.nroInspect = nroInspect;
        this.fecha = fecha;
        this.cantidadMuestra = cantidadMuestra;
        this.lugar = lugar;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroInspect() {
        return nroInspect;
    }

    public void setNroInspect(String nroInspect) {
        this.nroInspect = nroInspect;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setCantidadMuestra(int cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
