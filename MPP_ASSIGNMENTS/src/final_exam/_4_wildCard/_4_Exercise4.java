package final_exam._4_wildCard;

/**
 * You are building a notification service for a healthcare app. Users can receive notifications via SMS, Email,
 * or Push Notification. The system should use a factory pattern for creating the appropriate notifier object.
 *
 * Requirements
 * Create a Java interface Notifier that includes:
 *
 * One abstract method: void sendNotification(String recipient, String message);
 * One default method: void notifySelf(String message)
 * (Sends a notification to a default recipient, "self@system.com", using the abstract method.)
 * One static method:
 * static boolean isValidMessage(String message)
 * (Returns true if the message is not null and less than 160 characters.)
 * One private method:
 * String formatMessage(String recipient, String message)
 * (Returns a string in the format: "To [recipient]: [message]".)
 * Implement three classes: SmsNotifier, EmailNotifier, and PushNotifier—each
 * implements Notifier and prints out the formatted message when sending.
 * Create a NotifierFactory class with a static method:
 * public static Notifier getNotifier(String type)
 * Returns the correct notifier (SmsNotifier, EmailNotifier, or PushNotifier) based on the type string ("sms", "email", or "push").
 * Demonstrate how to send a notification via each method using the factory.
 */
interface Notifier{
    String DEFAULT_RECIPIENT = "selft@system.com";
    void sendNotification(String recipient, String message);
    static boolean isValidMessage(String message){
        return message!= null && message.length()>0 && message.length()<160;
    }

    /*  A convenient extra default (used in the demo) */
    default void sendFormattedNotification(String recipient, String message) {
        System.out.println(formatMessage(recipient, message));
    }

    default void notifySelf(String message) {
       sendNotification(DEFAULT_RECIPIENT, message);
    }
    private String formatMessage(String recipient,  String message){
        return String.format("To %s: %s", recipient, message);
    }
}
enum TYPE_NOTIFIER {
    SMS, EMAIL, PUSH
}
class SmsNotifier implements Notifier{
    @Override
    public void sendNotification(String recipient, String message) {
        if (!Notifier.isValidMessage(message)) {
            System.out.println("[SMS] Invalid message – not sent.");
            return;
        }
        System.out.print("[SMS] ");
        Notifier.super.sendFormattedNotification(recipient, message);
    }
}
class EmailNotifier implements Notifier{
    @Override
    public void sendNotification(String recipient, String message) {
        if (!Notifier.isValidMessage(message)) {
            System.out.println("[SMS] Invalid message – not sent.");
            return;
        }
        System.out.print("[SMS] ");
        this.sendFormattedNotification(recipient, message);
    }

    @Override
    public void sendFormattedNotification(String recipient, String message) {
        System.out.println("SENDED ");
    }
}
class PushNotifierEach implements Notifier{
    @Override
    public void sendNotification(String recipient, String message) {
        if (!Notifier.isValidMessage(message)) {
            System.out.println("[PUSH] Invalid message – not sent.");
            return;
        }
        System.out.print("[PUSH] ");
        Notifier.super.sendFormattedNotification(recipient, message);
    }
}

class NotifierFactory{
    public static Notifier createNotifier(String type){
       return  switch (type){
            case "sms" -> new SmsNotifier();
            case "email" -> new EmailNotifier();
            case "push" -> new PushNotifierEach();
           default      -> throw new IllegalArgumentException("Unknown notifier type: " + type);

       };
    }
}
public class _4_Exercise4 {
    public static void main(String[] args) {
        // Using the factory to obtain each type of Notifier
        Notifier smsNotifier   = NotifierFactory.createNotifier("sms");
        Notifier emailNotifier = NotifierFactory.createNotifier("email");
        Notifier pushNotifier  = NotifierFactory.createNotifier("push");

        // Send SMS notification
        smsNotifier.sendNotification("+1234567890","Your appointment is confirmed.");

        // Send Email notification
        emailNotifier.sendNotification("user@example.com","You have a new test result available.");

        // Send Push notification
        pushNotifier.sendNotification("user_device_token","Don't forget to take your medicine!");

        // Default method: notifySelf
        emailNotifier.notifySelf("System maintenance scheduled for tonight.");

        // Default method: sendFormattedNotification
        pushNotifier.sendFormattedNotification("admin","Critical update required.");
    }
}
