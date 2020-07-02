package org.tcl.game.utils;

import org.tcl.game.view.pad.PadManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 全局配置类
 * @author 蔡翔
 */
public class Global {
    /**高级难度的图片资源**/
    public static File ImgFile=new File("123.png");
    /**魔板的间隔大小**/
    public final static int GAP =10;
    /**主要内容部分的高度**/
    public final static int HEIGHT=650;
    /**右边面板的宽度，魔板的宽度**/
    public final static int RIGHT_WIDTH =400, PAD_WIDTH =800;
    /**主界面**/
    public static Frame Window;
    /**列数，行数**/
    public static int Col=3,Row=3;
    /**卡片个数**/
    public static int CardNums=Col*Row;
    /**魔板管理者**/
    public static PadManager padManager;
    /**计时器**/
    public static Timer timer;
    /**统计时间**/
    public static int time;

}
