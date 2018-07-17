package org.neil.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.neil.domain.PC;

/**
 * @author neil
 * @date 2018/6/28
 */
@Mapper
public interface PCDao {

    String getMAXId();

    Long insertPC(PC pc);

    List<PC> pageQueryPCList();

}
