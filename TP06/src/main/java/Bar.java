import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    protected boolean happy_hour;
    List<BarObserver> observers;

    Bar() {
        happy_hour = false;
        observers = new ArrayList<>();
    }

    public boolean isHappyHour() {
        return happy_hour;
    }

    public void startHappyHour() {
        happy_hour = true;
        notifyObservers();
    }
    public void endHappyHour() {
        happy_hour = false;
        notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for(BarObserver observer : observers) {
            if(isHappyHour()) {
                observer.happyHourStarted(this);
            } else {
                observer.happyHourEnded(this);
            }
        }
    }
}
