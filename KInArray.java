public class KInArray {
	public int GetNumberOfK(int [] array , int k) {
		int count = 0;

		if(array.length == 0) {
			return 0;
		}

		int left = 0;
		int right = array.length - 1;

		while(left <= right) {
			int mid = left + (right-left) / 2;
			if(array[mid] == k) {
				for(int i=left;i<=right;i++) {
					if(array[i] == k) {
						count ++;
					}
				}
				return count;
			} else if(array[mid] < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return count;
	}
}
