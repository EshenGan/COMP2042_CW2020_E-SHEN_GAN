
package game_app;
/**<b>EXTENSION</b>:<br>
 * class for bubble sorting in descending order
 */
public class BubbleSort {
 
    private static int temp = 0;  
	
    
 //**************************************************CONTROLLER****************************************************
    /**static method to sort array integers in descending order
     * @param arr : array of type int
     */
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
		/** static getter for temp object 
		 * @return temp : temp object of type int
		 */
	    public static int getTemp() {
			return temp;
		}

	    /**static setter for temp object 
	     * @param temp : int object instantiated
	     */
		public static void setTemp(int temp) {
			BubbleSort.temp = temp;
		}
	    
	    
}