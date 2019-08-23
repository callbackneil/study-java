package org.neil;

import javax.annotation.Resource;

import org.junit.Test;
import org.neil.dao.PCDao;
import org.neil.domain.PC;
import org.neil.service.PCService;
import com.github.pagehelper.Page;

/**
 * @author neil
 * @date 2018/7/13
 */
public class PCServiceTest extends BaseTest {

    @Resource
    PCService pcService;

    @Resource
    private PCDao pcDao;


    @Test
    public void getByIdTest() {
        PC byId = pcService.getById(5);
    }

    @Test
    public void pageTest() {
        Page<PC> pcs = pcService.pageQueryPCList();
        System.out.println(pcs.getTotal());
    }
}
