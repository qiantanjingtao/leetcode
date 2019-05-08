import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryMirror {
	public void Mirror(TreeNode root) {
		if(root == null) {
			return;
		} else {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			Mirror(root.left);
			Mirror(root.right);
		}
	}
}
