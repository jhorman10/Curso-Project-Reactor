package com.jhorman.appreactor;

import com.jhorman.appreactor.Combination.Combination;
import com.jhorman.appreactor.Creation.Creation;
import com.jhorman.appreactor.Filter.Filter;
import com.jhorman.appreactor.Operator.Transform;
import com.jhorman.appreactor.Person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AppReactorApplication.class);

	public void reactor(){
		Mono.just(new Person(1, "Juan",29))
				.doOnNext(p -> {
					// logica adicional
					log.info("[doOnNext] Persona: " + p);
				}) // para depuración
				.subscribe(p -> log.info("[subscribe] Persona: " + p)); // recoleccion dato final
	}

	public void mono(){
		Mono.just(new Person(1, "Pedro", 30))
				.subscribe(p-> log.info(p.toString()));
	}

	public void flux(){
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Lucas",20));
		persons.add(new Person(2,"Luis",22));
		persons.add(new Person(3,"Raul",24));

		Flux.fromIterable(persons).subscribe(p-> log.info(p.toString()));
	}

	public void fluxMono(){
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Lucas",20));
		persons.add(new Person(2,"Luis",22));
		persons.add(new Person(3,"Raul",24));

		Flux<Person> fx = Flux.fromIterable(persons);
		fx.collectList().subscribe(list -> log.info(list.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(AppReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// reactor();
		// mono();
		// flux();
		// fluxMono();

		// Creation app = new Creation();
		// app.range();
		// app.repeat();

		// Transform appT = new Transform();
		// appT.map();
		// appT.flatMap();
		// appT.groupBy();

		// Filter appF = new Filter();
		// appF.filter();
		// appF.distinct();
		// appF.take();
		// appF.takeLast();
		// appF.skip();
		// appF.skipLast();

		Combination appC = new Combination();
		appC.merge();
	}
}