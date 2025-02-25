package Testing_with_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Puse Set example
public class Example1 {
    List<String> names = List.of("one", "two", "three", "four", "five", "six");
    Set<String> name_set = new HashSet<>();

    public Example1(){
        name_set.addAll(names);
        name_set.forEach(System.out::println);
    }

//    Adding element in a set
    Set<String> students = new HashSet<>();
    public void addVal(String name){
        students.add(name);
    }
    public void removeVal(String name){
        students.remove(name);
    }

    public void display(){
        students.forEach(System.out::println);
    }
}
