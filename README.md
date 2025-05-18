# 🎓 Proyecto de Gestión Académica - Universidad 📘🧠

## 🗂️ Organización del Proyecto

El proyecto está organizado en los siguientes paquetes:

- 📦 `com.universidad.excepciones`  
  Contiene todas las **excepciones personalizadas** para manejar errores específicos del sistema.

- 📦 `com.universidad.gestores`  
  Incluye la clase `GestorRecursos`, encargada de gestionar todos los tipos de recursos académicos.

- 📦 `com.universidad.interfaces`  
  Contiene todas las **interfaces** utilizadas e implementadas por las clases del proyecto.

- 📦 `com.universidad.prueba`  
  Contiene el método `main`, donde se realizan las **pruebas de ejecución** del sistema.

- 📦 `com.universidad.recursos`  
  Alberga la clase abstracta `RecursoAcademico` y todas sus **clases hijas**.

---

## 💡 Principios de Programación Orientada a Objetos

Este sistema fue diseñado aplicando **conceptos fundamentales de la POO**, como:

- 🧬 **Herencia**
- 🌀 **Polimorfismo**

Estos conceptos se reflejan en la clase abstracta `RecursoAcademico` y sus subclases:

- 📖 `Libro`
- 📰 `Articulo`
- 🧪 `TrabajoInvestigacion`

Cada una **implementa y redefine** los métodos heredados como `calcularRelevancia()` y `mostrarDetalles()` según su propio comportamiento.

---

## 🧠 Clase Principal: `GestorRecursos`

La clase `GestorRecursos` es la responsable de gestionar todos los `RecursoAcademico`.

### 🔗 Interfaces implementadas

- `Clasificable`  
  Permite **asignar categorías** a los recursos académicos, los cuales inicialmente no tienen una categoría definida.

- `Evaluable`  
  Permite realizar **evaluaciones** sobre los recursos con su **Evaluador correspondiente**, obteniendo un **puntaje final** en base a su relevancia.

- `FiltroRecurso` (funcional)  
  Facilita el uso de **expresiones lambda** para **filtrar** recursos de forma flexible.

---

## 🧾 Funcionalidades adicionales

- 📌 Métodos para **filtrar** y **ordenar** recursos.
- 📄 Generación de un **informe** completo de los recursos registrados.
- 💾 Permite **guardar** la lista de recursos en un archivo definido por el usuario.
- 🔁 En la próxima ejecución del programa, se pueden **recuperar los recursos** guardados previamente desde un archivo `recursos.ser`.

> 🗃️ El archivo `recursos.ser` ya contiene una lista precargada con:
> - 1 recurso del tipo `Libro` 📘  
> - 1 recurso del tipo `Artículo` 📰  
> - 1 recurso del tipo `TrabajoInvestigacion` 🧪  

---

## ⚠️ Excepciones Personalizadas

El sistema cuenta con las siguientes excepciones:

- ❌ `RecursoNoEncontradoException`  
  Se lanza cuando no se encuentra el recurso referenciado.

- 🚫 `CategoriaInvalidaException`  
  La categoría asignada no está entre las válidas del recurso.

- 📏 `LimiteRecursosException`  
  Límite máximo de recursos en la lista alcanzado.

- 👤 `InvalidEvaluator`  
  Evaluador solicitado no encontrado en el `enum`.

- 🧾 `InvalidListType`  
  Se intenta asignar un valor `null` a una lista que no lo admite.

- 📉 `InvalidNumeroPaginas`  
  Se intenta asignar un número de páginas inválido (`<= 0`).

---

## ✅ Estado Actual

🟢 El proyecto está completamente funcional y listo para ser probado.  
📁 El archivo `recursos.ser` ya cargado facilita la prueba inicial sin necesidad de crear nuevos recursos manualmente.

---

👨‍💻 *Desarrollado aplicando buenas prácticas de diseño orientado a objetos.*  
🚀 ¡Listo para escalar e integrar nuevas funcionalidades!


