package excercise1;

/*
For two lists of sorted integers, a and b.
Merge a and b into one sorted list.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> mergeList(List<Integer> l1, List<Integer> l2){
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;

        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)){
                list.add(l1.get(i++));
            } else {
                list.add(l2.get(j++));
            }
        }

        while(i<l1.size()){
            list.add(l1.get(i++));
        }

        while(j<l2.size()){
            list.add(l2.get(j++));
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5, 8);
        List<Integer> list2 = List.of(4, 6, 8, 10, 12, 16);
        List<Integer> sortedlist = mergeList(list1, list2);
        System.out.println("List1: "+list1);
        System.out.println("List2: "+list2);
        System.out.println("Mergerd "+sortedlist);
    }
}
