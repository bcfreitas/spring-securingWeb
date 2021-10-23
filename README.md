# spring-securingWeb



As views ficam disponíveis na pasta /src/main/resources/templates, e são templates do starter Thymeleaf.

A aplicação é baseada em Spring MVC, por isso é preciso criar a classe MvcConfig que implementa WebMvcConfigurer. Nesta classe são configurados os controladores de views que serão utilizados pela aplicação e exporão os templates. 

A view hello, assim como qualquer outra diferente da raiz, /home, /login e /logout, é protegida pelo Spring Security (spring-boot-starter-secutiry), que automaticamente usa segurança com autenticação básica "HTTP".
