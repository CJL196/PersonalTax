
# 个人所得税计算器

## 作者信息
- **姓名**：CJL
- **学号**：22330004
- **邮箱**：cjl196@foxmail.com


## 项目简介
基于Java实现的个人所得税计算器，提供阶梯税率计算、税率配置调整、税收起征点设置等功能。支持通过控制台交互操作，适用于个人所得税计算场景。

## 功能特性
- **阶梯税率计算**：支持5级超额累进税率计算
- **动态配置调整**：
  - 可修改任意税率等级的税率（0-100%区间）
  - 支持自定义起征点设置
- **实时交互界面**：
  - 数字菜单导航系统
  - 输入有效性校验（非负数/合法区间）
- **配置管理**：
  - 税率表格式化输出
  - 当前配置状态查看
- **异常处理**：
  - 非法输入自动拦截
  - 友好的错误提示

## 技术实现
- **核心类说明**：
  - `app`：主程序入口，处理用户交互
  - `calc`：计算引擎，实现税率配置和税款计算
  - `ReadFromConsole`：输入验证工具类
- **算法特点**：
  - 基于应税收入分段的递进计算
  - 数学公式：∑(各区间差额×对应税率)

## 环境要求
- JDK 1.8+
- 支持命令行操作的系统

## 编译运行
```bash
# 编译项目
make build

# 运行程序
make run

# 生成文档
make doc

# 清理构建
make clean
```

## 操作指南
1. 选择功能菜单（1-5）
2. 输入工资：
   - 示例输入：`8000`
3. 调整税率：
   - 选择税率等级（1-5）
   - 输入新税率（0.00-1.00）
4. 设置起征点：
   - 输入非负整数
5. 查看配置：
   - 输出格式化的税率表

## 典型输出示例
```text
+------------------------+
个人所得税计算器
1. 输入工资计算个人所得税
2. 调整税率
3. 调整个人所得税起征点
4. 打印当前配置
5. 退出
+------------------------+
~>4
+--------+-----------------------------------------------+--------+
| Level  | Taxable Income Amount                         | Rate%  |
+--------+-----------------------------------------------+--------+
| 1      | Not exceeding 500 yuan                        | 5      |
| 2      | The portion exceeding 500 to 2,000 yuan       | 10     |
| 3      | The portion exceeding 2,000 to 5,000 yuan     | 15     |
| 4      | The portion exceeding 5,000 to 20,000 yuan    | 20     |
| 5      | The portion exceeding 20,000 yuan             | 25     |
+--------+-----------------------------------------------+--------+
tax-free threshold: 1600
+------------------------+
个人所得税计算器
1. 输入工资计算个人所得税
2. 调整税率
3. 调整个人所得税起征点
4. 打印当前配置
5. 退出
+------------------------+
~>1
请输入您的工资: 114514
您的税收为: 26853.5
```

## 设计亮点
1. **分层架构**：
   - 视图层（app）：处理IO交互
   - 逻辑层（calc）：封装业务规则
   - 工具层（ReadFromConsole）：输入验证

2. **防御式编程**：
   - 工资/起征点非负校验
   - 税率区间校验（0-1）
   - 输入错误自动恢复机制

3. **可维护性**：
   - 税率等级参数化（size=5）
   - 边界值与税率分离存储
   - 配置修改实时生效

## 扩展方向
1. 增加税率等级配置
2. 实现税率历史版本管理
3. 添加年度累计计税功能
4. 支持不同地区的个性化税率

## UML图

![UML](assets/UML.png)

## 测试用例
测试用例设计说明：

1. **基础测试**：

- 工资低于起征点（1600）
- 工资恰好在第一税率区间上限（2100元）

2. **边界条件**：

- 工资处于税率区间临界值（如3600元测试第二区间上限）
- 工资超过最高税率区间（22600元）

3. **配置修改测试**：

- 修改税率等级1为10%
- 尝试设置非法税率（150%）

4. **异常处理**：

- 验证非法税率设置抛出异常

5. **覆盖率**：

- 覆盖所有税率区间计算
- 验证配置修改的持久性

该测试方案实现了：

1. 核心计算逻辑的全区间覆盖
2. 配置修改功能的正确性验证
3. 异常输入的防御性处理
4. 自动化测试执行框架
5. 与现有构建系统的集成