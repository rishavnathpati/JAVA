import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int s = 0, num = i;
            while (num != 0) {
                s += num % 10;
                num /= 10;
            }

            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }

        int winners = 0;
        for (int i : counts.keySet()) {
            winners = Math.max(winners, counts.get(i));
        }

        int ans = 0;
        for (int i : counts.keySet()) {
            if (counts.get(i) == winners) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
