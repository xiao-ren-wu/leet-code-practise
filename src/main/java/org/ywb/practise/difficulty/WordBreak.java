package org.ywb.practise.difficulty;

import java.util.*;

/**
 * @author yuwenbo1
 * @date 2020/11/1 5:01 下午 星期日
 * @since 1.0.0
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordBreak {
//    public List<String> wordBreak(String s, List<String> wordDict) {
//
//    }

    private List<List<String>> wordsList = new ArrayList<>();

    private Stack<String> curStack = new Stack<>();

    private void splitWord(String str, int start, int begin) {
        if (begin == str.length()) {
            System.out.println(curStack);
            return;
        }
        for (int i = begin; i < str.length(); i++) {
            // 此时我们的单词为start-begin
            String word = str.substring(start, i + 1);
            curStack.push(word);
            splitWord(str, i+1, i+1);
            curStack.pop();
        }

    }

    public static void main(String[] args) {
        new WordBreak().splitWord("hello", 0, 0);
    }
}































