package com.company;

import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//about half of month
//we din't push new commit into our private repos to improve my java programming skill.
//fuck stupid guy.
public class Main {

    static void ArrayUnionCount() {
//        int[] aArray = {1, 2, 3, 4,5};
//        int[] bArray = {2, 3, 4,5,5};
//        int[] result = getUnionOfArray(aArray, bArray);
//        printArray(result);
//
//        int[] aArray = {1, 2};
//        int[] bArray = {1, 2};
//        int[] result = getUnionOfArray(aArray, bArray);
//        printArray(result);


//        int[] aArray = { 2};
//        int[] bArray = { 2};
//        int[] result = getUnionOfArray(aArray, bArray);
//        printArray(result);


//0 这种元素，通不过测试//case 0跑不过的原因，如果数据源中包含0, 然后，然后我们初始化的temp数组，默认的值也是0；
//        int[] aArray = { 1,0};
//        int[] bArray = { 2,0};
//        Integer[] result = getUnionOfArrayV2(aArray, bArray);
//        printArray(result);

//        int[] aArray = { 1,1,1,1,3,2};
//        int[] bArray = { 3,4,5,6,1,1};
//        Map map = getUnionOfArrayV3(aArray, bArray);
//        System.out.println(map);
    }

    /**
     * 1.重复
     * 2.末尾的0
     * 3.数组中默认的0和数据源中0容易造成重复，混淆
     *
     * 重要的是解决问题的思路，就是解决问题的大致方向的问题，往这条方向走的时候可能会有一些小小的错误，我们及时调整即可以了；
     *
     * 两个数组中的交集
     * 1.一个元素在a数组中存在，那么在另一一个数组中也存在
     * 2.往temp数据添加元素的时候，需要判断是否已经存在，避免重复添加;
     * 3.将temp中的实际数据copy到最后的result数组中
     * 4.最总返回我们的结果
     *
     * @param aArray
     * @param bArray
     */
    static int[] getUnionOfArray(int[] aArray, int[] bArray) {
        int maxLength = aArray.length + bArray.length;
        int[] temp = new int[maxLength];
        int index = 0;
        for (int i = 0; i < aArray.length; i++) {
            int a = aArray[i];
            for (int j = 0; j < bArray.length; j++) {
                int b = bArray[j];
                if (a == b) {  //这部分实现，可以换成使用hashset进行实现，整体效果还算不错；
                    boolean isExisted = false;
                    for (int z = 0; z < temp.length; z++) {
                        int val = temp[z];
                        if (a == val) {
                            isExisted = true;
                            break;
                        } else {
                            isExisted = false;
                        }
                    }
                    if (!isExisted) {
                        temp[index] = a;
                        index++;
                    }
                }
            }
        }
        //把结果放到一个新的数据中心去; 这样来解决我们的 数组过大，导致的0的影响;
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    static Integer [] getUnionOfArrayV2(int[] aArray, int[] bArray) {
        HashSet<Integer> result=new HashSet<Integer>();
        for (int i = 0; i < aArray.length; i++) {
            int a = aArray[i];
            for (int j = 0; j < bArray.length; j++) {
                int b = bArray[j];
                if (a == b) {
                    result.add(a);
                }
            }
        }
        return result.toArray( new Integer [result.size()]);
    }

    //这个还要加上元素出现的次数;
    static Map getUnionOfArrayV3(int[] aArray, int[] bArray) {
        Map<Integer,Integer> result= new HashMap<>();
        for (int i = 0; i < aArray.length; i++) {
            int a = aArray[i];
            for (int j = 0; j < bArray.length; j++) {
                int b = bArray[j];
                if (a == b) {
                    if(result.containsKey(a)){
                        int count=result.get(a)+1;
                        result.put(a,count);
                    }else{
                        result.put(a,1); //首次初始化的各种数据
                    }
                }
            }
        }
        return result;
    }

    static void printArray(int [] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void printArray(Integer [] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void md(){


        System.out.println("start");

        SumInfo sum=new SumInfo();
        sum.test();
        System.out.print("hash----方式进行查找");
        sum.testHash();

        System.out.print("字符串元素中第一个，不重复（唯一的元素）----------");
        sum.testString();

        System.out.println("end");

    }

    public static void main(String[] args) {

        md();
    }
}
