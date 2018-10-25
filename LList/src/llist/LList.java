package llist;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;

public class LList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lst=new LinkedList();//make new list
		Date dt=new Date();//take time
		Random rnd=new Random(dt.getTime());// run random
		Scanner read=new Scanner(System.in);// run read from console
		for(int i=1;i!=0;) {
			lst.addEnd(i=rnd.nextInt(10));//make array 
			P.p(i+" ");
		}
		P.p();
		lst.lookAll();//look consist of array
		/*/take element by index
		P.p("\nput index\n=");
		P.p(lst.get(read.nextInt()));
		*/
		//put an element to middle
		P.p("\nput index\n=");
		int ind=read.nextInt();
		P.p("\nput value\n=");
		lst.addMid(read.nextInt(), ind);
		lst.lookAll();//look consist of array
	}

}
