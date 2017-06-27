import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rrr on 2017/3/25.
 */
public class Test {
    public static void main(String[] args) {
        try {
            String time = "2016-04-21";
            DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fm.parse(time);
            //Date date2 = new Date(System.currentTimeMillis());
            String str = String.format("%tj",date);//得到time日期是在这年的第几天
            System.out.println(str);
            System.out.println("ABC".indexOf('a'));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
