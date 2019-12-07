package com.cpuscheduling;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner one = new Scanner(System.in);
    static Scanner two = new Scanner(System.in);
    static Scanner three = new Scanner(System.in);
    static Scanner four = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Process> arr = new ArrayList<>();
        /*for (int i=0;i<4;i++){
            arr.add(new Process(one.nextLine(),two.nextInt(),three.nextInt(),0,0));
        }
        */
        /*arr.add(new Process("p1",7,0,0,0));
        arr.add(new Process("p2",4,2,0,0));
        arr.add(new Process("p3",1,4,0,0));
        arr.add(new Process("p4",4,5,0,0));
        Scheduling.SJF(arr);*/

        /*arr.add(new Process("p1", 7, 0, 3, 0));
        arr.add(new Process("p2", 4, 2, 1, 0));
        arr.add(new Process("p3", 1, 4, 4, 0));
        arr.add(new Process("p4", 4, 5, 5, 0));
        //Scheduling.Priority(arr);
        Scheduling.SRTF(arr);*/
        arr.add(new Process("p1",17,0,4,4));
        arr.add(new Process("p2",6,3,9,4));
        arr.add(new Process("p3",10,4,3,4));
        arr.add(new Process("p4",4,29,8,4));
        //Scheduling.Priority(arr);
        Scheduling.AG(arr);
    }
}
