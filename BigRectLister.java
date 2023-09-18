import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static ArrayList<Object> collectAll(ArrayList<Object> objects,
                                               Filter f) {
        ArrayList<Object> result = new ArrayList<Object>();

        for (Object obj : objects) {
            if (f.accept(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(new Rectangle(100, 40));
        list.add(new Rectangle(4, 5));
        list.add(new Rectangle(6, 10));
        list.add(new Rectangle(5, 2));
        list.add(new Rectangle(40, 12));
        list.add(new Rectangle(4, 1));
        list.add(new Rectangle(7, 13));
        list.add(new Rectangle(6, 3));
        list.add(new Rectangle(1, 2));
        list.add(new Rectangle(3, 2));

        System.out.println("Unfiltered rectangles:");
        for (Object ob : list) {
            Rectangle rect = (Rectangle) ob;
            System.out.println("Rectangle with width: " + rect.width
                    + ", height: " + rect.height + ", perimeter: "
                    + (2 * (rect.width + rect.height)));
        }
        ArrayList<Object> filtered = collectAll(list, new BigRectangleFilter());

        System.out.println("\nFiltered rectangles:");
        for (Object ob : filtered) {
            Rectangle rect = (Rectangle) ob;
            System.out.println("Rectangle with width: " + rect.width
                    + ", height: " + rect.height + ", perimeter: "
                    + (2 * (rect.width + rect.height)));
        }
    }
}