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

    Stack<String> str = new Stack<>();

    List<String> resList = new LinkedList<>();

    Map<Integer, List<String>> wordMap = new HashMap<>();

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        if (s == null || "".equals(s) || wordDict == null || wordDict.isEmpty()) {
//            return null;
//        }
//        wordBreakCore(s, wordDict, 0);
//        return resList;
//    }

//    private void wordBreakCore(String s, List<String> wordDict, int start) {
//        if (start == s.length()) {
//            // 说明有一组解出来了
//            String res = str.stream().reduce((a, b) -> a + " " + b).orElse(null);
//            resList.add(res);
//            return;
//        }
//        for (int i = start; i < s.length(); i++) {
//            String substring = s.substring(start, i + 1);
//            if (wordDict.contains(substring)) {
//                str.push(substring);
//                wordBreakCore(s, wordDict, i + 1);
//
//                str.pop();
//            }
//        }
//    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakCore(s, wordDict, 0);
    }

    private List<String> wordBreakCore(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return new ArrayList<>();
        }
        List<String> list = wordMap.get(start);
        if (Objects.nonNull(list)) {
            return list;
        }
        List<String> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (wordDict.contains(substring)) {
                List<String> response = wordBreakCore(s, wordDict, i + 1);
                response.forEach(a -> {
                    String s1 = substring + " " + a;
                    res.add(s1);
                });
            }
        }
        wordMap.put(start, res);
        return wordMap.get(start);
    }

    /**
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}































