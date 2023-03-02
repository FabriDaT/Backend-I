import java.util.logging.Logger;

public abstract class Animal {
    private String nombre;
    private int edad;

    private Logger logger = Logger.getLogger("Animal");



    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public Logger getLogger(){
        return logger;
    }
    public abstract void correr();
}
