package tmp;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        br.readLine();
//        int length = Integer.parseInt(input[0]);
//        int box = Integer.parseInt(input[1]);
//        int result;
//
//        if ((length - 1) % (box - 1) == 0) {
//            result = (length - 1) / (box - 1);
//        } else {
//            result = ((length - 1) / (box - 1)) + 1;
//        }
//        System.out.println(result);

        ///////////////////////////////////////
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            String[] arr = br.readLine().split(" ");
            long seasonCoupon = Long.parseLong(arr[0]);
            long normalCoupon = Long.parseLong(arr[1]);
            int result = 0;
            int stmp = 5;
            int ntmp = 7;

            while (seasonCoupon - 5 >= 0) {
                if (seasonCoupon + normalCoupon < 12 || normalCoupon == 0) {
                    break;
                }
                if (seasonCoupon >= stmp) {
                    seasonCoupon -= stmp;
                    normalCoupon -= ntmp;
                    result++;
                } else {
                    stmp++;
                    ntmp--;
                }
            }
            System.out.println(result);
        }
    }
}