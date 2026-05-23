package co.edu.udea.certificacion.moduloSignInAndTransactions.utils;

public class Wait {

    private static Wait wait;
    private Integer mills;

    public Wait(Integer mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Wait waitSomeMills(Integer mills){
        wait = new Wait(mills);
        return wait;
    }
}
