package com.github.cuzfrog.function;

import java.util.function.*;

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

    public interface ThrowingBiConsumer<T1, T2, E extends Exception> {
        void accept(T1 t1, T2 t2) throws E;
    }

    public static <T1, T2, E extends Exception> BiConsumer<T1, T2> unchecked(final ThrowingBiConsumer<T1, T2, E> throwingBiConsumer) {
        return (a, b) -> {
            try {
                throwingBiConsumer.accept(a, b);
            } catch (Exception e) {
                reThrow(e);
            }
        };
    }

    public interface ThrowingBiFunction<T1, T2, R, E extends Exception> {
        R apply(T1 t1, T2 t2) throws E;
    }

    public static <T1, T2, R, E extends Exception> BiFunction<T1, T2, R> uncheckedF(final ThrowingBiFunction<T1, T2, R, E> throwingBiFunction) {
        return (a, b) -> {
            try {
                return throwingBiFunction.apply(a, b);
            } catch (Exception e) {
                return reThrow(e);
            }
        };
    }

    public interface ThrowingPredicate<T, E extends Exception> {
        boolean test(T t) throws E;
    }

    public static <T, E extends Exception> Predicate<T> uncheckedP(final ThrowingPredicate<T, E> throwingPredicate) {
        return t -> {
            try {
                return throwingPredicate.test(t);
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
