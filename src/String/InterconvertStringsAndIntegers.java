package String;

public class InterconvertStringsAndIntegers {
    public static void main(String[] args) {
        int num = -324;
        System.out.println(intToString(num));

        String input = "-324";
        System.out.println(stringToInt(input));
    }

    private static int stringToInt(String input) {
        int index = input.charAt(0) == '-' ? 1 : 0;
        int number = 0;
        while (index < input.length()) {
            number = number * 10 + (input.charAt(index) - '0');
            index++;
        }
        return input.charAt(0) == '-' ? -number : number;
    }

    private static String intToString(int number) {
        boolean isNeg = false;
        if (number < 0) {
            isNeg = true;
            number = -number;
        }
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(number % 10);
            number = number / 10;
        }

        return isNeg ? sb.append('-').reverse().toString() : sb.reverse().toString();
    }
}
