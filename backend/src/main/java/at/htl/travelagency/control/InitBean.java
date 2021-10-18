package at.htl.travelagency.control;

import at.htl.travelagency.entity.Customer;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {


    @Transactional
    public void startUp(@Observes StartupEvent startupEvent) {

        Customer rosi = new Customer("Rosalie","Mandel","rosalie.mandel@email.at");
        Customer mia = new Customer("Mia","Mandel","mia.mandel@email.at");
        Customer sophie = new Customer("Sophie","Sambs","sophie.sambs@email.at");
        Customer hannah = new Customer("Hannah","Kauer","hannah.kauer@email.at");
        Customer paul = new Customer("Paul","Mauer","paul.mauer@email.at");

        rosi.persist();
        mia.persist();
        sophie.persist();
        hannah.persist();
        paul.persist();
    }
}
