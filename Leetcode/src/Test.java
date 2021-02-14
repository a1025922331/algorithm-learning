import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Set<List<Integer>> map = new HashSet<>();
        Map<List<Integer>,Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(-1);

        map.put(list,1);
        map.put(Arrays.asList(1,0,-1),1);
        map.put(Arrays.asList(-1,0,1),1);

        System.out.println(map);


        System.out.println("====================================");

        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1,2,3});
        set.add(new int[]{1,2,3});

        System.out.println(set);

        System.out.println("====================================");

        Set<List<Integer>> set2 = new HashSet<>();
        set2.add(Arrays.asList(1,2,3));
        set2.add(Arrays.asList(1,2,3));

        System.out.println(set2);
    }
}
