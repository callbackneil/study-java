package org.neil.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/12/27
 */
public class Sudoku {
    List<Cell>   cellList = new ArrayList<>();
    List<Row>    rowList= new ArrayList<>();
    List<Column> columnList= new ArrayList<>();
    List<Block>  blockList= new ArrayList<>();

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public List<Row> getRowList() {
        return rowList;
    }

    public void setRowList(List<Row> rowList) {
        this.rowList = rowList;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }
}
