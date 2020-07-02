package org.tcl.game.view.pad;

import org.tcl.game.data.Card;
import org.tcl.game.utils.GameRandom;
import org.tcl.game.utils.Global;
import org.tcl.game.view.card.MyNumCard;

/**
 * 数字魔板
 * @author 唐晓玉
 */
public class NumPad extends BasePuzzlePad {
    protected NumPad() {
        myCards = new MyNumCard[Global.Row][Global.Col];
    }

    /**
     * 创建数字卡片model
     * @return 数字卡片model数组
     */
    private Card<String>[] CreateCards() {
        //打乱0-CardNums-1之间的数字
        int[] nums = GameRandom.randoms(0, Global.CardNums - 1);
        //新建一个cards数组
        Card<String>[] cards = new Card[Global.CardNums];
        //初始化卡片数组中的数据
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = new Card<>();
            cards[i].setSrc((nums[i] + 1) + "");
            cards[i].setKey(nums[i] + 1);
        }
        //将最后一个卡片设置为空白卡
        cards[Global.CardNums - 1] = new Card<>();
        cards[Global.CardNums - 1].setSrc("");
        cards[Global.CardNums - 1].setKey(Global.CardNums);
        return cards;
    }

    @Override
    public void random() {
        //创建卡片model
        Card<String>[] cards = CreateCards();
        //卡片边长
        int sideLength;
        //左上角卡片的位置
        int x, y;

        if ((Global.HEIGHT - (Global.Row - 1) * Global.GAP) / Global.Row > (Global.PAD_WIDTH - (Global.Col - 1) * Global.GAP) / Global.Col) {
            //通过计算，若height>width,则sideLength=width;
            sideLength = (getWidth() - (Global.Col - 1) * Global.GAP) / Global.Col;
            //设置坐标
            y = Math.abs(getHeight() - getWidth()) / 2;
            x = 0;
        } else {
            sideLength = (getHeight() - (Global.Row - 1) * Global.GAP) / Global.Row;
            y = 0;
            x = Math.abs(getHeight() - getWidth()) / 2;
        }


        for (int i = 0; i < Global.Row; i++) {
            for (int j = 0; j < Global.Col; j++) {
                // 将数字卡片model装入Card控件中
                myCards[i][j] = new MyNumCard(cards[i * Global.Col + j]);
                //设置卡片控件的位置及宽高
                myCards[i][j].setBounds(x + j * (sideLength + Global.GAP), y + i * (sideLength + Global.GAP), sideLength, sideLength);
                //添加鼠标事件
                myCards[i][j].addMouseListener(this);
                //将卡片控件放入魔板中
                add(myCards[i][j]);
            }
        }
    }


}
