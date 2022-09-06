
## CIFRADO

Es el proceso de codificar la información de su representación original (texto plano)
a texto cifrado, de manera que solamente pueda ser descifrado utilizando una clave.

*Historia del CIFRADO:

1. Almacenar las contraseñas en texto plano

2. Almacenar contraseñas cifradas (Aplicando una función "hash") 

3. Almacenar contraseñas cifradas (Aplicando una función "hash") y agregándole una palabra clave "salt"
SALT- Es un texto aleatorio generado que funcionaría como otra contraseña, pero generadola aleatoriamente 
y diferente para cada usuario. Cómo si tuvieras 2 contraseñas.

4. Almacenar contraseñas cifradas con una función adaptativa + factor de trabajo

La seguridad se gana haciendo que la validación de contraseñas sea costosa computacionalmente.

## Algoritmos de Spring Security

* BCrypt
* PBKDF2
* scrypt
* argon2