import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sumit.jha on 5/28/16.
 */

/*
* Given a dictionary of words and the string. break the string into sequence of valid words.
* print all valid combinations of it.
*
* @i/p dict = {ice, cream, sand, and, wich, creams, icecream, sandwich}
*
* and string = icecreamsandwich
*
* @O/p =
* ice cream sand wich
* icecream sandwich
* ice cream sandwich
* ice creams and wich
*
* */

public class WordBreak {


  void wordBreakRecur(HashSet<String> dict, String s, int length, String ans){

    for(int i =1 ;i<=length;i++){
      String prefix = s.substring(0, i);
      if(dict.contains(prefix)){
        if(i == length){
          ans =ans+prefix;
          System.out.println(ans);
          return;
        }

        wordBreakRecur(dict,s.substring(i,length),length-i, ans + prefix + " ");
      }

    }





  }

  public static void main(String args[]){

    HashSet<String> dict = new HashSet<>(Arrays.asList("ice","cream", "sand", "and", "wich", "creams", "icecream", "sandwich", "i"));
    String str = "icecreamsandwich";
    WordBreak wordBreak = new WordBreak();
    System.out.println("Solving Recursively.....\n");
    wordBreak.wordBreakRecur(dict, str,str.length(), "");
  }


}
