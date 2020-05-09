package excercise1;

import java.util.List;

public class Pair implements Comparable<Pair> {

    int index;
    List<Integer> list;

    public Pair(List<Integer> list){
        index = 0;
        this.list = list;
    }

    public int getCurrent(){
        return list.get(index);
    }

    public void moveNext(){
        index++;
    }

    boolean hasNext(){
        return (index+1<list.size());
    }

    @Override
    public int compareTo(Pair o) {
        return this.getCurrent()-o.getCurrent();
    }

    public String toString(){
        return ""+list;
    }
}
