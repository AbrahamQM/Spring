
## Open Authorization (OAuth)

Es un framework de autorización, abierto y está construido por estándares IETF y licenciado bajo Open Web Foundation.

Es un protocolo de delegación:

Permite que alguien que controle un recurso, permita a una aplicación de (software de terceros), acceder a ese recurso en su propio nombre, sin pasar por ello.

(Es cuando una app o web, te permite registrarte con una cuenta de google, facebook, ..., para evitarnos tener que introducir todos los datos de registro)

Con la ayuda de OAuth, los usuarios pueden autorizar a third part applications a acceder a sus datos o ejecutar determinadas operaciones, sin necesidad de proporcionar usuario y contraseña.

##Flujo de trabajo con OAuth:

1. Una aplicación solicita autenticación
2. Se realiza login mediante google, github, facebook, ...
3. La aplicación en sí, se comunica con Google (o la que sea), donde utilizan las credenciales de Google (o la que sea), sin que la aplicación pueda verlas.
4. El servidor de Google (o la que sea), pregunta al usuario si desea conceder X permisos.
5. El usuario acepta los permisos.
6. Google genera un token de acceso como respuesta.
7. La aplicación utiliza ese token, (Nunca verá los datos de autenticación).


## Escenarios para utilizar OAuth

1. Autenticación HTTP en la que no se quiere utilizar usuario y contraseña todo el tiempo.
2. Múltiples aplicaciones dentro de una misma empresa y en consecuencia múltiples.
3. Arquitecturas de microservicios.
4. Interacción de aplicaciones de terceros.


## Proveedores

Google, Github, Facebook, Okta

##OAuth en Spring Security

Inicialmente había un proyecto llamado "Spring Security OAuth".

En 2018 se sobreescribe para hacerlo más eficiente, con un código base más sencillo.

Se depreca el antiguo (https://spring.io/projects/spring-security-oauth) y ahora OAuth está integrado en el propio Spring Security

Incluye:

*Client Support
*Resource server
-----------------
*Authorization Server(en proceso): https://github.com/spring-projects/spring-authorization-server
*Keycloak()Herramienta para gestionar usuarios: https://www.keycloak.org/ ---  https://www.keycloak.org/docs/latest/getting_started/index.html
*Ver ejemplos de aplicaciones: https://github.com/spring-guides/tut-spring-boot-oauth2

##Flujos de acción OAuth:

*Authorization code.
*Implicit.
*Resource Owner password credentials.
*Client Credentials.
*Refresh Token.

##OpenID Connect

*OpenID Connect --> Authentication
*Oauth 2.0 --> Authorization
*http
