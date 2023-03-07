package pl.sda.orange2.entity;

import java.util.Objects;

public class Car {
    private final  Long id;
    private final String colour;
    private  final String brand;
    private  final String cmodel;

    public Car(Long id, String colour, String brand, String cmodel) {
        this.id = id;
        this.colour = colour;
        this.brand = brand;
        this.cmodel = cmodel;
    }

    public Long getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public String getBrand() {
        return brand;
    }

    public String getCmodel() {
        return cmodel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                ", cmodel='" + cmodel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return id.equals(car.id) && colour.equals(car.colour) && brand.equals(car.brand) && cmodel.equals(car.cmodel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colour, brand, cmodel);
    }
}
