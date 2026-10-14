# Cheat sheet — Del código fuente a la JVM

## Versiones

```bash
java -version
javac -version
```

## Compilar

```bash
javac Hello.java
```

## Ejecutar clase compilada

```bash
java Hello
```

## Source-file mode

```bash
java Hello.java
```

Disponible desde Java 11.

## Compilar a otro directorio

```bash
javac -d classes src/academy/java21/Hello.java
```

## Classpath

```bash
java -cp classes academy.java21.Hello
java -classpath classes academy.java21.Hello
java --class-path classes academy.java21.Hello
```

## Main clásico relevante para OCP Java 21

```java
public static void main(String[] args)
```

## Recordar

| Elemento | Función |
|---|---|
| `.java` | código fuente |
| `.class` | bytecode |
| `javac` | compilador |
| `java` | launcher |
| JVM | ejecuta bytecode |
| classpath | raíces donde se buscan clases |

**Compile-time no es runtime.**
