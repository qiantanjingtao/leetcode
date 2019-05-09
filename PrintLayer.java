import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintLayer {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> binary = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque();
		if(root == null) {
			return null;
		}
		queue.offer(root);
		while(queue.size() > 0) {
			TreeNode t = queue.poll();
			binary.add(t.val);
			if(t.left != null) {
				queue.offer(t.left);
			}
			if(t.right != null) {
				queue.offer(t.right);
			}
		}

		return binary;
	}

	public static void main(String []args) {
		PrintLayer pl = new PrintLayer();
		pl.PrintFromTopToBottom(null);
	}

}
