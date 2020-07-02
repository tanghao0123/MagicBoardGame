package org.tcl.game.view.card;

import org.tcl.game.data.Card;

import javax.swing.*;
import java.awt.*;

/**
 * 基础卡片
 * @author 蔡翔
 */
public abstract class BaseCard  extends JPanel implements Canvas {
    /**卡片model**/
    protected Card card;

    /**
     * 设置卡片model
     * @param card 卡片
     */
    public void setCard(Card card) {
        this.card = card;
        //重新绘制
        repaint();
    }

    /**
     * 获得卡片
     * @return 卡片
     */
    public Card getCard() {
        return card;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawing(g);
    }

}
