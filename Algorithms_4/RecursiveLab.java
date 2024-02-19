package Algorithms_4;

public class RecursiveLab {
	public static void main(String[] args) throws Exception {
//		BinaryString();
//		charOccur("eclipse", 'c');
//		int[] arr = {0,1,2,3,4,5};
//		ArrayCombination(arr, 3);
	}
	
	//Ex1	
	public static void BinaryStringCons(int k) {
//		final int size = k;
//		char[] ch = new char[size];
//		int n = 
//		if(k==0) {
//			System.out.println('0'*size);
//		}
//		String num = "";
//		for(int i = k;i>=0;i--) {
//			if() {
//				
//			}
//		}
//		else
//			System.out.println();
		
//		BinaryString(k-1);
	}
	
	public static void generate(int k,char[] ch, int n) {
		final int size = k;
		
	}
	
	//Ex2
	static void ArrayCombination(int arr[], int r) {
		int n = arr.length;
		int[] data = new int[r];
		CombinationUtil(arr, data, 0, n-1, 0, r);
	}
	
	static void CombinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		if(index==r) {
			for(int i=0; i<r; i++)
				System.out.print(data[i] + " ");
			System.out.println(" ");
			return;
		}
		for(int j = start; j<= end && end-j+1 >= r - index; j++) {
			data[index] = arr[j];
			CombinationUtil(arr, data, j+1, end, index+1, r);
		}
	}
	
	//Ex3
	public static void charOccur(String str, char x) throws Exception {
		System.out.println(Occur(str, x, 0));
	}
	
	//Ex4
	public static int Occur(String str, char x, int index) throws Exception {
		if(str.length()==0) {
			throw new Exception("char could not found");
		}

		if(str.charAt(0) == x) {
			return index;
		}
		return Occur(str.substring(1), x, index+1);
	}
}
