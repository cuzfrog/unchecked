package com.github.cuzfrog.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Functionally {
    private Functionally() {
    }

    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }

    public static <T, E extends Exception> Consumer<T> unchecked(final ThrowingConsumer<T, E> throwingConsumer) {
        return t -> {
            try {
                throwingConsumer.accept(t);
            } catch (Exception e) {
                reThrow(e);
            }
        };
    }

    public interface ThrowingSupplier<T, E extends Exception> {
        T get() throws E;
    }

    public static <T, E extends Exception> Supplier<T> unchecked(final ThrowingSupplier<T, E> throwingSupplier) {
        return () -> {
            try {
                return throwingSupplier.get();
            } catch (Exception e) {
                return reThrow(e);
            }
        };
    }

    public interface ThrowingFunction<T, R, E extends Exception> {
        R apply(T t) throws E;
    }

    public static <T, R, E extends Exception> Function<T, R> uncheckedF(final ThrowingFunction<T, R, E> throwingFunction) {
        return t -> {
            try {
                return throwingFunction.apply(t);
            } catch (Exception e) {
                return reThrow(e);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <R, E extends Exception> R reThrow(Exception e) throws E {
        throw (E) e;
    }
}
