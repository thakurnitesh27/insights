package algo.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//https://leetcode.com/problems/queue-reconstruction-by-height/
public class QueueReconstructionByHeight {

    public static void main(String[] args) {

        int people[][]=new int[][]{
                new int[]{6,0},
                new int[]{1,1},
                new int[]{7,1},
                new int[]{8,0},
                new int[]{9,0}, new int[]{2,4}, new int[]{0,6}, new int[]{2,5}, new int[]{3,4}, new int[]{7,3}
        };
        int[][] response = new QueueReconstructionByHeight().reconstructAgain(people);
        print(response); //[[6,0],[1,1],[8,0],[7,1],[9,0],[2,4],[0,6],[2,5],[3,4],[7,3]]
         people = new int[][]{new int[]{6, 0},
                new int[]{5, 0},
                new int[]{4, 0},
                new int[]{3, 2},
                new int[]{2, 2},
                new int[]{1, 4}
        };//[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        response = new QueueReconstructionByHeight().reconstructAgain(people);
        print(response);

        people = new int[][]{new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2}
        };

        response = new QueueReconstructionByHeight().reconstructAgain(people);
        print(response);

    }

    public int[][] reconstructQueueFirstAttempt(int[][] people) {
        int relativeHeight = 0;

        ArrayList<int[]> result = new ArrayList<>();

        int[] firstPerson = null;
        while (firstPerson == null) {
            firstPerson = findSmallestByHeight(people, relativeHeight);
            relativeHeight++;
        }
        result.add(firstPerson);
        relativeHeight = firstPerson[1];
        int numOfPeopleProcessed = 0;

        while (numOfPeopleProcessed < people.length) {

            ArrayList<int[]> persons = findAllPersonsMatchingRelativeHeight(people, relativeHeight);

            // int j = 0;
            for (int i = 0; i < persons.size(); i++) {
                int[] currentPerson = persons.get(i);

                int countOfLargePeopleBefore = 0;
                int countOfAllPeopleBefore = 0;
                //  for(int j=0;j<result.size();i++){

                while (countOfAllPeopleBefore <= result.size()) {

                    if (countOfLargePeopleBefore == currentPerson[1]) {
                        if (result.get(countOfAllPeopleBefore > 0 ? countOfAllPeopleBefore - 1 : 0)[0] != currentPerson[0]) {
                            // result.add(countOfPeopleBefore>0?countOfPeopleBefore:j, currentPerson);
                            if (countOfLargePeopleBefore > 0) {

                                while (i < persons.size()) {
                                    currentPerson = persons.get(i);
                                    //   countOfAllPeopleBefore++;
                                    result.add(countOfAllPeopleBefore, currentPerson);
                                    // countOfLargePeopleBefore++;
                                    countOfAllPeopleBefore++;
                                    i++;
                                }
                            } else {
                                result.add(currentPerson);
                                countOfAllPeopleBefore++;
                            }
                        } else {
                            countOfAllPeopleBefore++;
                        }
                        break;
                    }
                    if (result.get(countOfAllPeopleBefore)[0] >= currentPerson[0]) {
                        countOfLargePeopleBefore++;
                        // j++;
                    }
                    countOfAllPeopleBefore++;
                    // else {
                    //  j++;
                    // }
                    // j++;
                }
            }
            relativeHeight++;
            numOfPeopleProcessed += persons.size();
        }

        return result.toArray(new int[people.length][]);

    }


    int[][] reconstruct(int[][] people) {


        int relativeHeight = 0;
        ArrayList<int[]> result = new ArrayList<>();
        int numOfPeopleProcessed = 0;


        while (numOfPeopleProcessed < people.length) {

            ArrayList<int[]> persons = findAllPersonsMatchingRelativeHeight(people, relativeHeight);
          //  int index=0;
            if (persons.size() > 0) {

                for(int index=0;index<persons.size();index++) {

                    int[] currentPerson = persons.get(index);
                    int countOfLargePeopleBefore = 0;
                    int countOfAllPeopleBefore = 0;

                    while (countOfAllPeopleBefore <= result.size()) {

                        if (countOfLargePeopleBefore == currentPerson[1]) {

                            if (countOfLargePeopleBefore > 0) {
                                result.addAll(countOfAllPeopleBefore, persons);
                                index=persons.size();
                                //countOfAllPeopleBefore++;

                            } else {
                                result.addAll(persons);
                                index=persons.size();
                               // countOfAllPeopleBefore++;
                            }
                            break;
                        }
                        if (result.get(countOfAllPeopleBefore)[0] >= currentPerson[0]) {
                            countOfLargePeopleBefore++;
                        }
                        countOfAllPeopleBefore++;
                    }
                }
            }
            relativeHeight++;
            numOfPeopleProcessed += persons.size();
        }

        return result.toArray(new int[people.length][]);


    }

    int[][] reconstructAgain(int[][] people) {


        int relativeHeight = 0;
        ArrayList<int[]> result = new ArrayList<>();
        int numOfPeopleProcessed = 0;


        while (numOfPeopleProcessed < people.length) {

            ArrayList<int[]> persons = findAllPersonsMatchingRelativeHeight(people, relativeHeight);
            //  int index=0;
            if (persons.size() > 0) {

                for(int index=persons.size()-1;index>=0;index--){

                  int[] currentPerson=  persons.get(index);
                    int countOfLargePeopleBefore=0;
                    int peopleFoundSoFar=0;
                    boolean personAdded=false;

                    for(peopleFoundSoFar=0;peopleFoundSoFar<result.size();peopleFoundSoFar++){

                        if(countOfLargePeopleBefore==currentPerson[1]){
                            result.add(peopleFoundSoFar,currentPerson);
                            personAdded=true;
                            break;
                        }
                        else if(result.get(peopleFoundSoFar)[0]>=currentPerson[0]){
                            countOfLargePeopleBefore++;
                        }
                       // peopleFoundSoFar++;

                    }
                    if(!personAdded){
                        result.add(peopleFoundSoFar,currentPerson);
                       // break;
                    }
                }

            }
            relativeHeight++;
            numOfPeopleProcessed += persons.size();
        }

        return result.toArray(new int[people.length][]);


    }

    int[] findSmallestByHeight(int[][] people, int height) {

        int smallestIndex = 0;
        boolean smallestFound = false;

        for (int i = 1; i < people.length; i++) {

            if (people[i][1] == height) {

                if (smallestFound) {

                    if (people[smallestIndex][0] > people[i][0]) {
                        smallestIndex = i;
                    }
                } else {
                    smallestFound = true;
                    smallestIndex = i;
                }
            }

        }

        if (smallestFound) {
            return people[smallestIndex];
        }
        return null;

    }

    ArrayList<int[]> findAllPersonsMatchingRelativeHeight(int[][] people, int height) {
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            if (people[i][1] == height) {
                list.add(people[i]);
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else return 0;
            }
        });

        return list;


    }

    static void print(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(+arr[i][j]);
            }
            System.out.print("]\t");
        }
        System.out.println("\n");


    }
}
