package org.example;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) {
        //callIntStream();
        //peopleFilter();

        ArrayList<Apple> appleBag = new ArrayList<>();

        appleBag.add(new Apple("green",322));
        appleBag.add(new Apple("yellow",100));
        appleBag.add(new Apple("red",423));
        appleBag.add(new Apple("green",1010));
        appleBag.add(new Apple("yellow",32));

        Apple.filterApples(appleBag, new appleColorPredicate());

        appleBag.forEach(System.out::println);

    }



    public static void callIntStream() {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(56345);
        numbers.stream()
                .filter(s -> s > 6)
                .forEach(System.out::println);

    }

    public static void peopleFilter(){

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
                map(PersonDTO::getAge).
                filter(age -> age >25).
                forEach(System.out::println);


    }
    public static ArrayList<Apple> appleFilter(ArrayList<Apple> apples){

        apples.add(new Apple("green",322));
        apples.add(new Apple("yellow",100));
        apples.add(new Apple("red",423));
        apples.add(new Apple("green",1010));
        apples.add(new Apple("yellow",32));

        apples = (ArrayList<Apple>) apples.stream()
                .filter(x->x.getWeight()>125).filter(x-> Objects.equals(x.getColor(), "green")).collect(Collectors.toList());

        return apples;

    }


}