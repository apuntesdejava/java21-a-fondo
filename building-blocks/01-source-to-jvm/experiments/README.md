# Experimentos — Video 1

Ejecutar desde la carpeta `01-source-to-jvm`.

## 1. Compilación explícita

```bash
cd examples/01-hello
javac Hello.java
java Hello
```

Comprobar que aparece `Hello.class`.

## 2. Argumentos y runtime

```bash
cd ../02-arguments
javac Arguments.java
java Arguments Duke Java
java Arguments Duke
```

La segunda ejecución compila previamente sin problema, pero falla en runtime al acceder a un índice inexistente.

## 3. Source-file mode

```bash
cd ../03-source-file-mode
java SourceFileDemo.java
```

Comparar con:

```bash
javac SourceFileDemo.java
java SourceFileDemo
```

## 4. Packages + classpath

Desde `examples/04-classpath`:

```bash
mkdir classes
javac -d classes src/academy/java21/Hello.java
java -cp classes academy.java21.Hello
```

Árbol esperado:

```text
04-classpath/
├── src/
│   └── academy/
│       └── java21/
│           └── Hello.java
└── classes/
    └── academy/
        └── java21/
            └── Hello.class
```

Este experimento debe mostrarse con el árbol visible para que quede clara la diferencia entre ruta de fuente, directorio de salida y raíz del classpath.
