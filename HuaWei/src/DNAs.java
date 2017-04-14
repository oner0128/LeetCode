import java.util.Scanner;

/**
 * Created by rrr on 2017/4/11.
 */
public class DNAs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] DNA = scanner.nextLine().split(" ");
            String firstDNA = DNA[0];
            String secondDNA = DNA[1];
            System.out.println(calculate(firstDNA, secondDNA));
        }
    }

    private static int calculate(String firstDNA, String secondDNA) {
        char[]one=firstDNA.toCharArray();
        char[]two=secondDNA.toCharArray();
        int count=0;
        for (int i = 0; i < one.length; i++) {
            if (one[i]=='A'&&two[i]=='T'||one[i]=='T'&&two[i]=='A'||one[i]=='C'&&two[i]=='G'||one[i]=='G'&&two[i]=='C')count++;
        }
        return one.length-count;
    }
}


