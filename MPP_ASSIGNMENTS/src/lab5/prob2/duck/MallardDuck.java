package lab5.prob2.duck;

import lab5.prob2.flyBehavior.FlyWithWingsImpl;
import lab5.prob2.quackBehavior.QuackImpl;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWingsImpl();
        quackBehavior = new QuackImpl();
    }

    public void display() {
        System.out.println("displaying");
    }
}

