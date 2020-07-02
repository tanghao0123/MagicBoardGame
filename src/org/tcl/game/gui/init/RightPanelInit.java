package org.tcl.game.gui.init;

import org.tcl.game.gui.BtnClicked;
import org.tcl.game.utils.Global;
import org.tcl.game.view.MyImageView;

import javax.swing.*;
import java.awt.*;

/**
 * 右面板的初始化
 * @author 李婷妍
 */
public class RightPanelInit {
    private BtnClicked btnClicked;

    public RightPanelInit() {
        btnClicked = new BtnClicked();
    }

    /**
     * 初始化
     * @return 右面板
     */
    public JPanel init() {
        JPanel right = leftPanelSetting();
        labelsInit(right);
        createBtn(right);
        imageInit(right);
        return right;
    }

    /**
     * 图片控件的初始化
     *
     * @param right 右面板
     */
    private void imageInit(JPanel right) {
        MyImageView imageView = new MyImageView();
        imageView.setName("Sample");
        imageView.setBounds(50, 30, 300, 300);
        right.add(imageView);
    }

    /**
     * 按钮的初始化设置
     *
     * @param right 右面板
     */
    private void createBtn(JPanel right) {
        JButton btn = createBtn();
        //添加点击事件
        btn.addActionListener(btnClicked);
        //设置按钮位置，大小
        btn.setBounds(150, 500, 100, 50);
        //放入右面板中
        right.add(btn);
    }

    /**
     * 按钮创建
     *
     * @return 按钮
     */
    private JButton createBtn() {
        JButton button = new JButton("重新开始");
        button.setName("restart");
        return button;
    }

    /**
     * 统计Label的初始化设置
     *
     * @param right 右面板
     */
    private void labelsInit(JPanel right) {
        JLabel timeShow = labelInit("", "时间：");
        JLabel time = labelInit("time", "0");
        JLabel timesShow = labelInit("", "次数:");
        JLabel times = labelInit("times", "0");
        //设置字体
        Font font = new Font("宋体", Font.BOLD, 20);
        timeShow.setFont(font);
        time.setFont(font);
        timesShow.setFont(font);
        times.setFont(font);

        //设置Label位置，大小
        timeShow.setBounds(150, 350, 75, 50);
        time.setBounds(225, 350, 75, 50);
        timesShow.setBounds(150, 400, 75, 50);
        times.setBounds(225, 400, 75, 50);

        //加入右面板中
        right.add(timeShow);
        right.add(time);
        right.add(timesShow);
        right.add(times);
    }

    /**
     * 简单初始化
     *
     * @param name 控件名
     * @param str  显示的文字
     * @return 文字控件
     */
    private JLabel labelInit(String name, String str) {
        JLabel label = new JLabel(str);
        label.setName(name);
        return label;
    }

    /**
     * 右面板的初始化及设置
     *
     * @return 右面板
     */
    private JPanel leftPanelSetting() {
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(Global.RIGHT_WIDTH, Global.HEIGHT));
        left.setLayout(null);
        left.setName("left");
        return left;
    }

}
