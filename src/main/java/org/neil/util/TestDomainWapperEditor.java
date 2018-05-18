package org.neil.util;

import com.alibaba.fastjson.JSON;
import org.neil.domain.TestDomain;

import java.beans.PropertyEditorSupport;

/**
 * @author neil
 * @date 2018/5/17
 */
public class TestDomainWapperEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        TestDomain domain = JSON.parseObject(text, TestDomain.class);
        setValue(domain);
    }
}
