public class BinarySearchTreeOrder {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0) {
			return false;
		}
		return Ver(sequence);
	}

	public boolean Ver(int [] sequence) {
		if(sequence.length == 0 || sequence.length == 1) {
			return true;
		}
		int root = sequence[sequence.length-1];
		int[] left = new int[sequence.length];
		int[] right = new int[sequence.length];
		int i ;
		int leftLength = 0;
		int rightLength = 0;
		for(i=0;i<sequence.length;i++) {
			if(sequence[i] < root) {
				left[i] = sequence[i];
				leftLength += 1;
			} else {
				break;
			}
		}
		int []leftVal = new int[leftLength];
		for(int k=0;k<leftLength;k++) {
			leftVal[k] = left[k];
		}

		for (int j=i;j<sequence.length-1;j++) {
			if(sequence[j] < root) {
				return false;
			}

			right[j] = sequence[j];
			rightLength += 1;
		}

		int []rightVal = new int[rightLength];
		for(int k=0;k<rightLength;k++,i++) {
			rightVal[k] = right[i];
		}
		return Ver(leftVal) && Ver(rightVal);
	}


	public static void main(String []args) {
		int []a = new int[4];
		a[0] = 4; a[1] = 6; a[2] = 7; a[3] = 5; //a[4] = 16; a[5] = 14; a[6] = 10;
		//4,8,6,12,16,14,10
		BinarySearchTreeOrder bsto = new BinarySearchTreeOrder();
		if(bsto.VerifySquenceOfBST(a)) {
			System.out.print("jhe");
		}
	}
}
