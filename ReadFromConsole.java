import java.util.Scanner;
/**
 * ReadFromConsole 类提供了从控制台读取整数和浮点数的方法。
 * 该类包含两个静态方法：readInt() 和 readDouble()，用于读取用户输入的整数和浮点数。
 */
public class ReadFromConsole {

    /**
     * 从控制台读取一个整数，并返回该值。
     * 该方法会提示用户输入一个整数，并进行输入验证，确保输入的是一个有效的32位整数。
     * 如果输入无效，会提示用户重新输入，直到输入有效为止。
     *
     * @return 用户输入的整数
     */
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        int number = 0; // 初始化变量
        boolean isValid = false; // 标志输入是否有效

        while (!isValid) {
            try {
                number = scanner.nextInt(); // 尝试读取整数
                isValid = true; // 如果成功读取，标记为有效
            } catch (Exception e) {
                // 捕获异常，处理非整数输入的情况
                System.out.println("输入无效，请输入一个32位整数！");
                scanner.nextLine(); // 清除错误输入
            }
        }
        // scanner 可以不关闭，因为它是方法内的局部变量
        return number;
    }
    /**
     * 从控制台读取一个浮点数，并返回该值。
     * 该方法会提示用户输入一个浮点数，并进行输入验证，确保输入的是一个有效的64位浮点数。
     * 如果输入无效，会提示用户重新输入，直到输入有效为止。
     *
     * @return 用户输入的浮点数
     */
    public static double readDouble() {
        Scanner scanner = new Scanner(System.in);
        double number = 0; // 初始化变量
        boolean isValid = false; // 标志输入是否有效

        while (!isValid) {
            try {
                number = scanner.nextDouble(); // 尝试读取浮点数
                isValid = true; // 如果成功读取，标记为有效
            } catch (Exception e) {
                // 捕获异常，处理非浮点数输入的情况
                System.out.println("输入无效，请输入一个64位浮点数！");
                scanner.nextLine(); // 清除错误输入
            }
        }
        // scanner 可以不关闭，因为它是方法内的局部变量
        return number;
    }

}