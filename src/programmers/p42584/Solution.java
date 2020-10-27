package programmers.p42584;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int price = prices[i];
            int index = i;
            int count = 0;

            while (index < prices.length - 1 && price <= prices[index]) {
                index++;
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}
