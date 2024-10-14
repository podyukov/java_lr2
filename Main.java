import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean bexit = true;
        while (bexit) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("\n> Введите номер задания (1.1 это 11) (0 для выхода): ");
            try {
                int nn = scanner1.nextInt();
                System.out.println();
                switch (nn) {
                    case 0: {
                        bexit = false;
                        break;
                    }
                    case 11: { // задание "точка координат"
                        System.out.println("Согласно условию задания, нужно ввести три точки");
                        Scanner scanner = new Scanner(System.in);
                        int ap = 3; // количество точек
                        Point[] point = new Point[ap];
                        for (int i = 0; i < ap; i++) {
                            System.out.println(String.format("Начинайте вводить %d точку (целое число)", i+1));
                            point[i] = new Point();
                        }
                        System.out.println("Координаты введены успешно!");
                        for (int i = 0; i < ap; i++) {
                            System.out.println(String.format("Точка %d: %s", i+1, point[i]));
                        }
                        break;
                    }
                    case 13: { // задание "имена"
                        try {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Введите фамилию (или ничего): ");
                            String secname = scanner.nextLine();
                            System.out.print("Введите имя (или ничего): ");
                            String name = scanner.nextLine();
                            System.out.print("Введите отчество (или ничего): ");
                            String father_name = scanner.nextLine();
                            System.out.println("Данные успешно введены!");
                            Name person = new Name(secname, name, father_name);
                            System.out.println(person);
                        } catch (InputMismatchException e) {
                            System.out.println("Введены некорректные данные! Выход из цикла!\n");
                            break;
                        }
                        break;
                    }
                    case 21: { // задание "прямая"
                        System.out.println("Создание первой линии:");
                        Line line1 = new Line();
                        System.out.println("Создание второй линии:");
                        Line line2 = new Line();
                        Line line3 = new Line(line1.getX1(), line1.getY1(), line2.getX2(), line2.getY2());
                        System.out.println(String.format("Линия 1: %s", line1));
                        System.out.println(String.format("Линия 2: %s", line2));
                        System.out.println(String.format("Линия 3: %s", line3));
                        System.out.println("\nПосле создания всех трёх объектов изменяем координаты 1 и 2 линий");
                        System.out.println("Новые координаты первой линии:");
                        line1 = new Line();
                        System.out.println("Новые координаты второй линии:");
                        line2 = new Line();
                        line3 = new Line(line1.getX1(), line1.getY1(), line2.getX2(), line2.getY2());
                        System.out.println("Изменились и координаты 3 линии\n");
                        System.out.println(String.format("Линия 1: %s", line1));
                        System.out.println(String.format("Линия 2: %s", line2));
                        System.out.println(String.format("Линия 3: %s", line3));
                        System.out.println("\nА теперь изменим координаты 1 линии, и у 3 ничего не поменяется");
                        System.out.println("Новые координаты первой линии:");
                        line1 = new Line();
                        System.out.println(String.format("Линия 1: %s", line1));
                        System.out.println(String.format("Линия 2: %s", line2));
                        System.out.println(String.format("Линия 3: %s", line3));
                        break;
                    }
                    case 33: { // задание "города"
                        List<City> cities = new ArrayList<>();
                        System.out.println("Построчно вводите какие города будут учитываться. Чтобы закончить, ничего не вводите и нажмите enter:");
                        for (boolean b = true; b != false;) {
                            Scanner scanner = new Scanner(System.in);
                            String name = scanner.nextLine();
                            if (Objects.equals(name, "")) b = false;
                            else cities.add(new City(name));
                        }

                        for (City city : cities) {
                            System.out.println(String.format("\nВведите маршруты для города %s", city.getName()));
                            System.out.print("Сколько маршрутов будет? ");
                            int r = 0;
                            try {
                                Scanner scanner = new Scanner(System.in);
                                r = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Введены некорректные данные! Маршрутов для этого города не будет!\n");
                            }
                            for (int i = 0; i < r; i++) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Введите город назначения: ");
                                String dcityname = scanner.nextLine();
                                City dcity = new City(dcityname);
                                System.out.print("Введите стоимость до этого города: ");
                                int dcost = 0;
                                try {
                                    dcost = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Введены некорректные данные! Стоимость будет равна нулю!\n");
                                }
                                city.addRoute(dcity, dcost);
                            }
                        }
                        System.out.println();
                        for (City city : cities) { // вывод маршрутов
                            System.out.println(city);
                        }
                        break;
                    }
                    case 48: { // задание "создаём города"
                        List<City> cities = new ArrayList<>(); // Создаем список городов
                        int numCities = 0;
                        try {
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Введите количество городов: ");
                            numCities = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Введены некорректные данные! Выход!\n");
                            break;
                        }
                        for (int i = 0; i < numCities; i++) { // создание городов
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Введите название города: ");
                            String cityName = scanner.nextLine();
                            City city = new City(cityName);
                            cities.add(city);
                        }
                        for (City city : cities) { // ввод маршрутов для каждого города
                            System.out.print(String.format("Введите количество маршрутов для города %s: ", city.getName()));
                            int numRoutes = 0;
                            try {
                                Scanner scanner = new Scanner(System.in);
                                numRoutes = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Введены некорректные данные! Количество маршрутов для этого города будет равно 0!\n");
                            }
                            for (int i = 0; i < numRoutes; i++) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Введите название города назначения: ");
                                String destinationName = scanner.nextLine();
                                // поиск города назначения в списке уже созданных городов
                                City destinationCity = null;
                                for (City c : cities) {
                                    if (c.getName().equals(destinationName)) { // если имя города совпадает с городом назначения
                                        destinationCity = c;
                                        break;
                                    }
                                }
                                // если город не нашли
                                if (destinationCity == null) {
                                    System.out.println("Город с именем " + destinationName + " не найден.");
                                    continue; // идём в следующий маршрут
                                }
                                System.out.print("Введите стоимость маршрута до " + destinationName + ": ");
                                int cost = 0;
                                try {
                                    cost = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Введены некорректные данные! Стоимость маршрута будет равна 0!\n");
                                }
                                city.addRoute(destinationCity, cost); // добавляем маршрут
                            }
                        }
                        // выаодим информацию о городах и маршрутах
                        for (City city : cities) {
                            System.out.println(city);
                        }
                        break;
                    }
                    case 55: { // задание "дроби"
                        // примеры создания дробей
                        Fraction f1 = new Fraction(1, 3);
                        Fraction f2 = new Fraction(2, 3);
                        Fraction f3 = new Fraction(3, 4);

                        // примеры использования методов
                        Fraction resultSum = f1.sum(f2);
                        Fraction resultMinus = f1.minus(f2);
                        Fraction resultMultiply = f1.multiply(f2);
                        Fraction resultDiv = f1.div(f2);

                        // вывод результатов
                        System.out.println(String.format("%s + %s = %s", f1, f2, resultSum));
                        System.out.println(String.format("%s - %s = %s", f1, f2, resultMinus));
                        System.out.println(String.format("%s * %s = %s", f1, f2, resultMultiply));
                        System.out.println(String.format("%s / %s = %s", f1, f2, resultDiv));

                        // пример выполнения цепочки операций
                        Fraction resultChain = f1.sum(f2).div(f3).minus(5);
                        System.out.println(String.format("%s + %s / %s - 5 = %s", f1, f2, f3, resultChain));
                        break;
                    }
                    default: {
                        System.out.println("Неверный номер задачи!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены некорректные данные!");
            }
        }
    }
}