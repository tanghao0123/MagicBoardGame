package org.tcl.game.utils;


import java.awt.*;

/**
 * 寻找控件工具类
 * @author 蔡翔
 */
public class FindComponent {
    /**
     * 通过组件名,从父级组件沿着递归找到此名字的组件
     *
     * @param c		父级组件
     * @param name	设置的组件名称
     * @return
     */
    public static Component searchComponentByName(Container c, String name){
        Component result = null;
        Component[] components = c.getComponents();
        if(null != components && components.length > 0){
            for (Component component : components) {
                String name2 = component.getName();
                if(name2 != null && name2.equals(name)){
                    result = component;

                    return result;
                    //递归调用所有下级组件列表
                }else if(null == result){
                    if(component instanceof Container)
                    { result = searchComponentByName((Container)component, name);}
                }
            }
        }
        return result;

    }

}
