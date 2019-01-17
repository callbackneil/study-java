package org.neil.sudoku;

/**
 * @author neil
 * @date 2018/12/27
 */
public class SoduALG {

    public static void main(String[] args) {

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

        for(int j = 1; j<= 9;j++){
//            sudoku.getColumnList().add(sudoku.getRowList().get(0).getRow().get(0));

        }
        sudoku.getRowList();
        System.out.println(sudoku);





    }

}
