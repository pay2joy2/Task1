package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        OwnArrayList<Integer> test = new OwnArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);

        test.add(1,9);

        System.out.println(test.showAsList());

//
//        test.clear();
//
//        OwnArrayList<String> aboba = new OwnArrayList<>();
//
//        aboba.add("Z");
//        aboba.add("B");
//        aboba.add("Y");
//        aboba.add("M");
//        aboba.add("A");
//        aboba.add("X");
//
//        aboba.sort(Comparator.naturalOrder());
//
//        System.out.println(aboba.showAsList());

//        ArrayList<Integer> x =  new ArrayList<>();
//
//        x.add(1);
//        x.add(2);
//        x.add(3);
//
//        for(Integer meow : x){
//            System.out.println(meow);
//        }
//
//        x.add(1,9);
//
//        for(Integer meow : x){
//            System.out.println(meow);
//        }

    }
}