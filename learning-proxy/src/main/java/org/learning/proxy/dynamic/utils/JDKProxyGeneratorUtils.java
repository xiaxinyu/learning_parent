package org.learning.proxy.dynamic.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import sun.misc.ProxyGenerator;

@SuppressWarnings("restriction")
public class JDKProxyGeneratorUtils {
	  /** 
     * 把代理类的字节码写到硬盘上 
     * @param path 保存路径 
     */  
    public static void writeProxyClassToHardDisk(String path, Object targetObject) {  
		byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", targetObject.getClass().getInterfaces());  
        FileOutputStream out = null;  
          
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
