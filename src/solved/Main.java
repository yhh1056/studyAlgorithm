package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by yhh1056
 * Date: 2021/07/01 Time: 4:37 오후
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("/Users/yuhyeonho/Desktop/code/studyAlgorithm/README.md");
        try (BufferedReader br = new BufferedReader(new FileReader(file));
                FileWriter fw = new FileWriter( "README.md" ,true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            String line;
            int solved = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains("[")) {
                    solved++;
                }

            }

            bw.newLine();
            bw.write("## 현재 풀이한 문제수는 : " + solved + "개 입니다."); //버퍼에 데이터 입력
            bw.newLine();
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
