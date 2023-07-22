package tensDigit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class tensDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] input1 = new int[size];
        System.out.println("Enter array elements ");
        for (int i = 0; i < size; i++) {
            input1[i] = scanner.nextInt();
        }
        scanner.close();
        int[] output1 = sortArrayByTensPlace(input1);

        System.out.println("Output 1: " + Arrays.toString(output1));
    }

    public static int[] sortArrayByTensPlace(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                int tensPlace1 = (num1 % 100) / 10;
                int tensPlace2 = (num2 % 100) / 10;

                if (tensPlace1 != tensPlace2) {
                    return tensPlace1 - tensPlace2;
                } else {
                    return num2 - num1;
                }
            }
        });

        int[] sortedArr = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();

        return sortedArr;
    }
}
