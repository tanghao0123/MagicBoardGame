package org.tcl.game.utils;

import org.tcl.game.data.Card;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 图像处理工具类
 * @author 蔡翔
 */
public class ImageHandler {

    /**
     * 将img按全局配置类中的配置分解为若干份Card，
     * @param img 图像资源
     * @return 图片类型卡片数组
     */
    public static Card<BufferedImage>[] getCards(BufferedImage img){
        //创建卡片数组
        Card<BufferedImage>[] cards=new Card[Global.CardNums];
        //将img分解为若干imgs
        BufferedImage[] imgs=splitImage(img,Global.Row,Global.Col);

        //初始化卡片数组中的数据
        for (int i = 0; i < cards.length; i++) {
            cards[i]=new Card<>();
            cards[i].setSrc(imgs[i]);
            cards[i].setKey(i+1);
        }
        return cards;
    }

    /**
     *  将文件转换为BufferImage
     * @param file 文件
     * @return 图像
     */
    public static BufferedImage getImage(File file)  {
        BufferedImage img;
        try {
            //将文件转换为流
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            //将文件流转换为BufferImage
            img= ImageIO.read(fis);

        }catch (IOException e) {
            //若文件不存在或转换错误则创建空白的图像
            img=new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 分解图片
     * @param image 原始图片
     * @param rows 行数
     * @param cols 列数
     * @return 分解后得到的图像数组
     */
    public static BufferedImage[] splitImage(BufferedImage image,int rows,int cols) {
        int chunks = rows * cols;

        // 计算每个小图的宽度和高度
        int chunkWidth = image.getWidth() / cols;
        int chunkHeight = image.getHeight() / rows;

        int count = 0;
        BufferedImage[] imgs= new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //设置小图的大小和类型
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                //写入图像内容
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0,
                        chunkWidth, chunkHeight,
                        chunkWidth * y, chunkHeight * x,
                        chunkWidth * y + chunkWidth,
                        chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        return imgs;
    }

}
