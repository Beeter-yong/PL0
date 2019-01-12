package pl;

/**
 *　　这个类只是包含了报错函数以及错误计数器。
 */
public class Err {
	/**
	 * 错误计数器，编译过程中一共有多少个错误
	 */
	public static int err = 0;
	static boolean judge = true;
	static String str = null;
	/**
	 * 报错函数
	 * @param errcode 错误码
	 */
	public static void report(int errcode) {
		judge = false;
		char[] s = new char[PL0.lex.cc-1];
		java.util.Arrays.fill(s, ' ');
		String space = new String(s);
		PL0.fa1.println("****" + space + "!" + errcode);
		err ++;
		switch(errcode) {
		case 1:
			str = "把 = 写成了 :=";
			break;
		case 2:
			str = "常量说明 = 后应是数字";
			break;
		case 3:
			str = "常量说明标识后应是 =";
			break;
		case 4:
			str = "procedure后应为标识符";
			break;
		case 5:
			str = "漏掉了逗号或者分号";
			break;
		case 10:
			str = " 缺少分号";
			break;
		case 11:
			str = "变量未找到或标识符未声明";
			break;
		case 12:
			str = "赋值语句格式错误";
			break;
		case 13:
			str = "没有检测到赋值符号";
			break;
		case 14:
			str = "call后应为标识符";
			break;
		case 15:
			str = "call后标识符应为过程";
			break;
		case 16:
			str = "缺少end或分号";
			break;
		case 17:
			str = "缺少end或分号";
			break;
		case 18:
			str = "缺少do";
			break;
		case 19:
			str = "--后應該跟標識符";
			break;
		case 21:
			str = "因子中不能为过程";
			break;
		case 22:
			str = "缺少右括号";
			break;
		case 32:
			str = "read()中的标识符不是变量";
			break;
		case 33:
			str = "write中应为完整表达式";
			break;
		case 34:
			str = "格式错误，应是左括号";
			break;
		case 35:
			str = "read()中应为声明过的变量";
			break;
		case 81:
			str = "格式错误，应是右括号";
			break;
		case 82:
			str = "标识符未声明";
			break;
			default:
				str = "没有具体建议！！！";
		}
		View.InText("程序出错！！！" + str);
	}
}
