package org.jingtao8a.code_random_notes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SegmentTree {
    private class Node {
        int l;
        int r;
        int info;//区间最大值
        int tag;//标记
        Node(int l, int r) {this.l = l; this.r = r;}
        Node(int l, int r, int info) {this.l = l; this.r = r; this.info = info;};
    }
    //(tree.length - 1) = 4 * (num.length - 1)
    private Node[] tree;//index 0 not use
    private int[] num;//index 0 not use
    public void init(int[] array) {//array index 0 not use
        num = Arrays.copyOf(array, array.length);
        int n = array.length - 1;
        int treeSize = n * 4 + 1;
        tree = new Node[treeSize];
        build(1, 1, n);
    }

    private void build(int u, int l, int r) {//构建线段树 O(N)
        if (l == r) {
            tree[u] = new Node(l, r, num[l]);
            return;
        }
        tree[u] = new Node(l, r);
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);//构建左子树
        build(u << 1 | 1, mid + 1, r);//构建右子树
        pushUp(u);
    }
    private void pushUp(int u) {//更新tree[u]的info
        assert(tree[u] != null);
        tree[u].info = tree[u << 1].info + tree[u << 1 | 1].info;
    }

    public void updatePoint(int x, int delta) {//修改单点
        if (x < 1 || x >= num.length) {
            return;
        }
        num[x] += delta;
        updatePointHelper(1, x, delta);
    }

    private void updatePointHelper(int u, int x, int delta) {//单点修改 O(logN)
        if (tree[u].l == tree[u].r) {
            tree[u].info += delta;
            return;
        }
        int mid = (tree[u].l + tree[u].r) >> 1;
        if ( x <= mid) {
            updatePointHelper(u << 1, x, delta);
        } else {
            updatePointHelper(u << 1 | 1, x, delta);
        }
        pushUp(u);
    }
    private void pushDown(int u) {
        if (tree[u].tag != 0) {//懒标记不为0 两个子节点更新info 和 tag
            tree[u << 1].tag += tree[u].tag;
            tree[u << 1 | 1].tag += tree[u].tag;
            tree[u << 1].info += tree[u].tag * (tree[u << 1].r - tree[u << 1].l + 1);
            tree[u << 1 | 1].info += tree[u].tag * (tree[u << 1 | 1].r - tree[u << 1 | 1].l + 1);
            tree[u].tag = 0;
        }
    }
    public void updateSpan(int l, int r, int delta) {//修改区间
        if (l > r || l < 1 || r >= num.length) {
            return;
        }
        for (int i = l; i <= r; ++i) {
            num[i] += delta;
        }
        updateSpanHelper(1, l, r, delta);
    }

    private void updateSpanHelper(int u, int l, int r, int delta) {//区间修改 O(logN)
        if (l <= tree[u].l && tree[u].r <= r) {
            tree[u].tag += delta;//打上懒标记
            tree[u].info += delta * (tree[u].r - tree[u].l + 1);//更新info
            return;
        }
        pushDown(u);//如果u的tag不为0, 则u的child需要跟新info和tag
        int mid = (tree[u].l + tree[u].r) >> 1;
        if (l <= mid) {//更新左子树
            updateSpanHelper(u << 1, l, r, delta);
        }
        if (r > mid) {//更新右子树
            updateSpanHelper(u << 1 | 1, l, r, delta);
        }
        pushUp(u);
    }

    public int query(int l, int r) {//区间查询
        return queryHelper(1, l, r);
    }

    private int queryHelper(int u, int l, int r) {//区间查询
        if (l <= tree[u].l  && tree[u].r <= r) {
            return tree[u].info;
        }
        pushDown(u);//如果u的tag不为0, 则u的child需要跟新info和tag
        int mid = (tree[u].l + tree[u].r) >> 1;
        int sum = 0;
        if (l <= mid) {//查询左子树
            sum += queryHelper(u << 1, l, r);
        }
        if (r > mid) {//查询右子树
            sum += queryHelper(u << 1 | 1, l, r);
        }
        return sum;
    }

    @Test
    public void segmentTreeTest() {
        SegmentTree segmentTree = new SegmentTree();
        int[] num = new int[]{0, 1, 2, 3, 4, 5};//index 0 not use;
        segmentTree.init(num);
        assertEquals(15, segmentTree.query(1, 5));
        assertEquals(6, segmentTree.query(1, 3));
        assertEquals(3, segmentTree.query(1, 2));

        segmentTree.updatePoint(3, 2);
        assertEquals(segmentTree.query(1, 3), 8);
        assertEquals(segmentTree.query(1, 2), 3);

        segmentTree.updatePoint(3, -2);
        assertEquals(segmentTree.query(1, 5), 15);
        assertEquals(segmentTree.query(1, 3), 6);

        segmentTree.updateSpan(1, 5, 1);
        assertEquals(20, segmentTree.query(1, 5));
        assertEquals(9, segmentTree.query(1, 3));
        assertEquals(5, segmentTree.query(1, 2));
    }
}
