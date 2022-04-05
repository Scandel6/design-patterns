package main.java.com.kreitek.pets;

public class Logger {

    private static volatile Logger instance = null;

    private int cont;

    private Logger() {
        this.cont = 0;
    }

    public static Logger getInstance(){
        if (instance == null)
            synchronized (Logger.class){
                if (instance == null){
                    instance = new Logger();
                }
            }
        return instance;
    }
}