package org.example;
import java.io.InputStream;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        callIntStream();

        ArrayList<PersonDTO> people = new ArrayList<>();

        people.add(new PersonDTO("Van","Darkholme",54));
        people.add(new PersonDTO("Billy","Herrington",52));
        people.add(new PersonDTO("Billy","Leatherman",27));
        people.add(new PersonDTO("Billy","Airish",32));
        people.add(new PersonDTO("Steve", "Cassady", 25));

        people.stream()
                .filter(x->x.getAge()>25).forEach(x-> System.out.println(x.getName() + " " + x.getSurname()));

        people.stream().filter(x-> !Objects.equals(x.getName(), "Steve")).
                filter(x->x.getName().equals("Billy")).
                filter(x->x.getAge()>25).
                map(x->x.getName()).
                forEach(x->System.out.println(x));

        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y);
        System.out.println(sentence.get());


    }

    public static void callIntStream() {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(56345);
        numbers.stream()
                .filter(s -> s > 6)
                .forEach(System.out::println);

    }

}