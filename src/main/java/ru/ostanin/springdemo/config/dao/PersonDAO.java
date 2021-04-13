package ru.ostanin.springdemo.config.dao;

import org.springframework.stereotype.Component;
import ru.ostanin.springdemo.config.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Maksim"));
        people.add(new Person(2, "Dasha"));
        people.add(new Person(3, "Sasha"));
        people.add(new Person(4, "Kirill"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }
}
