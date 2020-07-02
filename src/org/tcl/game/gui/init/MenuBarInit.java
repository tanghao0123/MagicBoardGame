package org.tcl.game.gui.init;

import org.tcl.game.gui.ItemChecked;

import javax.swing.*;

/**
 * 菜单栏的初始化
 * @author 李婷妍
 */
public class MenuBarInit {
    /**
     * 菜单选项点击事件处理
     */
    ItemChecked itemChecked;
    public  MenuBarInit(){
        itemChecked=new ItemChecked();
    }


    /**
     * 菜单栏初始化
     * @return 菜单栏
     */
    public JMenuBar init() {
        //各菜单的初始化
        JMenu start = initStart();
        JMenu help = initHelp();
        JMenu other = initOther();

        //将各个菜单添加入菜单栏中
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(start);
        jMenuBar.add(help);
        jMenuBar.add(other);
        return jMenuBar;
    }

    /**
     * 开始菜单初始化
     * @return 开始菜单
     */
    private JMenu initStart() {
        JMenu start = createMenu("开始");
        JMenuItem level1 = initMenuItem("初级");
        JMenuItem level3 = initMenuItem("高级");
        //游戏开始为初级模式
        level1.setText("初级   √");
        //将选项添加至“开始”菜单中
        start.add(level1);
        start.add(level3);

        return start;
    }

    /**
     * 帮助菜单初始化
     * @return 帮助菜单
     */
    private JMenu initHelp() {
        JMenu help= createMenu("帮助");
        JMenuItem gameHelp=initMenuItem("帮助");
        JMenuItem about=initMenuItem("关于");
        //将选项添加至“帮助”菜单中
        help.add(gameHelp);
        help.add(about);
        return  help;
    }

    /**
     * 其它菜单初始化
     * @return 其它菜单
     */
    private  JMenu initOther(){
        JMenu jMenu=new JMenu("其它");
        JMenuItem image=initMenuItem("更换图片");
        JMenuItem save=initMenuItem("保存进度");
        //将选项添加至"其它"菜单中
        jMenu.add(image);
        jMenu.add(save);
        return jMenu;
    }

    /**
     * 创建菜单
     * @param str 菜单名
     * @return 菜单
     */
    private JMenu createMenu(String str) {
        return new JMenu(str);
    }

    /**
     * 菜单选项的初始化
     * @param str 选项名
     * @return 选项
     */
    private JMenuItem initMenuItem(String str) {
        JMenuItem item = new JMenuItem(str);
        //设置控件名称
        item.setName(str);
        //添加点击事件
        item.addActionListener(itemChecked);
        return item;
    }
}
