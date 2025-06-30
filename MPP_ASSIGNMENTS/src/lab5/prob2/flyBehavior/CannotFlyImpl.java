package lab5.prob2.flyBehavior;

public class CannotFlyImpl implements IFlyBehavior {
    public void fly() {
        System.out.println("cannot fly");
    }
}