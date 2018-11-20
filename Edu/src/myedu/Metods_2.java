package myedu;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Metods_2 {
	static void nextAlpha() {//������������ ������ ����. �����, ������� ��������� ��� �� ��������.
		//���� ������� ����������, �� ������� �������� � ������ ��������, �� ���� ���� z, �� a b c.
		//����� ������ ��������� ����. ������, ��� ������������ ����� ������ ���������
		Scanner sc=new Scanner(System.in);
		char c;
		System.out.print("Put a_z:");
		c=( ( sc.next() ).toLowerCase() ).charAt(0);
		if(c>='a' && c<='z' ) {
			char next;
			for(int i=1;i<=3;i++) {
				next=(char)(c+i);
				if(next>'z') next=(char)(next-26);
				System.out.print(next);
			}
		}
		
		sc.close();
	}
	static void alphaBet() {//������� ����. ������� �� 5 ���� � ������.
		for(int a='a';a<='z';a++) {
			if((a-2)%5==0) System.out.println();
			System.out.print((char)a);
			
		}
	}
	static void a7x7() {//������� ������� 7 �� 7 �� ��������� ���� �� 'a' �� 'd'.
		Random rnd=new Random((new Date()).getTime());
		for(int i=1;i<=7;i++) {
			for(int j=1;j<=7;j++) {
				System.out.print((char)(rnd.nextInt(26)+'a')+" ");
			}
			System.out.println();
		}
	}
	static void pwGen() {//������������� ������ ��� ������������. ����������: ����� �� 6 �� 20 ��������,
		//������ ���� ����� ���� ������ �������������, ���� �� ��� ��������� �����, �� ����� 5 ����,
		//����� ��� ����� ������ �����������.
		Random rnd=new Random((new Date()).getTime());
		int lenght=rnd.nextInt(15)+6;
		String s=""; 
		char c;
		boolean line=false;
		int big=0;//����� ������� ����
		int num=0;//����� ����
		boolean lastNum=false;//���������� ������-�����
		while(!line || big<2) {
			line=false;
			big=0;
			num=0;
			s="";
		for(int i=1;i<=lenght;i++) {
			c=(char)(rnd.nextInt(93)+33);
			if(c=='_') {
				if(!line) {
					s+=c;
					line=true;
					lastNum=false;
				}else i=i-1;
			}
			else {
				if(c<='Z' && c>='A' && big<2) { s+=c; big++; lastNum=false;}
				else {
					if(c<='9' && c>='0') {
						if(num>=5) {i=i-1;}//������ �������� �������
						 else if(!lastNum) { s+=c; num++;	lastNum=true;}
						  else i=i-1;//������ �������� �������
					}else s+=c;
				}
			}
		}//end for
		}//end while
		System.out.print(s);
	}
	static void f() {//���� ��������
		for(int i=0;i<=200;i++) {
			System.out.printf("%d=%c\n",i,(char)i);
		}
	}
	static void two1() {//������������ ������ �� 0 � 1, � ������� ����� ��� �������, ������� �� ��������� ��������.
		Random rnd=new Random( (new Date()).getTime() );
		int n=10;
		int zero[]=new int[n];
		int n1=0;
		while(n1!=2) {
			n1=0;
			for(int i=0;i<n;i++) {
				zero[i]=rnd.nextInt(2);
				if(zero[i]==1) n1++;
			}
		}
		for(int i:zero) { System.out.print(i+" "); }
		
	}
	static void arr012() {//��������� ������ ��������� ������� ������, ��������� � �������� ���,
		//����� ������ ������ � ������� ����������� ������ ������ �������,
		//���������� ������ ���� � �������� ����� ���������� ���������� ����� � �����.
		Random rnd=new Random( (new Date()).getTime() );
		int n=4,n0=0,n1=0,n2=2;//2 ��� ����� � while
		int a012[]=new int[n];
		int next;
		boolean is1=false,is21=false;;
		while( !is21 /*|| !(n1==n0+n2)*/) {//��������������� �� ��������� �� ������� ������������������
			//��� n1==n0+n2 � 2 ������ 1 �������������!

			n0=n1=n2=0;
			is21=false;
			is1=false;
			for(int i=0;i<n && !is21;i++) {
				next=rnd.nextInt(3);
				if(next==1) { is1=true;n1++;}
				if(next==2 && !is1) {is21=true;}
				if(next==2) n2++; 
				if(next==0) n0++;
				a012[i]=next;
			}
			//for(int i:a012) { System.out.printf(i+" "); }
			//if(n1==n0+n2) System.out.printf("n0=%d, n1=%d, n2=%d", n0,n1,n2);
			//System.out.println();
		}
		for(int i:a012) { System.out.print(i+" "); }
	}
	static void arr37(int n) {//����� ���������� ����� � �������, ������� ������� �� 3, �� �� ������� �� 7.
		Random rnd=new Random((new Date()).getTime());
		int a37[]=new int[n];
		int cnt=0;
		for(int i=0; i<n; i++) {
			a37[i]=rnd.nextInt(100);
			if(a37[i]%3==0 && a37[i]%7!=0) {cnt++;System.out.println(a37[i]);}
		}
		System.out.println("%="+cnt*100/n+"%");
	}
	static void arr1_N() {//����������, ����� ����� � ������� ������: ������� ������� �� ������ ������� �������
		//��� ������� ������� �� ��������� ������� �������.
		Random rnd=new Random((new Date()).getTime());
		int n=50, n1, nN;
		n1=nN=0;
		int a1n[]=new int[n];
		for(int i=0;i<n;i++) {
			a1n[i]=rnd.nextInt(100)+1;
		}
		for(int i=1;i<n-1;i++) {
			if(i%a1n[0]==0) n1++;
			if(i%a1n[n-1]==0) nN++;
		}
		System.out.printf("'1'=%d, 'N'=%d", n1,nN);
	}
	static void arr1xN() {//��� ������ x �� n ���������. ������� x1*xN+x2*xN-1+...+xN*x1
		Random rnd=new Random((new Date()).getTime());
		int n=10;
		int aX[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++) {aX[i]=rnd.nextInt(3)+1; System.out.print(aX[i]+" ");}
		for(int i=0;i<n;i++) sum+=aX[i]*aX[n-1-i];
		System.out.print("\nsum="+sum);
	}
	static void arrM10(){//������� ���������� ��������� �������, ������� ������� �� ����������� �������� �� ����� ��� �� 10%.
		Random rnd=new Random((new Date()).getTime());
		int n=40;
		int a10[]=new int[n];
		int max=0, cnt=0;
		for(int i=0;i<n;i++) {
			a10[i]=rnd.nextInt(100);
			if(a10[i]>max) max=a10[i];
			System.out.print(a10[i]+" ");
		}
		System.out.println("\nmax="+max);
		for(int i:a10) if( (max-i)*10<=max ) {System.out.print(i+" ");cnt++;}
		System.out.println("\ncnt="+cnt);
	}
	static void arrEven3() {//����� ��������� � ��������� �������� ������� ���������� ������� �������,
		//������� ������� �� 3.
		Random rnd=new Random((new Date()).getTime());
		int n=100;
		int ae3[]=new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			ae3[i]=rnd.nextInt(100);
			System.out.print(ae3[i]+" ");
			if(ae3[i]>max && i%2==0 && ae3[i]%3==0) max=ae3[i];
		}
		System.out.println("\nmax="+max);
	}
	static void arr1N() {//���������, �������� �� ������ ������ �� n �����, ��� ����� �� 1 �� n.
		Random rnd=new Random((new Date()).getTime());
		int n=5;
		int nFull[]=new int[n];
		int nAll[]=new int[n];
		int point=-1;//index of last element of nAll[]
		for(int i=0;i<n;i++) {//make arr
			nFull[i]=rnd.nextInt(n);
			System.out.print(nFull[i]+" ");
		}
		boolean fromAll=false;
		for(int i=0;i<n && !fromAll;i++) {
			for(int j=0;j<=point && !fromAll; j++) {
				if(nFull[i]==nAll[j]) fromAll=true;
			}
			if(!fromAll) nAll[++point]=nFull[i];
		}
		if(point==n-1) System.out.print("\nOnly uniq elem!");
		else System.out.print("\nThis is a usual array.");
	}
	static void uniqElems() {//������� ���������� ��������� ��������� ������� �������.
		Random rnd=new Random((new Date()).getTime());
		int n=20;//nums of elems
		int q=20;//elems from 1 to q
		int arr[]=new int[n];
		int uniq[]=new int[n];
		int puniq=-1;//index last uniq elem
		for(int i=0;i<n;i++) {
			arr[i]=rnd.nextInt(q)+1;
			System.out.printf("%2d  ",arr[i]);
		}
		boolean notUniq=true;
		for(int i=0;i<n;i++) {
			notUniq=false;
			for(int j=0;j<=puniq && !notUniq; j++) {
				if(arr[i]==uniq[j]) notUniq=true;
			}
			if(!notUniq) uniq[++puniq]=arr[i];
		}
		System.out.println();
		for(int i=0;i<=puniq;i++) System.out.printf("%2d  ",uniq[i]);
		System.out.println();
		System.out.println("count of uniq elems="+(puniq+1) );
	}
	static void nSign() {//���������� ���������� ������� ������ ��������� �������.
		Random rnd=new Random((new Date()).getTime());
		int n=10;//count of elems
		int q=9;//value of elems from -9 to 8
		int arr[]=new int[n];
		int cnt=0;//change sign
		boolean negative=true;
		arr[0]=rnd.nextInt(q*2)-q;
		negative=arr[0]<0;
		System.out.printf("%4d", arr[0]);
		for(int i=1;i<n;i++) {
			arr[i]=rnd.nextInt(q*2)-q;
			System.out.printf("%4d", arr[i]);
			if( (negative && arr[i]>=0)||(!negative && arr[i]<0) ) cnt++;
			negative=arr[i]<0;
		}
		System.out.printf("\ncount=%d\n",cnt);
	}
	static void mostOften() {//����� �������� ����� ������������� ������� � ������� ����� �����.
		Random rnd=new Random((new Date()).getTime());
		int n=10;//count of elems
		int q=10;//value from 0 to q-1
		int arr[]=new int[n];
		int qarr[]=new int[q];
		for(int i=0;i<n;i++) {//make arr
			arr[i]=rnd.nextInt(q);
			System.out.printf("%2d", arr[i]);
			qarr[arr[i]]++;
		}
		int max=0;//frequency
		int mOf=-1;//The most often elem
		for(int i=0;i<q;i++) {//find most often elem
			if(qarr[i]>max) {
				max=qarr[i];
				mOf=i;
			}
		}
		System.out.printf("\nelem=%d, frequency=%d", mOf, max);
	}
	static void localMax() {//������� �������� ��������� ����������, ���� �� �� ����� �������, �������, ��� �� ���
		Random rnd=new Random((new Date()).getTime());
		int n=10;//count of elems
		int q=10;//value from 0 to q-1
		int arr[]=new int[n];
		for(int i=0;i<n;i++) System.out.printf("%3d", i);
		System.out.println();
		for(int i=0;i<n;i++) {
			arr[i]=rnd.nextInt(q);
			System.out.printf("%3d", arr[i]);
		}
		System.out.println();
		System.out.println("Local MAX: value(:index)");
		for(int i=1;i<n-1;i++) {
			if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) System.out.printf("%3d (:%d)", arr[i], i);
		}
		
	}
	static void twoMin() {//� ������ ������� ������� ��� ���������� ��������.
		Random rnd=new Random((new Date()).getTime());
		int n=10;//count of elems
		int q=10;//value from 0 to q-1
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=rnd.nextInt(q);
			System.out.printf("%3d", arr[i]);
		}
		System.out.println();
		int min=arr[0];
		int max=arr[n-1];
		for(int i=1;i<n;i++) {
			if(arr[i]<min) min=arr[i];
			if(arr[i]>max) max=arr[i];
		}
		int min2=max;
		for(int i=0;i<n;i++) {
			if(arr[i]>min && arr[i]<min2 ) min2=arr[i];
		}
		System.out.printf("min=%d, min2=%d, max=%d", min,min2,max);
		
	}
	static void succession() {//� ������ ������� ������� ���������� ����� ������ ������ ���������,
		//������������� �� �����������.
		Random rnd=new Random((new Date()).getTime());
		int n=20;//count of elems
		int q=100;//value from 0 to q-1
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=rnd.nextInt(q);
			System.out.printf("%3d", arr[i]);
		}
		System.out.println();
		int begin,last,cnt=0,cntMax=0,iMax=0;
		boolean exit=false;
		for(int i=0;i<n;i++) {
			begin=arr[i];
			last=begin;
			cnt=0;
			for(int j=i+1;j<n && !exit;j++) {
				if(last<=arr[j]) {last=arr[j];cnt++;}
				else exit=true;
			}
			exit=false;
			cnt+=1;
			for(int j=i;j<i+cnt;j++) System.out.printf("%3d", arr[j]);
			System.out.print("\tcnt="+cnt);
			if(cntMax<cnt) {cntMax=cnt;iMax=i;}
			System.out.printf(", iMax=%d, cntMax=%d\n", iMax, cntMax);
			i+=cnt-1;//���������� ������������ ������������������
		}
		System.out.println();
		System.out.println("max lenght succession:");
		for(int i=iMax;i<cntMax+iMax;i++) System.out.printf("%3d", arr[i]);
		System.out.printf(", iMax=%d, cntMax=%d\n", iMax, cntMax);
	}
	static void nToArMean(int n) {//� ������� �������� ��� �����, ������� ������� �����,
		//�� ������� �������������� ���� ����� �������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=10;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		double am=0;
		for(int v:arr) am+=v;//sum all elems of arr
		am=am/sz;
		System.out.printf("\n Ariphmethic mean=%.2f, n=%d\n", am, n);
		for(int i=0;i<sz;i++) {//replace and print
			if(arr[i]>n) arr[i]=(int)am;
			System.out.printf("%3d", arr[i]);			
		}
	}
	static void lessLast() {//��� ������. �������� ��� �����, ������� ���������� �������� �������, �� ������ �������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=10;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		System.out.printf("%3d", arr[0]);
		for(int i=1;i<sz-1;i++) {
			if(arr[i]<arr[sz-1]) arr[i]=arr[0];
			System.out.printf("%3d", arr[i]);
		}
		System.out.printf("%3d", arr[sz-1]);
	}
	static void swapMinMax() {//�������� ������� ���������� � ���������� �������� �������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=10;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];
		int xmin=0,xmax=sz-1,buf;//indexes
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
			if(arr[i]<arr[xmin]) xmin=i;
			if(arr[i]>arr[xmax]) xmax=i;
		}
		System.out.printf("\nmin=%d, max=%d\n", arr[xmin], arr[xmax]);
		buf=arr[xmin]; arr[xmin]=arr[xmax]; arr[xmax]=buf;
		for(int v: arr) System.out.printf("%3d", v);
	}
	static void delMore2Time() {//������� � ������� ��� �����, ������� ����������� ����� ���� ���.(����� ������?)
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=2;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr where frequency may be >2
		int qArr[]=new int[q];//������ ��� ������� -���� ������� ��������, � �������� - ������� �� ��������
		int secArr[]=new int[sz];// arr where frequency <=2
		int secPointer=-1;//count of elem arr sec Arr
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		for(int i=0;i<sz;i++) {
			if ( qArr[arr[i]] < 2) {
				qArr[arr[i]]++;
				secArr[++secPointer]=arr[i];
			}
		}
		
		for(int i=0;i<=secPointer; i++) System.out.printf("%3d", secArr[i]);
	}
	static void onlyTime() {//����� � ������� ��� ����� ������ ������ ���������� ��������� �
		//������� �� ��� ��� �������� ����� ������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=2;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr where frequency may be >2
		int secArr[]=new int[sz];// arr where frequency <=2
		int secPointer=-1;//count of elem arr sec Arr
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		System.out.printf("%3d",secArr[++secPointer]=arr[0]);
		for(int i=1;i<sz;i++) {
			if( arr[i]!=arr[i-1] ) System.out.printf("%3d",secArr[++secPointer]=arr[i]);
			else System.out.print("   ");
		}
		
	}
	static void inReverseOrder() {//����������� �������� ������� � �������� �������.
		Random rnd=new Random((new Date()).getTime());
		int sz=11,q=5;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr where frequency may be >2
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		int buf;
		for(int i=0;i<sz/2;i++) {
			buf=arr[i];	arr[i]=arr[sz-1-i]; arr[sz-1-i]=buf;
		}
		for(int i=0; i<sz; i++) System.out.printf("%3d", arr[i]);
	}
	static void zeroToThree() {//� ������� ����� ��� ������� �������� � �������� �� ������ � ��������� ���������� �� 3.
		Random rnd=new Random((new Date()).getTime());
		int sz=11,q=2;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr where frequency may be >2
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		for(int i=0;i<sz;i++) {
			if(arr[i]==0) {
				if( (i-1)>=0 ) arr[i-1]=3;//previous elem
				arr[i]=3;//current elem
				if( (i+1)<sz && arr[i+1]!=0) arr[i+1]=3;//next elem
			}
		}
		for(int v: arr) System.out.printf("%3d", v);
	}
	static void oneAtfirst() {//������������� ������ ����� �������, ����� ������� ������������� ��� ��������,
		//������ ������� �� ��������� �������, � ����� � ��� ���������.
		Random rnd=new Random((new Date()).getTime());
		int sz=11,q=5;//sz-size, q - value from -q to q-1 inclusive
		int arr[]=new int[sz];//main arr
		int helpArr[]=new int[sz];//help (or buf) arr
		int home=-1, end=sz;
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%4d", arr[i]=rnd.nextInt(q*2)-q);
		}
		System.out.println();
		for(int i=0;i<sz;i++) {
			if( arr[i]<-1 || arr[i]>1 ) helpArr[--end]=arr[i];//write to end
			else helpArr[++home]=arr[i];//write to home
		}
		arr=helpArr;
		for(int v: arr) System.out.printf("%4d", v);
	}
	static void twoToOne() {//���� ��� �������. ������������ ������ ������, ��������� �� ��� ���������, �������:
		//�) ������������ � ����� ��������; �) ������������ ������ � ����� �� ��������.
		Random rnd=new Random((new Date()).getTime());
		int sz1=5, sz2=3, q=3;//sz-size, q - value from 0 to q-1 inclusive
		int arr1[]=new int[sz1];
		int arr2[]=new int[sz2];
		int max= sz1>sz2 ? sz1 : sz2;
		
		int a[]=new int[max];
		int b[]=new int[max*2];
		int aPointer=-1, bPointer=-1;
		
		for(int i=0;i<sz1;i++) {//make arr
			System.out.printf("%4d", arr1[i]=rnd.nextInt(q) );
		}
		System.out.println("\n-----------------------------------------");
		for(int i=0;i<sz2;i++) {//make arr
			System.out.printf("%4d", arr2[i]=rnd.nextInt(q) );
		}
		System.out.println("\n-----------------------------------------");
		//elems which execute in arr1 and arr2
		boolean inSecond=false;
		for(int i=0;i<sz1;i++) {
			inSecond=false;
			for(int j=0;j<sz2 && !inSecond;j++) {
				if(arr1[i]==arr2[j]) {
					a[++aPointer]=arr1[i];
					inSecond=true;
				}
			}
			if(!inSecond) b[++bPointer]=arr1[i];
		}
		System.out.print("Common: "); 
		if(aPointer>=0) for(int i=0;i<=aPointer;i++) System.out.printf("%4d", a[i]);
		else System.out.print("Not common elems");
		System.out.println();
		System.out.print("Only in first: "); 
		if(bPointer>=0) for(int i=0;i<=bPointer;i++) System.out.printf("%4d", b[i]);
		else System.out.print("Only common elems");
		System.out.println();
		
	}
	static void shift() {//��� ������. ����������� ����������� ����� ������ �� k ������
		//������, ���� ������ ���������� ������� ������� ���������� ������ ���������� ����������� �������� �������, 
		//� �����, ���� �����
		int k=2;//shift value
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=10;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr
		int bufArr[]=new int[sz];
		int min=q, max=-1;
		int iMin=0, iMax=sz-1;
		for(int i=0;i<sz;i++) System.out.printf("%3d", i);
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(int i=0;i<sz;i++) {//make arr
			System.out.printf("%3d", arr[i]=rnd.nextInt(q));
		}
		System.out.println();
		for(int i=0;i<sz;i++) {
			if(arr[i]<arr[iMin]) iMin=i;
			if(arr[sz-1-i]>arr[iMax]) iMax=sz-1-i;
		}
		System.out.printf("min=%d, iMin=%d, max=%d, iMax=%d", arr[iMin], iMin, arr[iMax], iMax);
		if(iMin<iMax) {
			System.out.printf("  >> %d >>\n",k);
			for(int i=0;i<sz;i++) {
				if(i+k<sz) bufArr[i+k]=arr[i];
				else bufArr[i-sz+k]=arr[i];
			}
		}
		else {
			System.out.printf("  << %d <<\n",k);
			for(int i=0;i<sz;i++) {
				if(i-k>=0) bufArr[i-k]=arr[i];
				else bufArr[i+sz-k]=arr[i];
			}
		}
		for(int v: bufArr) System.out.printf("%3d", v);	
		
		
	}
	static void sum2is3() {//���� ��� �������. ����������, ���������� �� � ������ ������� ����� ��� ��������,
		//��� �� ����� ����� ����� �����-���� ���� ��������� ������� �������.
		Random rnd=new Random((new Date()).getTime());
		int s2=5,s3=10;//size of arreys
		int q=10;//value from 0 to q-1
		int arr2[]=new int[s2];
		int arr3[]=new int[s3];
		for(int i=0;i<s2;i++) System.out.printf("%3d", arr2[i]=rnd.nextInt(q));
		System.out.println();
		for(int i=0;i<s3;i++) System.out.printf("%3d", arr3[i]=rnd.nextInt(q));
		System.out.println();
		System.out.println("------------------------------------------------");
		boolean exist=false;
		boolean exist2=false;
		for(int i=0;i<s2 && !exist;i++) {
			for(int j=i+1;j<s2 && !exist;j++) {
				for(int ii=0;ii<s3 && !exist;ii++) {
					for(int jj=ii+1;jj<s3 && !exist;jj++) {
						for(int k=jj+1;k<s3 && !exist;k++) {
							exist2= ( arr2[i]+arr2[j] == arr3[ii]+arr3[jj]+arr3[k] );
							if(exist2) System.out.printf(" %d + %d = %d + %d + %d\n",
									arr2[i], arr2[j], arr3[ii], arr3[jj], arr3[k] );
						}
					}
				}
			}
		}
	}
	static void posNeg() {//��� ������, � ������� ���������� ������������� ��������� ����� ���������� �������������.
		//��������� ������� ������ ������������� � ������ �������������, ������ ������������� � ������ ������������� ���.
		Random rnd=new Random( (new Date()).getTime() );
		int sz=10;//num of elements
		int q=9;//-9 to 8
		int pos=0,neg=1;
		int arr[]=new int[sz];
		int helpArr[]=new int[sz];
		while(!(pos==neg && pos>=2)) {
			pos=neg=0;
			for(int i=0;i<sz;i++) {
				arr[i]=rnd.nextInt(2*q)-q;
				if(arr[i]>0) pos++;
				if(arr[i]<0) neg++;
			}
		}
		for(int v: arr) System.out.printf("%4d", v);
		System.out.println();
		int lastPos=-1, lastNeg=-1;
		boolean pF=true, nF=true;
		while( pF && nF) {//�� ����� ����������� ���� ��� (��� ���) ���� �� ����� ������� � ���� while
			pF=false;
			for(int i=lastPos+1;i<sz && !pF; i++)//beg from next elem
				if(arr[i]>0) {
					lastPos=i;
					pF=true;
				}
			nF=false;
			for(int i=lastNeg+1;i<sz && !nF; i++)//beg from next elem
				if(arr[i]<0) {
					lastNeg=i;
					nF=true;
				}
			helpArr[lastPos]=arr[lastNeg];
			helpArr[lastNeg]=arr[lastPos];
		}
		arr=helpArr;
		for(int v: arr) 
			if(v==0) System.out.print("    ");
			else System.out.printf("%4d", v);
		
	}
	static void pldrm() {//������� � ������������� ������� ��� ������������� �����, ������� �������� ������������.
		//����� ������������� ����� ������������� ����� ���� int
		Random rnd=new Random((new Date()).getTime());
		int poli;
		int q=2_000_000_000;//������, ����� ����� ������� max ��� int �����, min is 12
		int dig[]=new int[10];
		int digPointer=10;
		boolean polidrom=false;
		while(!polidrom) {//������ ������ ��������� ����� ����� ������������ ������� � ���������� �������� ��� ���������� �������
			poli=Math.abs(rnd.nextInt(q));//���������� ��� ����� ������������� ����� ������
			//get digital ����� ������ ������� ��������� �� �������
			dig[9]=poli/1_000_000_000;
			int d=10;
			for(int i=1;i<9;i++) { dig[i]=poli/d%10; d*=10;}
			dig[0]=poli%10;
			//get length ���������� �������� ����� (����������� �������� ����)
			for(int i=9;i>=0 && dig[i]==0;i--) digPointer=i; 
			//���������� �������� ����� 
			polidrom=true;
			for(int i=0;i<digPointer/2;i++) if(dig[i]!=dig[digPointer-1-i]) polidrom=false;
			//���� ���� �� ���� ���� ���� �� ��������� ��������� � ���������� �����(�������� �������, ��������)
			//��� ��� � ������ ������� ������ ���������� ��������� �����, ���� �� ����������� ��������
			//System.out.println(poli);
			
		}
		//System.out.println(digPointer);
		for(int i=digPointer-1; i>=0; i--) System.out.printf("%d", dig[i]);
		//���� � ������� ����������� ��������, �� ������ �������� ��� ��� �� �������� �� ��������������� ������
		
	}
	static void negZeroPos() {//��� ������. ������������ ����� ������, � ������� ���� ������� ������������� ��������,
		//����� ����, ����� �������������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10;
		int q=9;//from -9 to 8
		int arr[]=new int[sz];
		int newArr[]=new int[sz];
		for(int i=0;i<sz;i++) System.out.printf("%4d",arr[i]=rnd.nextInt(2*q)-q);
		System.out.println();
		int homePointer=-1;
		int endPointer=sz;
		for(int i=0;i<sz;i++) {
			if(arr[i]<0) newArr[++homePointer]=arr[i];
			if(arr[i]>0) newArr[--endPointer]=arr[i];
			
		}
		for(int v: newArr) System.out.printf("%4d", v);
	}
	static void series() {//���� ��� �������. ���������� ��� ����� ������ ������ ��������� �� ������� �������
		//(����� ����� �������� � �� ������ ��������), ������ �� ������� ��������� � �����-������ ������
		//������ ������ ��������� ������� �������.
		Random rnd=new Random((new Date()).getTime());
		int sz1=4, sz2=6;
		int q=10;//from 0 to q-1
		int arr1[]=new int[sz1];
		int arr2[]=new int[sz2];
		for(int i=0;i<10;i++) System.out.printf("%4d", i);
		System.out.println();
		System.out.println("----------------------------------------");
		for(int i=0;i<sz1;i++) System.out.printf("%4d", arr1[i]=rnd.nextInt(q) );
		System.out.println();
		for(int i=0;i<sz2;i++) System.out.printf("%4d", arr2[i]=rnd.nextInt(q) );
		System.out.println();
		boolean serial=false;//������� ���� �� ������ ����������
		int pointer2=-1;
		String s;
		for(int i=0; i<sz1; i++) {//���������� �������� ������� �������
			//����� ������� � ������� i, ���� ��� ������� ���� ���������� � ���������� ������� �������
			for(int j=0;j<sz2; j++) {
				if(arr1[i]==arr2[j]) {//���� ���� ����������
					System.out.printf("%2d(%2d,%2d)", arr1[i], i, j);//������� ������� �� �����
					
					for(int k=1;k<sz1;k++) {//������� ���������� ����������� �������� ����� �������� �������� �� �������
						if( (i+k<sz1) && (j+k<sz2) && (arr1[i+k]==arr2[j+k]) )
							System.out.printf("%2d(%2d,%2d)", arr1[i+k], i+k, j+k);//������� ������� �� �����
						else {k=sz1;System.out.println();}//���� ��� ���������� ��� ����� ������� ������� �� ��������� ������
					}//����� ��������� ������
					
				}
				//���� ��� ���������� ��� ���� ����������, ������ ���� ������ �� ����� ������� �������,
				//����� ���� ������ ���������� � ������ ��� ����� ������� ����������
			}//����� ������� �������, ���� ��� ��� ���������� �������� � ���� ���� ������� ������� 
			
		}
	}
	static void arrToRnd() {//��� ������ �� n ���������. ����������� ��� �������� ��������� �������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10;
		int q=100;//0 to q-1
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) System.out.printf( "%4d", arr[i]=rnd.nextInt(q) );
		System.out.println();
		boolean barr[]=new boolean[sz];//����� ������������� �������, true - ������ ������
		int helpArr[]=new int[sz];//�� ��������� ����� ��������� �������� ������� arr
		int index=-1;
		boolean put=false;//true ���� ������� ������� � ������ ������� ������ �������
		for(int v: arr) {//���������� �������� ��������� �������
			put=false;
			while(!put) {
				index=rnd.nextInt(sz);
				if(!barr[index]) {//����� ������ ������ ������
					helpArr[index]=v;//��������� �����
					barr[index]=true;//��������� ��� ������ ������
					put=true;//��� ������ �� ����� ��������� ��������
				}
			}//��������� � ���������� ��������
		}
		arr=helpArr;//�������� �������� ������ � ��������������� �����������
		for(int v: arr) System.out.printf("%4d", v);
		
		
	}
	static void noHelpArr() {//� ������ ������� ������ ������� ����� 0, 1  ��� 2. ����������� �������� ������� ���, �����
		//������� ������������� ��� ����, ����� ��� ������� �, �������, ��� ������. �������������� ������ �� ������������.
		Random rnd=new Random((new Date()).getTime());
		int sz=10;
		int q=3;//0 to q-1
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) System.out.printf( "%4d", arr[i]=rnd.nextInt(q) );
		System.out.println();
		//�� ����� �������, ��������� 0, 1, 2 ��� ������ ��������� �������� �� �����������
		int buf;
		for(int i=0;i<sz;i++) {
			for(int j=i+1;j<sz;j++) {
				if( arr[i] > arr[j] ) {
					buf=arr[i];
					arr[i]=arr[j];
					arr[j]=buf;
				}
			}
		}
		for(int v: arr) System.out.printf("%4d", v);
		
		
	}
	static void minToMax3() {//���� ��� ������������� �� ����������� �������. 
		//���������� �� ���� ���� �������� ������ ������������� �� ����������� ������.
		
	}
}




