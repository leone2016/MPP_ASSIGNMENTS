package lab5.prob2.duck;

import lab5.prob2.flyBehavior.IFlyBehavior;
import lab5.prob2.quackBehavior.IQuackBehavior;

public abstract class Duck {
    protected IFlyBehavior flyBehavior;
    protected IQuackBehavior quackBehavior;

    public void swim() {
        System.out.println("swimming");
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public abstract void display();
}