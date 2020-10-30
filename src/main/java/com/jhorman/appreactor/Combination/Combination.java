package com.jhorman.appreactor.Combination;

import com.jhorman.appreactor.Person.Person;
import com.jhorman.appreactor.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static final Logger log = LoggerFactory.getLogger(Combination.class);

    public void merge(){
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1,"Lucas",20));
        persons1.add(new Person(2,"Luis",22));
        persons1.add(new Person(3,"Raul",24));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4,"Jaime",20));
        persons2.add(new Person(5,"Pedro",22));
        persons2.add(new Person(6,"Pepe",24));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        Flux.merge(fx1, fx2, fx3).subscribe(p -> log.info(p.toString()));

    }
}
