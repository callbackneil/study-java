package org.neil.service;

import org.neil.domain.PC;
import com.github.pagehelper.Page;

/**
 * @author neil
 * @date 2018/7/13
 */
public interface PCService {

    Page<PC> pageQueryPCList();
}
