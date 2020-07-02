package org.tcl.game.data;

/**
 * 卡片
 * @param <T> 卡片类型
 * @author 蔡翔
 */
public class Card<T> {
    /**
     * 资源
     */
    private T src;
    /**
     * 主键
     */
    private int key;

    public T getSrc() {
        return src;
    }

    public void setSrc(T src) {
        this.src = src;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
