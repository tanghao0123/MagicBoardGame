package org.tcl.game.utils;

import org.tcl.game.data.Card;

import java.util.Random;

/**
 * 游戏随机类
 * @author 蔡翔
 */
public class GameRandom {

    /**
     * 打乱卡片在数组中的位置
     * @param cards 卡片数组
     * @param <T> 卡片类型
     * @return 乱序的卡片数组
     */
    public static <T> Card<T>[] randoms(Card<T>[] cards) {
        Card<T>[] cs = new Card[cards.length];
        //将0-Global.CardNums-1的间的数字打乱
        int[] nums = randoms(0, Global.CardNums-1);
        //打乱卡片的坐标
        for (int i = 0; i < nums.length; i++) {
            cs[i] = cards[nums[i]];
        }
        //将最后一个卡片设为空白
        cs[cards.length-1]=cards[cards.length-1];
        cs[cards.length-1].setSrc(null);
        return cs;
    }

    /**
     * 打乱一段范围的数字
     * @param min 起始数
     * @param max 终止数
     * @return 乱序的数组
     */
    public static int[] randoms(int min, int max) {
        int[] nums = new int[max - min];
        int index1, index2, temp;
        //初始化有序的数字
        for (int i = 0; i < nums.length; i++) {
            nums[i] = min + i;
        }
        Random random = new Random();
        //通过乱序坐标打乱数组
        for (int i = 0; i < nums.length; i++) {
            index1 = random.nextInt(nums.length);
            index2 = random.nextInt(nums.length);
            temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
        return nums;
    }
}
