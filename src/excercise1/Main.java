package excercise1;

/*
Given N sorted lists.
Merged into one sorted list.
 */

import java.util.*;

public class Main {

    public static List<Integer> mergeList(List<List<Integer>> list){
        List<Integer> mergedlist = new ArrayList<>();
        Queue<Pair> queue = new PriorityQueue<>();
        for (List<Integer> l: list) {
            queue.add(new Pair(l));
        }

        while(queue.size() > 0) {
            Pair topPair = queue.poll();
            //System.out.println("Adding\t"+topPair.getCurrent());
            mergedlist.add(topPair.getCurrent());
            if(topPair.hasNext()){
                topPair.moveNext();
                queue.add(topPair);
            }
        }

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
        int i=1;
        for (List<Integer> list: nlist) {
            System.out.println("List "+i+"\t"+list);
            i++;
        }
        List<Integer> mergedlist = mergeList(nlist);
        System.out.println("MergedList: "+mergedlist);

    }
}
