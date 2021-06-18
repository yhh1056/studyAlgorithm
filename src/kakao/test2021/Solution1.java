package kakao.test2021;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yhh1056
 * Date: 2021/06/18 Time: 7:15 오후
 *
 */
public class Solution1 {

    public String solution(String nickname) {
        return step7(step6(step5(step4(step3(step2(step1(nickname)))))));
    }

    private String step1(String nickname) {
        return nickname.toLowerCase();
    }

    private String step2(String nickname) {
        return nickname.replaceAll("[^0-9a-z-_.]", "");
    }

    private String step3(String nickname) {
        return nickname.replaceAll("[.]{2,}", ".");
    }

    private String step4(String nickname) {
        return nickname.replaceAll("^[.]|[.]$", "");
    }

    private String step5(String nickname) {
        if (nickname.equals("")) {
            return "a";
        }
        return nickname;
    }

    private String step6(String nickname) {

        if (nickname.length() >= 16) {
            String cut = nickname.substring(0, 15);
            cut.replaceAll("^[.]|[.]$", "");
        }
        return nickname;
    }

    private String step7(String nickname) {
        if (nickname.length() == 1) {
            return nickname + nickname + nickname;
        } else if (nickname.length() == 2) {
            return nickname + nickname.substring(1);
        } else {
            return nickname;
        }
    }

}
