import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean bexit = true;
        while (bexit) {
            Scanner scannernn = new Scanner(System.in);
            System.out.print("\n> Введите номер задания (1.1 это 11) (0 для выхода): ");
            try {
                int nn = scannernn.nextInt();
                System.out.println();
                switch (nn) {
                    case 0: {
                        System.out.println("До свидания!");
                        bexit = false;
                        break;
                    }
                    case 110: { // задание "дороги"
                        Scanner scanner = new Scanner(System.in);
                        List<City> cities = new ArrayList<>();
                        // Ввод городов
                        System.out.println("Введите названия городов. Для завершения оставьте строку пустой и нажмите Enter:");
                        while (true) {
                            String cityName = scanner.nextLine();
                            if (cityName.isEmpty()) break;
                            cities.add(new City(cityName));
                        }
                        // Ввод маршрутов для каждого города
                        for (City city : cities) {
                            System.out.printf("\nВведите количество маршрутов для города %s: ", city.getName());
                            int routeCount = scanner.nextInt();
                            scanner.nextLine(); // очистка перехода на новую строку

                            for (int i = 0; i < routeCount; i++) {
                                System.out.print("Введите город назначения: ");
                                String destCityName = scanner.nextLine();

                                // Проверка, существует ли уже этот город
                                City destination = findCityByName(cities, destCityName);
                                if (destination == null) {
                                    destination = new City(destCityName);
                                    cities.add(destination);
                                }

                                System.out.print("Введите стоимость маршрута: ");
                                int cost = scanner.nextInt();
                                scanner.nextLine(); // очистка перехода на новую строку

                                city.addRoute(destination, cost);
                            }
                        }
                        // Меню для добавления, обновления и удаления маршрутов
                        while (true) {
                            System.out.println("\nВыберите действие: ");
                            System.out.println("1 - Добавить маршрут");
                            System.out.println("2 - Обновить маршрут");
                            System.out.println("3 - Удалить маршрут");
                            System.out.println("4 - Показать маршруты всех городов");
                            System.out.println("0 - Выйти");
                            int choice = scanner.nextInt();
                            scanner.nextLine(); // очистка перехода на новую строку
                            if (choice == 0) break;
                            switch (choice) {
                                case 1:
                                    System.out.print("Введите название города отправления: ");
                                    String sourceName = scanner.nextLine();
                                    City source = findCityByName(cities, sourceName);
                                    if (source == null) {
                                        System.out.println("Город не найден.");
                                        continue;
                                    }
                                    System.out.print("Введите название города назначения: ");
                                    String destName = scanner.nextLine();
                                    City destination = findCityByName(cities, destName);
                                    if (destination == null) {
                                        destination = new City(destName);
                                        cities.add(destination);
                                    }
                                    System.out.print("Введите стоимость маршрута: ");
                                    int cost = scanner.nextInt();
                                    scanner.nextLine();
                                    source.addRoute(destination, cost);
                                    break;
                                case 2:
                                    System.out.print("Введите название города отправления: ");
                                    sourceName = scanner.nextLine();
                                    source = findCityByName(cities, sourceName);
                                    if (source == null) {
                                        System.out.println("Город не найден.");
                                        continue;
                                    }
                                    System.out.print("Введите название города назначения: ");
                                    destName = scanner.nextLine();
                                    destination = findCityByName(cities, destName);
                                    if (destination != null) {
                                        System.out.print("Введите новую стоимость маршрута: ");
                                        int newCost = scanner.nextInt();
                                        scanner.nextLine();
                                        source.updateRoute(destination, newCost);
                                    } else {
                                        System.out.println("Маршрут не найден.");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Введите название города отправления: ");
                                    sourceName = scanner.nextLine();
                                    source = findCityByName(cities, sourceName);
                                    if (source == null) {
                                        System.out.println("Город не найден.");
                                        continue;
                                    }
                                    System.out.print("Введите название города назначения: ");
                                    destName = scanner.nextLine();
                                    destination = findCityByName(cities, destName);
                                    if (destination != null) {
                                        source.removeRoute(destination);
                                    } else {
                                        System.out.println("Маршрут не найден.");
                                    }
                                    break;
                                case 4:
                                    for (City city : cities) {
                                        System.out.println(city);
                                    }
                                    break;
                                default:
                                    System.out.println("Некорректный выбор.");
                                    break;
                            }
                        }
                        scanner.close();
                        break;
                    }

                    case 35: { // задание "трёхмерная точка"
                        System.out.println("Введите точку");
                        Scanner scanner = new Scanner(System.in);
                        int ap = 1; // количество точек
                        PointZ[] point = new PointZ[ap];
                        for (int i = 0; i < ap; i++) {
                            System.out.println(String.format("Начинайте вводить %d точку (целое число)", i+1));
                            point[i] = new PointZ();
                        }
                        System.out.println("Координаты введены успешно!");
                        for (int i = 0; i < ap; i++) {
                            System.out.println(String.format("Точка %d: %s", i+1, point[i]));
                        }
                        break;
                    }
                    case 43: {
                        Bird sparrow = new Sparrow(); // воробей
                        Bird cuckoo = new Cuckoo(); // кукушка
                        Bird parrot = new Parrot("Привет!"); // попугай
                        sparrow.sing();
                        cuckoo.sing();
                        parrot.sing();
                        break;
                    }
                    case 73: {
                        System.out.println("Задание 7.3 оформлено другим проектом,");
                        System.out.println("так как там в Main передаются параметры из командной строки");
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
    // Метод для поиска города по имени
    private static City findCityByName(List<City> cities, String name) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }
}
