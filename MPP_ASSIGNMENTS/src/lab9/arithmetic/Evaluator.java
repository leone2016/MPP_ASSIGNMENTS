package lab9.arithmetic;

public class Evaluator {
    public static int eval(Expresions expr) {
        return switch (expr) {
            case Constant c -> c.value();
            case Add a -> eval(a.left()) + eval(a.right());
            case Multiply m -> eval(m.left()) * eval(m.right());
        };
    }
}
 class Main {
    public static void main(String[] args) {
        // (2 + 3) * 4
        Expresions expr = new Multiply(
                new Add(new Constant(2), new Constant(3)),
                new Constant(4)
        );

        int result = Evaluator.eval(expr);
        System.out.println("Result: " + result); // Output: 20
    }
}