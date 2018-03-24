/**Simple quickSort*/
import java.util.Arrays;
class QuickSort
{
	public int partition(int a[], int l, int r)
	{
		int i, j, pivot, t, temp;
		pivot = a[l]; i = l; j = r + 1;
		
		while(true)
		{
			do ++i; while(a[i] <= pivot);
			do --j; while(a[j] >= pivot);
			if (i >= j) 
				break;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}//end while

		//Swap pivot with position of j
		a[l] = a[j];
		a[j] = pivot;

		return j;

	}//end partition

	int[] quickSort(int a[], int l, int r)
	{
		//Account for bad input
		if (l < r) 
		{
			int j = partition (a, l, r);

			//Sort left side (from left index to middle - 1)
			quickSort(a, l, j - 1);
			//Sort right side (from right index to middle + 1)
			quickSort(a, j + 1, r);
		}

		return a;
	}

	public static void main(String[] args) 
	{
		int[] testArray = {8, 2, 5, 13, 4, 19, 12, 6, 3, 11, 10, 7, 9};
		int i = 0;
		QuickSort q = new QuickSort();

		int[] sortedArray = q.quickSort(testArray, 0, testArray.length - 1);

		/**if (testArray.equals(sortedArray)) 
		Returns true if I return the sorted array. this is due to hash function on equals method which is the same
		since same number of elements and corresponding parts are scattered in the array*/
		// if (sortedArray[0] == Integer.MIN_VALUE)	
		// {
		// 	System.out.print("The array has no elements or input was incorrect");
		// }
		//else
		//{
			//Iterate and print sortedArray
			for (i = 0;i < sortedArray.length - 1;i++ ) 
			{

				System.out.print(" " + sortedArray[i] + ", ");
			}
				System.out.print(sortedArray[i]);
		//}
	}//end main
}//end class

