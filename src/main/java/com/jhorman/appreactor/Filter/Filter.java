package com.jhorman.appreactor.Filter;

import com.jhorman.appreactor.Person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static final Logger log = LoggerFactory.getLogger(Filter.class);

    public void filter() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .filter(p -> p.getYearsOld() > 20)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct(){

        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(p -> log.info(p.toString()));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
            .distinct()
            .subscribe(p -> log.info(p.toString()));
    }

    public void take() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }
    public void takeLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(p -> log.info(p.toString()));
    }
}
