package mo.must.array;

/*来源：JZ-Offer P51
题目：替换空格

描述：请实现一个函数，把字符串中的每个空格替换成“%20”.例如,输入“we are happy.”,
则输出“we%20are%20happy”
 */

public class Exercise004 {
    public static void main(String[] args) {
        String s = " 0 1 2 3 4 5 6 7 8 9";
        System.out.println(s);
        long begin = System.currentTimeMillis();

        //time: 1945ms
        String sReplace = "";
        for (int i = 0; i < 10000000; i++) {
            sReplace = solution1(s);
        }
        long point1 = System.currentTimeMillis();

        //time: 3996ms
        String sReplace2 = "";
        for (int i = 0; i < 10000000; i++) {
            sReplace2 = solution2(s);
        }
        long point2 = System.currentTimeMillis();
        System.out.println(sReplace);
        System.out.println("time: " + (point1 - begin) + "ms");
        System.out.println(sReplace2);
        System.out.println("time: " + (point2 - point1) + "ms");


    }

    //时间复杂度为O(n)的方法
    private static String solution1(String s) {
        if (s == null || s.length() == 0)
            return "ERROR";
        char[] chars = s.toCharArray();
        int newLength = 0;
        int originalLength = 0;
        int numberOfBlank = 0;
        for (char c : chars) {
            if (c == ' ')
                numberOfBlank++;
            originalLength++;
        }
        newLength = originalLength + 3 * numberOfBlank;
        char[] newChars = new char[newLength];
        //两个索引
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;

        while (indexOfNew >= 0 && indexOfOriginal >= 0) {
            if (chars[indexOfOriginal]==' ') {
                newChars[indexOfNew--] = '0';
                newChars[indexOfNew--] = '2';
                newChars[indexOfNew--] = '%';
            }else {
                newChars[indexOfNew--] = chars[indexOfOriginal];
            }
            indexOfOriginal --;
        }
        return new String(newChars);
    }

    //String中的已有方法
    private static String solution2(String s) {
        return s.replace(" ", "%20");
    }
}
