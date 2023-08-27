import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TestTemp {

    public static void main(String[] args) {

        String[] products=new String[]{"mouse","mobile","moneypot","monitor","mousepad"};
         products=new String[]{"bags","baggage","banner","box","cloths"};

        System.out.println(new TestTemp().suggestedProducts(products,"bags"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) { //mouse


        int index = 0;
        TreeSet<String> treeSet = new TreeSet();
        List<List<String>> ans = new ArrayList<>();

        for (String product : products) {
            //if (product.startsWith(tmpSearchWord)) {
            treeSet.add(product);
            //}
        }

        for (index = 1; index <= searchWord.length(); index++) {
            String tmpSearchWord = searchWord.substring(0, index); //mo

            TreeSet<String> filteredSet = (TreeSet<String>) treeSet.tailSet(tmpSearchWord);
            if (filteredSet != null) {
                int count = 0;
                List<String> filteredList = new ArrayList<>();

                List<String> removedVals = new ArrayList<>();
                while (count < 3) {

                    // treeSet.tailSet(searchWord).
                    if(filteredSet.size()>0) {
                        String removedVal = filteredSet.pollFirst();
                        filteredList.add(removedVal);
                        removedVals.add(removedVal);
                    }
                    count++;
                }

                filteredSet.addAll(removedVals);

                ans.add(filteredList);

            }
        }

        return ans;


    }
}
