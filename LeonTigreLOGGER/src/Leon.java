import org.apache.log4j.Logger;

public class Leon extends Animal{
    private Boolean esAlfa;

    public Leon(String nombre, int edad, Boolean esAlfa) {
        super(nombre, edad);
        this.esAlfa = esAlfa;
    }

    @Override
    public void correr() {
        getLogger().info("Hola a todos soy el leon Running crazy");
    }
}
