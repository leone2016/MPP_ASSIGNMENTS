package lab5.prob2.duck;

import lab5.prob2.flyBehavior.CannotFlyImpl;
import lab5.prob2.quackBehavior.SqueakImpl;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new CannotFlyImpl();
        quackBehavior = new SqueakImpl();
    }

    public void display() {
        System.out.println("displaying");
    }
}
