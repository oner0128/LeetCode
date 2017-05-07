/**
 * Created by rrr on 2017/5/7.
 */
public class FirstAppearingOnce {
    StringBuilder stringBuilder=new StringBuilder();
    int[]map=new int[256];
    private int firstIndex=0;
    private char firstChar='#';

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        stringBuilder.append(ch);
        map[ch]++;
        if (firstIndex ==(int)ch||firstIndex ==0)firstNotRepeatingChar();
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return firstChar;
    }
    private void firstNotRepeatingChar() {
        if (stringBuilder == null || stringBuilder.toString().length() == 0) {
            firstIndex =0;firstChar='#';return;}
        String str=stringBuilder.toString();
        for (int i = firstIndex; i < str.length(); i++)
            if (map[str.charAt(i)] == 1 )  {firstIndex=i;firstChar=str.charAt(i);return;}
        firstChar='#';
    }
}
