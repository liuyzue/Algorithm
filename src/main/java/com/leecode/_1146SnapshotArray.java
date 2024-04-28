package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class _1146SnapshotArray {

    private int snapNo;

    private List<int[]>[] data;

    public _1146SnapshotArray(int length) {
        snapNo = 0;
        data = new List[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList<int[]>();
        }
    }

    public void set(int index, int val) {
        data[index].add(new int[]{snapNo, val});
    }

    public int snap() {
        return snapNo++;
    }

    public int get(int index, int snap_id) {
        int x = binarSearch(index, snap_id);
        return x == 0 ? 0 : data[index].get(x - 1)[1];
    }

    public int binarSearch(int index, int snap_id) {
        int low = 0,high = data[index].size();
        while (low < high) {
            int mid = (low + high) / 2;
            int[] pair = data[index].get(mid);
            if (pair[0] == snap_id + 1 || (pair[0] == snap_id + 1 && pair[1] >= 0)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
