package org.snoflo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * CollectionExample
 */
public class CollectionExample {

    public static <T> List<T> collectionTest(List<T> collection) {
        List<T> list = collection; 
        return list;
    }
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("유진우");

        System.out.println(list.get(0));

        collectionTest(list);
        System.out.println(collectionTest(list));
    }
}