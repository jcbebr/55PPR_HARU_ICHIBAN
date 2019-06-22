package br.udesc.ppr.haruichiban.control.composite;

import br.udesc.ppr.haruichiban.control.builder.Board;
import br.udesc.ppr.haruichiban.model.card.nenuphar.BrightNenupharRedFlower;
import br.udesc.ppr.haruichiban.model.card.nenuphar.BrightNenupharYellowFlower;
import br.udesc.ppr.haruichiban.model.card.nenuphar.DarkNenupharRedFlower;
import br.udesc.ppr.haruichiban.model.card.nenuphar.DarkNenupharYellowFlower;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 21/06/2019
 */
public abstract class ScoreCalculation {

    private static boolean isEquals(Class c, Class... c1) {
        for (Class classes : c1) {
            if (c.equals(classes)) {
                return true;
            }
        }
        return false;
    }

    public static int[] squareScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize() - 1; i++) {
            for (int j = 0; j < board.getSize() - 1; j++) {
                if (squareScoreCalcCondition(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                    r++;
                }
                if (squareScoreCalcCondition(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                    y++;
                }
            }
        }
        return new int[]{r, y};
    }

    public static boolean squareScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2);
    }

    public static int[] horizontalFourScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 3; j++) {
                if (horizontalFourScoreCalcCondition(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                    r++;
                }
                if (horizontalFourScoreCalcCondition(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                    y++;
                }
            }
        }
        return new int[]{r, y};
    }

    public static boolean horizontalFourScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i, j + 3).getClass(), c1, c2);
    }

    public static int[] verticalFourScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (verticalFourScoreCalcCondition(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                    r++;
                }
                if (verticalFourScoreCalcCondition(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                    y++;
                }
            }
        }
        return new int[]{r, y};
    }

    public static boolean verticalFourScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j).getClass(), c1, c2);
    }

    public static int[] diagonalDecrescentFourScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 0; j < board.getSize() - 3; j++) {
                if (diagonalDecrescentFourScoreCalcCondition(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                    r++;
                }
                if (diagonalDecrescentFourScoreCalcCondition(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                    y++;
                }
            }
        }
        return new int[]{r, y};
    }

    public static boolean diagonalDecrescentFourScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j + 3).getClass(), c1, c2);
    }

    public static int[] diagonalCrescentFourScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize() - 3; i++) {
            for (int j = 3; j < board.getSize(); j++) {
                if (diagonalCrescentFourScoreCalcCondition(i, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                    r++;
                }
                if (diagonalCrescentFourScoreCalcCondition(i, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                    y++;
                }
            }
        }
        return new int[]{r, y};
    }

    public static boolean diagonalCrescentFourScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j - 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j - 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j - 3).getClass(), c1, c2);
    }

    public static int[] verticalFiveScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int j = 0; j < board.getSize(); j++) {
            if (verticalFiveScoreCalcCondition(0, j, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                r++;
            }
            if (verticalFiveScoreCalcCondition(0, j, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                y++;
            }
        }
        return new int[]{r, y};
    }

    public static boolean verticalFiveScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j).getClass(), c1, c2);
    }

    public static int[] horizontalFiveScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (horizontalFiveScoreCalcCondition(i, 0, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
                r++;
            }
            if (horizontalFiveScoreCalcCondition(i, 0, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
                y++;
            }
        }
        return new int[]{r, y};
    }

    public static boolean horizontalFiveScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i, j + 3).getClass(), c1, c2)
                && isEquals(board.get(i, j + 4).getClass(), c1, c2);
    }

    public static int[] diagonalDecrescentFiveScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        if (diagonalDecrescentFiveScoreCalcCondition(0, 0, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
            r++;
        }
        if (diagonalDecrescentFiveScoreCalcCondition(0, 0, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
            y++;
        }
        return new int[]{r, y};
    }

    public static boolean diagonalDecrescentFiveScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j + 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j + 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j + 3).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j + 4).getClass(), c1, c2);
    }

    public static int[] diagonalCrescentFiveScoreCalc(Board board) {
        int r = 0;
        int y = 0;
        if (diagonalCrescentFiveScoreCalcCondition(0, 4, BrightNenupharRedFlower.class, DarkNenupharRedFlower.class, board)) {
            r++;
        }
        if (diagonalCrescentFiveScoreCalcCondition(0, 4, BrightNenupharYellowFlower.class, DarkNenupharYellowFlower.class, board)) {
            y++;
        }
        return new int[]{r, y};
    }

    public static boolean diagonalCrescentFiveScoreCalcCondition(int i, int j, Class c1, Class c2, Board board) {
        return isEquals(board.get(i, j).getClass(), c1, c2)
                && isEquals(board.get(i + 1, j - 1).getClass(), c1, c2)
                && isEquals(board.get(i + 2, j - 2).getClass(), c1, c2)
                && isEquals(board.get(i + 3, j - 3).getClass(), c1, c2)
                && isEquals(board.get(i + 4, j - 4).getClass(), c1, c2);
    }

}
