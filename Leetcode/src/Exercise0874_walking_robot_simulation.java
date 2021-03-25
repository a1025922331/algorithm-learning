import java.util.*;

public class Exercise0874_walking_robot_simulation {
    // 位操作+转化为long (最快:12ms)
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0; // 北东南西0123
        int x = 0, y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int max = 0;
        Set<Long> obstacleSet = new HashSet<>(); // 障碍物哈希表
        for (int[] obstacle : obstacles) {
            obstacleSet.add((long) (obstacle[0] + 30000) << 16 + (long) (obstacle[1] + 30000));
        }
        for (int command : commands) {
            if (command == -2)
                direction = (direction - 1 + 4) % 4;
            else if (command == -1)
                direction = (direction + 1 + 4) % 4;
            else {
                for (; command > 0; command--) {
                    x += dx[direction];
                    y += dy[direction];
                    if (obstacleSet.contains((long) (x + 30000) << 16 + (long) (y + 30000))) {
                        x -= dx[direction];
                        y -= dy[direction];
                        break;
                    }
                }
            }
            //计算位置
            max = (int) Math.max(max, Math.pow(x, 2) + Math.pow(y, 2));
        }
        return max;
    }

//    //障碍物坐标不进行编码，直接转为list(速度快，36ms)
//    public int robotSim(int[] commands, int[][] obstacles) {
//        int direction = 0; // 北东南西0123
//        int x = 0, y = 0;
//        int[] dx = {0, 1, 0, -1};
//        int[] dy = {1, 0, -1, 0};
//        int max = 0;
//        Set<List<Integer>> obstacleSet = new HashSet<>(); // 障碍物哈希表,
//        for (int[] obstacle : obstacles) {
//            LinkedList<Integer> list = new LinkedList<>();
//            list.add(obstacle[0]);
//            list.add(obstacle[1]);
//            obstacleSet.add(list);
//        }
//        for (int command : commands) {
//            if (command == -2)
//                direction = (direction - 1 + 4) % 4;
//            else if (command == -1)
//                direction = (direction + 1 + 4) % 4;
//            else {
//                for (; command > 0; command--) {
//                    x += dx[direction];
//                    y += dy[direction];
//                    LinkedList<Integer> list = new LinkedList<>();
//                    list.add(x);
//                    list.add(y);
//                    if (obstacleSet.contains(list)) {
//                        x -= dx[direction];
//                        y -= dy[direction];
//                        break;
//                    }
//                }
//            }
//            //计算位置
//            max = (int) Math.max(max, Math.pow(x,2) + Math.pow(y, 2));
//        }
//        return max;
//    }

//    //障碍物坐标编码成字符串(速度略慢，47ms)
//    public int robotSim(int[] commands, int[][] obstacles) {
//        int direction = 0; // 北东南西0123
//        int x = 0, y = 0;
//        int[] dx = {0, 1, 0, -1};
//        int[] dy = {1, 0, -1, 0};
//        int max = 0;
//        Set<String> obstacleSet = new HashSet<>(); // 障碍物哈希表,
//        for (int[] obstacle : obstacles) {
////            StringBuilder sb = new StringBuilder();
////            sb.append(String.valueOf(obstacle[0]));
////            sb.append(',');
////            sb.append(String.valueOf(obstacle[1]));
////            obstacleSet.add(sb.toString());
//            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
//        }
//        for (int command : commands) {
//            if (command == -2)
//                direction = (direction - 1 + 4) % 4;
//            else if (command == -1)
//                direction = (direction + 1 + 4) % 4;
//            else {
//                for (; command > 0; command--) {
//                    x += dx[direction];
//                    y += dy[direction];
//                    StringBuilder sb = new StringBuilder();
////                    sb.append(String.valueOf(x));
////                    sb.append(',');
////                    sb.append(String.valueOf(y));
////                    if (obstacleSet.contains(sb.toString())) {
//                    if (obstacleSet.contains(x + "," + y)) {
//                        x -= dx[direction];
//                        y -= dy[direction];
//                        break;
//                    }
//                }
//            }
//            //计算位置
//            max = (int) Math.max(max, Math.pow(x,2) + Math.pow(y, 2));
//        }
//        return max;
//    }
}