package com.jhorman.appreactor.Creation;

import com.jhorman.appreactor.Person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


public class Creation {
    private static final Logger log = LoggerFactory.getLogger(Creation.class);

    public void justFrom(){
        Mono.just(new Person(1, "Maria", 20));
        // Flux.fromIterable(collection);
        // observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        // Observable.empty();
    }

    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i : " + i)).subscribe();
    }

    public void repeat(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Lucas",20));
        persons.add(new Person(2,"Luis",22));
        persons.add(new Person(3,"Raul",24));

        Flux.fromIterable(persons).repeat(3).subscribe(p -> log.info(p.toString()));

        /*Mono.just(new Person(1,"Lucas",20))
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));*/
    }
}
