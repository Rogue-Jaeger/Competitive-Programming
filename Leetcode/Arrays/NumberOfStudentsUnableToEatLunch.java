// This below case failed for my earlier approach I was stopping at students index 1 which contains value 1
// students = [0,1,0,0,0,0]
// sandwiches = [1,0,0,0,1,1]

class Solution {
    private int calculateStudentsLeft(int[] sandwiches, int minimumValue, int toCheckValue) {
        int i;
        for (i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == toCheckValue) {
                if (minimumValue > 0) minimumValue--;
                else break;
            }
        }
        return sandwiches.length - i;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int squareSandwiches = 0, squarePreference = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 1) squarePreference++;
            if (sandwiches[i] == 1) squareSandwiches++;
        }

        if (squarePreference < squareSandwiches) {
            return calculateStudentsLeft(sandwiches, squarePreference, 1);
        } else if (squarePreference > squareSandwiches) {
            squarePreference = students.length - squarePreference;
            return calculateStudentsLeft(sandwiches, squarePreference, 0);
        }

        return 0;
    }
}
