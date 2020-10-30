package com.jhorman.appreactor.Operator;

import com.jhorman.appreactor.Person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    private static final Logger log = LoggerFactory.getLogger(Transform.class);

    public void map(){
        /*List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
            .map(p-> {
                p.setYearsOld(p.getYearsOld() + 10);
                return p;
            })
            .subscribe(p -> log.info(p.toString())); */
        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("X: " + x));
    }

    public void flatMap(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .flatMap(p-> {
                    p.setYearsOld(p.getYearsOld() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(1,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .groupBy(Person::getIdPerson)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
