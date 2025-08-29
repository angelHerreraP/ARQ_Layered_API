__BIENVENIDO__

Soy Angel Herrera, ing. en Seguridad Informatica y Desarrollo de Software, cuando sali de la carrera y empezar a trabajar
me di cuenta que no tenia idea de muchas cosas que estoy aprendiendo, tratare de escribir en el readme de mis proyectos
con mis palabras lo que entendi y como lo use, si se complica, no dudes en escribir :)


Para este proyecto, estoy usando una DB en PostgreSQL hosteada en Supabase, pero puedes hostearla donde quieras, te comparto la estrutura de mi tabla usuarios:     
-- ==========================================  
CREATE TABLE usuarios (  
id UUID PRIMARY KEY DEFAULT gen_random_uuid(),  
nombre VARCHAR(100) NOT NULL,  
email VARCHAR(150) UNIQUE NOT NULL,  
password_hash TEXT NOT NULL,  
rol VARCHAR(20) CHECK (rol IN ('admin', 'instructor', 'estudiante')) DEFAULT 'estudiante',  
fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
activo BOOLEAN DEFAULT TRUE  
);  
-- ==========================================  

Okay, antes de empezar a desarrollar tu APi, debes saber:
1. Que es un pom.xml  
Aqui vas a cargar todo lo que tu app necesita, por ejemplo, en este proyecto, yo quise usar Lombok, que es una libreria que ahorra demasiado codigo
usualmente lo encuantras como   
<'dependencies>  
    <'dpendency>'  
   /AQUI VA EL CONTENIDO DE LO QUE QUIERAS IMPLEMENTAR  
    <'/dpendency>'  
<'/dependencies>


2. applicacion.properties / application.yml:    
Sirve para configurar el comportamiento de la aplicación: conexión a BD, puertos, logs, etc.  

-- ==========================================  
 
__CARPETAS__  
1. __Model/:__  
   A palabras simples, me gusta ver el model como un objeto de "la DB" en tu programa; por eso, si empatan la tabla DB con el modelo Usuario, se darán cuenta de que es lo mismo. Sin embargo, el modelo también puede incluir funciones simples relacionadas con ese objeto, como métodos para calcular valores derivados o formatear información.2.
2. 



__ORDEN SEGUN YO::__  
1. Model, asi sabemos QUE estamos construyendo
