# Quiz — Anatomía de una clase Java

## 1. Firma de método

```java
public long total(int month, String region) {
    return 0;
}
```

¿Cuál es la firma simplificada correcta?

A. `public long total(int, String)`  
B. `total(int month, String region)`  
C. `total(int, String)`  
D. `long total(int, String)`

**Respuesta: C.**

El tipo de retorno, los modificadores y los nombres de parámetros no forman parte de la firma.

---

## 2. ¿Compila?

```java
class Test {
    int read(int n) { return n; }
    String read(int n) { return "" + n; }
}
```

A. Sí, porque cambia el retorno.  
B. No, porque ambos métodos tienen la misma firma.  
C. Sí, porque `String` y `int` son tipos distintos.  
D. Falla solo en runtime.

**Respuesta: B.**

Cambiar únicamente el retorno no crea una sobrecarga válida.

---

## 3. Wildcard

¿Qué import permite usar `AtomicInteger` por nombre simple?

A. `import java.util.*;`  
B. `import java.util.concurrent.*;`  
C. `import java.util.concurrent.atomic.*;`  
D. A y B.

**Respuesta: C.**

Los wildcards no recorren subpackages.

---

## 4. Redundancia

```java
import java.lang.String;

class Test {
    String name;
}
```

¿Qué ocurre?

A. No compila porque `java.lang` no puede importarse.  
B. Compila; el import es redundante.  
C. Compila solo en el unnamed package.  
D. Lanza una excepción al cargar la clase.

**Respuesta: B.**

`java.lang` se importa implícitamente, pero escribir un import explícito válido no lo vuelve ilegal.

---

## 5. Conflicto

```java
import java.util.*;
import java.sql.*;

class Test {
    Date date;
}
```

A. Usa automáticamente `java.util.Date`.  
B. Usa automáticamente `java.sql.Date`.  
C. No compila por ambigüedad.  
D. Compila y decide en runtime.

**Respuesta: C.**

Ambos wildcards ofrecen un tipo accesible llamado `Date` y el nombre simple queda ambiguo.

---

## 6. Tipos top-level

Archivo `Animal.java`:

```java
public class Animal {}
class Habitat {}
```

¿Qué ocurre?

A. No compila porque hay dos clases.  
B. Compila y puede generar `Animal.class` y `Habitat.class`.  
C. Solo genera `Animal.class`.  
D. `Habitat` debe ser `public`.

**Respuesta: B.**

Una unidad de compilación puede declarar más de un tipo top-level.
