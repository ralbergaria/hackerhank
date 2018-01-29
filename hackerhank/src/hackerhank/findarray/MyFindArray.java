package hackerhank.findarray;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
		if(array.length == 0 || subArray.length == 0) {
			return -1;
		}
		
		int pos = -1;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == subArray[0]) {
				pos = i;
				for (int j = 1; j < subArray.length; j++) {
					i++;
					if (i >= array.length || array[i] != subArray[j]) {
						i--;
						pos = -1;
						break;
					}
				}
			}
		}
		return pos;
	}
}
