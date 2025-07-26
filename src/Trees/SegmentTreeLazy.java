// Segment Tree with Lazy Propagation for Range Sum Queries and Updates
// Author: GitHub Copilot

public class SegmentTreeLazy {
    private int[] tree, lazy;
    private int n;

    public SegmentTreeLazy(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        build(arr, 0, n - 1, 1);
    }

    // Build the segment tree
    private void build(int[] arr, int l, int r, int idx) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, 2 * idx);
        build(arr, mid + 1, r, 2 * idx + 1);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    // Push lazy updates to children
    private void push(int idx, int l, int r) {
        if (lazy[idx] != 0) {
            tree[idx] += (r - l + 1) * lazy[idx];
            if (l != r) { // not a leaf
                lazy[2 * idx] += lazy[idx];
                lazy[2 * idx + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    // Range update: add val to all elements in [ql, qr]
    public void updateRange(int ql, int qr, int val) {
        updateRange(1, 0, n - 1, ql, qr, val);
    }
    private void updateRange(int idx, int l, int r, int ql, int qr, int val) {
        push(idx, l, r);
        if (r < ql || l > qr) return; // no overlap
        if (l >= ql && r <= qr) { // total overlap
            lazy[idx] += val;
            push(idx, l, r);
            return;
        }
        int mid = (l + r) / 2;
        updateRange(2 * idx, l, mid, ql, qr, val);
        updateRange(2 * idx + 1, mid + 1, r, ql, qr, val);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    // Range query: sum of elements in [ql, qr]
    public int queryRange(int ql, int qr) {
        return queryRange(1, 0, n - 1, ql, qr);
    }
    private int queryRange(int idx, int l, int r, int ql, int qr) {
        push(idx, l, r);
        if (r < ql || l > qr) return 0; // no overlap
        if (l >= ql && r <= qr) return tree[idx]; // total overlap
        int mid = (l + r) / 2;
        return queryRange(2 * idx, l, mid, ql, qr) + queryRange(2 * idx + 1, mid + 1, r, ql, qr);
    }

    // For demonstration: print the segment tree and lazy arrays
    public void print() {
        System.out.print("Tree: ");
        for (int i = 1; i < 2 * n; i++) System.out.print(tree[i] + " ");
        System.out.println();
        System.out.print("Lazy: ");
        for (int i = 1; i < 2 * n; i++) System.out.print(lazy[i] + " ");
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTreeLazy st = new SegmentTreeLazy(arr);
        System.out.println("Sum of [1, 3]: " + st.queryRange(1, 3)); // 15
        st.updateRange(1, 3, 10); // add 10 to elements 1,2,3
        System.out.println("Sum of [1, 3] after update: " + st.queryRange(1, 3)); // 45
        st.print();
    }
}
