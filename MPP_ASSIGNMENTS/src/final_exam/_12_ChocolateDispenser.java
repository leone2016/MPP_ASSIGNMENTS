package final_exam;

public class _12_ChocolateDispenser {
    private static _12_ChocolateDispenser instance;
    private static int counter = 0;

    private _12_ChocolateDispenser() {
        counter++;
        System.out.println("🍫 ChocolateDispenser initialized by " +
                Thread.currentThread().getName() + " (Setup count: " + counter + ")");
    }

    public static  _12_ChocolateDispenser getInstance() {
        if (instance == null) {
            instance = new _12_ChocolateDispenser();
        }
        return instance;
    }

    public static int getSetupCount() {
        return counter;
    }
}
