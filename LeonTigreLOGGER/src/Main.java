import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Leon leon = new Leon("zion",5,true);
        leon.correr();
        leon.getLogger();
        logger.warn("Advertencia el metodo MAIN esta por finalizar");
        logger.debug("Esto va a mostrarse solo si el infoLogger esta en DEBUG");
        logger.info("Finalizamos el thread MAIN");



    }
}