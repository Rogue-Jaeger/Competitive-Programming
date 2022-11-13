import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class AliceAndTheCake {

    public static void main(String[] Args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        long n, key;
        long sum = 0L;

        TreeMap<Long, Integer> original = new TreeMap<>();

        while (testCases > 0) {
            n = s.nextInt();
            while (n > 0) {
                key = s.nextInt();
                sum += key;
                original.put(key, original.get(key) == null ? 1 : original.get(key) + 1);
                n--;
            }

            if (evaluate(original, sum)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            sum = 0L;
            original.clear();
            testCases--;
        }
        s.close();
    }

    private static boolean evaluate(TreeMap<Long, Integer> original, long sum) {
        TreeMap<Long, Integer> toMake = new TreeMap<Long, Integer>() {{
            put(sum, 1);
        }};

        long floor, ceil;

        while (original.size() > 0 || toMake.size() > 0) {
            if (original.lastKey() > toMake.lastKey()) {
                return false;
            }

            if (Objects.equals(original.lastKey(), toMake.lastKey()) && Objects.equals(original.get(original.lastKey()), toMake.get(toMake.lastKey()))) {
                original.remove(original.lastKey());
                toMake.remove(toMake.lastKey());
            } else {
                floor = (long) Math.floor(toMake.lastKey().doubleValue() / 2);
                ceil = (long) Math.ceil(toMake.lastKey().doubleValue() / 2);

                toMake.put(floor, toMake.get(floor) == null ? 1 : toMake.get(floor) + 1);
                toMake.put(ceil, toMake.get(ceil) == null ? 1 : toMake.get(ceil) + 1);

                if (toMake.get(toMake.lastKey()) > 1) {
                    toMake.put(toMake.lastKey(), toMake.get(toMake.lastKey()) - 1);
                } else {
                    toMake.remove(toMake.lastKey());
                }
            }
        }

        return true;
    }
}
