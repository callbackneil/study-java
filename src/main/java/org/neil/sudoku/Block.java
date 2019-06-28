package org.neil.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/12/27
 */
public class Block {
    private List<Cell> block= new ArrayList<>();

    public List<Cell> getBlock() {
        return block;
    }

    public void setBlock(List<Cell> block) {
        this.block = block;
    }
}
