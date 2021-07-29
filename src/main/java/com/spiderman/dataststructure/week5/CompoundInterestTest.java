package com.spiderman.dataststructure.week5;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * 股票复利增长计算
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week5.CompoundInterestTest,v 0.1 3/6/21 10:02 AM Exp $$
 */
public class CompoundInterestTest {
    /**
     * 复利计算/按月计算
     * 本金
     *
     * @param amount 金额
     * @param month  年份
     * @param rate   月利率
     */
    public void compoundInterest(BigDecimal amount, int month, double rate) {
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal principalAmount = new BigDecimal(0);
        //计算月利率
        double yearRate=rate;
        rate = rate / 100 / 12;
        for (int i = 0; i < month; i++) {
            totalAmount = totalAmount.add(amount);
            //计算月利率
            BigDecimal currentYear = totalAmount.multiply(new BigDecimal(rate));
            totalAmount = totalAmount.add(currentYear);
            principalAmount = principalAmount.add(amount);
        }
        System.out.println("每月定投：" + amount.intValue()+",投资"+month+"月");
        System.out.println("年利率：" + yearRate);
        System.out.println("本金：" + principalAmount.intValue());
        System.out.println("收益：" + totalAmount.subtract(principalAmount).setScale(2,BigDecimal.ROUND_HALF_UP).longValue());
        System.out.println("总额：" + totalAmount.setScale(2,BigDecimal.ROUND_HALF_UP).longValue());


    }

    public static void main(String[] args) {
        //每月定投金额
        BigDecimal amount = new BigDecimal(1000);
        //月份，30年 * 12月
        int month = 10 * 12;
        //月利率
        new CompoundInterestTest().compoundInterest(amount, month, 15);

    }
}
