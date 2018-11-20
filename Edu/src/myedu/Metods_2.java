package myedu;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Metods_2 {
	static void nextAlpha() {//Пользователь вводит англ. букву, вывести следующие три по алфавиту.
		//Если алфавит закончился, то вывести циклично с начала алфавита, то есть если z, то a b c.
		//Вывод только маленьких букв. Учесть, что пользователь может ввести заглавную
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
	static void alphaBet() {//Вывести англ. алфавит по 5 букв в строке.
		for(int a='a';a<='z';a++) {
			if((a-2)%5==0) System.out.println();
			System.out.print((char)a);
			
		}
	}
	static void a7x7() {//Вывести квадрат 7 на 7 из случайных букв от 'a' до 'd'.
		Random rnd=new Random((new Date()).getTime());
		for(int i=1;i<=7;i++) {
			for(int j=1;j<=7;j++) {
				System.out.print((char)(rnd.nextInt(26)+'a')+" ");
			}
			System.out.println();
		}
	}
	static void pwGen() {//Сгенерировать пароль для пользователя. Требования: длина от 6 до 20 символов,
		//должен быть ровно один символ подчеркивания, хотя бы две заглавных буквы, не более 5 цифр,
		//любые две цифры подряд недопустимы.
		Random rnd=new Random((new Date()).getTime());
		int lenght=rnd.nextInt(15)+6;
		String s=""; 
		char c;
		boolean line=false;
		int big=0;//число больших букв
		int num=0;//число цифр
		boolean lastNum=false;//предыдущий символ-цифра
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
						if(num>=5) {i=i-1;}//запуск итерации сначала
						 else if(!lastNum) { s+=c; num++;	lastNum=true;}
						  else i=i-1;//запуск итерации сначала
					}else s+=c;
				}
			}
		}//end for
		}//end while
		System.out.print(s);
	}
	static void f() {//коды символов
		for(int i=0;i<=200;i++) {
			System.out.printf("%d=%c\n",i,(char)i);
		}
	}
	static void two1() {//Сформировать массив из 0 и 1, в которых ровно две единицы, стоящие на случайных позициях.
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
	static void arr012() {//Заполните массив случайным образом нулями, единицами и двойками так,
		//чтобы первая двойка в массиве встречалась раньше первой единицы,
		//количество единиц было в точности равно суммарному количеству нулей и двоек.
		Random rnd=new Random( (new Date()).getTime() );
		int n=4,n0=0,n1=0,n2=2;//2 для входа в while
		int a012[]=new int[n];
		int next;
		boolean is1=false,is21=false;;
		while( !is21 /*|| !(n1==n0+n2)*/) {//закоментировано тк генератор не создает последовательности
			//где n1==n0+n2 и 2 прежде 1 одновременнно!

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
	static void arr37(int n) {//Найти количество чисел в массиве, которые делятся на 3, но не делятся на 7.
		Random rnd=new Random((new Date()).getTime());
		int a37[]=new int[n];
		int cnt=0;
		for(int i=0; i<n; i++) {
			a37[i]=rnd.nextInt(100);
			if(a37[i]%3==0 && a37[i]%7!=0) {cnt++;System.out.println(a37[i]);}
		}
		System.out.println("%="+cnt*100/n+"%");
	}
	static void arr1_N() {//Определите, каких чисел в массиве больше: которые делятся на первый элемент массива
		//или которые делятся на последний элемент массива.
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
	static void arr1xN() {//Дан массив x из n элементов. Найдите x1*xN+x2*xN-1+...+xN*x1
		Random rnd=new Random((new Date()).getTime());
		int n=10;
		int aX[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++) {aX[i]=rnd.nextInt(3)+1; System.out.print(aX[i]+" ");}
		for(int i=0;i<n;i++) sum+=aX[i]*aX[n-1-i];
		System.out.print("\nsum="+sum);
	}
	static void arrM10(){//Найдите количество элементов массива, которые отличны от наибольшего элемента не более чем на 10%.
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
	static void arrEven3() {//Среди элементов с нечетными номерами найдите наибольший элемент массива,
		//который делится на 3.
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
	static void arr1N() {//Проверьте, содержит ли данный массив из n чисел, все числа от 1 до n.
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
	static void uniqElems() {//Найдите количество различных элементов данного массива.
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
	static void nSign() {//Определите количество перемен знаков элементов массива.
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
	static void mostOften() {//Найти наиболее часто встречающийся элемент в массиве целых чисел.
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
	static void localMax() {//элемент является локальным максимумом, если он не имеет соседей, больших, чем он сам
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
	static void twoMin() {//В данном массиве найдите два наименьших элемента.
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
	static void succession() {//В данном массиве найдите наибольшую серию подряд идущих элементов,
		//расположенных по возрастанию.
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
			i+=cnt-1;//пропускаем возрастающую последовательность
		}
		System.out.println();
		System.out.println("max lenght succession:");
		for(int i=iMax;i<cntMax+iMax;i++) System.out.printf("%3d", arr[i]);
		System.out.printf(", iMax=%d, cntMax=%d\n", iMax, cntMax);
	}
	static void nToArMean(int n) {//В массиве заменить все числа, большие данного числа,
		//на среднее арифметическое всех чисел массива.
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
	static void lessLast() {//Дан массив. Заменить все числа, меньшие последнего элемента массива, на первый элемент.
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
	static void swapMinMax() {//Поменять местами наибольший и наименьший элементы массива.
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
	static void delMore2Time() {//Удалить в массиве все числа, которые повторяются более двух раз.(новый массив?)
		Random rnd=new Random((new Date()).getTime());
		int sz=10,q=2;//sz-size, q - value from 0 to q-1 inclusive
		int arr[]=new int[sz];//main arr where frequency may be >2
		int qArr[]=new int[q];//массив где индексы -знач первого масисива, а значения - частота их пояления
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
	static void onlyTime() {//Найти в массиве все серии подряд идущих одинаковых элементов и
		//удалить из них все элементы кроме одного.
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
	static void inReverseOrder() {//Переставить элементы массива в обратном порядке.
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
	static void zeroToThree() {//В массиве найти все нулевые элементы и заменить их вместе с соседними элементами на 3.
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
	static void oneAtfirst() {//Преобразовать массив таким образом, чтобы сначала располагались все элементы,
		//модуль которых не превышает единицу, а потом – все остальные.
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
	static void twoToOne() {//Даны два массива. Сформировать третий массив, состоящий из тех элементов, которые:
		//а) присутствуют в обоих массивах; б) присутствуют только в одном из массивов.
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
	static void shift() {//Дан массив. Осуществите циклический сдвиг массив на k единиц
		//вправо, если первый наименьший элемент массива расположен раньше последнего наибольшего элемента массива, 
		//и влево, если иначе
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
	static void sum2is3() {//Даны два массива. Определите, существуют ли в первом массиве такие два элемента,
		//что их сумма равна сумме каких-либо трех элементов второго массива.
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
	static void posNeg() {//Дан массив, в котором количество отрицательных элементов равно количеству положительным.
		//Поменяйте местами первый отрицательный и первый положительный, второй отрицательный и второй положительный итд.
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
		while( pF && nF) {//не будет выполняться если пол (или отр) элем не будет найдено в теле while
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
	static void pldrm() {//Удалите в целочисленном массиве все положительные числа, которые являются палиндромами.
		//будем рассматривать любые положительные числа типа int
		Random rnd=new Random((new Date()).getTime());
		int poli;
		int q=2_000_000_000;//предел, здесь можно указать max для int число, min is 12
		int dig[]=new int[10];
		int digPointer=10;
		boolean polidrom=false;
		while(!polidrom) {//вместо поиска полидрома здесь можно организовать переход с следующему элементу уже созданного массива
			poli=Math.abs(rnd.nextInt(q));//собственно так можно сгененировать целый массив
			//get digital потом каждый элемент разложить на разряды
			dig[9]=poli/1_000_000_000;
			int d=10;
			for(int i=1;i<9;i++) { dig[i]=poli/d%10; d*=10;}
			dig[0]=poli%10;
			//get length определяем реальную длину (отбрасываем передние нули)
			for(int i=9;i>=0 && dig[i]==0;i--) digPointer=i; 
			//сравниваем значимые цифры 
			polidrom=true;
			for(int i=0;i<digPointer/2;i++) if(dig[i]!=dig[digPointer-1-i]) polidrom=false;
			//если хотя бы одна пара цифр не совпадает переходим с следующему числу(элементу массива, например)
			//или как в данном случаем просто гененируем следующее число, пока не встретиться полидром
			//System.out.println(poli);
			
		}
		//System.out.println(digPointer);
		for(int i=digPointer-1; i>=0; i--) System.out.printf("%d", dig[i]);
		//если в массиве встретиться полидром, мы просто зануляем его или не копируем во вспомогательный массив
		
	}
	static void negZeroPos() {//Дан массив. Сформировать новый массив, в котором идут сначала отрицательные элементы,
		//затем нули, затем положительные.
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
	static void series() {//Даны два массива. Определите все серии подряд идущих элементов из первого массива
		//(серия может состоять и из одного элемента), каждая из которых совпадает с какой-нибудь серией
		//подряд идущих элементов второго массива.
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
		boolean serial=false;//условие хотя бы одного совпадения
		int pointer2=-1;
		String s;
		for(int i=0; i<sz1; i++) {//перебираем элементы первого массива
			//берем элемент с номером i, ищем как минимум одно совпадении с элементами второго массива
			for(int j=0;j<sz2; j++) {
				if(arr1[i]==arr2[j]) {//если есть совпадение
					System.out.printf("%2d(%2d,%2d)", arr1[i], i, j);//выводим элемент на экран
					
					for(int k=1;k<sz1;k++) {//попарно сравниваем последующие элементы обоих массивов учитывая их границы
						if( (i+k<sz1) && (j+k<sz2) && (arr1[i+k]==arr2[j+k]) )
							System.out.printf("%2d(%2d,%2d)", arr1[i+k], i+k, j+k);//выводим элемент на экран
						else {k=sz1;System.out.println();}//если нет совпадения или конец массива выходим из попарного поиска
					}//конец попарного поиска
					
				}
				//если нет совпадения или одно обработали, просто ищем дальше до конца второго массива,
				//может быть второе совпадение и второй раз будем попарно сравнивать
			}//конец второго массива, были или нет совпадения переходи к след элем первого массива 
			
		}
	}
	static void arrToRnd() {//Дан массив из n элементов. Переставьте его элементы случайным образом.
		Random rnd=new Random((new Date()).getTime());
		int sz=10;
		int q=100;//0 to q-1
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) System.out.printf( "%4d", arr[i]=rnd.nextInt(q) );
		System.out.println();
		boolean barr[]=new boolean[sz];//флаги заполняемости массива, true - ячейка занята
		int helpArr[]=new int[sz];//на случайные места ставяться элементы массива arr
		int index=-1;
		boolean put=false;//true если элемент втавлен в пустую ячейкку нового массива
		for(int v: arr) {//перебираем элементы основного массива
			put=false;
			while(!put) {
				index=rnd.nextInt(sz);
				if(!barr[index]) {//когда найдем пустую ячейку
					helpArr[index]=v;//заполняем ячеку
					barr[index]=true;//указываем что ячейка занята
					put=true;//для выхода из цикла генерации индексов
				}
			}//переходим к следующему элементу
		}
		arr=helpArr;//получаем исходный массив с переставленными элемментами
		for(int v: arr) System.out.printf("%4d", v);
		
		
	}
	static void noHelpArr() {//В данном массиве каждый элемент равен 0, 1  или 2. Переставить элементы массива так, чтобы
		//сначала располагались все нули, затем все единицы и, наконец, все двойки. Дополнительный массив не использовать.
		Random rnd=new Random((new Date()).getTime());
		int sz=10;
		int q=3;//0 to q-1
		int arr[]=new int[sz];
		for(int i=0;i<sz;i++) System.out.printf( "%4d", arr[i]=rnd.nextInt(q) );
		System.out.println();
		//не будем мудрить, поставить 0, 1, 2 это значит выставить элементы по возрастанию
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
	static void minToMax3() {//Даны два упорядоченных по возрастанию массива. 
		//Образовать из этих двух массивов единый упорядоченный по возрастанию массив.
		
	}
}




