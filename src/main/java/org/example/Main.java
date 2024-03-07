package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        OwnArrayList<Integer> test = new OwnArrayList<>();

        test.add(8);
        test.add(7);
        test.add(6);
        test.add(5);
        test.add(4);

        test.sort(Comparator.naturalOrder());

        test.showAll();



    }
}