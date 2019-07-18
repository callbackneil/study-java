package org.neil.service;

import org.neil.domain.PC;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;

/**
 * @author neil
 * @date 2018/7/13
 */
public interface PCService {

    Page<PC> pageQueryPCList();

    void update(PC pc) throws Exception;

    @Transactional
    void insert(PC pc) throws Exception;

    @Transactional
    void insertAndUpdate(PC pc) throws Exception;
}
