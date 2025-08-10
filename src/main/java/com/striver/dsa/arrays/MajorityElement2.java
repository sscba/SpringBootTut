package com.striver.dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {

    public List<Integer> optimalApp (int[] arr){
        List<Integer> res = new ArrayList<>();
        int cnt1 =0;
        int cnt2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int min = (arr.length/3) +1;

        for(int ele: arr){
            if(cnt1==0 && ele != ele2){
                ele1 = ele;
                cnt1++;
            }else if(cnt2 ==0 && ele != ele1){
                ele2 = ele;
                cnt2++;
            }else if(ele == ele1){
                cnt1++;
            } else if (ele == ele2) {
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }

        }
        cnt1=0;
        cnt2=0;

        for(int ele: arr){
            if(ele==ele1) cnt1++;
            else if(ele==ele2) cnt2++;
        }
        if(cnt1 >= min)   res.add(ele1);

        if(cnt2 >= min) res.add(ele2);

        return res;
    }


    public List<Integer> solve (int[] arr){
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> eleCnt = new HashMap<>();
        int min = (arr.length/3) +1;

        for(int ele: arr){
            eleCnt.put(ele,eleCnt.getOrDefault(ele,0)+1);
            if(eleCnt.getOrDefault(ele,0) >= min && !res.contains(ele)){
                res.add(ele);
            }
            if (res.size() == 2 ) break;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2};
        MajorityElement2 majorityElement2 = new MajorityElement2();
        List<Integer> ans =  majorityElement2.solve(arr);
        for(int ele: ans){
            System.out.println(ele);
        }
    }
}
