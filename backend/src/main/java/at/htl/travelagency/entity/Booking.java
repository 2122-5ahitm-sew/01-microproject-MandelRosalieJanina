package at.htl.travelagency.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TA_BOOKNG")
public class Booking extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "TRIP_ID")
    private Trip trip;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "TRIPSTART")
    private LocalDate tripStart;

    @Column(name = "TRIPEND")
    private LocalDate tripEnd;

    public Booking(Trip trip, Customer customer, LocalDate tripStart, LocalDate tripEnd) {
        this.trip = trip;
        this.customer = customer;
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
    }


    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getTripStart() {
        return tripStart;
    }

    public void setTripStart(LocalDate tripStart) {
        this.tripStart = tripStart;
    }

    public LocalDate getTripEnd() {
        return tripEnd;
    }

    public void setTripEnd(LocalDate tripEnd) {
        this.tripEnd = tripEnd;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", trip=" + trip +
                ", customer=" + customer +
                ", tripStart=" + tripStart +
                ", tripEnd=" + tripEnd +
                '}';
    }
}
