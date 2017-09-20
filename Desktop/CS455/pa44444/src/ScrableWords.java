import java.util.Arrays;
import java.util.*;
/**
 * Created by weichuanli on 4/6/17.
 */
public class ScrableWords{
    String word;
    public ScrableWords(String word){
        this.word = word;
    }
    public static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String str = new String(chars);
        return str;
    }
    public static String cleanWord(String word) {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            letter = Character.toLowerCase(letter);
            if (letter >= 'a' && letter <= 'z') {
                str = str + letter;
            }
        }
        return str;
    }
    public static int[] multi(String str){
        int[] multi;
        String cleanedAnagram = ScrableWords.cleanWord(str);
        String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);
        String unique = sortedAnagram.charAt(0)+"";

        for(int i = 1; i < sortedAnagram.length(); i++){
            if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                unique = unique + sortedAnagram.charAt(i);
            }
        }
        multi = new int[unique.length()];
        int num = 1;
        int index = 0;
        for(int i = 0; i < sortedAnagram.length()-1; i++){
            if(sortedAnagram.charAt(i) == sortedAnagram.charAt(i+1)){
                num++;
            }else{
                multi[index++] = num;
                num = 1;
            }
        }
        multi[unique.length()-1] = num;
        return multi;
    }

    public static String uniqueString(String str){

        String cleanedAnagram = ScrableWords.cleanWord(str);
        String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);
        String unique = sortedAnagram.charAt(0)+"";

        for(int i = 1; i < sortedAnagram.length(); i++){
            if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                unique = unique + sortedAnagram.charAt(i);
            }
        }
        return unique;

    }



}