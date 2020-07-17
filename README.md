# Unchecked

Functionally uncheck exceptions at compile time.

### Example:

```java
import static com.github.cuzfrog.function.Functionally.uncheckedF;

Files.list(Paths.get("dir")).map(uncheckedF(Files::readAllBytes)).map(String::new)...
```

In case of exception, `IOException` will be thrown without `RuntimeException` wrapper.

### Implemented functions:
* `unchecked` - `Consumer`, `Supplier`, `BiConsumer`
* `uncheckedF` - `Function`, `BiFunction`
* `uncheckedP` - `Predicate`

