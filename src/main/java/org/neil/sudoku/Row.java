package org.neil.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/12/27
 */
public class Row {
    private List<Cell> Row= new ArrayList<>();

    public List<Cell> getRow() {
        return Row;
    }

    public void setRow(List<Cell> row) {
        Row = row;
    }

    public static void main(String[] args) {
        Flag is = new Flag();
        is.setIs(false);
        a(is);
        System.out.println(is.isIs());
    }

    private static void a(Flag is) {
        is.setIs(true);
        System.out.println(is.isIs());
    }
}
