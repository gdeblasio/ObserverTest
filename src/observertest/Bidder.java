package observertest;

import java.math.BigDecimal;

public class Bidder implements Observer {
    private final String bidderName;

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }
    
    @Override
    public void update(Observer observer, String productName, BigDecimal bidAmount) {
        if(observer.toString().equals(bidderName)){
            System.out.println("Hola " + bidderName 
                    + ": Has efectuado una oferta de " + bidAmount 
                    + "€ por el producto \"" + productName + "\"" );
        }
        if(!observer.toString().equals(bidderName)) {
            System.out.println("Hola " + bidderName 
                    + ": Una nueva oferta de " + bidAmount 
                    + "€ ha sido efectuada por " + observer
                    + " por el producto \"" + productName + "\"" );
        }
    }

    @Override
    public String toString() {
        return bidderName;
    }
    
}
