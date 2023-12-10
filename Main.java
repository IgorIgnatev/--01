package СТР87;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputAction = new Scanner(System.in);
        System.out.println("Введите запрос для вывода данных о авто:");
        System.out.println("a) список авто заданной марки;\n" +
                "b) список авто заданной модели, которые эксплуатируются больше n лет;\n" +
                "c) список авто с заданнм годом выпуска, цена которых больше заданной.\n\n");
        System.out.print("Ввод: ");
        String i = inputAction.nextLine();
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(1, "BMW", "M2", 2003, "красный", 800500, 25));
        cars.add(new Car(2, "Honda", "Pilot", 2000, "желтый", 590670, 39));
        cars.add(new Car(3, "Volkswagen", "Jetta", 1995, "зеленый", 900000, 77));
        cars.add(new Car(4, "Ford", "M2", 1980, "синий", 123670, 46));
        cars.add(new Car(5, "Audi", "A8", 1987, "голубой", 687120, 80));
        cars.add(new Car(6, "Hyundai", "Solaris", 2010, "фиолетовый", 688990, 12));
        cars.add(new Car(7, "Porsche", "911Carrera", 2001, "оранжевый", 645120, 120));
        cars.add(new Car(8, "Nissan", "Ariya", 2019, "белый", 637400, 576));
        cars.add(new Car(9, "Mercedes-Benz", "CLS", 2000, "черный", 360590, 210));
        cars.add(new Car(10, "Ford", "Tourneo", 2015, "розовый", 756888, 582));
        switch (i) {
            case "a" -> {
                System.out.print("a) Введите наименование марки: ");
                String a = inputAction.next();
                String s;
                for (Car my : cars) {
                    s = my.getMarka();
                    if (a.equals(s)) {
                        System.out.println(my.toString());
                    }
                }
            }
            case "b" -> {
                System.out.print("b) Введите наименование модели: ");
                String a1 = inputAction.next();
                System.out.print("Введите год: ");
                Scanner in = new Scanner(System.in);
                double b = in.nextDouble();
                for (Car my : cars) {
                    if (a1.equals(my.getModel()) && b < my.getYear()) {
                        System.out.println(my.toString());
                    }
                }
            }
            case "c" -> {
                System.out.print("c) Введите год выпуска: ");
                double a3 = inputAction.nextDouble();
                System.out.print("Введите цену: ");
                double b2 = inputAction.nextDouble();
                for (Car my : cars) {
                    if (a3 == my.getYear() &&  my.getPrice()>b2) {
                        System.out.println(my.toString());
                    }
                }
            }
        }
    }
}

