package com.cpuscheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//asasdfasdfgaksjdskf
public class Scheduling {

    public static void SJF(ArrayList<Process> arr) {
        Collections.sort(arr, Comparator.comparing(process -> process.arrivalTime));
        ArrayList<Process> statistics = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            statistics.add(arr.get(i).forStat);
        }
        ArrayList<Process> readyQueue = new ArrayList<>();
        Process currProcess;
        readyQueue.add(arr.get(0));
        currProcess = readyQueue.get(0);
        arr.remove(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).arrivalTime == currProcess.arrivalTime) {
                readyQueue.add(arr.get(i));
                arr.remove(i--);
            }
        }
        Collections.sort(readyQueue, Comparator.comparing(process -> process.burstTime));
        currProcess = readyQueue.get(0);
        int totalTime = currProcess.arrivalTime;
        Rang rang = new Rang();

        while (readyQueue.size() > 0) {
            rang.low = totalTime;
            totalTime += currProcess.burstTime;
            rang.high = totalTime;
            /*for (int i = 0; i < readyQueue.size(); i++) {
                if (currProcess != readyQueue.get(i))
                    readyQueue.get(i).forStat.waitingTime += currProcess.burstTime;
            }*/
            currProcess.waitingTime=totalTime-currProcess.forStat.burstTime-currProcess.arrivalTime;
            currProcess.chartTable.Rang_Arr.add(rang);
            rang = new Rang();
            currProcess.burstTime = 0;
            readyQueue.remove(currProcess);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).arrivalTime <= totalTime) {
                    readyQueue.add(arr.get(i));
                    arr.remove(i--);
                } else break;
            }
            Collections.sort(readyQueue, Comparator.comparing(process -> process.burstTime));
            if (readyQueue.size() != 0)
                currProcess = readyQueue.get(0);
        }
        for (int i = 0; i < statistics.size(); i++) {
            statistics.get(i).turnaroundTime = statistics.get(i).waitingTime + statistics.get(i).burstTime;
        }
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println(statistics.get(i).name + " " + statistics.get(i).waitingTime + " " + statistics.get(i).turnaroundTime);
        }
    }
    public static void Priority(ArrayList<Process> arr) {
        int avgPriority=0;
        Collections.sort(arr, Comparator.comparing(process -> process.arrivalTime));

        ArrayList<Process> statistics = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            avgPriority+=arr.get(i).priority;
            statistics.add(arr.get(i).forStat);
        }
        avgPriority=avgPriority/arr.size();
        ArrayList<Process> readyQueue = new ArrayList<>();
        Process currProcess;
        readyQueue.add(arr.get(0));
        currProcess = readyQueue.get(0);
        arr.remove(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).arrivalTime == currProcess.arrivalTime) {
                readyQueue.add(arr.get(i));
                arr.remove(i--);
            }
        }
        Collections.sort(readyQueue, Comparator.comparing(process -> process.priority));
        currProcess = readyQueue.get(0);
        int totalTime = currProcess.arrivalTime;
        Rang rang = new Rang();
        while (readyQueue.size() > 0) {
            rang.low = totalTime;
            totalTime += currProcess.burstTime;
            rang.high = totalTime;
            /*for (int i = 0; i < readyQueue.size(); i++) {
                if (currProcess != readyQueue.get(i))
                    readyQueue.get(i).forStat.waitingTime += currProcess.burstTime;
            }*/
            currProcess.forStat.waitingTime=totalTime-currProcess.forStat.burstTime-currProcess.arrivalTime;
            currProcess.chartTable.Rang_Arr.add(rang);
            rang = new Rang();
            currProcess.burstTime = 0;
            readyQueue.remove(currProcess);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).arrivalTime <= totalTime) {
                    readyQueue.add(arr.get(i));
                    arr.remove(i--);
                } else break;
            }
            Collections.sort(readyQueue, Comparator.comparing(process -> process.priority));
            if (readyQueue.size() != 0)
                currProcess = readyQueue.get(0);
        }
        for (int i = 0; i < statistics.size(); i++) {
            statistics.get(i).turnaroundTime = statistics.get(i).waitingTime + statistics.get(i).burstTime;
        }
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println(statistics.get(i).name + " " + statistics.get(i).waitingTime + " " + statistics.get(i).turnaroundTime);
        }
    }

    public static void SRTF(ArrayList<Process> arr) {
        Collections.sort(arr, Comparator.comparing(process -> process.arrivalTime));
        ArrayList<Process> statistics = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            statistics.add(arr.get(i).forStat);
        }
        ArrayList<Process> readyQueue = new ArrayList<>();
        Process currProcess;
        readyQueue.add(arr.get(0));
        currProcess = readyQueue.get(0);
        arr.remove(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).arrivalTime == currProcess.arrivalTime) {
                readyQueue.add(arr.get(i));
                arr.remove(i--);
            }
        }
        Collections.sort(readyQueue, Comparator.comparing(process -> process.burstTime));
        currProcess = readyQueue.get(0);
        int totalTime = currProcess.arrivalTime;
        Rang rang = new Rang();
        rang.low = totalTime;
        Boolean madeSwitch;
        while (readyQueue.size() > 0) {
            madeSwitch=false;
            totalTime++;
            currProcess.burstTime--;
            if (currProcess.burstTime == 0) {
                madeSwitch=true;
                rang.high = totalTime;
                currProcess.chartTable.Rang_Arr.add(rang);
                currProcess.forStat.waitingTime=totalTime-currProcess.forStat.burstTime-currProcess.arrivalTime;
                readyQueue.remove(currProcess);

            }
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).arrivalTime <= totalTime) {
                    readyQueue.add(arr.get(i));
                    arr.remove(i--);
                } else break;
            }
            Collections.sort(readyQueue, Comparator.comparing(process -> process.burstTime));
            if (readyQueue.size() != 0) {
                if (currProcess != readyQueue.get(0)) {
                    madeSwitch=true;
                    rang.high = totalTime;

                    currProcess.chartTable.Rang_Arr.add(rang);

                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).arrivalTime <= totalTime+1) {
                            readyQueue.add(arr.get(i));
                            arr.remove(i--);
                        } else break;
                    }
                    Collections.sort(readyQueue, Comparator.comparing(process -> process.burstTime));
                    currProcess = readyQueue.get(0);

                }
            }
            if(madeSwitch){
                totalTime++;
                rang = new Rang();
                rang.low = totalTime;
            }
        }
        for (int i = 0; i < statistics.size(); i++) {
            statistics.get(i).turnaroundTime = statistics.get(i).waitingTime + statistics.get(i).burstTime;
        }
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println(statistics.get(i).name + " " + statistics.get(i).waitingTime + " " + statistics.get(i).turnaroundTime);
        }

    }
    public static void AG(ArrayList<Process> arr) {
        ArrayList<Process> arrived=new ArrayList();
        ArrayList<Process> result=new ArrayList();
        //ArrayList<ChartTable> Table=new ArrayList();
        for (int i = 0; i<arr.size(); i++) result.add(new Process(arr.get(i).name,arr.get(i).burstTime,arr.get(i).arrivalTime,arr.get(i).priority,arr.get(i).quantumTime));
        boolean firstTime=true;
        int totalTime=0;
        ArrayList<Process>queue=new ArrayList<>();
        ArrayList<Process>dieList=new ArrayList<>();
        while (arr.size() > 0) {
            arrived.clear();
            if (firstTime) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(0).arrivalTime == arr.get(i).arrivalTime)
                        arrived.add(arr.get(i));
                    else break;
                }
                firstTime = false;
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).arrivalTime <= totalTime)
                        arrived.add(arr.get(i));
                    else break;
                }
            }
            Collections.sort(arrived, Comparator.comparing(process -> process.AgFactor));
            Process currProcess = arrived.get(0);
            boolean nonPrimitative=true;
            int i=0;
            while(i<=currProcess.quantumTime){
                arrived=update(arr,totalTime);
                if (nonPrimitative) {
                    if(currProcess.burstTime-Math.ceil(currProcess.quantumTime/2.0)<=0){
                        /////////////////////////////////////
                        System.out.print("Quantum (");
                        for(int j=0 ;j<result.size();j++){
                            if(j==result.size()-1)System.out.print(result.get(j).quantumTime);
                            else System.out.print(result.get(j).quantumTime+",");
                        }
                        System.out.print(") ->  ceil(50%) = (");
                        for(int j=0 ;j<result.size();j++){
                            if(j==result.size()-1)System.out.print((int)Math.ceil(result.get(j).quantumTime/2.0));
                            else System.out.print((int)Math.ceil(result.get(j).quantumTime/2.0)+",");
                        }
                        System.out.print(") "+ currProcess.name+" Running\n");
                        /////////////////////////////////////////////////////////
                        totalTime+=currProcess.burstTime;
                        currProcess.quantumTime=0;
                        currProcess.burstTime=0;
                        int indx=0;
                        for(int j=0 ;j<result.size();j++){
                            if((currProcess.name).equals(result.get(j).name))indx=j;
                        }
                        currProcess.waitingTime=totalTime-result.get(indx).burstTime-currProcess.arrivalTime;
                        currProcess.turnaroundTime=currProcess.waitingTime+result.get(indx).burstTime;
                        result.get(indx).quantumTime=0;
                        dieList.add(currProcess);
                        arr.remove(currProcess);
                        arrived.remove(currProcess);
                        if(queue.isEmpty())break;
                        currProcess=queue.get(0);
                        queue.remove(0);
                        i=0;
                        continue;
                    }
                    else {
                        /////////////////////////////////////
                        System.out.print("Quantum (");
                        for(int j=0 ;j<result.size();j++){
                            if(j==result.size()-1)System.out.print(result.get(j).quantumTime);
                            else System.out.print(result.get(j).quantumTime+",");
                        }
                        System.out.print(") ->  ceil(50%) = (");
                        for(int j=0 ;j<result.size();j++){
                            if(j==result.size()-1)System.out.print((int)Math.ceil(result.get(j).quantumTime/2.0));
                            else System.out.print((int)Math.ceil(result.get(j).quantumTime/2.0)+",");
                        }
                        System.out.print(") "+ currProcess.name+" Running\n");
                        /////////////////////////////////////////////////////////
                        totalTime+=Math.ceil(currProcess.quantumTime/2.0);
                        i+=Math.ceil(currProcess.quantumTime/2.0);
                        currProcess.burstTime-=Math.ceil(currProcess.quantumTime/2.0);
                        nonPrimitative=false;
                        continue;
                    }
                }
                else if(!nonPrimitative){
                    if(currProcess.burstTime==0){//finish its all job

                        arr.remove(currProcess);
                        arrived.remove(currProcess);
                        currProcess.quantumTime=0;
                        currProcess.burstTime=0;
                        int indx=0;
                        for(int j=0 ;j<result.size();j++){
                            if((currProcess.name).equals(result.get(j).name))indx=j;
                        }
                        currProcess.waitingTime=totalTime-result.get(indx).burstTime-currProcess.arrivalTime;dieList.add(currProcess);
                        currProcess.turnaroundTime=currProcess.waitingTime+result.get(indx).burstTime;
                        result.get(indx).quantumTime=0;
                        if(queue.isEmpty()) {
                            currProcess = pickProcess(arr, totalTime);
                            break;
                        }
                        else {
                            currProcess = queue.get(0);
                        }
                        nonPrimitative=true;
                        i=0;
                        continue;
                    }
                    if(i==currProcess.quantumTime){//finish quantum
                        currProcess.quantumTime+= (int) Math.ceil(.1*(getMean(arr,totalTime)));
                        int indx=0;
                        for(int j=0 ;j<result.size();j++){
                            if((currProcess.name).equals(result.get(j).name))indx=j;
                        }
                        result.get(indx).quantumTime=currProcess.quantumTime;
                        queue.add(currProcess);
                        currProcess=queue.get(0);
                        queue.remove(0);

                        nonPrimitative=true;
                        i=0;
                        continue;
                    }
                    Process tempProcess= pickProcess(arr,totalTime);
                    if(tempProcess!=null){
                        if(currProcess!=tempProcess){
                            currProcess.quantumTime+=(currProcess.quantumTime-i);
                            /////////////////////////////////////////////////////
                            int indx=0;
                            for(int j=0 ;j<result.size();j++){
                                if((currProcess.name).equals(result.get(j).name))indx=j;
                            }
                            result.get(indx).quantumTime=currProcess.quantumTime;
                            /////////////////////////////////////////////////
                            queue.add(currProcess);
                            currProcess=tempProcess;
                            queue.remove(tempProcess);
                            nonPrimitative=true;
                            i=0;
                        }
                        else {

                            currProcess.burstTime-=1;
                            totalTime++;
                            i++;
                        }
                    }
                }
            }
        }
        ////////////////////////////
        System.out.print("Quantum (");
        for(int j=0 ;j<result.size();j++){
            if(j==result.size()-1)System.out.print(result.get(j).quantumTime+")\n");
            else System.out.print(result.get(j).quantumTime+",");
        }
        ///////////////////////////
        for (int i = 0; i < dieList.size(); i++)
            System.out.println("Process name: "+dieList.get(i).name + "  Waiting time: " + dieList.get(i).waitingTime + "  Turnaroundtime: " + dieList.get(i).turnaroundTime);
        //////////////////////

    }
    private static ArrayList<Process> update(ArrayList<Process> arr,int totalTime) {
        ArrayList<Process>arrived=new ArrayList<>();
        for(int j=0;j<arr.size();j++){
            if(arr.get(j).arrivalTime<=totalTime){
                arrived.add(arr.get(j));
            }
        }
        return arrived;
    }

    private static double getMean(ArrayList<Process> arr,int totalTime) {
        ArrayList<Process>arrived=new ArrayList<>();
        for(int j=0;j<arr.size();j++){
            if(arr.get(j).arrivalTime<=totalTime){
                arrived.add(arr.get(j));
            }
        }
        double sum=0,temp=0;
        for(int j=0;j<arrived.size();j++) {
            sum+=arrived.get(j).quantumTime;
        }
        temp= (sum/arrived.size());
        return temp;
    }

    private static Process pickProcess(ArrayList<Process>arr,int totalTime) {
        ArrayList<Process>arrived=new ArrayList<>();
        for(int j=0;j<arr.size();j++){
            if(arr.get(j).arrivalTime<=totalTime){
                arrived.add(arr.get(j));
            }
        }
        Collections.sort(arrived,Comparator.comparing(process -> process.AgFactor));
        if(arrived.size()!=0)
            return arrived.get(0);

        return null;
    }

}
