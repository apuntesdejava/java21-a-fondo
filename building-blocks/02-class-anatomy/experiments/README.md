# Experimentos — Anatomía de una clase Java

Ejecutar desde `02-class-anatomy/examples`.

## 1. Clase básica y miembros

```bash
cd 01-members
javac Animal.java
```

Modificar el orden de campos y métodos y comprobar que sigue compilando.

## 2. Firma de método

```bash
cd ../02-signature
javac Signatures.java
```

El archivo deliberadamente **NO COMPILA** porque dos métodos difieren solo en el tipo de retorno.

Después cambiar uno de ellos a:

```java
String value(long n)
```

y volver a compilar.

## 3. Comentarios

```bash
cd ../03-comments
javac Comments.java
```

El archivo deliberadamente **NO COMPILA**.

El comentario de bloque contiene otro `/* ... */`. Los comentarios de bloque no se anidan: el primer `*/` cierra el comentario exterior y el resto del texto queda expuesto como código Java inválido.

Para experimentar, elimina el comentario interno y comprueba que el archivo vuelve a compilar.


## 4. Dos tipos top-level

```bash
cd ../04-top-level-types
javac Animal.java
```

Comprobar que aparecen:

```text
Animal.class
Habitat.class
```

Un solo archivo fuente produjo dos archivos de clase.

## 5. Imports

```bash
cd ../05-imports
javac NumberPicker.java
java NumberPicker
```

Cambiar el import explícito por:

```java
import java.util.*;
```

y comprobar que sigue funcionando.

## 6. Wildcards no recursivos

```bash
cd ../06-wildcards
javac Wildcards.java
```

Primero debe compilar con el import correcto de `AtomicInteger`.

Reemplazarlo por:

```java
import java.util.*;
```

y comprobar que deja de compilar.

## 7. Conflictos

```bash
cd ../07-conflicts
javac Dates.java
```

El ejemplo válido usa un import explícito y un nombre completamente cualificado.

Experimentar con:

```java
import java.util.*;
import java.sql.*;
```

y usar solo `Date`: debe aparecer ambigüedad.
