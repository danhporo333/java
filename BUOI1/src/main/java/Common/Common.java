/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

/**
 *
 * @author ADMIN
 */
public class Common {
    public static String phepToan(int a, int b, char sign){
        if(sign =='+'){
            return ""+(a+b);
        } else if (sign=='-'){
            return ""+(a-b);
        } else if(sign == '*'){
            return ""+(a*b);
        } else if(sign=='/'){
            return ""+(float)a/b;
        } else if (sign == '%'){
            return ""+(int)a/b;
        } else {
            return ""+(a%b);
        }
        
    }
    public static String PTB1 (float a, float b) {
        if (a==0){
            if (b==0)
                return "PTVSN";
            else
                return "PTVN";
        }else {
            float x=-b/a;
            return ""+x;
        }
    }

    //Giải phương trình bậc 2
    public static String PTB2(float a,float b,float c) {
        if (a==0){
            return PTB1(b,c);
        }else{
            float d=b*b-4*a*c;
            if(d<0){
                return "PTVN";
            }else if(d==0){
                return "x1=x2"+(-b/a);
            }else{ //d>0
                float x1=(float)(-b+ Math.sqrt(d))/(2*a);
                float x2=(float)(-b- Math.sqrt(d))/(2*a);
                return "x1="+x1+",x2="+x2;
            }
        }
    }
    
    public static String xn(float x,int n){
        float p = 1;
        for(int i = 1;i<=n;i++){
            p=p*x;
        }
        return ""+p;
    }
}
