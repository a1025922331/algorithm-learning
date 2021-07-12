import java.util.*;

public class Main {
//    //用来上下左右移动的辅助数组
//    public static int[] dx = {0, 0, 1, -1};
//    public static int[] dy = {1, -1, 0, 0};
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] input = new int[n][m];
//        boolean[][] hasVisited = new boolean[n][m]; //用于存储当前位置是否访问过
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                input[i][j] = sc.nextInt();
//            }
//        }
//        int count = 0;
//        //扫描整个区域，一旦发现没有访问过的位置就进行深度遍历
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (!hasVisited[i][j]) {
//                    dfs(input, hasVisited, i, j, input[i][j]);
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    private static void dfs(int[][] input, boolean[][] hasVisited, int curX, int curY, int curCountry) {
//        hasVisited[curX][curY] = true; //当前位置已经访问
//        //遍历上下左右
//        for (int i = 0; i < 4; i++) {
//            int tempX = curX + dx[i];
//            int tempY = curY + dy[i];
//            //当新位置坐标没有越界，且新位置未访问过，且新位置与当前位置同属于一个国家，则可以继续深度遍历
//            if (tempX >= 0 && tempX < input.length && tempY >= 0 && tempY < input[0].length
//                && !hasVisited[tempX][tempY] && curCountry == input[tempX][tempY])
//                dfs(input, hasVisited, tempX, tempY, curCountry);
//        }
//    }

    //用来上下左右移动的辅助数组
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int minSteps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        int x1 = sc.nextInt() - 1, y1 = sc.nextInt() - 1, x2 = sc.nextInt() - 1, y2 = sc.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        minSteps = Integer.MAX_VALUE;
        dfs(nums, x1, y1, x2, y2, 0); //从起点开始dfs
        System.out.println(minSteps == Integer.MAX_VALUE ? -1 : minSteps); //如果minStep没有更新，则说明不存在路径
    }

    private static void dfs(int[][] nums, int curX, int curY, int destX, int destY, int curSteps) {
        int curNum = nums[curX][curY];
        // 进行剪枝操作（当前路径长度已经大于minSteps 或者 当前路径长度大于mn 或者 当前元素大于终点元素）
        if (curSteps >= minSteps || curSteps >= nums.length * nums[0].length || curNum > nums[destX][destY])
            return;
        if (curX == destX && curY == destY) {
            minSteps = Math.min(minSteps, curSteps);
            return;
        }
        // 尝试上下左右
        for (int i = 0; i < 4; i++) {
            int tempX = curX + dx[i];
            int tempY = curY + dy[i];
            if (tempX >= 0 && tempX < nums.length && tempY >= 0 && tempY < nums[0].length && nums[tempX][tempY] >= curNum) {
                dfs(nums, tempX, tempY, destX, destY, curSteps + 1);
            }
        }
    }
}
