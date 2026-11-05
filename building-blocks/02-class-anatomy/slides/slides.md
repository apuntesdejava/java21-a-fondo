# Java 21 a fondo

## Anatomía de una clase Java

¿Qué ve realmente el compilador?

---

## No son lo mismo

```text
archivo .java
compilation unit
clase
objeto
```

---

## Cuerpo de una clase

```java
class Animal {
    String name;

    String getName() {
        return name;
    }
}
```

**field + method**

---

## Firma de método

```java
public int visitors(int month)
```

Firma:

```text
visitors(int)
```

No incluye:

- `public`
- `int` de retorno
- nombre `month`

---

## ¿Compila?

```java
int value(int n) { return n; }

String value(int n) {
    return String.valueOf(n);
}
```

**NO COMPILA**

---

## Comentarios

```java
// una línea

/* bloque */

/** Javadoc */
```

Los bloques **no se anidan**.

---

## Una compilation unit

```java
public class Animal {}

class Habitat {}
```

Un archivo.

Dos tipos top-level.

---

## PIC

```text
Package
Import
Class / top-level type
```

---

## import no copia nada

```java
import java.util.Random;
```

Permite resolver:

```text
Random -> java.util.Random
```

---

## Wildcard

```java
import java.util.*;
```

No incluye:

```text
java.util.concurrent.atomic.*
```

---

## Implícito

```text
java.lang.*
mismo package
```

---

## Conflicto

```java
import java.util.*;
import java.sql.*;

Date date;
```

**AMBIGUO**

---

## Import explícito gana al wildcard

```java
import java.util.Date;
import java.sql.*;
```

```java
Date date;
```

=> `java.util.Date`

---

## Mapa mental

```text
Compilation Unit
├─ package?
├─ imports*
└─ top-level types*
   └─ class body
      ├─ fields
      ├─ methods
      └─ nested types
```

### Entender antes que memorizar
