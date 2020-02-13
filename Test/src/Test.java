import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.util.*;

public class Test {
    public static void main(String[] args){
        String s="    ";
        System.out.printf("calc=%d",calculate(s));

    }
    static int calculate(String mathString) {
        //System.out.println(mathString+"[12]");
        mathString.replace(" ","");//replace space
        if (mathString.equals("") || mathString == null)
            return 0;
        char[] str=mathString.toCharArray();
        int par=0;//count of '('
        int begin=0;//first index of ext '('
        String resault="";
        for(int i=0;i<str.length;i++){
            if(str[i]=='('){
                par++;
                if(par==1){
                    begin=i;
                }
            }else if(str[i]==')'){
                par--;
                if(par==0){
                    resault+=calculate( mathString.substring(begin+1,i));
                    //System.out.println(mathString.substring(begin+1,i));
                }
            }else{
                if(par==0) resault+=str[i];
            }
        }
        resault=resault.replace(" ","");//replace space
        //System.out.println(resault+"[36]");
        String[] res=resault.split("[+/*\\-]");//get numbers as String[]
        if(res==null) return 0;
        if(res.length==1) {
            if(res[0].equals(" ") || res[0].equals("") || res[0]==null) return 0;
            return Integer.parseInt(res[0]);
        }
        int[] intRes=new int[res.length];
        for(int i=0;i<res.length;i++){//get numbers as int[]
            if(res[i].equals("") || res[i].equals(" ")) intRes[i]=0;
            else intRes[i]=Integer.parseInt(res[i]);
        };
        char[] oper=resault.replaceAll("[0-9]","").toCharArray();//get operators
        boolean pmOper=(resault.contains("+") || resault.contains("-"));// +-
        boolean mdOper=(resault.contains("*") || resault.contains("/"));// */

        //System.out.println(Arrays.toString(intRes));
        //System.out.println(Arrays.toString(oper));
        if(pmOper && !mdOper){// only 0-9+-
            //System.out.println(resault+"    +-");
            int sum=intRes[0];
            for(int i=0;i<oper.length;i++)
                if(oper[i]=='+') sum+=intRes[i+1];
                else sum-=intRes[i+1];
            return sum;
        }
        if(!pmOper && mdOper){// only 0-9*/
            //System.out.println(resault+"    */");
            int sum=intRes[0];
            for(int i=0;i<oper.length;i++)
                if(oper[i]=='*') sum*=intRes[i+1];
                else sum/=intRes[i+1];
            return sum;
        }
        //System.out.println(resault+"    +-*/");
        resault="";
        char operPrev='0';
        int first=0;
        if(oper[0]=='+' || oper[0]=='-') {
            resault+=""+intRes[0]+oper[0];
            first=1;
            operPrev=oper[0];
        };
        String muxdef="";
        for(int i=first;i<oper.length;i++){
            if(oper[i]=='*' || oper[i]=='/'){
                //System.out.println(""+intRes[i]+ oper[i]+ intRes[i+1]);
                if(muxdef.equals("")) muxdef+=""+intRes[i]+oper[i]+intRes[i+1];
                else muxdef+=""+oper[i]+intRes[i+1];
                operPrev=oper[i];
                if((i+1 == oper.length) || (oper[i+1]=='-' || oper[i+1]=='+')){
                    resault+=calculate(muxdef);// 8*7 or 7*9/8 pass to calculate
                    //System.out.println(muxdef);
                    if(i+1 < oper.length){// present next in oper[]
                        resault+=oper[i+1];
                        operPrev=oper[i+1];
                        i++;
                    }
                    muxdef="";
                }
            }else{

                resault+=""+intRes[i]+oper[i];
                operPrev=oper[i];
            }
        }//for oper
        if(operPrev=='+' || operPrev=='-') resault+=intRes[intRes.length-1];

        return calculate(resault);
    }

}

