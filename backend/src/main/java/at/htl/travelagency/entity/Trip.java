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


    public Trip() {
    }

    public Trip(Trip trip, Customer customer, LocalDate tripStart, LocalDate tripEnd) {
        this.trip = trip;
        this.customer = customer;
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip1 = (Trip) o;
        return Objects.equals(id, trip1.id) && Objects.equals(trip, trip1.trip) && Objects.equals(customer, trip1.customer) && Objects.equals(tripStart, trip1.tripStart) && Objects.equals(tripEnd, trip1.tripEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trip, customer, tripStart, tripEnd);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", trip=" + trip +
                ", customer=" + customer +
                ", tripStart=" + tripStart +
                ", tripEnd=" + tripEnd +
                '}';
    }
}
