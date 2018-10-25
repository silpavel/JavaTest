package test;
import java.util.Random;
//bubble sort (only for int type)
//find min from n members, then find min  from n-1  etc
public class BubbleSort {
	public static void main(String arg[]) {
		int size=1;
	    int arr[]=new int[size];
	    Random rnd=new Random();
	    for(int i=0; i<size; i++)
	    {
	        arr[i]=rnd.nextInt(10);//rand()%10;
	        P.p(arr[i]+"  ");//cout<<arr[i]<<" ";
	    }

	    P.p();//cout<<endl;
	    bubbleSort(arr);
	    for(int i=0; i<size; i++)
	    {
	    	P.p(arr[i]+"  ");//cout<<arr[i]<<" ";
	    }
	    P.p();//cout<<endl;
	}
	static void bubbleSort(int arr[])//"pi" is a pointer to int array, "size" is size of an array
	{
	    if(arr.length<=1)
	        return;
	    for(int i=0; i<arr.length; i++)
	    {
	        for(int j=i+1; j<arr.length; j++)
	        {
	            if(arr[j]<arr[i])
	            {
	                int buf=arr[j];
	                arr[j]=arr[i];
	                arr[i]=buf;
	            }
	        }
	    }
	}
}
class P{
	static void p(int i){System.out.print(i);}
	static void p() {System.out.println();}
	static void p(String s) {System.out.print(s);}
}