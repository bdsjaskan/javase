package com.zhengxifeng;

import java.util.Random;

public class ABC {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}

class UpdateB{}
class UpdateA extends UpdateB {}


//class A<UpdateA extends UpdateB> {
//    UpdateA updateA;
//}
//
//class B extends A<UpdateA> {
//    UpdateB updateB;
//}

 class OptimizedBubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 4, 2};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int lastSwap = n-1;//5
        while (lastSwap > 0) {
            int k = lastSwap;//5
            lastSwap = 0;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    lastSwap = j;
                }
            }
        }
    }
}




 class Fibonacci {
    public static void main(String[] args) {
        int result = fibonacci(30);
        System.out.println(result+"--");
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}

class RandomUtils {
    private static final int CODE_LENGTH = 4;

    public static String generateCode() {

        int min = 1;
        int max = 10;
        double random1 = Math.random();
        System.out.println("random1 = " + random1);
        int rand = (int)(random1 * (max - min + 1)) + min;
        System.out.println("rand = " + rand);


        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int digit = random.nextInt(10);
            System.out.println("digit = " + digit);
            sb.append(digit);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = RandomUtils.generateCode();
        System.out.println("s = " + s);
    }
}


class A<T extends UpdateB> {
    T updateA;
}

class B extends A<UpdateA> {
    UpdateB updateB;
}

