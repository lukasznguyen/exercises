package excercise1;

/*
Given N sorted lists.
Merged into one sorted list.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Integer> mergeList(List<List<Integer>> list){
        List<Integer> mergedlist = new ArrayList<>();
        for (List<Integer> l: list) {
            mergedlist.addAll(l);
        }
        Collections.sort(mergedlist);
        return mergedlist;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5, 8);
        List<Integer> list2 = List.of(4, 6, 8, 10, 12, 16);
        List<Integer> list3 = List.of(3, 4, 5, 6, 7);
        List<Integer> list4 = List.of(1, 3, 7, 8);
        List<List<Integer>> nlist = new ArrayList<>();
        nlist.add(list1);
        nlist.add(list2);
        nlist.add(list3);
        nlist.add(list4);
        List<Integer> mergedlist = mergeList(nlist);
        int i=0;
        for (List<Integer> x: nlist) {
            System.out.println("List "+i+":\t"+x);
            i++;
        }
        System.out.println("Merged "+mergedlist);
    }
}
