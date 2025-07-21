import prob2A.Student;
import prob2B.Order;
import prob2B.OrderLine;

/**
 * @author: Leonardo Medina
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Leonardo");
        System.out.println("Student name: "+student.getName());
        System.out.println("Students 1 - 1 Grade report "+ student.getGradeReport().getStudent().getName());

        Order order = new Order("MPP-401");
        OrderLine orderLine1 = new OrderLine(order);
        OrderLine orderLine2 =  new OrderLine(order);
        System.out.println("Order Number: "+ order.getOrderNum());
        System.out.println("Order size: "+ order.getOrderLines().size());
        System.out.println(" - OrderLine1 liked to: "+orderLine1.getOrder().getOrderNum());
        System.out.println(" - OrderLine2 liked to: "+orderLine2.getOrder().getOrderNum());
    }
}