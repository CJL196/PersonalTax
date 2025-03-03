/**
 * 计算税收的类。
 * 提供了计算税收、打印税率设置、设置税率和基数等功能。
 */
public class calc {
    private int size = 5;
    double[] tax_rate = new double[size];
    double[] taxable_income_bound = new double[size - 1];
    private int base = 1600;

    /**
     * 构造函数，初始化税率和应税收入边界。
     */
    public calc() {
        // 初始化设置
        tax_rate[0] = 0.05;
        tax_rate[1] = 0.10;
        tax_rate[2] = 0.15;
        tax_rate[3] = 0.20;
        tax_rate[4] = 0.25;
        taxable_income_bound[0] = 500;
        taxable_income_bound[1] = 2000;
        taxable_income_bound[2] = 5000;
        taxable_income_bound[3] = 20000;
    }

    /**
     * 计算给定收入的税收。
     *
     * @param income 收入
     * @return 计算出的税收
     */
    public double calcTax(double income) {
        // 计算税收
        if (income <= base) {
            return 0;
        } else {
            income -= base;
        }
        double tax = 0;
        if (income <= taxable_income_bound[0]) {
            tax = income * tax_rate[0];
            return tax;
        } else {
            tax += taxable_income_bound[0] * tax_rate[0];
        }
        for (int i = 1; i < size - 1; i++) {
            if (income > taxable_income_bound[i]) {
                tax += ((taxable_income_bound[i] - taxable_income_bound[i - 1]) * tax_rate[i]);
            } else {
                tax += ((income - taxable_income_bound[i - 1]) * tax_rate[i]);
                return tax;
            }
        }
        tax += ((income - taxable_income_bound[size - 2]) * tax_rate[size - 1]);
        return tax;
    }

    /**
     * 打印当前的税率设置。
     */
    public void printSettings() {
        String line = "+--------+-----------------------------------------------+--------+";
        System.out.println(line);
        System.out.printf("| %-6s | %-45s | %-6s |\n", "Level", "Taxable Income Amount", "Rate%");
        System.out.println(line);

        System.out.printf("| %-6d | %-45s | %-6.0f |\n", 1, "Not exceeding 500 yuan", tax_rate[0] * 100);
        System.out.printf("| %-6d | %-45s | %-6.0f |\n", 2, "The portion exceeding 500 to 2,000 yuan",
                tax_rate[1] * 100);
        System.out.printf("| %-6d | %-45s | %-6.0f |\n", 3, "The portion exceeding 2,000 to 5,000 yuan",
                tax_rate[2] * 100);
        System.out.printf("| %-6d | %-45s | %-6.0f |\n", 4, "The portion exceeding 5,000 to 20,000 yuan",
                tax_rate[3] * 100);
        System.out.printf("| %-6d | %-45s | %-6.0f |\n", 5, "The portion exceeding 20,000 yuan", tax_rate[4] * 100);
        System.out.println(line);
        System.out.printf("tax-free threshold: %d\n", base);

    }

    /**
     * 设置指定级别的税率。
     *
     * @param level 税率级别（1到5）
     * @param rate  税率（0到1之间）
     * @throws IllegalArgumentException 如果级别或税率无效
     */
    public void setTaxRate(int level, double rate) {
        if (level < 1 || level > size) {
            throw new IllegalArgumentException("Level must be between 1 and " + size);
        }
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Rate must be between 0 and 1");
        }
        tax_rate[level - 1] = rate;
    }

    /**
     * 设置税收基数。
     *
     * @param base 税收基数
     * @throws IllegalArgumentException 如果基数为负
     */
    public void setBase(int base) {
        if (base < 0) {
            throw new IllegalArgumentException("Base must be non-negative");
        }
        this.base = base;
    }

    /**
     * 获取税率级别的数量。
     *
     * @return 税率级别的数量
     */
    public int get_size() {
        return size;
    }
}