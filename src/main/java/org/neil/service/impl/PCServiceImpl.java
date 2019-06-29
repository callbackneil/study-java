package org.neil.service.impl;

import org.neil.dao.PCDao;
import org.neil.domain.PC;
import org.neil.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author neil
 * @date 2018/7/13
 */
@Service
public class PCServiceImpl implements PCService {

    @Autowired
    private PCDao pcDao;

    @Override
    public Page<PC> pageQueryPCList() {
        PageHelper.startPage(0, 0);
        Page<PC> pageList = (Page<PC>) pcDao.pageQueryPCList();
        return pageList;
    }
}
