public class Problem4 {
    public static int maxPalindrome(int digits) {
        int maxNo = 0;
        int minNo = (int)Math.pow(10, digits - 1);
        for(int i = 0; i < digits; i++) {
            maxNo += Math.pow(10, i) * 9;
        }
        int maxNumber = maxNo * maxNo;
        int minNumber = minNo * minNo;

        while (maxNumber > minNumber) {
            if (isPalindrome(maxNumber)) {
                return maxNumber;
            }

            maxNumber--;
        }

        return -1;
    }

    public static boolean isPalindrome(int num) {
        String numStr = Integer.toString(num);
        int median = (int)Math.ceil((double)(numStr.length() - 1) / (double) 2);
        for(int i = 0; i < median; i++) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
