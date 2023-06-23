// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

// First thought was how to include graph in this was struggling
// Was thinking in a way that one type of stone can be common in one row other can be in one column and one row and
// and the last type will be alone one... But solving for each of them was a hassle.
// Then some design things came to mind and after lots of thinking got to a simplification that
// We need to group coordinates toghether which can support other stones removal and in that group only one remains.

// Later got to know that this pattern is called UNION-FIND.

class Solution {
    Map<Integer, Set<String>> xCoor = new HashMap(), yCoor = new HashMap();
    Set<String> visitedStones = new HashSet();
    List<String> totalStones = new ArrayList();

    private String generateCoordinateString(int x, int y) {
        return x + "," + y;
    }

    public void addValueToMap(int x, int y) {
        if (xCoor.containsKey(x)) xCoor.get(x).add(generateCoordinateString(x,y));
        else xCoor.put(x, new HashSet(Arrays.asList(generateCoordinateString(x,y))));

        if (yCoor.containsKey(y)) yCoor.get(y).add(generateCoordinateString(x,y));
        else yCoor.put(y, new HashSet(Arrays.asList(generateCoordinateString(x,y))));
    }

    public void solve(String coor) {
        visitedStones.add(coor);
        int x = Integer.valueOf(coor.split(",")[0]), y = Integer.valueOf(coor.split(",")[1]);
        for (String commonX: xCoor.get(x)) {
            if (!visitedStones.contains(commonX)) {
                solve(commonX);
            }
        }

        for (String commonY: yCoor.get(y)) {
            if (!visitedStones.contains(commonY)) {
                solve(commonY);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int result = 0;

        for (int i = 0; i < stones.length; i++) {
            addValueToMap(stones[i][0], stones[i][1]);
            totalStones.add(generateCoordinateString(stones[i][0], stones[i][1]));
        }

        for (String coor: totalStones) {
            if (!visitedStones.contains(coor)) {
                solve(coor);
                result++;
            }
        }

        return stones.length - result;
    }
}