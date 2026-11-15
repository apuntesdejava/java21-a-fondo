# Experimentos - Objetos, referencias y construcción

Ejecutar desde `03-objects-references-construction/examples`.

## 1. Crear sin guardar la referencia

```bash
cd 01-create-without-variable
javac Demo.java
java Demo
```

El ejemplo contiene:

```java
new Coffee();
```

La expresión crea una instancia aunque ninguna variable conserve la referencia producida.

Referencia:

- JLS 15.9
- JLS 15.9.4

---

## 2. Dos referencias, una instancia

```bash
cd ../02-aliasing
javac Demo.java
java Demo
```

Salida esperada:

```text
80
```

El código:

```java
Coffee first = new Coffee();
Coffee second = first;
```

no crea una segunda instancia.

Modificar el experimento agregando:

```java
second.temperature = 95;
System.out.println(first.temperature);
```

y comprobar que la salida cambia a `95`.

Referencia:

- JLS 4.3

---

## 3. Reasignar una referencia

```bash
cd ../03-reassignment
javac Demo.java
java Demo
```

Salida esperada:

```text
Coffee #1
Coffee #2
```

La variable `coffee` contiene primero una referencia y después otra.

No analizar todavía garbage collection. El objetivo aquí es observar la reasignación.

---

## 4. Método que parece constructor

```bash
cd ../04-false-constructor
javac Demo.java
java Demo
```

Salida esperada:

```text
new Robot() no invoco Robot()
method
```

El método:

```java
void Robot()
```

no es un constructor porque tiene return type.

La primera línea de salida demuestra que `new Robot()` no lo invoca.

La segunda aparece únicamente al ejecutar:

```java
robot.Robot();
```

Referencia:

- JLS 8.8

---

## 5. Constructor por defecto

```bash
cd ../05-default-constructor-no-compile
javac Demo.java
```

Este ejemplo está diseñado para **NO COMPILAR**.

La clase declara:

```java
Coffee(int size) {
}
```

por lo que Java no declara implícitamente un constructor por defecto.

Sin embargo el código intenta:

```java
new Coffee();
```

Para repararlo, probar una de estas dos variantes:

### Variante A

```java
new Coffee(10);
```

### Variante B

Agregar explícitamente:

```java
Coffee() {
}
```

y volver a compilar.

Referencia:

- JLS 8.8.9

---

## 6. Orden básico de inicialización

```bash
cd ../06-initialization-order
javac Demo.java
java Demo
```

Salida esperada:

```text
field 1
initializer 1
field 2
initializer 2
constructor
```

El experimento permite observar que field initializers e instance initializer blocks se procesan siguiendo su orden textual antes del cuerpo del constructor, dentro del modelo simple estudiado en este episodio.

### Modificación propuesta

Intercambiar:

```java
String second = trace("field 2");
```

con el primer instance initializer y volver a ejecutar.

Predecir la salida antes de compilar.

Referencia:

- JLS 8.6
- JLS 12.5

---

## Método de trabajo recomendado

Para cada experimento:

1. leer el código;
2. predecir si compila;
3. si compila, predecir la salida;
4. ejecutar;
5. explicar cualquier diferencia entre predicción y resultado.

El objetivo no es memorizar salidas sino aprender a razonar el proceso de construcción.
