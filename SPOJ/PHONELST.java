package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/19/16.
 */
public class PHONELST {

    public static void main(String args[]) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int t;
        t = in.nextInt();
        while (t-- != 0) {

            int n = in.nextInt();
            boolean isConsistent = true;
            Trie trie = new Trie();
            while (n-- != 0) {
                String num = in.readLine();
                 if(!isConsistent(trie,num)){
                   isConsistent = false;
                     break;
                 }
            }

            out.println (isConsistent ? "YES" : "NO");
        }
    }

    static class Trie{

        //char data;
        Trie[] childs;
        boolean isWordEnd;
        boolean visited;

        public Trie() {
            childs = new Trie[10];
            isWordEnd = false;
            visited = false;
        }


    }


    private static boolean isConsistent (Trie n, String s) {
        while (s.length () > 0) {
            if (n.isWordEnd) return false;
            n.visited = true;
            int b = s.charAt (0) - '0';
            if (n.childs [b] == null) n.childs [b] = new Trie();
            n = n.childs [b];
            s = s.substring (1);
        }
        n.isWordEnd = true;
        return !n.visited;
    }
}



    /*
This thing works but TLE :(

    private static boolean isConsistent(Trie trie , String number){

        boolean isConsistent = true;
        char digits[] = number.toCharArray();
        int len = digits.length;
        for(int i=0; i<len;i++)  {

            char digit = digits[i];


            if(trie.childs[digit] == null){
                trie.childs[digit] = new Trie();
                trie.childs[digit].data = digit;
                if(i == len-1){
                    trie.childs[digit].isWordEnd = true;
                }

                trie = trie.childs[digit];
            } else {

                if(trie.childs[digit].data == digit && (trie.childs[digit].isWordEnd || i == len-1)){ //either yours or mine last
                    isConsistent = false;
                    break;
                } else if (trie.childs[digit].data == digit ){ //bad code else not required..
                    trie = trie.childs[digit];

                }


            }
        }

        return isConsistent;
    }
    */





