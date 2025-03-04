package org.jingtao8a.algorithm;

public class UnionSet {
    int[] parent;

    public UnionSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        parent[x] = y;
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        UnionSet unionSet = new UnionSet(5);
        unionSet.union(1, 2);
        unionSet.union(2, 3);
        System.out.println(unionSet.isSame(1, 3));
        System.out.println(unionSet.isSame(2, 4));
    }
}
