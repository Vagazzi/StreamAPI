package org.example;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long count =  Arrays.stream(array).filter(x->x>1&x*x<9).count();
        long mappedCount = Arrays.stream(array).map(x->x-300).filter(x->x<10).count();
        System.out.println(count);
        System.out.println(mappedCount);

    }
}