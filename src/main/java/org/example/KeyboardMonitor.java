package org.example;


import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardMonitor implements NativeKeyListener {
    private int keyPressCount = 0;
    private long startTime;

    public KeyboardMonitor() {
        startTime = System.currentTimeMillis();
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        keyPressCount++;
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime > 0 )  {
            double frequency = (double) keyPressCount / (elapsedTime / 1000.0);
            System.out.println("按鍵頻率" + frequency + " 次/秒");
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e){

    }

    public void nativeKeyTyped(NativeKeyEvent e) {

    }
}

