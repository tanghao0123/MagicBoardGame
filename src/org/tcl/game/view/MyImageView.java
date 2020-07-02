package org.tcl.game.view;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 图片显示器(样例图片)
 *
 * @author 蔡翔
 */
public class MyImageView extends JPanel {
    /**
     * 图片
     **/
    BufferedImage img;
    /**
     * 图片宽，高
     **/
    int width, height;
    /**
     * 图片的位置
     **/
    int x, y;


    /**
     * 设置图片
     * @param img
     */
    public void setImage(BufferedImage img) {
        this.img = img;
        //重新设置图片宽高
        changeImgSize();
        //绘制
        repaint();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        if (img != null) {
            //重新设置图片的宽高
            changeImgSize();
        }
    }

    /**
     * 根据控件宽高改变设置图片的宽高
     */
    private void changeImgSize() {
        double scale;
        if (img.getHeight() > img.getWidth()) {
            //当img高度大于宽度时
            //获得比率
            scale = img.getHeight() * 1.0 / getHeight();
            //计算并设置图片宽度
            this.width = (int) (img.getWidth() / scale);
            //设置图片高度
            this.height = getHeight();
            //根据控件宽度，图片的宽度计算，设置图片位置
            this.y = 0;
            this.x = (getWidth() - this.width) / 2;
            System.out.println(x + "");
        } else {
            //同上，类似
            scale = img.getWidth() * 1.0 / getWidth();
            this.height = (int) (img.getHeight() / scale);
            this.width = getWidth();
            this.x = 0;
            this.y = (getHeight() - this.height) / 2;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制图片
        g.drawImage(img, x, y, width, height, this);
    }
}
