package programmers.p42577;

/**
 * author {yhh1056}
 * Create by {2020/08/11}
 */
public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}