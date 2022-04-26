package ru.pankov.spring.dao;

import org.springframework.stereotype.Component;
import ru.pankov.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int ID_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++ID_COUNT, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++ID_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++ID_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++ID_COUNT, "Katy", 34, "katy@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++ID_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated  = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
