package TestOrder;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String uniqOrderId;
    private String orderNum;
    private String orderType;
    private ArrayList<Dish> dishList;

    public String getUniqOrderId() {
        return uniqOrderId;
    }

    public void setUniqOrderId(String uniqOrderId) {
        this.uniqOrderId = uniqOrderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }

    public String toString() {
        if (getOrderType().equals("Обычный заказ")) {
            this.orderType = "0";
        }
        if (getOrderType().equals("Доставка курьером")) {
            this.orderType = "1";
        }
        if (getOrderType().equals("Доставка самовывоз")) {
            this.orderType = "2";
        }
        return this.orderNum + " "+ this.uniqOrderId +" "+ this.orderType + " " + this.dishList;
    }

    private static Order getOrder(Node node) {
        Order order = new Order();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            order.setUniqOrderId(getTagValue("UniqOrderId.Id", element));
            order.setOrderNum(getTagValue("OrderNum", element));
            order.setOrderType(getTagValue("OrderType", element));

        }
        return order;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0)
                .getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    static void listOrder(String pathfile) {
        List<Order> orderList = new ArrayList<>();
        NodeList list = XMLParse.xmlParse(pathfile);
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
//                if (Order.getOrder(list.item(i)) != null) {
                orderList.add(Order.getOrder(list.item(i)));
//                }
            }
        }
        int count = 0;
        for (Order order : orderList) {
            System.out.println(order);
            count++;
        }
        System.out.println(count);
    }


}
