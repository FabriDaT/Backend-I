package model;
public class Medicamento {
  private long codigoNumerico;
  private String nombre;
  private String laboratorio;
  private int cantidad;
  private double precio;
  
  public Medicamento(long codigoNumerico, String nombre, String laboratorio, int cantidad, double precio) {
    this.codigoNumerico = codigoNumerico;
    this.nombre = nombre;
    this.laboratorio = laboratorio;
    this.cantidad = cantidad;
    this.precio = precio;
  }
  
  public Medicamento() {
  }
  
  public long getCodigoNumerico() {
    return codigoNumerico;
  }
  
  public void setCodigoNumerico(long codigoNumerico) {
    this.codigoNumerico = codigoNumerico;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getLaboratorio() {
    return laboratorio;
  }
  
  public void setLaboratorio(String laboratorio) {
    this.laboratorio = laboratorio;
  }
  
  public int getCantidad() {
    return cantidad;
  }
  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  @Override
  public String toString() {
    return "Medicamento{" +
        "codigoNumerico=" + codigoNumerico +
        ", nombre='" + nombre + '\'' +
        ", laboratorio='" + laboratorio + '\'' +
        ", cantidad=" + cantidad +
        ", precio=" + precio +
        '}';
  }
}
