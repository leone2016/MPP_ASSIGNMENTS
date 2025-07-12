package final_exam;

public class _12_ChocolateDispenser_T {
    private static _12_ChocolateDispenser_T instance;
    private static int counter = 0;

    private _12_ChocolateDispenser_T() {
        counter++;
        System.out.println("🍫 ChocolateDispenser initialized by " +
                Thread.currentThread().getName() + " (Setup count: " + counter + ")");
    }

    public static synchronized _12_ChocolateDispenser_T getInstance() {
        if (instance == null) {
            instance = new _12_ChocolateDispenser_T();
        }
        return instance;
    }

    public static int getSetupCount() {
        return counter;
    }
}
