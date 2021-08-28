package com.rp.sec01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources");


    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<String> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileNAme) {
        try {
            return Files.readString(PATH.resolve(fileNAme));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void writeFile(String fileNAme, String content) {
        try {
            Files.writeString(PATH.resolve(fileNAme), content);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void deleteFile(String fileNAme) {
        try {
            Files.delete(PATH.resolve(fileNAme));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
