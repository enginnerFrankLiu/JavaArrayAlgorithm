package com.company;

import java.util.HashMap;
import java.util.Map;

public class SumInfo {

    /**
     * 这种常见的问题，还是比较简单的，计算方式滴呀；
     * 强化自己的算法的各种理解；
     * 本质还是进行各种无意义的遍历；和遍历；
     */
    public void test(){
        int target=10;
        int [] nums= {8,1,9,5,5,6,4,2};
        Map indexs=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
             int a=nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int b=nums[j];
                int temp=a+b;
                if(temp==target){
                    indexs.put(i,j);
                }
            }
        }
        System.out.print(indexs);
    }

    /**
     * 用hash的方式去做；
     * 整体效果还算是比较明显的；
     *
     */
    public void testHash(){
        int target=10;
        int [] nums= {8,1,9,5,5,6,4,2};
        Map indexs=new HashMap<Integer,Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement=target-nums[i];
            if(map.containsKey(complement)){  //如果元素中存在我们的差值，那么我们就能够找到其中的值
                int complementIndex=map.get(complement);
                int index=i;
                indexs.put(complementIndex,index);
            }
            map.put(nums[i],i); //把元素和元素 和 元素中的下标放进我们的hash表中
        }
         System.out.print(indexs);
    }
}
