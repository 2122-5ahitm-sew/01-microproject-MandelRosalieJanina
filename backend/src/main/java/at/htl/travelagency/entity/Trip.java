package at.htl.travelagency.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity()
@Table(name = "TA_TRIP")
public class Trip extends PanacheEntityBase {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double price;

    @Column
    private String destination;

    public Trip(double price, String destination) {
        this.price = price;
        this.destination = destination;
    }

    public Trip() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                '}';
    }
}
