package game_app;

public class BubbleSort {
 
    private static int temp = 0;  
	//DESCENDING
  
	    public static void bubbleSort(int[] arr) {  
	        int n = arr.length; 
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] < arr[j]){  
	                                 //swap elements  
	                        	  	setTemp(arr[j-1]); //temp = arr[j-1];  
	                                 arr[j-1] = arr[j];
	                                 arr[j] = getTemp();//arr[j] = temp;
	                         }  
	                          
	                 }  
	         }  
	    }

		public static int getTemp() {
			return temp;
		}

		public static void setTemp(int temp) {
			BubbleSort.temp = temp;
		}
	    
	    
}