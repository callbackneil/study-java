package org.neil.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.neil.domain.PC;

/**
 * @author neil
 * @date 2018/6/28
 */
@Mapper
public interface PCDao {

    String getMAXId();

    Long insertPC(PC pc);

    Integer updatePC(PC pc);

    List<PC> pageQueryPCList();

    PC getById(@Param("id") Integer id);


}
