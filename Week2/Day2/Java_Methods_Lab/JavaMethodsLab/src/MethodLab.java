public class MethodLab {
    public static void main(String[] args) throws Exception {
        printProfile("Asha", 21, 5.6, true, 'A');
        printProfile("Ravi", 30, 5.9, false, 'B');

        System.out.println();

        System.out.println(average(1, 2, 2));

        System.out.println();

        System.out.println(fitsInByte(127));
        System.out.println(fitsInByte(128));
        System.out.println(fitsInByte(-129));

        System.out.println();

        System.out.println(addTexts("12", "30"));

        System.out.println();

        int r = boxTwice(21);
        System.out.println(r);

        System.out.println();

        describe(10);

        System.out.println();

        // Integer caches -128 to 127, so == compares the same object for 127 but two different objects for 1000. Use equals for wrapper values.
        Integer a = 127;
        Integer b = 127;
        System.out.println("127: " + "equals=" + sameValue(a, b) + "  ==" + (a == b));
        a = 1000;
        b = 1000;
        System.out.println("1000: " + "equals=" + sameValue(a, b) + "  ==" + (a == b));

        System.out.println();

        System.out.println(truncate(9.99));
        System.out.println(truncate(-9.99));

        System.out.println();

        System.out.println(widen(7));

        System.out.println();

        overflowDemo();

        System.out.println();

        System.out.println(shiftLetter('a', 2));

        System.out.println();

        describeValue(5);
        describeValue(2.5);
        describeValue("hi");
        describeValue('A');
        describeValue(5L);

        System.out.println();

        int x = 1;
        tryChange(x);
        System.out.println("x = " + x);

        System.out.println();

        StringBuilder sb = new StringBuilder("Hi");
        appendBang(sb);
        System.out.println(sb);

        System.out.println();

        // the parameter holds a copy of the reference. Pointing the copy at a new object does not move the caller's variable.
        sb = new StringBuilder("Hi");
        replaceBuilder(sb);
        System.out.println(sb);

        System.out.println();

        String s = "java";
        shout(s);
        System.out.println(s);

        System.out.println();

        StringBuilder sb_a = new StringBuilder("cat");
        StringBuilder sb_b = sb_a;
        sb_b.append("s");
        System.out.println(sb_a);

        System.out.println();

        compareRefs();

        System.out.println();

        System.out.println(safeLength(null));
        System.out.println(safeLength("hello"));

        System.out.println();

        System.out.println(initials("ashu", "jauhari"));

        System.out.println();

        System.out.println(clean("  HeLLo "));

        System.out.println();

        System.out.println(isPalindromeWord("Level"));
        System.out.println(isPalindromeWord("Java"));

        System.out.println();

        System.out.println(maskEmail("asha@mail.com"));

        System.out.println();

        System.out.println(buildCsv("a", "b", "c"));

        System.out.println();

        System.out.println(edit("Hello World"));

        System.out.println();

        System.out.println("String +=     : " + timeJoin(false) + " ns");
        System.out.println("StringBuilder :    " + timeJoin(true) + " ns");

        System.out.println();

        System.out.println(safeAppend(new StringBuffer("Hi"), " there"));

        System.out.println();

        System.out.println(formatReceipt("Asha", 3, 9.99));
        System.out.println(formatReceipt("Ravi", 2, 4.5));

        System.out.println();

        System.out.println(toFahrenheit(0));
        System.out.println(toFahrenheit(37.5));
        System.out.println(toFahrenheit(-40));

        System.out.println();

        System.out.println(percent(45, 60));
        System.out.println(percent(1, 3));

        System.out.println();
        
        System.out.println(describeInt(255));
        System.out.println(describeInt(8));

        System.out.println();

        int x1 = 1, y = 2;
        swap(x1, y);
        System.out.println("outside: x=" + x1 + " y=" + y);
        // x and y did not change because Java passes by value, so the swap method only changed it's own local copies of the variables.

        System.out.println();

        StringBuilder sb1 = new StringBuilder("Rao");
        addTitle(sb1);
        System.out.println(sb1);
        String s1 = "Rao";
        addTitleToString(s1);   // result ignored
        System.out.println(s1);
        System.out.println(addTitleToString(s1));
        // The builder changed because it copyed a reference to the StringBuilder object on the heap, which the method then modified. The String did not change because the method assigned a new reference to the variable instead of modifying the String object on the heap (though it couldn't because Java Strings are immutable).

        System.out.println();

        System.out.println(countChar("banana", 'a'));
        System.out.println(countChar("banana", 'z'));
        System.out.println(capitalize("jAVA"));

        System.out.println();

        System.out.println(padLeft("42", 5, '0'));
        System.out.println(padLeft("12345", 3, '0'));
        System.out.println(joinWithDash("ab", 3));
        System.out.println(joinWithDash("x", 1));

        System.out.println();
                
        System.out.println(roundHalfUp(2.5));
        System.out.println(roundHalfUp(2.4));
        System.out.println(roundHalfUp(7.0));

        System.out.println();

        System.out.println(factorialInt(5));
        System.out.println(factorialLong(5));
        System.out.println(factorialInt(13));
        System.out.println(factorialLong(13));
        System.out.println(factorialLong(20));
        // The result for factorialInt(13) is wrong because the multiplication overflowed, causing it to turn into a negative number.


    }

    public static void printProfile(String name, int age, double height, boolean student, char grade) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + student);
        System.out.println("Grade: " + grade);
    }

    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static boolean fitsInByte(int value) {
        return value >= -128 && value <= 127;
    }

    public static int addTexts(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public static Integer boxTwice(int x) {
        Integer v = x;
        return Integer.valueOf(x * 2);
    }

    public static void describe(Integer n) {
        System.out.println("Binary: " + Integer.toBinaryString(n));
        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Compare with 10.5: " + Double.compare(n, 10.5));
    }

    public static boolean sameValue(Integer a, Integer b) {
        return a.equals(b);
    }

    public static int truncate(double d) {
        return (int) d;
    }

    public static double widen(int i) {
        return (double) i;
    }

    public static void overflowDemo() {
        int big = 130; 
        byte b = (byte) big;
        // 130 is 2 more than the byte maximum of 127, so it wraps: 130 - 256 = -126.
        System.out.println(b);
    }

    public static char shiftLetter(char c, int by) {
        return (char) (c + by);
    }

    public static void describeValue(int value) {
        System.out.println("int: " + value);
    }

    public static void describeValue(double value) {
        System.out.println("double: " + value);
    }

    public static void describeValue(String value) {
        System.out.println("String: " + value);
    }

    public static void tryChange(int n) {
        n = 99;
    }

    public static void appendBang(StringBuilder sb) {
        sb.append("!");
    }

    public static void replaceBuilder(StringBuilder sb) {
        sb = new StringBuilder("New");
    }

    public static void shout(String s) {
        s = s.toUpperCase();
    }

    public static void compareRefs() {
        String s1 = "java", s2 = "java", s3 = new String("java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }

    public static int safeLength(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    public static String initials(String first, String last) {
        return (first.substring(0, 1) + last.substring(0, 1)).toUpperCase();
    }

    public static String clean(String raw) {
        return raw.trim().toLowerCase();
    }

    public static boolean isPalindromeWord(String w) {
        return w.equalsIgnoreCase(new StringBuilder(w).reverse().toString());
    }

    public static String maskEmail(String email) {
        char first = email.charAt(0);
        int idx = email.indexOf('@');
        String masked = "*".repeat(idx - 1);
        return first + masked + email.substring(idx);
    }

    public static String buildCsv(String a, String b, String c) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(",");
        sb.append(b);
        sb.append(",");
        sb.append(c);
        return sb.toString();
    }

    public static String edit(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(0, "[");
        sb.append("]");
        sb.replace(7, 12, "Java");
        sb.deleteCharAt(6);
        return sb.toString();
    }

    public static long timeJoin(boolean useBuilder) {
        if (useBuilder) {
            StringBuilder sb = new StringBuilder();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                sb.append(i);
            }
            long end = System.currentTimeMillis();
            return end - start;
        } else {
            long start = System.currentTimeMillis();
            String s = "";
            for (int i = 0; i < 10000; i++) {
                s += i;
            }
            long end = System.currentTimeMillis();
            return end - start;
        }
    }

    // use StringBuffer when several threads may change the same text, because its methods are synchronized. Otherwise use the faster StringBuilder.
    public static String safeAppend(StringBuffer sb, String part) {
        sb.append(part);
        return sb.toString();
    }

    public static String formatReceipt(String customer, int quantity, double unitPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.toUpperCase()).append("\n");
        sb.append("Qty: ").append(unitPrice).append(" | Price: ").append(unitPrice).append("\n");
        double total = quantity * unitPrice;
        sb.append("Total: ").append(total).append(" (whole: ").append((int) total).append(")\n");
        return sb.toString();
    }

    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static int percent(int obtained, int total) {
        return (int) ((double) obtained / total * 100);
    }

    public static String describeInt(int n) {
        return n + " -> binary " + Integer.toBinaryString(n) + ", hex " + Integer.toHexString(n) + ", octal " + Integer.toOctalString(n);
    }

    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
        System.out.println("inside: a=" + a + " b=" + b);
    }

    public static void addTitle(StringBuilder name) {
        name.insert(0, "Dr. ");
    }

    public static String addTitleToString(String name) {
        return "Dr. " + name;
    }

    public static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static String padLeft(String s, int width, char fill) {
        if (s.length() >= width) return s;
        return String.valueOf(fill).repeat(width - s.length()) + s;
    }

    public static String joinWithDash(String s, int times) {
        return ("-" + s).repeat(times).substring(1);
    }

    public static int roundHalfUp(double d) {
        return (int) (d + 0.5);
    }

    public static int factorialInt(int n) {
        if (n == 1) return 1;
        return n * factorialInt(n - 1);
    }

    public static long factorialLong(int n) {
        if (n == 1) return 1;
        return n * factorialLong(n - 1);
    }
}
