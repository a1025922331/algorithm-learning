import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Exercise0127_word_ladder {
    // BFS
    // 先将beginWord加入队列
    // 当队列非空时，取出字符串，并遍历地修改每一位
    // 判断是否转变为了endword，如果没有则判断是否在字典中
    // 在则加入队列，不在则尝试别的修改可能
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Deque<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        set.remove(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int currentLevelNum = queue.size();
            for (int i = 0; i < currentLevelNum; i++) {
                char[] chars = queue.removeFirst().toCharArray();
                for (int j = 0; j < beginWord.length(); j++) {
                    char oldChar = chars[j];
                    for (int k = 'a'; k <= 'z'; k++) {
                        chars[j] = (char) k;
                        String newString = new String(chars);
                        if (endWord.equals(newString)) {
                            return step + 1;
                        } else if (set.contains(newString)) {
                            queue.addLast(newString);
                            set.remove(newString);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }
        return 0;
    }

//    // DFS (超出时间限制，深度优先有可能陷入一条错误的道路且一路走到黑)
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord))
//            return 0;
//        boolean[] hasVisited = new boolean[wordList.size()];
//        int[] minStep = {Integer.MAX_VALUE};
//        DFS(beginWord, endWord, wordList, hasVisited, 0, minStep);
//        return minStep[0] == Integer.MAX_VALUE ? 0 : minStep[0] + 1;
//    }
//
//    private void DFS(String currentWord, String endWord, List<String> wordList, boolean[] hasVisited, int step, int[] minStep) {
//        // 剪枝
//        if (step >= minStep[0])
//            return;
//        // 边界条件
//        if (currentWord.equals(endWord)) {
//            minStep[0] = step; //无需判断大小，因为能执行到这里说明已经比当前minStep要小了
//        }
//        // 遍历剩余wordList
//        for (int i = 0; i < wordList.size(); i++) {
//            if (!hasVisited[i]) {
//                if (isValid(currentWord, wordList.get(i))) {
//                    hasVisited[i] = true;
//                    DFS(wordList.get(i), endWord, wordList, hasVisited, step + 1, minStep);
//                    hasVisited[i] = false; //回退
//                }
//            }
//
//        }
//    }
//
//    private boolean isValid(String currentWord, String s) {
//        int difNum = 0;
//        for (int i = 0; i < currentWord.length(); i++) {
//            if (currentWord.charAt(i) != s.charAt(i)) {
//                if (++difNum > 1)
//                    break;
//            }
//        }
//        return difNum == 1;
//    }
}
