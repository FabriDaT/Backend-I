import org.apache.log4j.Logger;

public class Tigre extends Animal {
    public Tigre(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void correr() {
        getLogger().info("Soy un tigre loco que esta running");

    }

}