package org.neil.sudoku;

/**
 * @author neil
 * @date 2018/12/27
 */
public class Cell {
    private Integer rowNo;
    private Integer columnNo;
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public Integer getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(Integer columnNo) {
        this.columnNo = columnNo;
    }
}
