package org.tcl.game.gui.load;

import org.tcl.game.gui.init.RightPanelInit;
import org.tcl.game.gui.init.MenuBarInit;
import org.tcl.game.utils.FindComponent;
import org.tcl.game.utils.Global;
import org.tcl.game.view.MyImageView;
import org.tcl.game.view.pad.PadManager;

import javax.swing.*;
import java.awt.*;

/**
 * 界面加载
 * @author 李婷妍
 */
public class ViewLoad implements Load {
    /**主界面**/
    JFrame frame;

    public ViewLoad(JFrame frame) {
        this.frame = frame;

    }

    @Override
    public void loading() {

        //右面板初始化
        RightPanelInit rightPanelInit=new RightPanelInit();
        JPanel jPanel=rightPanelInit.init();
        frame.add(jPanel,BorderLayout.EAST);

        //魔板的初始化
        Global.padManager =new PadManager((MyImageView) FindComponent.searchComponentByName(jPanel,"Sample"));
        frame.add(Global.padManager.init(),BorderLayout.CENTER);

        //菜单栏初始化
        MenuBarInit menubar=new MenuBarInit();
        frame.setJMenuBar(menubar.init());

    }




}
