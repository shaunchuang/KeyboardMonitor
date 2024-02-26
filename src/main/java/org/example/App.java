package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // 關閉JNativeHook的日誌輸出
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);

            // 註冊JNativeHook
            GlobalScreen.registerNativeHook();

            // 添加鍵盤監聽器
            GlobalScreen.addNativeKeyListener(new KeyboardMonitor());
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

    }
}
