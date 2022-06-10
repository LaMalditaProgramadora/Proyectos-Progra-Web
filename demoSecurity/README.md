# Proyecto: demoSecurity

## Features

* Inicia sesión con usuarios ROLE_ADMIN y ROLE_USER.
* Registra usuarios y les da el rol ROLE_USER.
* Un usuario ROLE_USER puede listar productos.
* Un usuario ROLE_ADMIN puede listar productos y registrar productos.
* Cierra sesión.

## Información adicional
* Se necesita crear la base de datos bd_demo_security. Los credenciales se deben cambiar el application.properties.
* Para cambiar el rol a ROLE_ADMIN, se deberá cambiar desde BD.
* Para cambiar el rol con el que se crea el usuario, cambiar el nombre del rol en UsersServiceImpl.
