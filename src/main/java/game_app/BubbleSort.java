/**@Extension
 * class for bubble sorting in descending order
 */
package game_app;

public class BubbleSort {
 
    private static int temp = 0;  
	
    
 //**************************************************CONTROLLER****************************************************
	    public static void bubbleSort(int[] arr) {  //DESCENDING SORT
	        int n = arr.length; 
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] < arr[j]){  
	                                 //swap elements  
	                        	  	setTemp(arr[j-1]);  
	                                 arr[j-1] = arr[j];
	                                 arr[j] = getTemp();
	                         }  
	                          
	                 }  
	         }  
	    }

	    //**************************************************MODEL****************************************************
		public static int getTemp() {
			return temp;
		}

		public static void setTemp(int temp) {
			BubbleSort.temp = temp;
		}
	    
	    
}