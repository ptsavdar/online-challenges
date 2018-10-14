import java.util.Random;

public class Rand47 {
    public static int rand04() {
        return (new Random()).nextInt(5);
    }

    public static int rand07() {
        int tmp = 5 * rand04() + rand04();

        return tmp == 24 ? rand07() : tmp % 8;
    }
}
