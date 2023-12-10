package СТР87;

public class Car {

    private int id;

    private String marka;

    private String model;

    private double year;

    private String color;

    private double price;

    private int registration_number;

    public Car(int id, String marka, String model, double year, String color, double price, int registration_number) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registration_number = registration_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>0) {
            this.year = year;
        } else System.out.println("Год выпуска не может быть отрицательным или нулевым!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price>0) {
            this.price = price;
        } else System.out.println("Цена не может быть отрицательной или нулевой!");
    }

    public int getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(int registration_number) {
        this.registration_number = registration_number;
    }

    @Override
    public String toString() {
        return "Машина —- " +
                "id=" + id +
                ", Марка=" + marka +
                ", Модель=" + model +
                ", Год выпуска=" + year +
                ", Цвет=" + color +
                ", Цена=" + price +
                ", Регистрационный номер=" + registration_number;
    }
}

