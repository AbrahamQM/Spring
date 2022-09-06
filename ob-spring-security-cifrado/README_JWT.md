
## JWT "JSON Web Tokens"
*web: https://jwt.io

Es un estándar abierto que permite transmitir información entre dos partes:

## Funcionamiento Sesión
1. Cliente envía una petición a un servidor (api/login)
2. Servidor valida Username y Password, si no son válidos devuelve respuesta 401 unauthorized
3. Servidor valida Username y Password, si son válidos, entonces se almacena el usuario en session
4. Se genera una cookie en el Cliente
5. En próximas peticiones, se comprueba que el cliente está en session

##Funcionamiento o Flujo

1. Cliente envía una petición a un servidor ej: (/api/login)
2. Servidor valida username y la password enviados, 
   -Si no son válidos: Devolverá una respuesta 401 unautorized
   -Si son válidos: Generará un token JWT utilizando una "secret key"

-Entendemos que "Si son válidos"
3. Servidor devuelve el token JWT generado al cliente.
4. Cliente (Guarda el token).
5. Cliente envía peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras
6. Servidor valida el token JWT en cada petición, y si es correcta, permite el acceso a los datos.


##################
Ventajas
*El token se almacena en el Cliente, de manera que consume menos recursos del servidor. Lo cual permite mayor escalabilidad

Desventajas:
*El token está en el navegador, no podríamos invalidarlo antes de la fecha de expiración asignada cuando se creó.
    -Lo que se hace es dar la opción de logout, lo cual simplemente borra el token.

*La información de la session se almacena en el servidor, lo cual consume recursos.


##Estructura del Token JWT

3 partes separadas con "." y codificadas en base 64 cada una: 

1. Header
...JSON
{
   "alg": "S512", //Algoritmo que se esta utilizando: "Ejemplo de algoritmo"
   "typ": "JWT"
}
...

2. Payload //Información, normalmente datos de usuario no sensibles

...JSON
{
"name":"Pepito"
"admin": (true o false)
}
...

3. Signatura

...
HMACKSHA256(
base64UrlEncode(header) + "." + base64UrlEncode(payload), secret
)
...


**Ejemplo del token generado, una vez codificado:
...
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
...

**El User-Agent envía el token JWT en las cabeceras:

...
Authorization: Bearer <token>
...


##Configuración Spring

Crear proyecto Spring Boot con:

*Spring Security
*Spring Web
*Spring boot devtools
*Spring Data JPA
*PostgreSQL

*Swagger 
(No se puede añadir como dependencia desde Spring-Boot al crear el proyecto, añadir la última versión http://springfox.github.io/springfox/docs/current/#getting-started):
...xml
    <depedency>
        <groupId>io.springfox</groupId>
        <artefactId>springfox-boot-starter</artefactId>
        <version>3.0.0</version> //Hay que comprobar la vesrión actual
    </dependency>
...
    -Habría que crear la clase swaggerConfig manualmente 

*Dependencia de jwt (se añade manualmente en pom.xml)

...xml
    <depedency>
        <groupId>io.jsonwebtoken</groupId>
        <artefactId>jjwt</artefactId>
        <version>0.9.1</version> //Hay que comprobar la vesrión actual
    </dependency>
...
