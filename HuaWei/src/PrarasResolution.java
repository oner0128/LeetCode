import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/20.
 * 在命令行输入如下命令：
 * xcopy /s c:\ d:\，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\
 * 参数4: 字符串d:\
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * 解析规则：
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 */
public class PrarasResolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String cli = input.nextLine();
            List<String> list = new ArrayList<>();
            int i = 0;
            if (cli.indexOf('"') != -1) {
                while (cli.indexOf(' ')>0||cli.indexOf('"') == 0) {
                    if (cli.indexOf('"') == 0) {
                        list.add(cli.substring(1, cli.indexOf('"',1)));
                        if (cli.indexOf('"',1)==cli.length()-1)break;
                        else cli = cli.substring(cli.indexOf('"',1) + 2, cli.length());
                    }
                    else if (cli.indexOf(' ') >0) {
                        list.add(cli.substring(0, cli.indexOf(' ')));
                        cli = cli.substring(cli.indexOf(' ') + 1, cli.length());
                    }
                }
                if (cli.length()!=0)list.add(cli);
            } else for (String s : cli.split(" ")) list.add(s);
            System.out.println(list.size());
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
        }
    }
}
