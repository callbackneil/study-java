package org.neil;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neil.dao.PCDao;
import org.neil.domain.PC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neil
 * @date 2018/6/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:WEB-INF/spring-servlet.xml"})
public class BaseTest {

    @Autowired
    private PCDao testDao;

    @Test
    public void test() {
        List<PC> maxId = testDao.pageQueryPCList();
        System.out.println(maxId);
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            PC pc = new PC();
            pc.setPcName("神州");
            pc.setPcPrice(5000.00);
            Long id = testDao.insertPC(pc);
        }

    }
}
