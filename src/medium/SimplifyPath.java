package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
            res = "/" + dir + res;
        }
        return res.isEmpty()?"/":res;
    }
}
