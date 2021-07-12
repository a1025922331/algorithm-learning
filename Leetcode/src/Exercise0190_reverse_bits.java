public class Exercise0190_reverse_bits {
    // public int reverseBits(int n) {
    //     int result = 0;
    //     for (int i = 0; i < 32 && n != 0; i++) {
    //         result |= (n & 1) << (31 - i);
    //         n >>= 1;
    //     }
    //     return result;
    // }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++ ) {
            res = (res << 1) + ((n >> i) & 1);
        }
        return res;
    }
}