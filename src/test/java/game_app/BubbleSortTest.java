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
				() -> assertEquals(5,arr[0],"Error: first element should be 5" ),
				() -> assertEquals(4,arr[1],"Error: second element should be 4"),
				() -> assertEquals(3,arr[2],"Error: third element should be 3"),
				() -> assertEquals(2,arr[3],"Error: fourth element should be 2"),
				() -> assertEquals(1,arr[4],"Error: fifth element should be 1")
				);
	}


}
