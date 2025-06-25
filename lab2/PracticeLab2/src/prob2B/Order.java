package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNum;
    private List<OrderLine>  orderLines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.orderLines = new ArrayList<OrderLine>();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void addOrderLines(OrderLine orderLines) {
        this.orderLines.add(orderLines);
    }
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

}
