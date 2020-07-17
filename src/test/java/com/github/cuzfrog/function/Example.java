package com.github.cuzfrog.function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.cuzfrog.function.Functionally.uncheckedF;

final class Example {
    void demo() throws IOException {
        Files.list(Paths.get("dir")).map(uncheckedF(Files::readAllBytes)).map(String::new);
    }
}
