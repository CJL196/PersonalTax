/**
 * 个人所得税计算器应用程序
 * 
 * <p>此程序允许用户计算个人所得税、调整税率、调整个人所得税起征点以及打印当前配置。</p>
 * 
 * <p>主要功能包括：</p>
 * <ul>
 *   <li>输入工资计算个人所得税</li>
 *   <li>调整税率</li>
 *   <li>调整个人所得税起征点</li>
 *   <li>打印当前配置</li>
 *   <li>退出程序</li>
 * </ul>
 * 
 * <p>程序通过控制台与用户交互，用户可以根据提示输入相应的选项和数据。</p>
 * 
 * <p>注意：此程序假设存在一个名为 ReadFromConsole 的类用于从控制台读取输入，
 * 以及一个名为 calc 的类用于计算税收和管理税率配置。</p>
 * 
 * @version 1.0
 * @author CJL
 */
public class app{
    public static void main(String[] args) {
        calc calculator = new calc();
        // ReadFromConsole r = new ReadFromConsole();
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
            choice = ReadFromConsole.readInt();
            if (choice == 1) {
                boolean valid = false;
                int salary = 0;
                while (!valid) {
                    System.out.print("请输入您的工资: ");
                    salary = ReadFromConsole.readInt();
                    if (salary < 0) {
                        System.out.println("工资必须为非负数！");
                        continue;
                    }
                    valid = true;
                }
                
                double tax = calculator.calcTax(salary);
                System.out.println("您的税收为: " + tax);
            }
            else if (choice == 2) {
                boolean valid = false;
                int level=0;
                double rate = 0;
                // 判断输入是否合法
                while (!valid) {
                    System.out.print("请输入税率等级: ");
                    level = ReadFromConsole.readInt();
                    System.out.print("请输入税率:(示例:0.10)");
                    rate = ReadFromConsole.readDouble();
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
                calculator.setTaxRate(level, rate);
            }
            else if(choice == 3){

                boolean valid = false;
                int base = 0;
                while (!valid) {
                    
                    System.out.print("请输入个人所得税起征点: ");
                    base = ReadFromConsole.readInt();
                    if (base < 0) {
                        System.out.println("起征点必须为非负数！");
                        continue;
                    }
                    valid = true;
                }
                calculator.setBase(base);
            }
            else if (choice == 4) {
                calculator.printSettings();
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