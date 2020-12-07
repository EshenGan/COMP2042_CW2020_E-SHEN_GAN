package game_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	private int[] arr;
	/*
	 * to test whether the bubble sort is actually sorting numbers in descending order as expected
	 */
	@Test
	void testBubbleSort() { 
		arr = new int[]{1,2,3,4,5};

		BubbleSort.bubbleSort(arr); //sort descending
		assertAll("arr",
				() -> assertEquals(arr[0],5,"first element should be 5" ),
				() -> assertEquals(arr[1],4,"second element should be 4"),
				() -> assertEquals(arr[2],3,"third element should be 3"),
				() -> assertEquals(arr[3],2,"fourth element should be 2"),
				() -> assertEquals(arr[4],1,"fifth element should be 1")
				);
	}


}
