package org.tcl.game.view.card;
import org.tcl.game.data.Card;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 图像卡片
 * @author 蔡翔
 */
public class MyImgCard extends BaseCard {

    /**
     * 实例化
     * @param card  传入图像类型卡片
     */
    public MyImgCard(Card<BufferedImage> card) {
        this.card = card;
    }

    @Override
    public Card<BufferedImage> getCard() {
        return card;
    }

    @Override
    public void drawing(Graphics g) {
        //绘制图像
        g.drawImage(getCard().getSrc(), 0, 0, getWidth(), getHeight(), this);
    }


}
