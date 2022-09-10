package org.example;

public class appleColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
