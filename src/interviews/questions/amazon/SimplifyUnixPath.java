package interviews.questions.amazon;

//Question: Collapse path to filename. Write a function that will take string as input. That string will be a a file
// name (e.g. "/usr/bin”). That path might contain special directories “.” (reference to self) and “..” (reference
// to parent directory). Your function will return the name for the file without using special directories
// (e.g. “/usr/var/../../tmp” should become “/tmp”)
//
// don’t expect candidates to have a solution right off the bat. If the candidate needs to understand the question,
// we will talk about it. Will the path always start with “/“? What should happen for input like “/..”
// For SDE I, the bar is describing a working approach for the common cases. O(n^2) is acceptable, but borders on below the bar.
// SDE II, the bar is implementing a working solution, handling “low-hanging fruit" edge cases correctly
// (null/empty/non-absolute paths, the parent of root, paths that collapse to “/").
// I prefer candidates to use a stack or doubly-linked list, but will accept O(n^2) regex based solutions if the
// candidate can understand/discuss the performance issues. This level raises the bar for SDE I.
// For SDE II, raising the bar is discussing or handling some less common edge cases: What should be the output for
// input like “/usr///bin”? What about escaped ‘/‘ characters? What about configuring behavior?

//Examples:
// "/a/./"   --> means stay at the current directory 'a'
//"/a/b/.." --> means jump to the parent directory
//              from 'b' to 'a'
//"////"    --> consecutive multiple '/' are a  valid
//              path, they are equivalent to single "/".
//
//Input : /home/
//Output : /home
//
//Input : /a/./b/../../c/
//Output : /c
//
//Input : /a/..
//Output:/
//
//Input : /a/../
//Output : /
//
//Input : /../../../../../a
//Output : /a
//
//Input : /a/./b/./c/./d/
//Output : /a/b/c/d
//
//Input : /a/../.././../../.
//Output:/
//
//Input : /a//b//c//////d
//Output : /a/b/c/d


import java.util.Stack;

public class SimplifyUnixPath {

    //Process the string by ignoring the "/" and multiples of "//". Store the non "/" chars in a temporary string 'dir'
    //Store current 'dir' name in a stack, continue processing (ignore) if "." is encountered in 'dir' and pop the stack
    // if ".." is encountered as long as the stack is not empty.
    // Create another stack (reverseStack) to store all the entries in the current stack to print the path in the correct
    //direction.
    //Time Complexity: O(n) - length of the string
    //Space Complexity: O(n) for the stack its O(2n) for the two stacks but remove constant

    // function to simplify a Unix - styled absolute path
    public String simplify(String A)
    {
        // Stack to store the file's names.
        Stack<String> st = new Stack<>();

        // Result string starts from root directory.
        String res = "/";

        // stores length of input String.
        int len_A = A.length();

        for (int i = 0; i < len_A; i++)
        {

            // we will clear the temporary String
            // every time to accommodate new directory
            // name or command.
            // dir will contain "a", "b", "..", ".";
            String dir = "";

            // skip all the multiple '/' Eg. "/////""
            while (i < len_A && A.charAt(i) == '/')
                i++;

            // stores directory's name("a", "b" etc.)
            // or commands("."/"..") into dir
            while (i < len_A && A.charAt(i) != '/')
            {
                dir += A.charAt(i);
                i++;
            }

            // if dir has ".." just pop the topmost
            // element if the Stack is not empty
            // otherwise ignore.
            if (dir.equals(".."))
            {
                if (!st.empty())
                    st.pop();
            }

            // if dir has "." then simply continue
            // with the process.
            else if (dir.equals("."))
                continue;

                // pushes if it encounters directory's
                // name("a", "b").
            else if (dir.length() != 0)
                st.push(dir);
        }

        // a temporary Stack (st1) which will contain
        // the reverse of original Stack(st).
        Stack<String> st1 = new Stack<String>();
        while (!st.empty())
        {

            st1.push(st.pop());
            // st.pop();
        }


        // the st1 will contain the actual res.
        while (!st1.empty())
        {

            // if it's the last element no need
            // to append "/"
            if (st1.size() != 1)
                res += (st1.pop() + "/");
            else
                res += st1.pop();

            // st1.pop();
        }
        return res;
    }

    public static void main(String []args)
    {
        SimplifyUnixPath sup = new SimplifyUnixPath();
        // Filename with unix reduce to be reduced to filename.
        String str = new String("/a/./b/../../c");
        String res = sup.simplify(str);
        System.out.println(res);
        str = "/home/";
        res = sup.simplify(str);
        System.out.println(res);
        str = "/usr/var/../../tmp";
        res = sup.simplify(str);
        System.out.println(res);
        str = "/a/./b/./c/./d/";
        res = sup.simplify(str);
        System.out.println(res);
    }
}
