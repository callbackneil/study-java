package org.neil;

import org.junit.Test;
import org.neil.domain.PC;
import org.neil.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;

/**
 * @author neil
 * @date 2018/7/13
 */
public class PCServiceTest extends BaseTest {

    @Autowired
    PCService pcService;

    @Test
    public void pageTest() {
        Page<PC> pcs = pcService.pageQueryPCList();
        System.out.println(pcs.getTotal());
    }
}
