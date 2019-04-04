# KDTree
Implementation of K-Dimensional Tree structure.

1)K-Dimensional tree structure is similar to the binart tree structure except that each node contaions D elements.

2)For each incoming node the Dth value is compared to decide Left-child or Right-child of the root node.

3)Because the kd-tree is the binary tree, and every leaf and internal node uses O(1) storage,therefore the total storage is O(n).

4)A kd-tree for a set of n-points uses O(n) storage and and can be constructed in O(n logn).

5)Range Search:Range query on the kd-tree takes O(√n + k) time, where k is the number of reported points.

