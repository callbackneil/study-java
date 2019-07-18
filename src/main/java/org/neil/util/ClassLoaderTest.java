package org.neil.util;

import java.io.InputStream;

/**
 * @author neil
 * @date 2019-07-18
 */
public class ClassLoaderTest extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader myLoader = new ClassLoaderTest();
        Object obj = myLoader.loadClass("java.lang.Math").newInstance();
        System.out.println(obj);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try{
            String className = null;
            if(name.startsWith("java.lang")){
                className = "/" + name.replace('.', '/') + ".class";
            }else{
                className = name.substring(name.lastIndexOf('.') + 1) + ".class";
            }
            System.out.println(className);
            InputStream is = getClass().getResourceAsStream(className);
            System.out.println(is);
            if(is == null){
                return super.loadClass(name);
            }

            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        }catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }
}
