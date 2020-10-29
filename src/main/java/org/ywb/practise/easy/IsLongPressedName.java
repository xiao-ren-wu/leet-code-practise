package org.ywb.practise.easy;

/**
 * @author yuwenbo1
 * @date 2020/10/21 10:26 下午 星期三
 * @since 1.0.0
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || "".equals(name) || typed == null || "".equals(typed) || name.length() > typed.length()) {
            return false;
        }
        int i = 0, j = 0;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        while (i < nameChar.length && j < typedChar.length) {
            if (nameChar[i] == typedChar[j]) {
                i++;
            }
            if (i == 0 || typedChar[j] != nameChar[i - 1]) {
                return false;
            }
            j++;
        }
        while (j < typedChar.length){
            if (typedChar[j] == nameChar[i - 1]){
                j++;
            }else {
                return false;
            }
        }
        return i == nameChar.length;
    }

    public static void main(String[] args) {
        //"alex"
        //"aaleelx"
        //"pyplrz"
        //"ppyypllr"
        //"pyplrz"
        //"ppyypllr"
        //"alex"
        //"alexxr"
        System.out.println(new IsLongPressedName().isLongPressedName("alex", "alexxr"));
    }
}
