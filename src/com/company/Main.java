package com.company;

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
        int[] aArray = { 1,0};
        int[] bArray = { 2,0};
        int[] result = getUnionOfArray(aArray, bArray);
        printArray(result);


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

    static void printArray(int [] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayUnionCount();
    }
}
