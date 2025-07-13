package com.striver.dsa.binarysearch;


import java.util.PriorityQueue;

public class GasStation {

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public double betterSolution(int[] stations,int k){
        int n = stations.length;
        int[] howManyPlaced = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first,a.first));

        for(int i=0;i<n-1;i++){
            pq.add(new GasStation.Pair(stations[i+1]-stations[i],i));
        }

        for(int gasStation = 1; gasStation<=k;gasStation++){
            Pair tp = pq.poll();
            int sectionInd = tp.second;

            howManyPlaced[sectionInd]++;
            int initDiff = stations[sectionInd+1] - stations[sectionInd];
            double newSectionLen = initDiff/(double) (howManyPlaced[sectionInd] + 1);

            pq.add(new GasStation.Pair(newSectionLen,sectionInd));
        }

        return pq.peek().first;
    }

    public double solve (int[] stations,int k){
        int[] howManyPlaced = new int[stations.length-1];

        for(int gasStation = 1; gasStation <= k;gasStation++){
            double maxSection = -1;
            int maxInd = -1;
            for(int i=0;i<stations.length-1;i++){
                int diff = stations[i+1] - stations[i];
                double sectionLength = diff/ (double) (howManyPlaced[i] + 1);

                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howManyPlaced[maxInd]++;
        }

        //find max of maxSection
        double maxAns = -1;
        for(int i =0; i<stations.length-1;i++){
            int diff = stations[i+1] - stations[i];
            double section = diff/(double)(howManyPlaced[i] + 1);
            maxAns = Math.max(section,maxAns);
        }
        return maxAns;
    }



    public double optimalSolution(int[] stations,int k){
        double low =0;
        double high = 0;

        for(int i=0 ; i<stations.length-1;i++){
            high = Math.max(high, (double) (stations[i+1] - stations[i]));
        }

        double diff = 1e-6;

        while(high - low > diff){
            double mid = (low+high)/2.0;

            int cnt = countGasStationRequired(stations,mid);
            if(cnt > k){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return high;

    }

    private int countGasStationRequired(int[] stations, double mid) {
        int cnt = 0;
        for(int i=0;i<stations.length-1;i++){
            int noInBtw = (int) ((stations[i+1] - stations[i])/mid);
            if(stations[i+1] - stations[i] == noInBtw * mid){
                noInBtw--;
            }
            cnt += noInBtw;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] gas = {1,13,17,23};
        int k = 5;

        double ans = new GasStation().optimalSolution(gas,k);
        System.out.println(ans);

    }
}
