package trie;

import java.util.*;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {

        System.out.println(new SearchSuggestionsSystem().suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},"mouse"));
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(new String[]{"havana"},"havana"));
       // System.out.println(new SearchSuggestionsSystem().suggestedProducts(new String[]{"havana"},"haff"));
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"},"bags"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TreeSet set=new TreeSet();
        for(String s:products){
            set.add(s);
        }

       List<List<String>> response=new ArrayList<>();

        int index=1;

        while (index<=searchWord.length()){
          String word=  searchWord.substring(0,index);
         SortedSet<String> matchingWord= set.tailSet(word);
        // matchingWord.headSet(word);
            List<String> list=new ArrayList<>(matchingWord);
        List<String> responseList= list.size()>=3?list.subList(0,3):list;

        int trimIndex=responseList.size()-1;

        while (trimIndex>=0){
            if(!responseList.get(trimIndex).startsWith(word)){
                trimIndex--;
            }
            else {
                break;
            }
        }
        responseList=responseList.subList(0,trimIndex+1);
        response.add(responseList);
         index++;
        }
        return response;
    }
}
