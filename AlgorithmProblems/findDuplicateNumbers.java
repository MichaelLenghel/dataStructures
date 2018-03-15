import java.util.Arrays;
//Problem
class findDuplicateNumbers
{
	public static int[] findDuplicates(int arr[] )
	{
		//By default visited is equal to false
		boolean[] visited = new boolean[arr.length + 100];
		int[] duplicates = new int[arr.length];
		int j = 0;

		//Initialise boolean valeus with false
		for (int i = 0;i < duplicates.length;i++ ) 
		{
			duplicates[i] = Integer.MIN_VALUE;
		}

		for (int i = 0;i < arr.length ; i++) 
		{
			if (visited[arr[i]])
			{
				duplicates[j] = arr[i];
				j++;
			}
			visited[arr[i]] = true;
		}
		if (duplicates[0] > Integer.MIN_VALUE) 
		{
			return duplicates;
		}
		else
		{
			return arr;
		}
	}

	public static void main(String[] args) {
		int a[] = {1 , 2, 5, 9, 8, 8, 2};
		int[] duplArr = findDuplicates(a);
		int i = 0;

		if (Arrays.equals(duplArr, a)) 
		{
			System.out.println("No duplicates found");
		}
		else
		{
			System.out.println("Duplicates are: ");
			for (i = 0;i < duplArr.length - 1;i++ ) 
			{
				if (duplArr[i + 1] == Integer.MIN_VALUE) 
				{
					break;	
				}
				System.out.print(" " + duplArr[i] + ", ");
			}//end for
			System.out.print(duplArr[i]);
		}//end else
	}//end main
}//end class