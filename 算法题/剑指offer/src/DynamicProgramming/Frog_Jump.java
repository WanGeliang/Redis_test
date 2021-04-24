package DynamicProgramming;

public class Frog_Jump {
    public static void main(String[] args) {

        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};
//        Jump(a);
        System.out.println(Jump(a));
        System.out.println(Jump(b));
    }

    public static boolean Jump(int[] arr) {
        int length = arr.length;
        boolean[] Enable = new boolean[length];
        Enable[0] = true;
        for (int j = 1; j < length; j++) {
            Enable[j] = false;
            for (int i = 0; i < j; i++) {
                if (Enable[i] && i + arr[i] >= j) {
                    Enable[j] = true;
                    break;
                }
            }
        }
        return Enable[length - 1];
    }
}
