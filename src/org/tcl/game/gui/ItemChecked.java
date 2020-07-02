package org.tcl.game.gui;

import org.tcl.game.utils.Global;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 菜单选项点击事件的处理
 * @author 李婷妍
 */
public class ItemChecked implements ActionListener {
    /**
     * 是否允许修改魔板图片
     */
    private boolean changeImageEnable = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();

        switch (item.getName()) {
            case "初级":
                //设置选项文字
                ((JMenuItem) item.getParent().getComponent(1)).setText("高级");
                item.setText("初级   √");
                //不允许更改魔板图片
                changeImageEnable = false;
                //设置魔板难度为初级难度
                Global.padManager.withlevel(1);
                break;
            case "高级":
                //设置选项文字
                ((JMenuItem) item.getParent().getComponent(0)).setText("初级");
                item.setText("高级   √");
                //允许修改魔板图片
                changeImageEnable = true;
                //设置魔板难度为高级难度
                Global.padManager.withlevel(3);
                break;
            case "帮助":
                //查看游戏规则
                JOptionPane.showMessageDialog(null,
                        "游戏规则：\n" +
                                "一个3×3的魔板，有一个格子是空的，\n" +
                                "其他格子内随机放置1-8共8个编号的\n" +
                                "方块，通过单击任意一个与空格子相\n" +
                                "邻的方块可以把该方块移入空格子，\n" +
                                "不断的移动方块，直到方块一行一行\n" +
                                "的按数字顺序排好。");
                break;
            case "关于":
                //该游戏的创始人
                JOptionPane.showMessageDialog(null,
                        "魔板游戏\n" +
                                "制作人：唐晓玉，蔡翔，李婷妍");
                break;
            case "更换图片":
                //判断是否可修改图片
                if (changeImageEnable) {
                    //初始化文件选择器
                    JFileChooser jfc = new JFileChooser();
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    //不允许选中多个文件
                    jfc.setMultiSelectionEnabled(false);
                    //通过过滤器过滤，只保留图片文件
                    jfc.setFileFilter(new FileNameExtensionFilter("图像文件(jpg/gif)", "jpg", "jpeg", "gif","png"));
                    jfc.showDialog(new JLabel(), "选择");
                    File file = jfc.getSelectedFile();
                    //判断是否选中文件
                    if (file != null) {
                        //若选中则设置图片资源，并重新初始化高级难度
                        Global.ImgFile = file;
                        Global.padManager.withlevel(3);
                    }
                } else {
                    //提示不可更改图片
                    JOptionPane.showMessageDialog(null, "初级模式，改个头的图片");
                }
                break;
            default:
                //其余选项暂未实现
                JOptionPane.showMessageDialog(null, "该功能暂未实现");
                break;
        }
    }

}
