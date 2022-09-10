package org.example;

public class appleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
