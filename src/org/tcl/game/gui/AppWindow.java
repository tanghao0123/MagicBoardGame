package org.tcl.game.gui;

import org.tcl.game.gui.load.DataLoad;
import org.tcl.game.gui.load.ViewLoad;
import org.tcl.game.utils.Global;

import javax.swing.*;

/**
 * 主界面
 * @author 李婷妍
 */
public class AppWindow extends JFrame {


    /**
     * 界面搭建
     */
    public void build() {
        //数据读取暂未制作
        DataLoad datas=new DataLoad("/setting.json");
        //界面控件初始化
        ViewLoad view=new ViewLoad(this);
        view.loading();
        //选择初级难度
        Global.padManager.withlevel(1);
        //初始化设置窗口
        frameInitSetting(this);
    }

    /**
     * 窗口设置
     * @param frame 窗口
     */
    private void frameInitSetting(JFrame frame) {
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }


    public static void main(String[] args) {
        AppWindow appWindow = new AppWindow();
        Global.Window =appWindow;
        //搭建界面
        appWindow.build();

    }


}
