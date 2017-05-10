import java.util.Stack;

/**
 * Created by rrr on 2017/5/10.
 */
public class IsNumeric {
    //牛客网解法
    public boolean isNumeric(char[] str) {
        if (str==null||str.length==0)return false;
        int eTime=0,pointTime=0;
        int index=0;
        if (str[index]=='+'||str[index]=='-')index++;
        boolean preIsE=false;
        while (index<str.length){
            if (str[index]=='.'){
                pointTime++;
                if (pointTime>1)return false;
            }else if (str[index]=='E'||str[index]=='e'){
                eTime++;preIsE=true;
                pointTime++;//指数不能为小数
                if (eTime>1||index>=str.length-1)return false;
            }else if (str[index]=='+'||str[index]=='-'){
                if (preIsE)preIsE=false;
                else return false;
            }else if (str[index]>'9'||str[index]<'0')return false;
            index++;
        }
        return true;
    }
}
