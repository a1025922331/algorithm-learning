import java.util.*;

public class Exercise0433_minimum_genetic_mutation {
//    // DFS回溯：
//    // 因为每次变化必须合法，因此可以从bank中取一个只相差一个元素的string做为当前变化并进入下一层递归。
//    // 时间复杂度: O(k * len(bank)^2)
//    // 空间复杂度: O(len(bank))
//    public int minMutation(String start, String end, String[] bank) {
//        boolean[] hasVisited = new boolean[bank.length];
//        int minStep[] = {Integer.MAX_VALUE}; //仅用0索引来存放最小值，方便做为形参进行修改
//        dfs(start, end, bank, hasVisited, 0, minStep);
//        return minStep[0] == Integer.MAX_VALUE ? -1: minStep[0];
//    }
//
//    private void dfs(String start, String end, String[] bank, boolean[] hasVisited, int step, int[] minStep) {
//        if (step >= minStep[0]) //剪枝
//            return;
//        if (start.equals(end)) {
//            minStep[0] = Math.min(minStep[0], step);
//            return;
//        }
//        for (int i = 0; i < bank.length; i++) {
//            if (!hasVisited[i] && isValid(start, bank[i])) {
//                hasVisited[i] = true;
//                dfs(bank[i], end, bank, hasVisited, step + 1, minStep); //下探
//                hasVisited[i] = false;  // 回溯
//            }
//        }
//    }
//
//    private boolean isValid(String s1, String s2) {
//        int numDif = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i))
//                if (++numDif > 1) break;
//        }
//        return numDif == 1;
//    }


    //BFS (每次改变一个元素，看是否变为end，变为end则返回当前层数，若没有则再判断是否在剩余bank中，
    //若在其中则将修改后的字符串加入队列，若不在尝试修改成其他字符。层次遍历可以保证了第一个变为end的路径为最短路径)
    public int minMutation(String start, String end, String[] bank) {
        //将bank装进哈希集合中，便于判断
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Deque<String> queue = new LinkedList<>();
        char[] four = {'A', 'C', 'G', 'T'};
        if (!bankSet.contains(end))
            return -1;
        queue.addLast(start);
        bankSet.remove(start); //防止往回走
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            //遍历该层并过滤
            int currentLevelNum = queue.size();
            for (int n = 0; n < currentLevelNum; n++) {
                char[] currentChars = queue.removeFirst().toCharArray();
                for (int i = 0; i < 8; i++) {
                    //保存原始字符
                    char oldChar = currentChars[i];
                    for (int j = 0; j < 4; j++) {
                        currentChars[i] = four[j];
                        String newString = new String(currentChars);
                        if (end.equals(newString)) {
                            return step;
                        } else if (bankSet.contains(newString)) {
                            bankSet.remove(newString); //防止往回走,后续变化还需要变回该string则说明该路径不是最短的，可以剪枝
                            queue.addLast(newString);
                        }
                    }
                    currentChars[i] = oldChar;
                }
            }
        }
        return -1;
    }
}