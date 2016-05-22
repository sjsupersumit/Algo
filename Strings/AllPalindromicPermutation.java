import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumit.jha on 5/22/16.
 */
/*
* Prints all the palindromic permutation of the string
*
* The idea is really simple, first we check whether  we can rearrange this string as palindrome (for string to be
* palindrome it should have exactly 1 or 0 char of odd occurence.
*
* after this just permute of half and add the reverse of it , if there is odd frequency cahr just put it in middle
* */
public class AllPalindromicPermutation {

  Map<Character,Integer> freqMap = new HashMap<>();

  char[] swap(char[] str, int i, int j){
    char  t =  str[i];
    str[i] = str[j];
    str[j] = t;

    return str;
  }

  void printPalindromicPermutationUtil(char[] str,Character middleChar , int start, int end){

    if(str == null  || start > end )
      return;

    if(start == end){
      StringBuilder temp = new StringBuilder(new String(str));
      StringBuilder res = new StringBuilder(temp);
      if(middleChar!=null){
        res.append(middleChar);
      }
      res.append(temp.reverse());
      System.out.println(res);
    } else {

      for(int i=start; i <= end; i++){

        str = swap(str, start, i);
        printPalindromicPermutationUtil(str,middleChar,start+1,end);
        str = swap(str,start,i);

      }


    }

  }

  boolean canBeMadePalindrome(String str){

    if(str == null)
       return false;

    for(Character c : str.toCharArray()){
      if(freqMap.containsKey(c)){
        freqMap.put(c ,freqMap.get(c)+1);
      } else {
        freqMap.put(c,1);
      }

    }

    int oddCount = 0;
    for(Character c: freqMap.keySet() ){
      int freq = freqMap.get(c);
      if (freq%2!=0){
        oddCount++;

      }
    }

    return (oddCount<=1);
  }









  public static void main(String args[]){

    String s = "aabbcadad";

    AllPalindromicPermutation allPalindromicPermutation = new AllPalindromicPermutation();
    if(allPalindromicPermutation.canBeMadePalindrome(s)){

      Character middleChar = null;
      int index=0;
      char[] charArray = new char[s.length()/2];
      for(Character c: allPalindromicPermutation.freqMap.keySet()){

        int fre = allPalindromicPermutation.freqMap.get(c);
        if(fre%2!=0){
          middleChar = c;

        } else {
          for(int i=0; i<fre/2;i++)
          charArray[index++] = c;
        }
      }


      System.out.println("All Palindromic Permutations Are:-");

      //if the orignal String is palin print then permute
      if(s.equals(new StringBuilder(s).reverse().toString()))
        System.out.println(s);

      allPalindromicPermutation.printPalindromicPermutationUtil(charArray,middleChar ,0,charArray.length-1);


    }
    else {
      System.out.println("There are no Palindromic permutation for this String");
    }

  }
}
