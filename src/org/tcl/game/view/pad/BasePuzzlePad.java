package org.tcl.game.view.pad;

import org.tcl.game.data.Card;
import org.tcl.game.utils.FindComponent;
import org.tcl.game.utils.Global;
import org.tcl.game.view.card.BaseCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 魔板基础类
 * @author 唐晓玉
 *
 */
public abstract class BasePuzzlePad extends JPanel implements MouseListener, ActionListener {

    protected BaseCard[][] myCards;
    private int moveX = 2, moveY = 2;
    private JLabel timesShow;

    private JLabel timeShow;
    private int times;

    protected BasePuzzlePad() {
        if (Global.timer==null){
        Global.timer=new Timer(1000,this);}else{
            Global.timer.stop();
        }
        timeShow=(JLabel) FindComponent.searchComponentByName(Global.Window,"time");
        timesShow=(JLabel) FindComponent.searchComponentByName(Global.Window,"times");
    }


    /**
     * 随机摆放卡片
     */
    public abstract void random();

    /**
     * 初始化魔板相关设置
     */
    protected void init() {
        //将可移动的纵轴，横轴设置为最后一格
        moveX=Global.Col-1;
        moveY=Global.Row-1;
        //清理所有子控件，并将布局设为null
        removeAll();
        setLayout(null);
        //设置背景色
        setBackground(Color.GRAY);
        //将移动次数设为0
        times = 0;
        timesShow.setText(times+"");
        //将计时设为0
        Global.time=0;
        timeShow.setText(Global.time+"");
        //重新开启计时
        Global.timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //计时触发,增加一秒
        timeShow.setText((++Global.time)+"");
    }

    /**
     * 移动卡片
     *
     * @param card
     */
    public void move(BaseCard card) {
        //判断不是空白块，才可进行移动
        if (card.getCard().getKey() != Global.CardNums) {
            //查找横向可移动卡片中是否存在card，若存在则移动
            for (int i = 0; i < Global.Col; i++) {
                if (myCards[moveY][i] == card) {
                    moveX(i);
                    return;
                }
            }
            //查找空白块纵向可移动卡片中是否存在card，若存在则移动
            for (int i = 0; i < Global.Row; i++) {
                if (myCards[i][moveX] == card) {
                    moveY(i);
                    return;
                }
            }
        }
    }

    /**
     * 横向移动
     *
     * @param record 需要移动的卡片所在位置
     */
    private void moveX(int record) {
        Card baseCard;
        baseCard = myCards[moveY][moveX].getCard();
        if (moveX > record) {
            //当空白块位置大于需要移动的卡片时
            //将record卡片到空白块之间的所有卡片都向空白块的方向移动一格
            for (int i = moveX; i > record; i--) {
                myCards[moveY][i].setCard(myCards[moveY][i - 1].getCard());
            }
        } else {
            for (int i = moveX; i < record; i++) {
                myCards[moveY][i].setCard(myCards[moveY][i + 1].getCard());
            }
        }
        //将record位置设置为空白块
        myCards[moveY][record].setCard(baseCard);
        //改变可移动横轴的位置
        moveX = record;
        if (timesShow != null) {
            //增加一次移动次数
            timesShow.setText((++times)+"");
        }
    }

    /**
     * 纵向移动
     *
     * @param record 需要移动的卡片所在位置
     */
    private void moveY(int record) {
        Card baseCard;
        baseCard = myCards[moveY][moveX].getCard();
        if (moveY > record) {
            //当空白块位置大于需要移动的卡片时
            //将record卡片到空白块之间的所有卡片都向空白块的方向移动一格
            for (int i = moveY; i > record; i--) {
                myCards[i][moveX].setCard(myCards[i - 1][moveX].getCard());
            }
        } else {
            //当空白块位置小于需要移动的卡片时
            for (int i = moveY; i < record; i++) {
                myCards[i][moveX].setCard(myCards[i + 1][moveX].getCard());
            }
        }
        //将record位置设置为空白块
        myCards[record][moveX].setCard(baseCard);
        //改变可移动纵轴的位置
        moveY = record;
        if (timesShow != null) {
            //增加一次移动次数
            timesShow.setText((++times)+"");
        }
    }

    /**
     * 判断是否胜利
     * @return true:胜利
     */
    private boolean win() {

        for (int i = Global.Row - 1; i >= 0; i--) {
            for (int j = Global.Col - 1; j >= 0; j--) {
                //通过key判断card是否在正确的位置，若不在则返回false
                if (myCards[i][j].getCard().getKey() != i * Global.Col + (j + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //当鼠标按下时触发移动事件
        move((BaseCard) e.getSource());
        if (win()) {
            //移动后胜利
            //暂停计时器
            Global.timer.stop();
            //胜利提示框
             JOptionPane.showMessageDialog(null, "恭喜你，小伙伴你赢了！！！\n本次共花费"+Global.time+"秒,共移动"+times+"次", "win",JOptionPane.INFORMATION_MESSAGE);
                Global.padManager.start();

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
