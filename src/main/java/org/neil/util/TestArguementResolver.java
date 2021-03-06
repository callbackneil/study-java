package org.neil.util;

import javax.servlet.http.HttpServletRequest;

import org.neil.domain.TestDomainWapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author neil
 * @date 2018/5/21
 */
public class TestArguementResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        java.lang.Class<?> aClass = parameter.getParameterType();
        if (aClass.equals(TestDomainWapper.class)) {
            return true;
        }

        new Integer(100);
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        binderFactory.createBinder(webRequest, "", "testDomainWapper");

        return null;
    }

}
