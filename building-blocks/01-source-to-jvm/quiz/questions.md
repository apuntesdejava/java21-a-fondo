# Quiz — Video 1

## 1

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println(args[1]);
    }
}
```

```bash
javac Demo.java
java Demo Java
```

¿Qué ocurre?

A. No compila.  
B. Imprime `Java`.  
C. Compila y lanza una excepción en runtime.  
D. `javac` detecta que falta un argumento.

**Respuesta:** C.

---

## 2

¿Cuál lanza una clase `Zoo` previamente compilada?

A. `java Zoo.class`  
B. `java Zoo`  
C. `javac Zoo`  
D. `java -d Zoo`

**Respuesta:** B.

---

## 3

¿Qué describe mejor?

```bash
java Demo.java
```

A. La JVM interpreta directamente sintaxis Java.  
B. Siempre es inválido sin `javac`.  
C. El launcher usa source-file mode y gestiona la compilación necesaria.  
D. Genera un ejecutable nativo permanente.

**Respuesta:** C.

---

## 4

Tenemos:

```bash
javac -d classes src/demo/App.java
```

y la clase declara:

```java
package demo;
```

¿Cuál tiene sentido?

A. `java classes/demo/App.class`  
B. `java -cp classes demo.App`  
C. `java -d classes demo.App`  
D. `javac -cp demo.App`

**Respuesta:** B.
