# Shorts / TikTok — Anatomía de una clase Java

## Short 1 — El retorno NO está en la firma

### Gancho

"¿Estos dos métodos están sobrecargados?"

### En pantalla

```java
int value(int n) { return n; }

String value(int n) {
    return String.valueOf(n);
}
```

### Giro

**NO COMPILA**

Ambos tienen la misma firma:

```text
value(int)
```

El tipo de retorno no forma parte de la firma.

### Cierre

"Si quieres entender qué considera Java realmente una firma de método, lo vemos completo en Java 21 a fondo."

### Texto principal

**Cambiar el retorno NO sobrecarga un método**

### Título sugerido

**La firma de un método Java no es lo que muchos creen**

---

## Short 2 — El wildcard no baja carpetas

### Gancho

"Si importo `java.util.*`, ¿tengo todo lo que cuelga de `java.util`?"

### En pantalla

```java
import java.util.*;

AtomicInteger n = new AtomicInteger();
```

### Giro

**NO COMPILA**

`AtomicInteger` pertenece a:

```text
java.util.concurrent.atomic
```

Los wildcards no importan subpackages.

### Título sugerido

**El asterisco de import en Java no es recursivo**
