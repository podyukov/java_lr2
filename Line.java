import java.util.InputMismatchException;
import java.util.Scanner;

public class Line {
    private String line;
    private int x1, x2, y1, y2;

    public Line() {
        System.out.println("Введите первую точку:");
        Point p1 = new Point();
        x1 = p1.getX();
        y1 = p1.getY();

        System.out.println("Введите вторую точку:");
        Point p2 = new Point();
        x2 = p2.getX();
        y2 = p2.getY();

        System.out.println();
        line = String.format("Линия от %s до %s", p1, p2);
    }

    public Line(int x1, int y1, int x2, int y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        this.x1 = p1.getX();
        this.y1 = p1.getY();
        this.x2 = p2.getX();
        this.y2 = p2.getY();
        line = String.format("Линия от %s до %s", p1, p2);
    }

    @Override
    public String toString() {
        return line;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
