package com.github.cuzfrog.function;

import org.junit.Test;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.github.cuzfrog.function.Functionally.unchecked;
import static com.github.cuzfrog.function.Functionally.uncheckedF;

public final class FunctionallyTest {

    @Test(expected = IOException.class)
    public void uncheckedConsumer() {
        needConsumer(unchecked(this::consume));
    }

    @Test(expected = IOException.class)
    public void uncheckedSupplier() {
        needSupplier(unchecked(this::produce));
    }

    @Test(expected = IOException.class)
    public void uncheckedFunction() {
        needFunction(uncheckedF(this::map));
    }

    private <T> void consume(T t) throws IOException {
        throw new IOException("Man made exception.");
    }

    private static <T> void needConsumer(Consumer<T> consumer) {
        consumer.accept(null);
    }

    private <T> T produce() throws IOException {
        throw new IOException("Man made exception.");
    }

    private static <T> void needSupplier(Supplier<T> supplier) {
        supplier.get();
    }

    private <T, R> R map(T t) throws IOException {
        throw new IOException("Man made exception.");
    }

    private static <T, R> void needFunction(Function<T, R> function) {
        function.apply(null);
    }
}
