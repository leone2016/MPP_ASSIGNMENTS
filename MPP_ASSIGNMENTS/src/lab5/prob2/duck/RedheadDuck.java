package lab5.prob2.duck;

import lab5.prob2.flyBehavior.FlyWithWingsImpl;
import lab5.prob2.quackBehavior.QuackImpl;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWingsImpl();
        quackBehavior = new QuackImpl();
    }

    public void display() {
        System.out.println("displaying");
    }
}