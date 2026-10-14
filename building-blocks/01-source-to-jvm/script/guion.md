# Guion — Del código fuente a la JVM

## Apertura

Escribimos esto:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hola Java");
    }
}
```

Pulsamos el botón verde del IDE y funciona.

Pero la pregunta importante es: **¿qué acaba de ocurrir?**

Nuestro procesador no entiende código fuente Java. El archivo `Hello.java` es texto. Entonces, ¿cómo termina convertido en un programa ejecutándose?

Ese recorrido es el tema de este video.

---

## 1. El JDK

**JDK** significa **Java Development Kit**.

Entre sus herramientas encontramos:

- `javac`: compilador de Java;
- `java`: Java application launcher;
- `jar`: empaquetado;
- `javadoc`: generación de documentación.

Para este video nos interesan principalmente `javac` y `java`.

Comprobamos la versión:

```bash
javac -version
java -version
```

Para esta serie trabajamos con Java 21.

---

## 2. Compilar no es ejecutar

Partimos de:

```text
Hello.java
```

Ejecutamos:

```bash
javac Hello.java
```

Ahora aparece:

```text
Hello.class
```

Todavía no hemos ejecutado nuestro programa.

### QUÉ OCURRE REALMENTE

`javac` transforma el código fuente en **bytecode** almacenado en archivos `.class`.

```text
Hello.java
    |
    | javac
    v
Hello.class
```

El bytecode está destinado a la **Java Virtual Machine**.

Esto permite separar el código compilado de la plataforma física concreta.

---

## 3. Ejecutar

Ahora:

```bash
java Hello
```

El comando `java` actúa como launcher de la aplicación.

Observa que escribimos:

```bash
java Hello
```

y no:

```bash
java Hello.class
```

Estamos indicando la clase que queremos lanzar, no pasando simplemente el nombre físico del archivo.

---

## 4. El main clásico

Para el alcance del OCP Java 21 debemos dominar:

```java
public static void main(String[] args)
```

- `public`: accesibilidad.
- `static`: no necesitamos crear primero una instancia.
- `void`: no devuelve un valor.
- `main`: nombre reconocido como punto de entrada en este modelo.
- `String[] args`: argumentos de línea de comandos.

### VERSION WATCH

En Java 21 existieron como preview ideas orientadas a simplificar programas iniciales, pero las preview features no forman parte del examen OCP 21.

En versiones posteriores esta línea evolucionó hacia formas más compactas de programas y métodos `main`.

Para esta serie, cuando estudiemos una regla del OCP 21, no la mezclaremos con sintaxis posterior.

---

## 5. Argumentos

```java
public class Arguments {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
```

```bash
javac Arguments.java
java Arguments Duke Java
```

```text
Duke
Java
```

Con comillas:

```bash
java Arguments "Duke Java" OCP
```

El primer argumento es ahora `"Duke Java"`.

---

## 6. Compile-time vs runtime

Este código:

```java
int number = "cinco";
```

no compila.

En cambio:

```java
System.out.println(args[10]);
```

puede compilar perfectamente y fallar durante la ejecución.

### OCP WATCH

Cada vez que algo falle, pregunta:

**¿quién detectó el problema?**

- ¿el compilador?
- ¿la JVM durante la ejecución?
- ¿una API lanzó una excepción?

No confundir **does not compile** con **runtime exception**.

---

## 7. Source-file mode

También podemos ejecutar:

```bash
java SourceFileDemo.java
```

Esta capacidad existe desde Java 11 y se conoce como lanzamiento de **single-file source-code programs**; el launcher entra en **source-file mode**.

### QUÉ OCURRE REALMENTE

Decir "Java ejecuta el archivo sin compilar" es cómodo, pero impreciso.

La compilación sigue formando parte del proceso. Lo que desaparece es el paso explícito:

```bash
javac SourceFileDemo.java
```

hecho por nosotros.

---

## 8. Packages y classpath

Supongamos:

```java
package academy.java21;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hola desde un package");
    }
}
```

Desde la raíz del ejemplo:

```text
04-classpath/
└── src/
    └── academy/
        └── java21/
            └── Hello.java
```

creamos el directorio de salida:

```bash
mkdir classes
```

y compilamos:

```bash
javac -d classes src/academy/java21/Hello.java
```

El resultado será:

```text
classes/
└── academy/
    └── java21/
        └── Hello.class
```

Ahora ejecutamos:

```bash
java -cp classes academy.java21.Hello
```

### QUÉ OCURRE REALMENTE

`classes` es una **raíz de búsqueda** del classpath.

No estamos apuntando directamente a `Hello.class`; damos a Java una raíz desde la cual puede resolver el nombre completamente cualificado:

```text
academy.java21.Hello
```

Las formas equivalentes son:

```bash
java -cp classes academy.java21.Hello
java -classpath classes academy.java21.Hello
java --class-path classes academy.java21.Hello
```

---

## Cierre

Mapa mental:

```text
Hello.java
    |
    | javac
    v
Hello.class
    |
    | java
    v
   JVM
    |
    v
plataforma
```

Y el atajo:

```bash
java Hello.java
```

no elimina conceptualmente la compilación; elimina el paso explícito de invocar `javac`.

**Java 21 a fondo — Entender antes que memorizar.**
