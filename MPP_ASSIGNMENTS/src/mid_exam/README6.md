You are building a notification system for a messaging app. The app needs to send different kinds of notifications:

Email Notification

SMS Notification

Push Notification

Each type of notification has its own implementation for sending messages.

You want to use the Object Creation Factory design pattern so that the client code can ask for a new notification object without worrying about which specific implementation it is.

**Your Tasks**

- Create a Notification interface with a method:
  - void send(String message);

- Create classes for each notification type (EmailNotification, SMSNotification, PushNotification).
- Each implementation should print a message like:
  - "Email sent: <message>", "SMS sent: <message>", etc.

- Write client code that uses the factory to send a message by type (e.g., "sms", "push", or "email").

- Add a new notification type: InAppNotification.
- What changes are required in your code?
- Explain how the factory pattern makes it easy to add new types.
- How does the factory pattern make your system flexible for future changes or new notification types?

Here’s a complete solution using the **Factory Design Pattern** to build a flexible **Notification System** for a messaging app.

------

## ✅ Step 1: Notification Interface

```java
public interface Notification {
    void send(String message);
}
```

------

## ✅ Step 2: Concrete Implementations

```java

public class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}




public class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

public class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Push Notification sent: " + message);
    }
}
```

------

## ✅ Step 3: Factory Class

```java
public class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            case "inapp" -> new InAppNotification(); // New type supported
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}
```

------

## ✅ Step 4: Add a New Notification Type

```java
public class InAppNotification implements Notification {
    public void send(String message) {
        System.out.println("In-App Notification sent: " + message);
    }
}
```

------

## ✅ Step 5: Client Code (Main)

```java

public class Main {
    public static void main(String[] args) {
        Notification email = NotificationFactory.createNotification("email");
        email.send("Welcome to the system!");

        Notification sms = NotificationFactory.createNotification("sms");
        sms.send("Your code is 1234");

        Notification push = NotificationFactory.createNotification("push");
        push.send("New update available!");

        Notification inapp = NotificationFactory.createNotification("inapp");
        inapp.send("You have a new message.");
    }
}
```

------

## ✅ Output Example

```bat

Email sent: Welcome to the system!
SMS sent: Your code is 1234
Push Notification sent: New update available!
In-App Notification sent: You have a new message.
```

