package com.jhorman.appreactor.Person;

import java.util.Objects;

public class Person {
    private Integer idPerson;
    private String name;
    private Integer yearsOld;

    public Person(Integer idPerson, String name, Integer yearsOld) {
        this.idPerson = idPerson;
        this.name = name;
        this.yearsOld = yearsOld;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(Integer yearsOld) {
        this.yearsOld = yearsOld;
    }

    @Override
    public String toString() {
        return "Person [" + "idPerson = " + idPerson + ", name = '" + name + '\'' + ", yearsOld = " + yearsOld + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idPerson.equals(person.idPerson) &&
                name.equals(person.name) &&
                yearsOld.equals(person.yearsOld);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, name, yearsOld);
    }
}
