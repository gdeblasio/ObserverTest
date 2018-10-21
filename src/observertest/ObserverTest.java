package observertest;

import java.math.BigDecimal;

public class ObserverTest {

    public static void main(String[] args) {
        Subject producto = new Product("TV LED de 56 pulgadas",
                new BigDecimal(350));
        Observer b1 = new Bidder("Ana");
        Observer b2 = new Bidder("Enrique");
        Observer b3 = new Bidder("María");        
        
        producto.registerObserver(b1);
        producto.registerObserver(b2);
        producto.registerObserver(b3);
        
        producto.setBidAmount(b1, new BigDecimal(375));
        producto.removeObserver(b2);
        producto.setBidAmount(b3, new BigDecimal(370));
        producto.setBidAmount(b3, new BigDecimal(400));
    }
    
}
