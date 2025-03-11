package app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private int year;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car(Long id, String name, String model, int year) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public Car() {
    }


}
