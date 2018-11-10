/**
 * 
 */
package assignment2;

import java.util.Arrays;

/**
 * @author Pooja
 *
 */
public class LeftPivotQuicksort {

	/**
	 * @param args
	 */static int[] a={13,19,9,5,12,8,7,4,11,2,6,21};
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(a));
		quicksort(0,a.length-1);
		//System.out.println(Arrays.toString(a));
	}
	
	private static void quicksort(int left,int right)
	{	if(right<=left)
			return;
		else if(left<right){
			    int temp=0;
				int pivot=a[left];  System.out.println("Pivot: "+pivot);                   
			    int L=left+1;
			    int R=right;
		
			    while(L<R)
			  {
			    	while(a[L]<pivot) {
				     if(L==right) 
				     break;
				     L++; } 
		
				    while(a[R]>pivot){
				     if(R==left) 
				     break;
				     R--;}
		
				   if(L<R) {
				     temp = a[L];
				     a[L]= a[R];
				     a[R]= temp;
				     L++;
				     R--;}
			  }   

			    if(a[R]<pivot){  
				    temp = a[R];
				    a[R]= a[left];
				    a[left]= temp;}
			    
	    System.out.println(Arrays.toString(a));
		     
	    if(left<R)                                    //Recursively sort the left half.
		     quicksort(left,R-1);
	   
	    

	    if(right>R)                                    //Recursively sort the right half.
	    	quicksort(R+1,right);
	    
	    
	   }
	}	
}
