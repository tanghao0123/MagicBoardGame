package org.tcl.game.view.pad;

import org.tcl.game.data.Card;
import org.tcl.game.utils.GameRandom;
import org.tcl.game.utils.Global;
import org.tcl.game.utils.ImageHandler;
import org.tcl.game.view.card.MyImgCard;

import java.awt.image.BufferedImage;

/**
 * 图像魔板
 * @author 唐晓玉
 */
public class ImgPad extends BasePuzzlePad {
    /**原图像**/
    private BufferedImage img;
    /**图像宽，高**/
    int width,height;
    /**左上角卡片的起始位置**/
    int x,y;
    protected ImgPad() {
        myCards=new MyImgCard[Global.Row][Global.Col];
    }

    /**
     * 设置原图片
     * @param img
     */
    public void setImg(BufferedImage img) {
        this.img = img;
    }

    @Override
    public void random() {
        //通过裁剪img得到装有整齐碎片化的img的card数组
        Card<BufferedImage>[]  cards = ImageHandler.getCards(img);
        //将card数组中各元素打乱
        cards= GameRandom.randoms(cards);
        //计算得到卡片的高度，宽度
        int cardHeight=(height-(Global.Row-1)*Global.GAP)/Global.Row,cardWidth=(width-(Global.Col-1)*Global.GAP)/Global.Col;

        for (int i = 0; i < Global.Row; i++) {
            for (int j = 0; j < Global.Col; j++) {
                //将图像卡片model装入Card控件中
                myCards[i][j]=new MyImgCard(cards[i*Global.Col+j]);
                //通过计算设置卡片的位置
                myCards[i][j].setBounds(x+j*(cardWidth+Global.GAP),y+i*(cardHeight+Global.GAP),cardWidth,cardHeight);
                //添加卡片鼠标事件
                myCards[i][j].addMouseListener(this);
                //将卡片控件放入魔板中
                add(myCards[i][j]);
            }
        }
    }


    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        //更改图片的宽高
        changeImgSize();
    }

    /**
     * 设置图片宽高
     */
    private void changeImgSize(){
        double scale;
        if (img.getHeight()>img.getWidth()){
            //当img的高大于宽
            //通过img高与pad高，计算缩放比例
            scale=(img.getHeight()*1.0)/getHeight();
            //缩放得到图片宽度
            this.width=(int)(img.getWidth()/scale);
            //设置图片高度
            this.height=getHeight();
            //设置图片的x,y轴坐标
            this.y=0;
            this.x=(getWidth()-this.width)/2;
            System.out.println(x+"");
        }else{
            //通过img宽与pad宽，计算缩放比例
            scale=(img.getWidth()*1.0)/getWidth();
            //缩放得到图片高度
            this.height=(int)(img.getHeight()/scale);
            //设置图片的宽度
            this.width=getWidth();
            //设置图片的x,y轴坐标
            this.x=0;
            this.y=(getHeight()-this.height)/2;
        }
    }


}
