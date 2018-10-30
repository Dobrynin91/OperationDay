package TestOrder;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Dish {
    private String dishAmountInt;
    private String dishName;
    private String fullSum;
    private String orderDeleted;
    private String dishServicePrintTime;
    private String removalType;
    private String storned;
    private String operationType;

    public void setDishAmountInt(String dishAmountInt) {
        this.dishAmountInt = dishAmountInt;
    }

    public String getDishAmountInt() {
        return dishAmountInt;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public String getFullSum() {
        return fullSum;
    }

    public void setFullSum(String fullSum) {
        this.fullSum = fullSum;
    }

    public String getOrderDeleted() {
        return orderDeleted;
    }

    public void setOrderDeleted(String orderDeleted) {
        this.orderDeleted = orderDeleted;
    }

    public String getDishServicePrintTime() {
        return dishServicePrintTime;
    }

    public void setDishServicePrintTime(String dishServicePrintTime) {
        this.dishServicePrintTime = dishServicePrintTime;
    }

    public String getRemovalType() {
        return removalType;
    }

    public void setRemovalType(String removalType) {
        this.removalType = removalType;
    }

    public void setStorned(String storned) {
        this.storned = storned;
    }

    public String getStorned() {

        return storned;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public String toString() {
        int sum = 0;
        if (!fullSum.equals("0E-17")) {
            sum = (int) Double.parseDouble(fullSum);
        }
        int amount = (int) Double.parseDouble(dishAmountInt);
        return amount + " " + this.dishName + " " + sum;
    }

    private static Dish getDish(Node node) {
        Dish dish = new Dish();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            dish.setOrderDeleted(getTagValue("OrderDeleted", element));
            dish.setStorned(getTagValue("Storned", element));
            dish.setDishServicePrintTime(getTagValue("DishServicePrintTime", element));
            dish.setRemovalType(getTagValue("RemovalType", element));
            dish.setOperationType(getTagValue("OperationType", element));
            if (dish.getOrderDeleted().equals("NOT_DELETED")) {
                if (dish.getStorned() == null) {
                    if (dish.getOperationType().equals("PAYMENT") | dish.getOperationType().equals("NO_PAYMENT")) {
                        if (dish.getRemovalType() == null) {
                            if (dish.getDishServicePrintTime() != null) {
                                dish.setDishAmountInt(getTagValue("DishAmountInt", element));
                                dish.setDishName(getTagValue("DishName", element));
                                dish.setFullSum(getTagValue("fullSum", element));
                                return dish;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0)
                .getChildNodes();
        Node node = nodeList.item(0);
        if (node != null) {
            return node.getNodeValue();
        }
        return null;
    }

    public static void listDish(String pathfile) {
        ArrayList<Dish> dishList = new ArrayList<>();
        NodeList list = XMLParse.xmlParse(pathfile);
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
                if (Dish.getDish(list.item(i)) != null) {
                    dishList.add(Dish.getDish(list.item(i)));
                }
            }
        }
        for (Dish dish : dishList) {
            System.out.println(dish);
        }
    }
}


