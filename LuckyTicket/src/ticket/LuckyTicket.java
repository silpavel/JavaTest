/*
I have array int def[28], indexes 0..27
Number of a ticket include 6 digit: 000000
A ticket is "lucky", if sum of 1,2,3 digit equals sum of 4,5,6.
In that case I do  "def[0]++"
If a difference between sum(1,2,3) and sum(4,4,5)  equals 1, then "def[1]++"
If a difference equals, then "def[15]++"
etc
The max difference is 9+9+9-0+0+0 = 3*9 = 27
*/
package ticket;

public class LuckyTicket {
	public static void main(String arg[]) {
		int def[]=new int[28];//int def[28];
	    for(int i=0; i<28; i++)
	        def[i]=0;//calloc, by zero
//solution use %,* and /
	    //*
	    for(int n=0; n<1000000; n++)
	    {
	        int r6,r5,r4,r3,r2,r1;//разряды числа
	        r1=n%10;
	        r2=(n%100-r1)/10;
	        r3=(n%1000-r2*10-r1)/100;
	        r4=(n%10000-r3*100-r2*10-r1)/1000;
	        r5=(n%100000-r4*1000-r3*100-r2*10-r1)/10000;
	        r6=(n-r5*10000-r4*1000-r3*100-r2*10-r1)/100000;
	        //cout<<r6<<r5<<r4<<r3<<r2<<r1<<endl;
	        //cout<<"*";
	        int dsum=r1+r2+r3-(r4+r5+r6);
	        if(dsum<0)
	            dsum*=-1;
	        def[dsum]++;
	    }
//print result
	    P.p();//cout<<endl;
	    for(int i=0; i<28; i++)
	    {
	        P.p("dsum="+i+"\tfreq="+def[i]/10000.+" %\n");
	    	//cout<<"dsum="<<i<<"\tfreq="<<def[i]/10000.<<" %"<<endl;
	    }
	    //*/
//solution use + and - only (almost)
	    //*
	    for(int i=0; i<28; i++)
	        def[i]=0;//обнуляем содержимое массива

	    int r6=0,r5=0,r4=0,r3=0,r2=0,r1=0;//разряды числа
	    while(r6<10)
	    {
	        //cout<<r6<<r5<<r4<<r3<<r2<<r1<<endl;
	        //cout<<"*";
	        int dsum=r1+r2+r3-(r4+r5+r6);
	        if(dsum<0)
	            dsum*=-1;
	        def[dsum]++;
	        r1++;
	        if(r1==10)
	        {
	            r1=0;
	            r2++;
	        }
	        if(r2==10)
	        {
	            r2=0;
	            r3++;
	        }
	        if(r3==10)
	        {
	            r3=0;
	            r4++;
	        }
	        if(r4==10)
	        {
	            r4=0;
	            r5++;
	        }
	        if(r5==10)
	        {
	            r5=0;
	            r6++;
	        }
	    }
	    //print result
	    P.p();//cout<<endl;
	    for(int i=0; i<28; i++)
	    {
	    	P.p("dsum="+i+"\tfreq="+def[i]/10000.+" %\n");
	    	//cout<<"dsum="<<i<<"\tfreq="<<def[i]/10000.<<" %\n";
	    }
	    //*/
	}
}
class P{
	static void p(int i){System.out.print(i);}
	static void p() {System.out.println();}
	static void p(String s) {System.out.print(s);}
}
