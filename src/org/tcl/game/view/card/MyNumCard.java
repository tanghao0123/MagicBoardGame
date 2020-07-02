package org.tcl.game.view.card;

import org.tcl.game.data.Card;

import java.awt.*;

/**
 * 数字卡片
 * @author 蔡翔
 */
public class MyNumCard extends BaseCard {
    Font f;

    /**
     * 实例化
     * @param card 传入数字类型卡片
     */
    public MyNumCard(Card<String> card) {
        this.card = card;
    }
     @Override
    public Card<String> getCard() {
        return card;
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        //设置字体大小
       f=new Font("Tahoma",Font.BOLD,(int)(getWidth()*0.6));
    }

    @Override
    public void drawing(Graphics g) {
        //设置字体
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        //绘制数字
        g.drawString(getCard().getSrc(),(getWidth()-((int)fm.getStringBounds(getCard().getSrc(), g).getWidth()))/2, fm.getHeight());
    }
}
