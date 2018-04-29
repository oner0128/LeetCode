package medium;

import java.util.*;

/**
 * Created by rrr on 2018/4/24.
 * 71. Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 click to show corner cases.

 Corner Cases:





 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String>strings=new Stack<>();
        Set<String>keyWord=new HashSet<>(Arrays.asList("","..","."));
        for (String dir:path.split("/")){
            if (dir.equals("..")&&!strings.isEmpty())strings.pop();
            else if (!keyWord.contains(dir))strings.push(dir);
        }
        String res="";
        for (String dir :
                strings) {
            res = res +"/" + dir ;
        }
        return res.isEmpty()?"/":res;
    }
    //no set and stack
    public String simplifyPath2(String path) {
        List<String> res = new ArrayList<>();
        String[] names = path.split("/");

        for (String str : names)
            if (str.length() != 0 && !str.equals("."))
                if (str.equals("..")) {
                    if (res.size() > 0)
                        res.remove(res.size() - 1);
                } else
                    res.add(str);

        StringBuilder sb = new StringBuilder();

        for (String str : res)
            sb.append("/").append(str);

        return res.size() == 0 ? "/" : sb.toString();
    }
}
