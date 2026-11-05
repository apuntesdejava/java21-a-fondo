# Cheat sheet — Anatomía de una clase Java

## Unidad de compilación ordinaria

```text
package? -> imports* -> top-level types*
```

Mnemotecnia pedagógica:

```text
PIC = Package, Import, Class
```

## Miembros de clase

- fields
- methods
- member classes
- member interfaces

**No son miembros:** constructores, instance initializers, static initializers.

## Firma de método

Ejemplo:

```java
public int count(String name, int age)
```

Firma simplificada para este nivel:

```text
count(String, int)
```

No forman parte:

- tipo de retorno;
- nombres de parámetros;
- modificador `public`.

## Comentarios

```java
// ...
/* ... */
/** ... */
```

Los comentarios de bloque no se anidan.

## Imports

Explícito:

```java
import java.util.Random;
```

Wildcard:

```java
import java.util.*;
```

El wildcard **no incluye subpackages**.

## Disponibles sin import explícito

- tipos públicos de `java.lang`;
- tipos accesibles del mismo package.

## Conflictos

```java
import java.util.*;
import java.sql.*;
Date d; // ambiguo
```

Un import explícito puede desambiguar frente a wildcards:

```java
import java.util.Date;
import java.sql.*;
```

Si se necesitan ambos nombres:

```java
Date utilDate;
java.sql.Date sqlDate;
```

## OCP WATCH

- redundante != inválido;
- wildcard != recursivo;
- retorno != firma;
- nombre de parámetro != firma;
- un archivo puede declarar varios tipos top-level.
