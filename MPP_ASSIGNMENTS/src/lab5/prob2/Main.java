package lab5.prob2;


import lab5.prob2.duck.*;

public class Main {
        public static void main(String[] args) {
            Duck[] ducks = {
                    new MallardDuck(),
                    new DecoyDuck(),
                    new RedheadDuck(),
                    new RubberDuck()
            };

            for (Duck d : ducks) {
                System.out.println(d.getClass().getSimpleName() + ":");
                d.display();
                d.fly();
                d.quack();
                d.swim();
                System.out.println();
            }
        }

}
