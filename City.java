import java.util.ArrayList;
import java.util.List;

public class City {
    private String name; // имя города
    private List<CityRoute> routes; // список маршрутов у города

    public City(String name) {
        this.name = name;
        this.routes = new ArrayList<>(); // создаём пустой список к городу
    }

    public void addRoute(City destination, int cost) { // добавление маршрута к городу
        routes.add(new CityRoute(destination, cost)); // добавление объекта маршрута в список
    }

    public String toString() { // когда запросят город, выводим город и его маршруты
        String s = String.format("Маршруты из города %s:\n", name);
        for (CityRoute route : routes) {
            s = s + route + '\n';
        }
        return s;
    }

    public String getName() {
        return name;
    }

    private class CityRoute { // тут мы будем хранить объекты город:стоимость
        private City destination;
        private int cost;

        public CityRoute(City destination, int cost) { // город:стоимость
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("%s:%d", destination.name, cost);
        }
    }
}

