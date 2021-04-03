package e1.Observers;

import e1.Observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer o){observers.add(o);}
    public void detach(Observer o){observers.remove(o);}



    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this);
        }
    }
}
