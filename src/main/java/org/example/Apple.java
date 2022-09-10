package org.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
public class Apple{
     public Apple(String color, int weight){
         this.color = color;
         this.weight = weight;
     }
     private int weight;
     private String color;

     public static ArrayList<Apple> filterApples (ArrayList<Apple> inventory, ApplePredicate p){
         ArrayList<Apple> filterResult = new ArrayList<>();
         for(Apple apple : inventory){
             if (p.test(apple)) {
                 filterResult.add(apple);
             }
         }
         return filterResult;
     }
}