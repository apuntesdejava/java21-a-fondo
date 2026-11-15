# Quiz - Objetos, referencias y construcción

## 1. ¿Cuántos objetos se crean?

```java
Coffee a = new Coffee();
Coffee b = a;
Coffee c = new Coffee();
```

A. 1  
B. 2  
C. 3  
D. Depende del garbage collector.

**Respuesta: B.**

Se evalúan dos expresiones `new Coffee()`. La asignación `b = a` copia el valor de referencia, no crea otra instancia.

---

## 2. ¿Qué imprime?

```java
class Coffee {
    int temperature;
}

public class Test {
    public static void main(String[] args) {
        Coffee first = new Coffee();
        Coffee second = first;

        first.temperature = 90;

        System.out.println(second.temperature);
    }
}
```

A. `0`  
B. `90`  
C. `null`  
D. No compila.

**Respuesta: B.**

`first` y `second` permiten acceder al mismo objeto.

---

## 3. ¿Constructor o método?

```java
class Robot {
    void Robot() {
    }
}
```

¿Cuál es la afirmación correcta?

A. `Robot()` es el constructor por defecto.  
B. `Robot()` es un constructor explícito.  
C. `Robot()` es un método.  
D. La clase no compila.

**Respuesta: C.**

La declaración tiene return type `void`, por lo que es un método.

---

## 4. Constructor por defecto

```java
class Coffee {
    Coffee(int size) {
    }
}
```

¿Qué ocurre con:

```java
new Coffee();
```

A. Compila y usa el constructor por defecto.  
B. Compila y asigna `0` a `size`.  
C. No compila porque no existe un constructor sin argumentos aplicable.  
D. Falla solo en runtime.

**Respuesta: C.**

Al declarar un constructor explícito, Java no declara implícitamente el constructor por defecto.

---

## 5. Valores iniciales

```java
class Robot {
    int battery;
    boolean active;
    String name;
}
```

Después de crear un `Robot`, ¿cuáles son los valores iniciales de esos fields?

A. `null`, `false`, `null`  
B. `0`, `false`, `null`  
C. `0`, `true`, `""`  
D. No tienen valor hasta que el constructor los asigne.

**Respuesta: B.**

Los fields de instancia reciben valores iniciales por defecto.

---

## 6. Orden de inicialización

```java
class Robot {

    String first = trace("field 1");

    {
        trace("initializer 1");
    }

    Robot() {
        trace("constructor");
    }

    static String trace(String value) {
        System.out.println(value);
        return value;
    }
}
```

¿Cuál es la salida al ejecutar `new Robot()`?

A.
```text
constructor
field 1
initializer 1
```

B.
```text
field 1
initializer 1
constructor
```

C.
```text
initializer 1
field 1
constructor
```

D. No compila.

**Respuesta: B.**

En el modelo simple estudiado aquí, field initializers e instance initializer blocks se siguen en orden textual antes del cuerpo del constructor.

---

## 7. Compile-time o runtime

```java
class Coffee {
    Coffee(int size) {
        System.out.println("constructor");
    }
}

public class Test {
    public static void main(String[] args) {
        new Coffee();
    }
}
```

¿Qué ocurre?

A. Imprime `constructor`.  
B. No imprime nada porque el constructor está vacío.  
C. Lanza una excepción en runtime.  
D. No compila.

**Respuesta: D.**

No existe un constructor aplicable a `new Coffee()`.

---

## 8. Reasignación

```java
Coffee coffee = new Coffee();
coffee = new Coffee();
```

¿Cuál es la mejor descripción?

A. El primer objeto se transforma en el segundo.  
B. La variable `coffee` pasa a contener otra referencia.  
C. Se copian todos los fields del primer objeto al segundo.  
D. El primer objeto se elimina inmediatamente.

**Respuesta: B.**

La reasignación cambia el valor de referencia almacenado en la variable.

Este episodio no determina todavía qué ocurre después con reachability o garbage collection.

---

## 9. Crear sin variable

```java
new Coffee();
```

¿Cuál es la afirmación correcta?

A. No compila porque falta una variable.  
B. Compila, pero no se crea ningún objeto.  
C. Puede crear una instancia aunque no se conserve la referencia resultante.  
D. Solo es válido dentro de un constructor.

**Respuesta: C.**

Una class instance creation expression puede evaluarse sin que su valor quede asignado a una variable.

---

## 10. Referencia y memoria

¿Cuál de estas afirmaciones es la más precisa para este curso?

A. Una referencia Java es necesariamente una dirección física de memoria visible.  
B. Una referencia es un valor del lenguaje que permite referirse a un objeto.  
C. Una referencia y el objeto son la misma entidad.  
D. Todas las referencias almacenan exactamente la misma representación binaria en todas las JVM.

**Respuesta: B.**

La JLS define valores de referencia. La representación física concreta pertenece a la implementación y no forma parte del modelo que necesitamos para razonar el lenguaje.
