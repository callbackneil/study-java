package org.neil.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/12/27
 */
public class Column {
    private List<Cell> column= new ArrayList<>();

    public List<Cell> getColumn() {
        return column;
    }

    public void setColumn(List<Cell> column) {
        this.column = column;
    }
}
