package observertest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final String productName;
    private BigDecimal bidAmount;
    private Observer observer;

    public Product(String productName, BigDecimal bidAmount) {
        this.productName = productName;
        this.bidAmount = bidAmount;
    }

    @Override
    public void registerObserver(Observer observer) {
        System.out.println(observer + " se ha unido a la subasta");
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("\n" + observer + " se retira de la subasta");
    }

    @Override
    public void notifyObservers() {
        System.out.println("\nNueva Subasta");
        System.out.println("-------------");
        for (Observer o : observers) {
            o.update(observer, productName, bidAmount);
        }
    }

    @Override
    public void setBidAmount(Observer observer, BigDecimal newBidAmount) {
        int compara = bidAmount.compareTo(newBidAmount);
        if (compara == -1) {
            this.observer = observer;
            this.bidAmount = newBidAmount;
            notifyObservers();
        } else {
            System.out.println("\n" + observer+ ", la nueva oferta " 
                              + "(" + newBidAmount + "€)" 
                              + " no puede ser menor o igual que "
                              + "la oferta actual"
                              + " (" + this.bidAmount + "€)");
        }
    }
    
}
