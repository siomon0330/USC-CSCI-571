
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class WordFinder {
    public static void main(String[] args) {
        try{

            System.out.println("Type . to quit.");
            AnagramDictionary anagramDictionary;
            String diction;
            if (args.length > 0) {
                diction = args[0];
              anagramDictionary = new AnagramDictionary(diction);
            } else{
                anagramDictionary = new AnagramDictionary("/Users/weichuanli/Desktop/sowpods.txt");
            }


        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while(true) {

            System.out.print("Rack? ");
            if(input.equals(".")){
                return;
            }

            int[] multi = ScrableWords.multi(input);

            String cleanedAnagram = ScrableWords.cleanWord(input);
            String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);
            String unique = sortedAnagram.charAt(0)+"";

            for(int i = 1; i < sortedAnagram.length(); i++){
                if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                    unique = unique + sortedAnagram.charAt(i);
                }
            }


            Rack rack = new Rack();

            ArrayList<String> res = rack.get(unique, multi, 0);

            ArrayList<String> list = new ArrayList<>();

            for (String str : res) {
                String word = ScrableWords.cleanWord(str);
                word = ScrableWords.sortWord(word);
                if (anagramDictionary.anagramMap.containsKey(word)) {
                    list.addAll(anagramDictionary.anagramMap.get(word));
                }
            }

            HashMap<String, Integer> map = new HashMap<>();
            ScoreTable ab = new ScoreTable();
            for (String str : list) {
                int sum = 0;
                for (int i = 0; i < str.length(); i++) {
                    int score = ab.table[str.charAt(i) - 'a'];
                    sum = sum + score;
                }
                map.put(str, sum);

            }
            Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o2.getValue() == o1.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue() - o1.getValue();
                }
            };
            ArrayList<Map.Entry<String, Integer>> array = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                array.add(entry);

            }
            Collections.sort(array, comparator);
            System.out.println("we can make " + array.size()+" words from " + "\""+sortedAnagram+"\"");
            if(array.size()>0) {
                System.out.println("All of the words with their scores (sorted by score):");
                for (Map.Entry<String, Integer> entry : array) {
                    System.out.println(entry.getValue() + ": " + entry.getKey());
                }
            }
            input = scanner.next();

        }

    }catch (FileNotFoundException exp){

            System.out.print("ddd"+exp.getStackTrace());
        }
    }
}
