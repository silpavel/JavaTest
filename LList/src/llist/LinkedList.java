package llist;

public class LinkedList {
	public void addEnd(int i)
	{
		if( sizeList==0)
		{
			sizeList=1;
	        first=new Elem(i);
		}
		else//find last element
	    {
	        Elem last = first;
			while (last.next != null)// find element that has zero pointer
			{
				last = last.next;// go by chain
			}
			sizeList++;
			last.next = new Elem(i);

		}
	}
	void lookAll()// all list to screen
	{
		if (sizeList == 0)
			return;
		Elem last = first;
		while (last.next != null) {
			P.p(last.var + " ");// cout<< last->var <<' ';
			last = last.next;
		}
		P.p(last.var + " \n");// cout<< last->var <<' ';
		// cout<<endl;
	}
	public LinkedList() {
		P.p("run constructor\n");
		sizeList = 0;
		first = null;
	}
	public class Elem {
		public Elem(int i) {
			var = i;
			next = null;
		}

		public Elem next;
		public int var;
	}
	public int get(int index)//get element with the index
	{
		if( index>=sizeList || sizeList==0 )
	        return 0;
	    int bufind=0;
	    Elem pindex=first;
	    while(bufind!=index)
	    {
	        pindex=pindex.next;
	        bufind++;
	    }
	    return pindex.var;

	}
	public void addMid(int i, int index)
	{
		if( index>=sizeList || sizeList==0 || index<0)
	        addEnd(i);
	    else if (index==0)
	    {
	        Elem bufnext=first;
	        first=new Elem(i);
	        first.next=bufnext;
	        sizeList++;
	    }
	    else
	    {
	        int bufind=0;
	        Elem pindex=first;
	        while(bufind!=index-1)
	        {
	            pindex=pindex.next;
	            bufind++;
	        }

	        Elem bufnext=pindex.next;
	        pindex.next=new Elem(i);
	        pindex.next.next=bufnext;
	        sizeList++;
	    }
	}
	private int sizeList;
	private Elem first;
}

class P {
	static void p(int i) {
		System.out.print(i);
	}
	static void p() {
		System.out.println();
	}
	static void p(String s) {
		System.out.print(s);
	}
}