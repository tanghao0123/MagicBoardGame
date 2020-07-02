package org.tcl.game.view.pad;

import org.tcl.game.utils.FindComponent;
import org.tcl.game.utils.Global;
import org.tcl.game.utils.ImageHandler;
import org.tcl.game.view.MyImageView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 魔板管理
 * @author 唐晓玉
 */
public class PadManager {
    /**魔板的父容器**/
    private JPanel panel;
    /**魔板**/
    private BasePuzzlePad pad;
    /**样例**/
    private MyImageView sample;

    /**
     *实例化
     * @param sample 样例显示控件
     */
    public PadManager(MyImageView sample){
        this.sample=sample;
    }

    /**
     * 父容器初始化
     * @return
     */
    public JPanel init(){
        JPanel panel=new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(Global.PAD_WIDTH,Global.HEIGHT));
        panel.setLayout(null);
        this.panel=panel;
    return panel;
    }

    public void withlevel(int level){
        panel.removeAll();
        if (level==1){
            //数字魔板
            pad=new NumPad();
            //数字原图设置
            setImg(new File("Default.png"));
        }else if(level==3){
            //图像魔板
            pad=new ImgPad();
            //原图设置
            setImg(Global.ImgFile);
        }
        //设置魔板在父容器的位置
        pad.setBounds(25,25,750,600);
        //将魔板放入魔板容器中
        panel.add(pad);
        //开始游戏
        start();
    }

    /**
     * 设置原图
     * @param file 原图文件
     */
    public void setImg(File file){
        BufferedImage image = ImageHandler.getImage(file);
        if (pad instanceof ImgPad) {
            //图像魔板
            //魔板设置原图
            ((ImgPad) pad).setImg(image);
        }
            //样例设置原图
            sample.setImage(image);
    }

    public void start(){
        //魔板初始化
        pad.init();
        //随机排版
        pad.random();
        //绘制
        pad.repaint();

    }



}
