class Solution {
    public boolean checkValidString(String s) {
        Set<Integer> availableLeftParanthesis = new LinkedHashSet();
        Set<Integer> availableAsterix = new LinkedHashSet();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') availableLeftParanthesis.add(i);
            else if (s.charAt(i) == '*') availableAsterix.add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // if (availableLeftParanthesis.size() > 0) {
                //     System.out.println("jj");
                //     int index = availableLeftParanthesis.iterator().next();
                //     if (index < i) return false;
                //     availableLeftParanthesis.remove(index);
                // } else if (availableAsterix.size() > 0) {
                //     System.out.println("kk");
                //     int index = -1;
                //     Iterator<Integer> h = availableAsterix.iterator();
                //     while (h.hasNext()) {
                //         int q = h.next();
                //         if (q > i) {
                //             index = q;
                //             break;
                //         }
                //     }
                //     if (index < i) return false;
                //     availableAsterix.remove(index);
                // } else return false;
                int index = Integer.MAX_VALUE;
                index = availableLeftParanthesis.size() > 0 ? availableLeftParanthesis.iterator().next() : Integer.MAX_VALUE;
                if (availableAsterix.size() > 0) {
                    Iterator<Integer> h = availableAsterix.iterator();
                    while (h.hasNext()) {
                        int q = h.next();
                        if (q > i) {
                            index = Math.min(q, index);
                            break;
                        }
                    }
                }
                if (index == Integer.MAX_VALUE) return false;

                // int index = Math.min(
                //     availableAsterix.size() > 0 ? availableAsterix.iterator().next() : Integer.MAX_VALUE,
                //     availableALeftParanthesis.size() > 0 ? availableALeftParanthesis.iterator().next() : Integer.MAX_VALUE,
                // );
                availableAsterix.remove(index);
                availableLeftParanthesis.remove(index);
            } else if (s.charAt(i) == ')' && availableLeftParanthesis.contains(i)) {
                if (availableAsterix.size() > 0) {
                    System.out.println("a " + availableLeftParanthesis + "/ " + availableAsterix);
                    int index = availableAsterix.iterator().next();
                    if (index > i) return false;
                    availableAsterix.remove(index);
                    availableLeftParanthesis.remove(i);
                } else return false;
            }
        }

        return true;
    }
}


class Solution {
    boolean valid = false;
    private boolean checkValidString(String s, int currIndex, int leftParenSum, int rightParenSum) {
        if (currIndex == s.length()) {
            if (leftParenSum == rightParenSum) valid = true;
            return leftParenSum == rightParenSum;
        }
        if (rightParenSum > leftParenSum) return false;
        if (valid) return true;
        // System.out.println(currIndex);
        if (s.charAt(currIndex) == '*') {
            checkValidString(s, currIndex + 1, leftParenSum + 1, rightParenSum);
            checkValidString(s, currIndex + 1, leftParenSum, rightParenSum);
            if (leftParenSum > rightParenSum) checkValidString(s, currIndex + 1, leftParenSum, rightParenSum + 1);
        } else if (s.charAt(currIndex) == '('){
            return checkValidString(s, currIndex + 1, leftParenSum + 1, rightParenSum);
        } else {
            return checkValidString(s, currIndex + 1, leftParenSum, rightParenSum + 1);
        }
    }

    public boolean checkValidString(String s) {
        checkValidString(s, 0, 0, 0);
        return valid;
    }
}

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return isValidString(0, 0, s, memo);
    }

    private boolean isValidString(int index, int openCount, String str, int[][] memo) {
        // If reached end of the string, check if all brackets are balanced
        if (index == str.length()) {
            return (openCount == 0);
        }
        // If already computed, return memoized result
        if (memo[index][openCount] != -1) {
            System.out.println("Chala " + index + " " + openCount + " " + memo[index][openCount]);
            return memo[index][openCount] == 1;
        }
        boolean isValid = false;
        // If encountering '*', try all possibilities
        if (str.charAt(index) == '*') {
            isValid |= isValidString(index + 1, openCount + 1, str, memo); // Treat '*' as '('
            if (openCount > 0) {
                isValid |= isValidString(index + 1, openCount - 1, str, memo); // Treat '*' as ')'
            }
            isValid |= isValidString(index + 1, openCount, str, memo); // Treat '*' as empty
        } else {
            // Handle '(' and ')'
            if (str.charAt(index) == '(') {
                isValid = isValidString(index + 1, openCount + 1, str, memo); // Increment count for '('
            } else if (openCount > 0) {
                isValid = isValidString(index + 1, openCount - 1, str, memo); // Decrement count for ')'
            }
        }

        // Memoize and return the result
        memo[index][openCount] = isValid ? 1 : 0;
        System.out.println("setting " + " " + index + " " + openCount+ " " + memo[index][openCount]);
        return isValid;
    }
}