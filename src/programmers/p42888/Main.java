package programmers.p42888;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 오픈채팅방
 * author {yhh1056}
 * Create by {2020/11/02}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution(new String[]{"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"});
    }

    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hashMap = new HashMap<>();
        int enterAndLeaveCount = 0;

        for (String message : record) {
            String[] info = message.split(" ");
            String userStatus = info[0];
            String id = info[1];
            String name = info[2];

            switch (userStatus) {
                case "Enter":
                    hashMap.put(id, name);
                    enterAndLeaveCount++;
                    break;
                case "Leave":
                    enterAndLeaveCount++;
                    break;
                case "Change":
                    hashMap.put(id, name);
                    break;
            }
        }
        answer = new String[enterAndLeaveCount];


        int index = 0;
        for (String command : record) {
            String[] info = command.split(" ");
            String status = info[0];
            String id = info[1];

            String name = hashMap.get(id);

            if (status.equals("Enter")) {
                answer[index++] = name + "님이 들어왔습니다.";
            } else if (status.equals("Leave")) {
                answer[index++] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

