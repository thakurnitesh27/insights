package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

//https://leetcode.com/problems/car-fleet/description/
public class CarFleet {

    public static void main(String[] args) {
       // new CarFleet().carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3});
       // new CarFleet().carFleet(12,new int[]{10,4,0,5,3},new int[]{2,4,1,1,3});
        System.out.println(new CarFleet().carFleet(10,new int[]{6,8},new int[]{3,2}));
        //0,3,5,8,10
    }


    public int carFleet(int target, int[] position, int[] speed) {

        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.position, o2.position);
            }
        });

        int fleet=0;

        int index=0;
        LinkedList<Integer> queue=new LinkedList<>();
        int ans[]=new int[position.length];
       // Arrays.fill(ans,-1);

        while (index<position.length){

            while (!queue.isEmpty() && cars[index].time>=cars[queue.peekLast()].time){
               // ans[queue.pollLast()]=cars[index].time;
                queue.pollLast();
            }

//            while (!queue.isEmpty() && cars[index].time>=queue.peekLast()){
//                queue.pollLast();
//            }
            queue.add(index);
            index++;
        }

        return queue.size();


    }

    class Car {
        int position;
        int remainingDistance;
        int speed;
        double time;

        public Car(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            this.remainingDistance = target - position;
            this.time =(double) remainingDistance / speed;

        }
    }
}
