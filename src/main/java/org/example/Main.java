package org.example;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingInt;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G","-Xmx4G"})
@State(Scope.Benchmark)
public class Main {

    private static final Long N = 10_000_000L;
    @Benchmark
    public static Long seqSum(){
        return Stream.iterate(1L,i->i+1).limit(N).reduce(0L,Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown(){
        System.gc();
    }

    public static void main(String[] args) {
        callIntStream();
        peopleFilter();

        ArrayList<Apple> appleBag = new ArrayList<>();

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        int result = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Element sum is " + result);

        Long anotherRes = Long.valueOf(numbers.stream().filter(x->x>=5).map(x->x*x).reduce(1,(a, b)->a*b));

        System.out.println("Multiplication res is " + anotherRes);

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

        Apple.filterApples(appleBag, new appleWeightPredicate());
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