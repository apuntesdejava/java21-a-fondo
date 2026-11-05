# Guion — Anatomía de una clase Java

## Apertura

En el video anterior seguimos el recorrido:

```text
.java -> javac -> .class -> JVM
```

Ahora quiero detenerme justo al principio.

Tenemos un archivo `.java`.

**¿Qué cree realmente el compilador que hay dentro?**

Porque nosotros solemos decir:

> "Este archivo contiene una clase."

Pero Java trabaja con conceptos un poco más precisos:

- unidad de compilación;
- declaración de package;
- imports;
- tipos top-level;
- cuerpo de clase;
- miembros.

Y si entendemos esas piezas, muchas reglas que parecen arbitrarias empiezan a tener sentido.

---

## 1. Clase, objeto y archivo no son lo mismo

Comencemos con:

```java
public class Animal {
}
```

Aquí estamos **declarando una clase**.

Todavía no estamos creando ningún objeto.

Tampoco debemos confundir la clase con el archivo físico `Animal.java`.

Para este episodio nos concentraremos en la declaración del tipo. La creación de objetos viene en el siguiente.

### QUÉ OCURRE REALMENTE

La JLS habla de una **compilation unit**.

En una unidad de compilación ordinaria podemos encontrar, en este orden conceptual:

```text
[package]
[imports]
[top-level type declarations]
```

Eso explica buena parte de las reglas de posición que veremos después.

---

## 2. El cuerpo de una clase

Agreguemos estado:

```java
public class Animal {
    String name;
}
```

`name` es un **field**.

Ahora agreguemos comportamiento:

```java
public class Animal {
    String name;

    String getName() {
        return name;
    }

    void setName(String newName) {
        name = newName;
    }
}
```

Los campos almacenan estado.

Los métodos describen comportamiento que puede ejecutarse.

### PRECISIÓN DE BATA BLANCA

Solemos decir informalmente que "todo lo que está dentro de una clase son miembros".

La especificación es más precisa.

Los miembros de una clase incluyen campos, métodos, clases miembro e interfaces miembro.

Los constructores y los bloques de inicialización pueden aparecer en el cuerpo de una clase, pero **no son miembros**.

No necesitamos memorizar esto todavía para resolver constructores; lo retomaremos en el siguiente episodio.

---

## 3. Anatomía de un método

Miremos:

```java
public int numberVisitors(int month) {
    return 10;
}
```

Podemos separar:

```text
public          -> modificador
int             -> tipo de retorno
numberVisitors  -> nombre
int month       -> parámetro
{ ... }         -> cuerpo
```

Ahora viene una distinción muy OCP.

### ¿Cuál es la firma?

Para este método:

```java
public int numberVisitors(int month)
```

la firma relevante es:

```text
numberVisitors(int)
```

El nombre del parámetro `month` no forma parte de la firma.

Y el tipo de retorno `int` tampoco.

### EXPERIMENTO

¿Compila esto?

```java
public class Signatures {

    int value(int n) {
        return n;
    }

    String value(int n) {
        return String.valueOf(n);
    }
}
```

**NO COMPILA**

Cambiar únicamente el tipo de retorno no crea otra firma.

Ambos métodos tienen la misma firma:

```text
value(int)
```

### OCP WATCH

No confundas:

- **declaración del método**;
- **tipo del método**;
- **firma del método**.

Para las preguntas básicas del examen, piensa en:

```text
nombre + tipos de parámetros
```

Más adelante, con genéricos, la definición formal tiene matices adicionales.

---

## 4. Comentarios: el compilador deja de mirar

Java reconoce tres formas habituales:

```java
// comentario de una línea
```

```java
/*
 comentario multilínea
*/
```

```java
/**
 comentario Javadoc
*/
```

El detalle interesante no es memorizar tres símbolos.

Es entender **dónde termina cada comentario**.

### EXPERIMENTO

```java
/*
 * // esto sigue dentro del comentario multilínea
 */
```

El `//` no abre un comentario independiente.

Ya estamos dentro de otro comentario.

Ahora:

```java
// /* esto también sigue siendo comentario de una línea */
```

Todo después de `//` hasta el final de línea es comentario.

Pero:

```java
/*
   /* intento de comentario anidado */
*/
```

**NO COMPILA**

Los comentarios tradicionales de bloque no se anidan.

El primer `*/` cierra el comentario exterior; queda sintaxis sobrante.

### EN UN PROYECTO REAL

Un comentario debería explicar **por qué** existe una decisión, no narrar mecánicamente cada línea.

Y para API pública, Javadoc merece un tratamiento propio más adelante.

---

## 5. Un archivo puede contener más de un tipo top-level

Esto es válido:

```java
public class Animal {
}

class Habitat {
}
```

Tenemos dos tipos top-level en una misma unidad de compilación.

En una organización normal basada en archivos, el tipo público `Animal` vive en:

```text
Animal.java
```

### OCP WATCH

No asumas que:

> un archivo Java = exactamente una clase.

Eso es una convención extremadamente común, no la estructura mínima que permite el lenguaje.

Para el examen importa reconocer que pueden existir varios tipos top-level en una misma unidad de compilación.

### QUÉ OCURRE REALMENTE

La JLS formula esta regla en términos de **compilation units** y permite que implementaciones basadas en sistema de archivos impongan la asociación entre un tipo público y un archivo con el mismo nombre.

En la práctica con `javac`:

```java
public class Animal2 {
}
```

dentro de `Animal.java` no es válido.

---

## 6. Orden externo: package, import, tipos

Un archivo típico:

```java
package academy.animals;

import java.util.List;

public class Animal {
    List<String> names;
}
```

La forma fácil de recordarlo:

```text
P I C
Package
Import
Class
```

Aunque "C" es pedagógico; formalmente podrían venir otros tipos top-level.

### EXPERIMENTO

```java
import java.util.List;
package academy.animals;

public class Animal {
}
```

**NO COMPILA**

Si existe una declaración `package`, va antes de los imports.

Y esto tampoco:

```java
package academy.animals;

String name;

public class Animal {
}
```

**NO COMPILA**

Un field no puede flotar fuera del cuerpo de una clase.

---

## 7. ¿Qué hace realmente import?

Supongamos:

```java
Random random = new Random();
```

El compilador necesita resolver qué significa el nombre simple:

```text
Random
```

Podemos escribir:

```java
java.util.Random random = new java.util.Random();
```

o importar el tipo:

```java
import java.util.Random;
```

y después usar:

```java
Random random = new Random();
```

### QUÉ OCURRE REALMENTE

Un `import` no "copia" una clase dentro de nuestro archivo.

Tampoco significa que todas las clases importadas se carguen en memoria.

Su función aquí es permitir que el compilador resuelva ciertos nombres usando una forma simple.

Podemos pensar:

```text
Random
   |
   +--> java.util.Random
```

---

## 8. Wildcards

Podemos escribir:

```java
import java.util.*;
```

Esto permite usar tipos directamente declarados en `java.util`.

Pero no significa:

> importa recursivamente todo lo que exista por debajo.

Por ejemplo:

```java
import java.util.*;
```

no basta para usar directamente:

```text
java.util.concurrent.atomic.AtomicInteger
```

Necesitaríamos:

```java
import java.util.concurrent.atomic.AtomicInteger;
```

o:

```java
import java.util.concurrent.atomic.*;
```

### OCP WATCH

El wildcard importa tipos de **ese package**.

No importa subpackages.

Los packages tienen nombres jerárquicos, pero un subpackage no es "contenido recursivo" del import.

---

## 9. java.lang y el mismo package

Podemos escribir:

```java
String name;
System.out.println(name);
```

sin:

```java
import java.lang.String;
import java.lang.System;
```

porque `java.lang` se importa implícitamente.

También tenemos acceso por nombre simple a tipos del mismo package.

Por eso algunos imports pueden ser redundantes.

### OCP WATCH

Esto compila:

```java
import java.lang.String;
```

Solo que es innecesario.

**Redundante no significa inválido.**

---

## 10. Conflictos de nombres

Java puede tener:

```text
java.util.Date
java.sql.Date
```

Ahora:

```java
import java.util.*;
import java.sql.*;

public class Dates {
    Date date;
}
```

**NO COMPILA**

`Date` es ambiguo.

Pero:

```java
import java.util.Date;
import java.sql.*;

public class Dates {
    Date date;
}
```

sí funciona.

El import explícito de tipo gana frente al wildcard para ese nombre.

### ¿Y esto?

```java
import java.util.Date;
import java.sql.Date;
```

**NO COMPILA**

Ahora hemos pedido dos candidatos explícitos con el mismo nombre simple.

### Si necesitamos ambos

Una opción:

```java
import java.util.Date;

public class Dates {
    Date utilDate;
    java.sql.Date sqlDate;
}
```

También podemos evitar ambos imports y usar siempre nombres completamente cualificados.

---

## 11. Imports que parecen plausibles pero no funcionan

```java
import java.nio.*;
```

No importa:

```text
java.nio.file.Files
```

porque `file` es un subpackage.

Esto tampoco:

```java
import java.nio.*.*;
```

**NO COMPILA**

Y:

```java
import java.nio.file.Paths.*;
```

no es un import normal de métodos.

Los imports estáticos existen, pero los veremos cuando corresponda.

---

## 12. Orden dentro de la clase

Dentro de una clase:

```java
public class Zoo {
    int animals;

    void open() {
    }

    String name;

    void close() {
    }
}
```

campos y métodos no tienen que estar agrupados por tipo para que compile.

La regla de orden fuerte que estamos estudiando es principalmente la estructura externa:

```text
package
imports
top-level types
```

### EN EL EXAMEN

El código puede estar deliberadamente desordenado para comprobar si reconoces qué es legal.

### EN UN PROYECTO REAL

La legibilidad importa.

Que el compilador acepte mezclar miembros de cualquier manera no significa que debamos convertir una clase en un cajón.

---

## 13. Mapa mental

Cuando abrimos un archivo Java ordinario:

```text
Compilation Unit
|
+-- package? 
|
+-- imports*
|
+-- top-level types*
      |
      +-- class body
          |
          +-- fields
          +-- methods
          +-- nested types
          +-- constructors / initializers
              (están en el cuerpo, pero no son miembros)
```

Y cuando aparece un nombre como:

```text
Random
```

el compilador debe resolver qué tipo representa ese nombre.

Los imports ayudan precisamente en esa resolución.

---

## Resumen

Qué debería quedar:

1. Archivo, unidad de compilación, clase y objeto no son sinónimos.
2. Campos y métodos son miembros de una clase.
3. La firma de un método no incluye su tipo de retorno ni el nombre de sus parámetros.
4. Los comentarios de bloque no se anidan.
5. Una unidad de compilación puede declarar varios tipos top-level.
6. El orden externo es `package -> imports -> tipos`.
7. `import` ayuda a resolver nombres; no copia ni carga clases.
8. Los wildcards no incluyen subpackages.
9. `java.lang` se importa implícitamente.
10. Los conflictos de nombres pueden requerir imports explícitos o nombres completamente cualificados.

**Java 21 a fondo — Entender antes que memorizar.**
