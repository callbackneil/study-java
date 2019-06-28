package org.neil.util;

import org.neil.domain.TestDomainWapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author neil
 * @date 2018/5/21
 */
public class TestArguementResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class aClass = parameter.getParameterType();
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

//    public static void main(String[] args) {
//        Integer i1 = Integer.valueOf(100);
//        int i2 = new Integer(100);
//        Integer i3  = Integer.valueOf(100);
//        System.out.println(i1 == i2);
//        System.out.println(i1 == i3);
//        System.out.println(i2 == i3);
//    }

    public static void main(String[] args) {
        int i = 0;
        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        int index = 0;
        for (; i < 11; i++) {
            int nextIndex = (index+1) % arr.length;
            index = nextIndex;
            System.out.println(arr[index]);
        }
    }



}
