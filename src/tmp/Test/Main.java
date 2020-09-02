package tmp.Test;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner br = new Scanner(System.in);
        int[] result = new int[6];

        int age = Integer.parseInt(br.nextLine());
        int hrMax = 220 - age;
        String input = br.nextLine();
        while (!input.isEmpty()) {
            int heartRate = Integer.parseInt(input);
            double rest = hrMax * 60 / 100;
            double warmingUp = hrMax * 68 / 100;
            double focus = hrMax * 75 / 100;
            double mT = hrMax * 80 / 100;
            double hT = hrMax * 90 / 100;

            if (heartRate < rest) {
                result[5]++;
            } else if (rest <= heartRate && heartRate < warmingUp) {
                result[4]++;
            } else if (warmingUp <= heartRate && heartRate < focus) {
                result[3]++;
            } else if (rest <= heartRate && heartRate < mT) {
                result[2]++;
            } else if (mT <= heartRate && heartRate < hT) {
                result[1]++;
            } else if (hT <= heartRate && heartRate <= hrMax) {
                result[0]++;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " +
                result[2] + " " + result[3] + " " +
                result[4] + " " + result[5]);
    }
}