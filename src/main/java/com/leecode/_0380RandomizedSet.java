package com.leecode;

import java.util.*;

public class _0380RandomizedSet {

    Map<Integer,Integer> valueIndexMap;

    private static final Integer DEFAULT_VALUE = 0;

    Random random = new Random();

    public _0380RandomizedSet() {
        valueIndexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valueIndexMap == null) {
            valueIndexMap = new HashMap<>();
        }
        Integer index = valueIndexMap.get(val);
        if (index != null) {
            return false;
        } else {
            valueIndexMap.put(val,DEFAULT_VALUE);
            return true;
        }
    }

    public boolean remove(int val) {
        if (valueIndexMap == null) {
            valueIndexMap = new HashMap<>();
        }
        Integer index = valueIndexMap.get(val);
        if (index == null) {
            return false;
        } else {
            valueIndexMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        if (valueIndexMap == null || valueIndexMap.isEmpty()) {
            throw new NullPointerException("valueIndexMap is null");
        }
        Set<Integer> keySet = valueIndexMap.keySet();
        Object[] array = keySet.toArray();
        return (int) array[random.nextInt(array.length)];
    }

    public static void main(String[] args) {
        _0380RandomizedSet randomizedSet = new _0380RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
    }
}
