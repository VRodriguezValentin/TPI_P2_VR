El proyecto se encuentra organizado en los siguientes paquetes:
- com.universidad.excepciones: Contiene todas las excepciones personalizadas para manejar errorres especificos del proyecto.
- com.universidad.gestores: Contiene la clase GestorRecursos encanrgada de gestionar todos los tipos de recursos.
- com.universidad.interfaces: Contiene todas las interfaces implementadas.
- com.universidad.prueba: Contiene el main donde se realizan las pruebas del proyecto.
- com.universidad.recursos: Contiene la clase abstracta RecursoAcademico y todas sus clases hijas.

Este sistema de gestion academica fue diseñado teniendo en cunta conceptos de la Programacion Orientada a objetos, como herencia y polimorfismo.
Estos conceptos los podemos ver en la clase abstracta RecursosAcademicos y sus clases hijas Libro, Articulo y TrbajaoInvestigacion las cuales implementan los metodos heredados calcularRelevancia y mostrarDetalles 
ajustando su funcionalidad dependiendo de la clase hija.

La clase GestorRecursos es la encargada de gestionar todos los RecursosAcademicos anteriormente mencionados. 
Esta implementa las interfaces Clasificable y Evaluable con el fin de asignarle categorias a los RecursosAcademicos los cuales al ser creados no poseen una categoria definida,
ademas de realizar evaluaciones sobre los distintos recursos segun su Evaluador correspondiente con el fin de obtener un puntaje final teneindo en cuenta la relevancia del recurso.
Tambien se implementa el uso de la interfaz funcional FiltroRecurso para facilitar el uso de funciones lambda para filtrar recursos.

Por otro lado, posee metodos para filtrar y ordenar recursos y un metodo para generar un informe de los recursos que se encuentran en la lista de recursos.
Esta Lista de tipo RecursoAcademico ademas de poder añadir y remover recursos de la misma, esta puede ser guardada en un archivo definido por el usuario
para luego en la proxima ejecucion del programa cargar los recursos que la lista contenia anteriormente y no perder registro de la misma.
Actualmente ya se encuentra cargado un archivo "recursos.ser" el cual contiene una lista con un recurso del tipo Libro, otro del tipo Articulo y otro del tipo TrabajoInvestigacion.

El proyecto tambien posee las siguientes excepciones personalizadas:
- RecursoNoEncontradoException: No se encuentra el recurso al que se hace referencia.
- CategoriaInvalidaException: La categoria que se quiere asignar no se encuntra en las categorias validas del recurso.
- LimiteRecursosException: Limita la lista de recursos a un tamaño maximo.
- InvalidEvaluator: No se encuentra el Evaluador solicitado dentro del enum.
- InvalidListType: Se quiere asignar un valor nulo a una lista que no lo admite.
- InvalidNumeroPaginas: Se quiere asignar un valor incorrecto(<=0) al numero de paginas.
