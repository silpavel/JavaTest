package myedu;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;

public class Methods {
	static void f5zero() {//���� ����� �� �����, ����� 0 ����� ������ ������
		String s="";
		for(int i=0;i<5;i++) {
			s=s+" 0";
			System.out.print(s+'\n');
		}
	}
	static void fA(int n, int m) {//"A" n*m, n- ����� �����
		String s="";
		for(int i=1;i<=m;i++) s+="A";
		s+="\n";
		for(int i=1;i<=n;i++) System.out.print(s);
	}
	static void fW() {//������� ��  ����� W �� *
		String s="*   *   *\n"+
				 " * * * *\n"+
				 "  *   *\n";
		System.out.print(s);
	}
	static void triangle() {// ������ ������, ����� ������� � ����������
		Scanner sc=new Scanner(System.in);
		System.out.print("a=");
		int a=sc.nextInt();
		System.out.print("b=");
		int b=sc.nextInt();
		System.out.printf("S=%d, gep=%.2f", a*b, Math.sqrt(a*a+b*b));
	}
	static void fSS() {// ���� �����, ������ �� ����� � ���������
		Scanner sc=new Scanner(System.in);
		System.out.print("x=");
		int x=sc.nextInt();
		System.out.print("y=");
		int y=sc.nextInt();
		//sqrt(x-sqrt(y)), y>=0, x-sqrt(y)>=0->x>=sqrt(y)
		if( y>=0 && x>=Math.sqrt(y) )
				System.out.printf("resault=%.2f",Math.sqrt(x-Math.sqrt(y)));
		else System.out.print("have no real value");
		
	}
	static void robot(int direct, int turn) {//direct: 11 -N, 12 - W, 13 - S, 14 - E, turn: 0 - no turn, 1- left, -1 - right
		char w[]={'N','W','S','E'};
		int temp=direct+turn*(-1);
		if(temp==10) temp=14;
		if(temp==15) temp=11;
		System.out.printf("turn from %c to %c", w[direct-11],w[temp-11]);
		/*
		 * ����� ����� ������������ � ������� ������������ (�11� � �����, �12� � �����, �13� � ��, �14� � ������)
		 * � ��������� ��� �������� �������: 0 � ���������� ��������, 1 � ������� ������, �1 � ������� �������.
		 * ��� ����� (11, 12, 13 ��� 14) � �������� ����������� ������ � ����� ����� N (0, 1 ��� -1) � ���������
		 * ��� �������. ������� ����������� ������ ����� ���������� ���������� ������� (�� ���� �����, �����, ��
		 * ��� ������).
		 */
	}
	static void clockArc(int h, int m) {
	/*
	 * ���� ����� h � m, ��� h - ���������� �����, m - ���������� ����� ���������� ������� �������.
	 *  ������� ���� ����� ������� � �������� ��������� � ���� ������ �������.
	 */
		m=m%60;
		h=h%12;
		h=h*30+m/2;//���� � ����
		m=m*6;//��� � ����
		int d=Math.abs(h-m);
		if(d>180 && d<360) d=360-d;
		if(d==360) d=0;
		System.out.printf( "arc=%d", d);
		
		
	}
	static void sum1toN(int n) {//1+2+3+...+n
		int sum=0;
		for (int i=1;i<=n;i++) sum+=i;
		System.out.printf("sum=%d", sum);
	}
	static void sumCos() {
		double sum=0;
		for(int i=3;i<=11111;i++)
			sum+=Math.cos(i/(i+2));
		System.out.printf("sumcos=%.2f",sum);
	}
	static void sportsmen() {
		/*
		 * ����� ����������, ������ � ������ ���� �������� 10 ��. ������ ��������� ���� �� ���������� ������ �� 10%
		 * �� ������� ����������� ���. ����������: �) ������ ������� �� ������, ������, ..., ������� ���� ����������;
		 * �) ����� ��������� ���� �� �������� �� ������ 7 ���� ����������. �) ��������� ���� �� n ���� ����������;
		 * �) � ����� ���� ��� ������� ���������� ����������� ������, ���� �� �� ������ ��������� 80 ��?
		 */
		int day1=10;//day2=10+10*0.1=day1*(1+0.1),day3=day2(1+0.1)=day1*(1+0.1)^2
		int n=10;
		double inday=day1;
		double sumday=0;
		for(int i=1;i<=n;i++) {
			inday=day1*Math.pow(1.1, i);
			sumday+=inday;
			if(sumday>80) {System.out.print("STOP!");break;}
			System.out.printf("%d day for day=%.2fkm for all time=%.2fkm\n", i, inday, sumday);
			
		}
	}
	static void notEqNum() {//������� �� ����� ����� �� 1000 �� 9999 �����, ��� ��� ����� ��������.
		for(int i=1000;i<=9999;i++) {
			int a=i/1000,
				b=i/100%10,
				c=i/10%10,
				d=i%10;
			if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d)
				System.out.printf("%d%d%d%d\n",a,b,c,d);
		}
	}
	static void no5and6() {//������� �� ����� ����� �� 1000 �� 9999 �����, ��� ����� ���� ��� ���� 5 � ����� 6.
		for(int i=1000;i<=9999;i++) {
			int a=i/1000,
				b=i/100%10,
				c=i/10%10,
				d=i%10;
			if(a!=5 && a!=6 && b!=5 && b!=6 && c!=5 && c!=6 && d!=5 && d!=6)
				System.out.printf("%d%d%d%d\n",a,b,c,d);
		}
	}
	static void sumCube3() {//������� ����������� �����, ������ ����� ����� ����� ����.
		int a,b,c;
		for(int i=100;i<=999;i++) {
			a=i/100;
			b=i/10%10;
			c=i%10;
			if( i == a*a*a + b*b*b + c*c*c )
				System.out.printf("%d%d%d\n",a,b,c);
		}
	}
	static void f4d600() {//������� ���������� �������������� �����, ������� � 600 ��� ������ ����� ����� ����?
		int a,b,c,d;
		for(int i=1000;i<=9999;i++) {
			a=i/1000;
			b=i/100%10;
			c=i/10%10;
			d=i%10;
			if( (a+b+c+d)*600==i)
				System.out.printf("%d%d%d%d",a,b,c,d);
		}
	}
	static void dev11(int n) {//������� ���� ���� ����������� �����, ������� ������� �� 11, 
		                 //� ��� ������� �� 2, 3, 4, ..., 10 ���� � ������� 1 (����������� 25201)
		for(int i=11;i<=n;i++) {
			if(i%11==0 && i%10==1 && i%9==1 && i%8==1 && i%7==1 && i%6==1 && i%5==1 && i%4==1 && i%3==1 && i%2==1)
				System.out.print(i+"\n");
		}
	}
	static void str30() {
		
		/* ������� 30 �����. �������� ������ �������� ����������� ����� �� 1 �� ������ ������� ������ ������������
		 * � ����� 1, ������ ������ �������  �� ���� ������.
		 */
		String s="";
		for(int i=1;i<=30;i++) {
			s+=i;
			if(i%2==0)
				System.out.print("11111\n");
			else
				System.out.print(s+'\n');
		}
	}
	static void sum2in() {//������������ ������ ��������� ����� ����� �� ��� ���, ���� �� ������ ����.
		//������� ���������� ������ �����, ������� �� ����.
		Scanner sc=new Scanner(System.in);
		int n=-1;
		int sum=0;
		while(n!=0) {
			System.out.print("put n=");
			n=sc.nextInt();
			if(n%2==0) sum+=n;
		}
		System.out.printf("sum=%d", sum);
	}
	static void intToDig(int n) {//���������� int-����� ����� ������ �� �������(�����)
		//max int 10dig
		System.out.println(n);
		int dig[]=new int[10];//12 is dig[0]=2;dig[1]=1;
		dig[0]=n%10;
		dig[9]=n/1_000_000_000;
		for(int i=1;i<10;i++) {
			dig[i]=n/( (int)Math.pow(10, i) )%10;
		}
		for(int i=9;i>=0;i--) {
			System.out.print(dig[i]);
		}
	}
	static void fibon(int n) {//������� n-�� ����� ���������.1:1, 2:1, 3:1+1=2, 4:1+2=3, 5:2+3=5
		int a=1, b=1, fib=1;
		for(int i=3;i<=n;i++) {
			fib=a+b;
			a=b;
			b=fib;
		}
		System.out.print(fib);
	}
	static void del(int d) {//������� ��� �������� ������� ������������ �����.
		//�������� - ������� �����
		//���� ������� ����� �� 2 �� d �������������
		int prime[]=new int[d];
		prime[0]=2;
		int sz=0;//������ ���������� ��������
		boolean isPrime;
		for(int i=3;i<d;i+=2) {
			isPrime=true;
			for(int j=0;j<=sz && isPrime;j++) {
				if( i%prime[j] == 0) isPrime=false;
			}
			if(isPrime) {
				prime[++sz]=i;
				//System.out.print(i+" ");
			}
		}
		//���� �������� � ������� �� �� �����
		System.out.printf("del=%d\n", d);
		int chn=d;//�������
		int dlt[]=new int[d];//������ ���������
		int pdlt=-1;//����� ���������� ��������
		while(chn!=1) {
			for(int i=0;i<=sz;i++) {
				if(chn%prime[i]==0 && d!=prime[i]) {
					System.out.print(prime[i]+" ");
					dlt[++pdlt]=prime[i];
					chn/=prime[i];
				}
				if(chn==d) chn=1;
			}
		}
	}
	static void friend(int a, int b) {//��� ����� ���������� ��������������, ���� ������ �� ��� ����� �����
		//���� ��������� ������� �� ������ ������ ����� �����. ������� ��� ���� ������������� ����� �� ������� [a;b].
		//�������� - ������� �����
		//���� ������� ����� �� 2 �� d �������������
		int prime[]=new int[b];
		prime[0]=2;
		int sz=0;//������ ���������� ��������
		boolean isPrime;
		for(int i=3;i<b;i+=2) {
			isPrime=true;
			for(int j=0;j<=sz && isPrime;j++) {
				if( i%prime[j] == 0) isPrime=false;
			}
			if(isPrime) {
				prime[++sz]=i;
				//System.out.print(i+" ");
			}
		}
		for(int i=a;i<=b;i++) {
			//���� �������� ����� i
			//System.out.printf("del=%d\n", d);
			int chn=i;//�������
			int dlt[]=new int[i];//������ ���������
			int pdlt=-1;//����� ���������� ��������
			int sumdel=0;//����� ���������
			while(chn!=1) {
				for(int k=0;k<=sz;k++) {
					if(chn%prime[k]==0 && i!=prime[k]) {
						//System.out.print(prime[k]+" ");
						dlt[++pdlt]=prime[k];
						sumdel+=prime[k];
						chn/=prime[k];
					}
					if(chn==i) chn=1;
				}
			}
			for(int j=a;j<=b && pdlt!=-1;j++) {
				if(j==sumdel) {
					System.out.print("num="+i+" del: ");
					for(int k=0;k<=pdlt;k++) {
						System.out.print(dlt[k]+" ");
					}
					System.out.print("\tfriend="+j+"\n");
				}
			}
			
		}
	}
	static void ideal(int b) {//����������� ����� ���������� �����������, ���� ��� ����� ����� ���� ����� ���������,
		//�� ������ ������ �����. ������� ��� ����������� �����, ������� ������� ������������ ����� n.
		//�������� - ������� �����
		//���� ������� ����� �� 2 �� b �������������
		int prime[]=new int[b];
		prime[0]=2;
		int sz=0;//������ ���������� ��������
		boolean isPrime;
		for(int i=3;i<b;i+=2) {
			isPrime=true;
			for(int j=0;j<=sz && isPrime;j++) {
				if( i%prime[j] == 0) isPrime=false;
			}
			if(isPrime) {
				prime[++sz]=i;
				//System.out.print(i+" ");
			}
		}
		for(int i=2;i<=b;i++) {
			//���� �������� ����� i
			//System.out.printf("del=%d\n", d);
			int chn=i;//�������
			int dlt[]=new int[i];//������ ���������
			int pdlt=-1;//����� ���������� ��������
			int sumdel=0;//����� ���������
			while(chn!=1) {
				for(int k=0;k<=sz;k++) {
					if(chn%prime[k]==0 && i!=prime[k]) {
						//System.out.print(prime[k]+" ");
						dlt[++pdlt]=prime[k];
						sumdel+=prime[k];
						chn/=prime[k];
					}
					if(chn==i) chn=1;
				}
			}
			if(i==sumdel) {
				System.out.print("num="+i+" del: ");
				for(int k=0;k<=pdlt;k++) {
					System.out.print(dlt[k]+" ");
				}
				System.out.print("\tsum="+sumdel+"\n");
			}
										
		}
	}
	static void t13next13() {//������� ���������� ����� ������������, ���� ����� ���� ��� ������������� ������
		//������� �� 13. ����� �� ��� ������ ������ ������ ��������� �������������?
		int a,b,c,d,e,f;
		boolean lastIs13=false;
		for(int i=0;i<=999999;i++) {
			//find digitals
			a=i/100000;
			b=i/10000%10;
			c=i/1000%10;
			d=i/100%10;
			e=i/10%10;
			f=i%10;
			if( (a+b+c+d+e+f)%13==0 )
				if(lastIs13) System.out.printf("%d\t%d\n", i-1, i);
				else lastIs13=true;
			else lastIs13=false;
			
		}
	}
	static void primeN(int b) {//������� n ��� ������� �����, ������� ���������� ���� �� ����� �� 2.
		int prime[]=new int[b*2];
		prime[0]=2;
		int cnt=0;
		int sz=0;//������ ���������� ��������
		boolean isPrime;
		for(int i=3;i<b*2 && cnt<=b;i+=2) {
			isPrime=true;
			for(int j=0;j<=sz && isPrime;j++) {
				if( i%prime[j] == 0) isPrime=false;
			}
			if(isPrime) {
				prime[++sz]=i;
				if(prime[sz]-prime[sz-1]==2) {
					System.out.printf("%d\t%d\n", prime[sz], prime[sz-1]);
					cnt++;
				}
			}
				//System.out.print(i+" ");
		}
	}
	static void digSum() {//������� ��� ����������� �����, �� ������������� 10000, ����� ���� ������� �� �������
		//� ��������� ������� ����� ������ �����.
		int a,b,c,d,sum=0;
		double tmp=0;
		for(int i=2;i<=9999;i++) {
			a=i/1000;
			b=i/100%10;
			c=i/10%10;
			d=i%10;
			sum=a+b+c+d;
			tmp=0;
			for(int j=1;tmp<=i && tmp!=1;j++) {
				tmp=Math.pow(sum, j);
				if(tmp==i) System.out.print(i+"  ");
				
			}
			
		}
	}
	static void sum01() {//001101011 sum>10
		Date t=new Date();
		Random rnd=new Random(t.getTime());
		int sum,rndint;
		for(int i=1;i<=5;i++) {
			sum=0;
			while(sum<=10) {
				rndint=rnd.nextInt(2);
				sum+=rndint;
				System.out.print(rndint);
			}
			System.out.println();
		}
	}
	static void take123Boxes(int n) {//���� n ��������. �� � ��������� ������ ����������. �� ��� ����� ����� 1, 2 ��� 3
		//�������. �������� ���, ���� ������ �����. ���������� ���� � �����������. ��������� ����� ��������
		//(��� ������� ���������� ���������), ������ ���� � ���� ���� ���, ������� �������� ��������� ��� ���
		//��������, �� �� ��� ���������.
		boolean user=true;//true ���� ����� ����
		int userBox;
		Scanner sc=new Scanner(System.in);
		Date dt=new Date();
		Random rnd=new Random(dt.getTime());
		for(int box=n;box>0;) {
			if(user) {
				System.out.printf("Left %d box(es).\nPut 1,2 or 3: ",box);
				if( sc.hasNextInt()) {
					userBox=sc.nextInt();
					if ( userBox<=box && (userBox==1 || userBox==2 || userBox==3) ) {
						box-=userBox;
						if(box!=0) user=false;
					}
					else {System.out.print("Incorrect. Only 1,2 or 3 (but <= left box). Try again.\n");}
				}else {System.out.print("Incorrect symbol. Try again.\n");sc.next();}
			}else {
				System.out.print("PC made step\n");
				if(box>3) {
					box-=rnd.nextInt(3)+1;
					user=true;
				}else box=0;
			}
		}
		if(user) System.out.print("User WIN!!!");
		else System.out.print("PC WIN!!!");
		sc.close();
	}
	static void gameStScPa(int n) {//���������� ����� �� n ��� "������, �������, ������" � �����������.
		//� ���������� �������� ����������: ������� ��� ������� ������������, ������� ��� ������� ���� �����
		//���� �������. ��������� ���� �������� ���������� ����� ����� � ����� �������� ����������� ������ ��� ����.
		Scanner sc=new Scanner(System.in);
		
		Random rnd=new Random( (new Date()).getTime() );
		char user,pc='s';
		int uf=0;//1 - user win, -1 - PC win
		int stat=0;
		for(int i=1;i<=n;i++) {
			System.out.println("Put simbol (s)tone, s(c)issors or (p)aper:");
			user=(sc.next()).charAt(0);//user step
			if(user!='s' && user!='c' && user!='p') {
				System.out.print("Incorrect simbol! try again!\n");
			}else {
				switch( rnd.nextInt(3) ) {//PC step
				case 0:pc='s';break;
				case 1:pc='c';break;
				case 2:pc='p';break;
				}
				System.out.printf("PC %c ",pc);
			}
			//System.out.printf("user=%c pc=%c\n",user, pc);
			if(pc==user) uf=0;
			else switch(user) {
			case 's': if(pc=='c') uf=1; else uf=-1;break;
			case 'c': if(pc=='p') uf=1; else uf=-1;break;
			case 'p': if(pc=='s') uf=1; else uf=-1;break;
			}
			if(uf==0) System.out.print("dead heat!\n");
			else if(uf==-1) {System.out.print("PC win!!!\n");stat--;}
			else {System.out.print("You win!!!\n");stat++;}
			System.out.print("-----------------------------------\n");
		}
		sc.close();
		System.out.print("<<<GAME OVER>>>\n");
		System.out.printf("resaul %d. <0 - PC win, >0 - You win\n, =0 - dead heat!",stat);
	}
	static void s111() {//������������� ��������� ����� �� 15 �����, � ������� ����� 3 �������, ��������� ����.
		Random rnd=new Random((new Date()).getTime());
		String s="";
		int sum=0,tmp,cnt=0;
		
		while(sum!=3) {
			sum=0;
			s="";
			cnt++;
			for(int i=1;i<=15;i++) {
				tmp=rnd.nextInt(2);
				s+=tmp;
				sum+=tmp;
			}
		}
		System.out.print(s+'\n');
		System.out.print(cnt);
	}
	static void s123() {//������������ ����� �� 10 ��������� ����� �� 1 �� 3 � �������: 
		//�) �� ������� ���������� ����� ������/������ ���������� �����, 
		//�) ���������� �����, ������� �� ������ ������, �)���������� ����� ����� ������ ���� ����� �����.
		Random rnd=new Random((new Date()).getTime());
		int a=0,b3even=0,v25=0,next;
		for(int i=1;i<=10;i++) {
			next=rnd.nextInt(3)+1;
			System.out.print(next+" ");
			if(next==2) a++;
			if(next==3) a--;
			if(i%2==0 && next==3) b3even++;
			if(i<=5 && next==2) v25++;
			
		}
		System.out.println();
		//aaaaaaaaaa
		if(a>0) System.out.println("2 more on "+a);
		if(a<0) System.out.println("3 more on "+a*(-1));
		else System.out.println("2 equals 3" );
		//bbbbbbbbbb
		System.out.println("3 in even place is "+b3even);
		//vvvvvvvvvv
		System.out.println("2 in 1..5 place is "+v25);
	}
	static void s012() {//������������� 20 ����� �� 0, 1, 2 �����, ��� ����� ����� � ������ ����� ����� 12.
		//����� ���������� ������ � ������ �����, ���������� ����� � ������ �����, ����� ������ �����,
		//������� ���������� ����� � ������, ������� ����� ����� � ���������� ���������� ��������� ����� � ������.
		Random rnd=new Random((new Date()).getTime());
		int sum,n0,n1,n2,next,lenght;
		int sum1=0,sum2=0,sumLenght=0,maxNotZero=0,notZero=0;
		for(int i=1;i<=20;i++) {//find 20 series
			sum=0;
			lenght=0;
			n1=n2=0;
			notZero=0;
			while(sum!=12) {
				next=rnd.nextInt(3);
				sum+=next;
				lenght++;
				if(next==1) {n1++;notZero++;}
				if(next==2) {n2++;notZero++;}
				
				System.out.print(next);
				if(sum>12) {
					sum=0;
					lenght=0;
					n1=n2=0;
					notZero=0;
				}
			}//end of seria
			if(notZero>maxNotZero) maxNotZero=notZero;
			sum1+=n1;//����� '1' �� ���� ������
			sum2+=n2;//����� '2' �� ���� ������
			sumLenght+=lenght;
			System.out.printf("\tlenght=%d, '1'=%d, '2'=%d, 'not 0 %%'=%d %%",lenght,n1,n2,100*notZero/lenght);
			System.out.println();
		}
		System.out.printf("average '1' =%.2f\n",sum1/20.);
		System.out.printf("average '2' =%.2f\n",sum2/20.);
		System.out.printf("average 'lenght' =%.2f\n",sumLenght/20.);
		System.out.printf("Max not zero simbols =%d\n",maxNotZero);
	}
	static void s2eq0() {//������������ ����� ��������� ����� �� 0, 1, 2 ���, ����� ���������� ����� ���� ����� ���������� �����.
		//����� ����� ���� �� ���� 0 � ��� ������� ���� 2
		Random rnd=new Random((new Date()).getTime());
		int n2=0,n0=0,next;
		boolean fneq=true;
		while(fneq) {
			next=rnd.nextInt(3);
			if(next==0) n0++;
			if(next==2) n2++;
			if(n0==n2 && n0>0) fneq=false;
			System.out.print(next);
		}
	}
	static void tri100(){
		Random rnd=new Random((new Date()).getTime());
		double c;
		int cnt=0;//����� ������������� � ������ ���������
		for(int a=1;a<=100;a++) {
			for(int b=1;b<=100;b++) {
				c=Math.sqrt(a*a+b*b);
				if(c==(int)c && c<100) {System.out.printf("%d, %d, %.0f\n", a,b,c);cnt++;}
				
			}
		}
		System.out.print("cnt="+cnt/2);//3_4_5 � 4_3_5 ���� ����������� � ������ ������ ���������
		//��� ������������ ����� ����, ������ � ����� �� ���
		
	}
}
