package TestOrder;

import java.io.*;

public class MainClass {
    private static final String FILENAME1 = "CHER__tmp_20180113.xml";
    private static final String FILENAME2 = "CHER__tmp_20180214.xml";
    private static final String FILENAME3 = "CHER__tmp_20180223.xml";
    private static final String FILENAME4 = "CHER__tmp_20180308.xml";

    public static void main(String[] args) {
        Order.listOrder(FILENAME1);
//        Dish.listDish(FILENAME1);
//        try {
//            PrintWriter printWriter = new PrintWriter(new FileWriter("text.txt"));
//            for (Dish dish : Dish.listDish(FILENAME1)) {
//                printWriter.println(dish.toString());
//            }
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }
}

