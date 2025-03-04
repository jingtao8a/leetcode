package org.jingtao8a.interview;
import java.util.*;

public class Interview1 {
    static class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            Integer val = null;
            List<Integer> res = new ArrayList<>();
            try {
                val = Integer.valueOf(expression);
            } catch (Exception e) {
                val = null;
            }
            if (val != null) {
                res.add(val);
                return res;
            }

            int n = expression.length();
            for (int i = 0; i < n; ++i) {
                char ch = expression.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    continue;
                }
                List<Integer> leftArray = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightArray = diffWaysToCompute(expression.substring(i + 1, n));
                switch (ch) {
                    case '+':
                        for (int left : leftArray) {
                            for (int right : rightArray) {
                                res.add(left + right);
                            }
                        }
                        break;
                    case '-':
                        for (int left : leftArray) {
                            for (int right : rightArray) {
                                res.add(left - right);
                            }
                        }
                        break;
                    case '*':
                        for (int left : leftArray) {
                            for (int right : rightArray) {
                                res.add(left * right);
                            }
                        }
                        break;
                    case '/':
                        for (int left : leftArray) {
                            for (int right : rightArray) {
                                res.add(left / right);
                            }
                        }
                        break;
                    default:
                        assert(false);
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2+3*4"));
    }
}
