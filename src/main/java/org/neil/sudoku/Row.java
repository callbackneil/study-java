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
}
