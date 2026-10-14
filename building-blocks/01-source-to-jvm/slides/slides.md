# Java 21 a fondo

## Entender antes que memorizar

### Del código fuente a la JVM

---

## Tenemos un archivo

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hola Java");
    }
}
```

¿qué ocurre cuando lo ejecutamos?

---

## Compilar

```text
Hello.java
    |
    | javac
    v
Hello.class
```

**.class = bytecode**

---

## Ejecutar

```text
Hello.class
    |
    | java
    v
   JVM
```

---

## OCP WATCH

```bash
javac Hello.java
java Hello
```

No:

```bash
java Hello.class
```

---

## Compile-time != Runtime

```java
int n = "cinco";
```

vs.

```java
System.out.println(args[10]);
```

---

## Source-file mode

Desde Java 11:

```bash
java Hello.java
```

La compilación no desaparece.

Desaparece el paso explícito de invocar `javac`.

---

## Packages

```text
src/
└── academy/
    └── java21/
        └── Hello.java
```

---

## Compilar a otro directorio

```bash
javac -d classes src/academy/java21/Hello.java
```

```text
classes/
└── academy/
    └── java21/
        └── Hello.class
```

---

## Classpath

```bash
java -cp classes academy.java21.Hello
```

**classes = raíz de búsqueda**

---

## Mapa final

```text
.java
 |
javac
 |
.class
 |
java
 |
JVM
```

### Java 21 a fondo
**Entender antes que memorizar**
