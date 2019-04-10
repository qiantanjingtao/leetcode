class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def travel(self, tree, display):
        tree_queue = [tree]
        while tree_queue:
            if tree_queue[0] is None:
                display.append(None)
            else:
                display.append(tree_queue[0].val)

                tree_queue.append(tree_queue[0].left)
                tree_queue.append(tree_queue[0].right)
            tree_queue.pop(0)

        return display

    def insert_tree(self, tree, i):
        if tree is None:
            return

        if tree.left is None and tree.val > i:
            left_node = TreeNode(i)
            tree.left = left_node
            return

        if tree.right is None and tree.val < i:
            right_node = TreeNode(i)
            tree.right = right_node
            return

        if i < tree.val:
            self.insert_tree(tree.left, i)
        elif i > tree.val:
            self.insert_tree(tree.right, i)

    def generateTrees(self, n: int):
        import itertools
        arr = []
        count = []
        if n == 0:
            return count
        for i in range(n):
            arr.append(i + 1)
        res = list(itertools.permutations(arr, n))

        for i in range(len(res)):
            tree_node = TreeNode(res[i][0])
            display = []
            for j in list(res[i]):
                self.insert_tree(tree_node, j)
            self.travel(tree_node, display)
            for i in range(len(display), -1, -1):
                if display[i - 1] is None:
                    display.pop(i - 1)
                else:
                    break

            if display not in count:
                count.append(display)

        return count



