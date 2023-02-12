package com.bii.alg;

/**
 * @author bihaiyang
 * @desc 分治算法 1、分解：将原问题分解为若干个规模小，相互独立，与原问题形式相同的子问题 2、解决：若子问题规模较小而容易被解决则直接解，否则递归的解各个问题
 * 3、合并：将各个问题的解合并为原问题的解
 * @since 2022/11/30
 */
public class DivideConquer {
    
    public static void main(String[] args) {
        hanoiTower(3, 'a', 'b', 'c');
    }
    
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else {
            //如果我们有n >= 2，我们总是可以看做两个盘 1、最下边的盘
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
        
    }
}
