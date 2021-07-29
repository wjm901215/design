package com.spiderman.dataststructure.week4;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0: com.spiderman.dataststructure.week4.MySqrt,v 0.1 2/28/21 10:57 PM Exp $$
 */
public class MySqrt {
    public int mySqrt(int x) {
        int l = 0,r = x,mid,ans = -1;
        while (l <= r) {
            mid = (r -l) / 2 + l;
            if((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(8));
    }
}
