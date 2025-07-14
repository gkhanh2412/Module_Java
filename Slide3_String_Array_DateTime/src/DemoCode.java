import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class DemoCode {
    public static void main(String[] args) {
        stringDemo();
        arrayDemo();
        array2DDemo();
        dateTimeDemo();
        dateTimeAdvanced();
    }

    // 1. Demo String
    public static void stringDemo() {
        System.out.println("--- String Demo ---");
        // Khởi tạo các chuỗi
        String s1 = "";
        String s2 = "Java programming";
        String s3 = new String("      Java programming            ");
        String s4 = "JAVA programming";

        // Các phương thức cơ bản của String
        System.out.println("Length: " + s2.length());
        System.out.println("Second char: " + s2.charAt(1));
        System.out.println("Upper case: " + s2.toUpperCase());
        System.out.println("Lower case: " + s2.toLowerCase());
        System.out.println("SubString: " + s2.substring(2, 8));
        System.out.println("Contains 'Java'? " + s1.contains("Java"));
        System.out.println("Contains 'Java'? " + s2.contains("Java"));
        System.out.println("Replace 'Java' -> 'Python': " + s2.replace("Java", "Python"));
        System.out.println(s2.indexOf("Java"));
        System.out.println(s2.lastIndexOf("Java"));
        System.out.println("String 4 after remove whitespace: " + s3.trim());
        System.out.println("String 4 equals String 2? " + s2.equals(s4));
        System.out.println("String 4 equalsIgnoreCase String 2? " + s2.equalsIgnoreCase(s4));
        System.out.println("CompareTo: " + s2.compareTo(s4));
        System.out.println("Starts with 'Java'? " + s2.startsWith("Java"));

        // Tách chuỗi bằng split()
        String[] words = s2.split(" ");
        System.out.println("Split words:");
        for (String w : words) System.out.println(w);
        System.out.println("Is Empty? " + s1.isEmpty());
        System.out.println("String.valueOf(123): " + String.valueOf(123));

    }

    // 2. Demo mảng 1 chiều
    public static void arrayDemo() {
        System.out.println("\n--- Array 1D Demo ---");
        int[] nums = {1, 3, 5, 7};
        System.out.println("Length of array: " + nums.length);
        System.out.println("First element: " + nums[0]);
        System.out.println("Last element: " + nums[nums.length - 1]);

        // Duyệt mảng bằng vòng lặp for
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Element at index " + i + ": " + nums[i]);
        }

        // enhanced for loop
        for(int number : nums) {
            System.out.println(number);
        }

        // Sắp xếp mảng
        int[] array2 = {1,2,4,8,29,9,0};
        Arrays.sort(array2);
        System.out.print("\nArray after sorted: ");
        System.out.println(Arrays.toString(array2));

        // Đảo ngược mảng
        for(int i =0, j = array2.length-1; i<j; i++, j--) {
            int temp = array2[i];
            array2[i] = array2[j];
            array2[j] = temp;
        }
        System.out.print("Array after reversed: ");
        System.out.println(Arrays.toString(array2));

        // Phép gán mảng
        int[] array3 = array2;

        // Clone mảng
        int[] array4 = array3.clone();

        // So sánh 2 mảng
        System.out.println("Array 2 equals Array 3? " + Arrays.equals(array2, array3));
        System.out.println("Array 2 equals Array 4? " + Arrays.equals(array2, array4));
    }

    // 3. Demo mảng 2 chiều
    public static void array2DDemo() {
        System.out.println("\n--- Array 2D Demo ---");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 4. Ngày giờ cơ bản
    public static void dateTimeDemo(){
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalTime time = LocalTime.now();
        System.out.println("Time Now: " + time);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("RightNow: " + dt);

        LocalDate myBirthday;
        myBirthday = LocalDate.of(2004, 07, 12);
        System.out.println("My BirthDay: " + myBirthday);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String formatted = dt.format(formatter); //format thanh string
        System.out.println("Dinh Dang: " + formatted);
    }

    // 5. Ngày giờ nâng cao: parse, localized
    public static void dateTimeAdvanced() {
        // 1. parse():  chuyển từ chuỗi sang ngày/giờ
        String input = "2025-07-10";
        LocalDate parsedDate = LocalDate.parse(input);
        System.out.println("Parsed Date: " + parsedDate);

        // 2. Localized Date
        LocalDate now = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("Ngày (FULL): " + now.format(fullDate));

        // 3. Localized Time
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter shortTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println("Giờ (SHORT): " + nowTime.format(shortTime));

        // 4. Localized DateTime
        LocalDateTime nowDT = LocalDateTime.now();
        DateTimeFormatter dtMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Ngày giờ (MEDIUM): " + nowDT.format(dtMedium));

        // 5. Localized DateTime với 2 kiểu
        DateTimeFormatter dtCustom = DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.LONG, FormatStyle.SHORT);
        System.out.println("Ngày giờ (LONG + SHORT): " + nowDT.format(dtCustom));
    }
}

