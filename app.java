import java.util.Scanner;

class ReadIntFromConsole {

    /**
     * 从控制台读取一个整数，并返回该值。
     *
     * @param prompt 提示信息（例如："请输入一个整数: "）
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

public class app{
    public static void main(String[] args) {
        calc calculator = new calc();
        // ReadIntFromConsole r = new ReadIntFromConsole();
        int choice = 0;
        while (true) {
            System.out.println("+------------------------+");
            System.out.println("个人所得税计算器");
            System.out.println("1. 输入工资计算个人所得税");
            System.out.println("2. 调整税率");
            System.out.println("3. 调整个人所得税起征点");
            System.out.println("4. 打印当前配置");
            System.out.println("5. 退出");
            System.out.println("+------------------------+");
            System.out.printf("~>");
            choice = ReadIntFromConsole.readInt();
            if (choice == 1) {
                boolean valid = false;
                int salary = 0;
                while (!valid) {
                    System.out.print("请输入您的工资: ");
                    salary = ReadIntFromConsole.readInt();
                    if (salary < 0) {
                        System.out.println("工资必须为非负数！");
                        continue;
                    }
                    valid = true;
                }
                
                double tax = calculator.calc_tax(salary);
                System.out.println("您的税收为: " + tax);
            }
            else if (choice == 2) {
                boolean valid = false;
                int level=0;
                double rate = 0;
                // 判断输入是否合法
                while (!valid) {
                    System.out.print("请输入税率等级: ");
                    level = ReadIntFromConsole.readInt();
                    System.out.print("请输入税率:(示例:0.10)");
                    rate = ReadIntFromConsole.readDouble();
                    if (level < 1 || level > calculator.get_size()) {
                        System.out.printf("Level must be between 1 and %d\n", calculator.get_size());
                        continue;
                    }
                    if (rate < 0 || rate > 1) {
                        System.out.printf("Rate must be between 0 and 1\n");
                        continue;
                    }
                    valid = true;
                }
                calculator.set_tax_rate(level, rate);
            }
            else if(choice == 3){

                boolean valid = false;
                int base = 0;
                while (!valid) {
                    
                    System.out.print("请输入个人所得税起征点: ");
                    base = ReadIntFromConsole.readInt();
                    if (base < 0) {
                        System.out.println("起征点必须为非负数！");
                        continue;
                    }
                    valid = true;
                }
                calculator.set_base(base);
            }
            else if (choice == 4) {
                calculator.print_settings();
            }
            else if (choice == 5) {
                break;
            }
            else {
                System.out.println("输入无效，请输入一个整数！");
                continue;
            }

        }
    }
}