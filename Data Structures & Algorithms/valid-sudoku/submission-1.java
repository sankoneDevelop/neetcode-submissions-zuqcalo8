class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean row = true;
        for (char[] value : board) {
            HashSet<Integer> setRow = new HashSet<>();
            for (char c : value) {
                if (c != '.') {
                    if (setRow.contains((int) c)) {
                        row = false;
                        break;
                    } else {
                        setRow.add((int) c);
                    }
                }
            }
        }

        boolean col = true;
        for (int j = 0; j < board.length; j++) {
            HashSet<Integer> setCol = new HashSet<>();
            for (char[] chars : board) {
                if (chars[j] != '.') {
                    if (setCol.contains((int) chars[j])) {
                        col = false;
                        break;
                    } else {
                        setCol.add((int) chars[j]);
                    }
                }
            }
        }

        boolean cube = true;

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Integer> setCube = new HashSet<>();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (board[x][y] != '.') {
                            if (setCube.contains((int) board[x][y])) {
                                cube = false;
                                break;
                            } else {
                                setCube.add((int) board[x][y]);
                            }
                        }
                    }
                }
            }
        }

        return row && col && cube;
    }

}
