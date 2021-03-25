public class Exercise0860_lemonade_change {
    //实际上不用统计20的张数，只维护5个10的个数即可，因为20花不出去
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            // 分类讨论
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) { //先尝试找10+5
                    five--;
                    ten--;
                } else if (five >= 3) { //再尝试5+5+5
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
