# Proyecto Integrador Portfolio Web Full Stack Argentina Programa #YoProgramo 3era Edicion - BACKEND

![213378693-8f3a8919-d1a7-4194-9c50-538b720f9911](https://user-images.githubusercontent.com/97917996/213384834-3af0ca33-7ad1-432a-8248-12790043b025.png)


API REST del Portfolio Argentina Programa, desarrollada en Spring Boot 3.0, Java 17 y conectando con una base de datos MySQL. Con funcionalidad de registro de nuevos usuarios y logueo para poder editar el portfolio. Para la autenticacion usamos JWT y como agregado extra se le agrego la posibilidad de asignar roles de usuario, al no haber una logica de negocio todos los usuarios son creados con el rol de USER. Tambien se dejo implementada con Java Mail Sender la posibilidad de activar las cuentas de usuario mediante el envio de un token por mail el cual el usuario al acceder al link activa su cuenta, registrando el estado activo en la base de datos, por el momento queda comentado para customizar la implementacion (buscar en el archivo bajo la carpeta de seguridad AuthService.java). La API se documento toda en Swagger2

![image](https://user-images.githubusercontent.com/97917996/213387341-d817f115-dd68-4606-a9ae-412b1b1213e5.png)

**Esquema de la Base de Datos**
![image](https://user-images.githubusercontent.com/97917996/213388439-9eed85fd-7a44-460e-b59c-2ecf2083f32e.png)

# **Link de Swagger**
https://engaged-range-374821.rj.r.appspot.com/swagger-ui/index.html

# **Link del Front**
https://github.com/nnfromthewindow/portfolio-ap
