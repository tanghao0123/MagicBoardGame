package org.tcl.game.gui;

import org.tcl.game.utils.Global;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 按钮点击事件的处理
 * @author 李婷妍
 */
public class BtnClicked implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if ("restart".equals(btn.getName())) {
            Global.padManager.start();
        }

    }
}
