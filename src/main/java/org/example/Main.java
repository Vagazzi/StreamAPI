package org.example;
import com.sun.source.doctree.SummaryTree;

import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;


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


        long filterCondition = appleBag.stream().filter(x->x.getWeight()>150).count();

        int totalWeight = appleBag.stream().mapToInt(Apple::getWeight).sum();

        IntSummaryStatistics statistics = appleBag.stream().collect(summarizingInt(Apple::getWeight));

        System.out.println(statistics);

        System.out.println(filterCondition);

        System.out.println(totalWeight);

        appleBag = Apple.filterApples(appleBag, new appleColorPredicate());

        //Apple.filterApples(appleBag, new appleWeightPredicate());
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

        apples = (ArrayList<Apple>) apples.stream()
                .filter(x->x.getWeight()>125).filter(x-> Objects.equals(x.getColor(), "green")).collect(Collectors.toList());

        return apples;

    }


}