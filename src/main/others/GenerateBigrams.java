package main.others;

import java.util.*;

class GenerateBigrams {
    TreeSet<String> bigrams = new TreeSet<>() ;
    public List<String> GenerateBigrams(String sentence, List<String> synonyms) {
        // Write your code here

       String[] words = sentence.split(" ");
       List<String> wordList = Arrays.asList(words);
       createBigrams(wordList);
       for(String synonym : synonyms){
           String[] pair = synonym.split(",");
           handleSynonym(pair[0], pair[1], wordList, sentence);
           handleSynonym(pair[1], pair[0], wordList, sentence);
       }
       return  new ArrayList<String>(bigrams);

    }

    public void handleSynonym(String source, String target, List<String> wordList, String sentence){
        if(sentence.indexOf(source)>0) {

            String[] x = source.split(" ");
            int sizeSynonym = x.length;
            int index = wordList.indexOf(x[0]);
            if (index < 0)
                return;
            List<String> tempWord = new ArrayList<>();
            if (index > 0)
                tempWord.add(wordList.get(index - 1));
            tempWord.add(target);
            if (index < wordList.size() - 1)
                tempWord.add(wordList.get(index + sizeSynonym));
            createBigrams(tempWord);
        }
    }

    public void createBigrams(List<String> words){
        String bigram;
        for(int i=0;(i+1)<words.size();i++){
            bigram = words.get(i) + " " +  words.get(i+1);
            bigrams.add(bigram);
        }
    }


    public int test(int N){
        Set<Integer> numbers = new HashSet<>();
        for(int a=1;;a++){
            for(int b=1;;b++){
                if(a==1 && b==1)
                    continue;
                for(int m=2;;m++){
                    for(int n=2;;n++){
                        int x = (int) Math.pow(a,m) + (int) Math.pow(b,n);
                        if(x<=N && !numbers.contains(x))
                            numbers.add(x);
                        if(b==1 || x>N)
                            break;
                    }
                    int x = (int) Math.pow(a,m) + (int) Math.pow(b,1);
                    if(a==1 || x>N)
                        break;
                }
                int x = (int) Math.pow(a,1) + (int) Math.pow(b,1);
                if(x>N)
                    break;
            }
            int x = (int) Math.pow(a,1) + (int) Math.pow(1,1);
            if(x>N)
                break;
        }
        return numbers.size();
    }

}
