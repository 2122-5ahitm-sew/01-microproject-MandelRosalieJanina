package at.htl.travelagency.control;

import at.htl.travelagency.entity.Trip;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TripRepository implements PanacheRepository<Trip> {
}
