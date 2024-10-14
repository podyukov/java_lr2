import com.sun.nio.sctp.NotificationHandler;

public class Fraction { // дробь
    private int numerator; // числитель
    private int denominator; // знаменатель

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен 0! Заменен на 1!");
            this.denominator = 1;
        }
        else this.denominator = denominator;
        simplify(); // упрощаем дробь
    }

    private void simplify() { // упрощение дроби
        int gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int gcd(int a, int b) { // greatest common divisior - наибольший общий делитель
        if (b == 0) return a; // алгоритм Евклида
        return gcd(b, a % b);
    }

    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction div(Fraction other) {
        if (other.denominator == 0) {
            System.out.println("Деление на ноль! Знаменатель будет заменён на 1!");
            int newNumerator = this.numerator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator);
        }
        else {
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator);
        }
    }

    public Fraction sum(int number) {
        return this.sum(new Fraction(number, 1));
    }

    public Fraction minus(int number) {
        return this.minus(new Fraction(number, 1));
    }

    public Fraction multiply(int number) {
        return this.multiply(new Fraction(number, 1));
    }

    public Fraction div(int number) {
        return this.div(new Fraction(number, 1));
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
