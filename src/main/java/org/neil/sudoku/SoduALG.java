package org.neil.sudoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author neil
 * @date 2018/12/27
 */
public class SoduALG {

    public static void main(String[] args) throws IOException {
        Sudoku sudoku = getSudoku();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入(行-列-值;行-列-值)：1-2-3;2-3-4;");
        // 1-4-4;1-6-9;1-8-5;1-9-3;2-2-4;2-3-2;2-8-7;3-7-8;4-6-5;4-8-4;5-4-7;5-6-1;6-2-5;6-4-6;7-3-6;8-2-1;8-7-7;8-8-3;9-1-2;9-2-7;9-4-5;9-6-8;9-5-6;9-7-4;9-8-1;9-3-3
        String block = sc.nextLine();
        String[] blocks= block.split(";");
        for(String block1:blocks){
            String[] b = block1.split("-");
            int row = Integer.valueOf(b[0]);
            int column = Integer.valueOf(b[1]);
            int value = Integer.valueOf(b[2]);
            setValue( sudoku,row, column, value);
        }
        System.out.println(sudoku);

        // 唯一余数法
        theOnlyNo(sudoku);
        System.out.println(sudoku);
    }

    private static void theOnlyNo(Sudoku sudoku) {
        Flag isrow = new Flag();
        isrow.setIs(true);
        Flag iscolumn = new Flag();
        iscolumn.setIs(true);
        Flag isblock = new Flag();
        isblock.setIs(true);
        while (isblock.isIs()||iscolumn.isIs()||isrow.isIs()){
            // 遍历每行
            if(isrow.isIs()){
                iscolumn.setIs(false);
                isblock.setIs(false);
                forRow(sudoku.getRowList(),iscolumn,isblock);
            }
            // 遍历每lie
            if(iscolumn.isIs()){
                isrow.setIs(false);
                isblock.setIs(false);
                forColumn(sudoku.getColumnList(),isrow,isblock);
            }
            //遍历每宫
            if(isblock.isIs()){
                iscolumn.setIs(false);
                isrow.setIs(false);
                forBlock(sudoku.getBlockList(),isrow,iscolumn);
            }

        }


    }

    /**
     * 遍历宫
     * @param blockList
     * @param isRow
     * @param isColumn
     */
    private static void forBlock(List<Block> blockList, Flag isRow, Flag isColumn) {
        for(Block block:blockList){
            List<Integer> valueList = new ArrayList<>();
            valueList.add(1);valueList.add(2);valueList.add(3);valueList.add(4);valueList.add(5);valueList.add(6);valueList.add(7);valueList.add(8);valueList.add(9);
            List<Cell> cellList = block.getBlock();
            List<Integer> valueListExit = new ArrayList<>();
            Cell noValueCell = new Cell();
            for(Cell cell:cellList){
                if(cell.getValue() != null){
                    valueListExit.add(cell.getValue());
                }
                if(cell.getValue() == null){
                    noValueCell = cell;
                }
            }
            setNoValueCell(valueList, valueListExit, noValueCell,isColumn,isRow);
    }
    }

    private static void forColumn(List<Column> columnList, Flag isrow, Flag isblock) {
        for(Column column:columnList){
            List<Integer> valueList = new ArrayList<>();
            valueList.add(1);valueList.add(2);valueList.add(3);valueList.add(4);valueList.add(5);valueList.add(6);valueList.add(7);valueList.add(8);valueList.add(9);
            List<Cell> cellList = column.getColumn();
            List<Integer> valueListExit = new ArrayList<>();
            Cell noValueCell = new Cell();
            for(Cell cell:cellList){
                if(cell.getValue() != null){
                    valueListExit.add(cell.getValue());
                }
                if(cell.getValue() == null){
                    noValueCell = cell;
                }
            }
            setNoValueCell(valueList, valueListExit, noValueCell,isrow,isblock);
        }
    }

    private static void setNoValueCell(List<Integer> valueList, List<Integer> valueListExit, Cell noValueCell, Flag isrow,
                                       Flag isblock) {
        if(valueListExit.size() == 8){
            // 填写唯一剩余值
            valueList.removeAll(valueListExit);
            noValueCell.setValue(valueList.get(0));
            isrow.setIs(true);
            isblock.setIs(true);
        }
    }

    private static void forRow(List<Row> rowList, Flag iscolumn, Flag isblock) {
        for(Row block:rowList){
            List<Integer> valueList = new ArrayList<>();
            valueList.add(1);valueList.add(2);valueList.add(3);valueList.add(4);valueList.add(5);valueList.add(6);valueList.add(7);valueList.add(8);valueList.add(9);
            List<Cell> cellList = block.getRow();
            List<Integer> valueListExit = new ArrayList<>();
            Cell noValueCell = new Cell();
            for(Cell cell:cellList){
                if(cell.getValue() != null){
                    valueListExit.add(cell.getValue());
                }
                if(cell.getValue() == null){
                    noValueCell = cell;
                }
            }
            setNoValueCell(valueList, valueListExit, noValueCell,isblock,iscolumn);
        }
    }

    private static void setValue(Sudoku sudoku, int rowNo, int columnNo, int valueNo) {
        sudoku.getRowList().get(rowNo-1).getRow().get(columnNo-1).setValue(valueNo);
    }

    private static Sudoku getSudoku() {
        Sudoku sudoku = new Sudoku();
        for(int i=1;i<=9;i++){
            Row row = new Row();
            for(int j = 1; j<= 9;j++){
                Cell cell = new Cell();
                cell.setRowNo(i);
                cell.setColumnNo(j);
                sudoku.getCellList().add(cell);
                row.getRow().add(cell);
            }
            sudoku.getRowList().add(row);
        }

        List<Row> rowList = sudoku.getRowList();
        for(int j = 0; j< 9;j++){
            Column column = new Column();
            for(Row row:rowList){
                column.getColumn().add(row.getRow().get(j));
            }
            sudoku.getColumnList().add(column);
        }

// 宫
        for(int i =0;i<9;){
            int row = i;
            i+=3;
            for(int j = 0;j<9;){
                int column = j;
                j+=3;
                Block block = new Block();
                for(;row<i;row++){
                    Row rows = sudoku.getRowList().get(row);
                    for(; column < j;column++){
                        block.getBlock().add( rows.getRow().get(column));
                    }
                    column-=3;
                }
                row-=3;
                sudoku.getBlockList().add(block);
            }

        }
        return sudoku;
    }

}
