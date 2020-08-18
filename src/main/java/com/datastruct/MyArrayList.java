package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/23
 * @time:22:01
 */
public class MyArrayList {

    private static final int DEFAULT_INIT_SIZE = 10;
    public Object[] values;
    public int size;

    /**
     * 默认数组容量为10的构造方法
     */
    public MyArrayList() {
        this.size = 0;
        values = new Object[DEFAULT_INIT_SIZE];
    }

    /**
     * 指定初始化容量的构造方法，但是如果指定的值小于默认大小，则按默认大小来
     *
     * @param minSize
     */
    public MyArrayList(int minSize) {
        this.size = 0;
        int mixCapacity = Math.max(minSize, DEFAULT_INIT_SIZE);
        values = new Object[mixCapacity];
    }

    public void isFull(int minCapacity) {
        //如果满了就进行扩容 新数组的容量是原来的两倍
        if (minCapacity - values.length > 0) {
            System.out.println("=========Done extend!===========");
            long newCapacity = values.length << 1;
            if (newCapacity < Integer.MAX_VALUE - 8) {
                Object[] newValues = new Object[(int) newCapacity];
                for (int i = 0; i < values.length; i++) {
                    newValues[i] = values[i];
                }
                values = newValues;
            } else {
                System.out.println("无法进行扩容，两倍当前容量已超出数组最大容量大小！");
                return;
            }
        }
    }

    /**
     * 在数组末尾添加
     *
     * @param value
     */
    public void addTail(Object value) {
        //首先判满
        isFull(size + 1);
        values[size++] = value;
    }

    /**
     * 在第几个位置插入某个值
     *
     * @param location
     * @param value
     */
    public void addNth(int location, Object value) {
        //如果需要在数组最大容量范围内任意插入，那么需要在location > values.length的情况下做扩容，再插入
        if (location < 0 || location > size) {
            System.out.println("插入失败，插入位置超出数组范围！");
        }
        isFull(size + 1);
        for (int i = size; i >= 0; i--) {
            if (i == location - 1) {
                values[i] = value;
                size++;
                break;
            }
            values[i] = values[i - 1];
        }
    }

    /**
     * 删除表尾
     */
    public void deleteTail() {
        if (size == 0) {
            return;
        }
        values[size--] = null;
    }

    /**
     * 删除任意位置
     *
     * @param location
     */
    public Object deleteNth(int location) {
        Object result = null;
        if (location < 0 || location > size || size == 0 ) {
            return null;
        }
        for (int i = location - 1; i < size - 1; i++) {
            result = values[i];
            values[i] = values[i + 1];
        }
        size--;
        return result;
    }

    public Object find(int location) {
        if (location < 0 || location > size) {
            return null;
        }
        return values[location - 1];
    }

    public void update(int location,Object value) {
        if (location < 0 || location > size) {
            return;
        }
        values[location-1] = value;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

    public void travel() {
        System.out.print("travel: ");
        for (int i = 0; i < size; i++) {
            System.out.print(values[i] + " ");
        }
    }


}
