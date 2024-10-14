import java.util.InputMismatchException;
import java.util.Scanner;

public class Point {
    private int x = 0;
    private int y = 0;

    public Point() {
        Scanner sx = new Scanner(System.in);
        try {
            System.out.print("Введите x: ");
            x = sx.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены некорректные данные! Будет заменено на 0!\n");
        }
        Scanner sy = new Scanner(System.in);
        try {
            System.out.print("Введите y: ");
            y = sy.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены некорректные данные! Будет заменено на 0!\n");
        }
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("{%d;%d}", x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}