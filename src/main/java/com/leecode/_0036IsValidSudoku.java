package com.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuyuze
 * @date 2025/5/8 14:12
 */
public class _0036IsValidSudoku {

    /**
     * 36. 有效的数独
     * 中等
     * 相关标签
     * 相关企业
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *
     *
     * 注意：
     *
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用 '.' 表示。
     *
     *
     * 示例 1：
     *
     *
     * 输入：board =
     * [['5','3','.','.','7','.','.','.','.']
     * ,['6','.','.','1','9','5','.','.','.']
     * ,['.','9','8','.','.','.','.','6','.']
     * ,['8','.','.','.','6','.','.','.','3']
     * ,['4','.','.','8','.','3','.','.','1']
     * ,['7','.','.','.','2','.','.','.','6']
     * ,['.','6','.','.','.','.','2','8','.']
     * ,['.','.','.','4','1','9','.','.','5']
     * ,['.','.','.','.','8','.','.','7','9']]
     * 输出：true
     * 示例 2：
     *
     * 输入：board =
     * [['8','3','.','.','7','.','.','.','.']
     * ,['6','.','.','1','9','5','.','.','.']
     * ,['.','9','8','.','.','.','.','6','.']
     * ,['8','.','.','.','6','.','.','.','3']
     * ,['4','.','.','8','.','3','.','.','1']
     * ,['7','.','.','.','2','.','.','.','6']
     * ,['.','6','.','.','.','.','2','8','.']
     * ,['.','.','.','4','1','9','.','.','5']
     * ,['.','.','.','.','8','.','.','7','9']]
     * 输出：false
     * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     *
     *
     * 提示：
     *
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字（1-9）或者 '.'
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] colSets = new HashSet[board.length];
        HashSet<Character>[] blockSets = new HashSet[board.length];
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                if (colSets[j] == null) {
                    colSets[j] = new HashSet<>();
                }
                if (colSets[j].contains(board[i][j])) {
                    return false;
                }
                int block = i / 3 + (j / 3) * 3;
                if (blockSets[block] == null) {
                    blockSets[block] = new HashSet<>();
                }
                if (blockSets[block].contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
                colSets[j].add(board[i][j]);
                blockSets[block].add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
