# Spring Boot / JPA

Fonctionnalités du projet:
  
  -visualisation d'une page d'accueil accessible à l'url : http:localhost:8080/
  
  -accès à une liste de contact par l'acceuil (http:localhost:8080/)
  
  -accès à une base de donnée embarqué h2 à l'adresse http:localhost:8080/h2-console/
  
    User : admin
    
    Password : password
  
  -connexion statique pour utiliser les autres fonctionnalités du site (connexion avec une BD commencée mais pas aboutie(class user))
    
    User : user
    
    Password : secret123
   
   (réalisé à partir des réponses de ce topic stackoverflow : https://stackoverflow.com/questions/49847791/java-spring-security-user-withdefaultpasswordencoder-is-deprecated)
   
   
  -navigation au travers de toutes les pages grâce à des boutons Javascript et des redirections
   
  -création d'un contact
  
  -édition d'un contact
  
  -suppression d'un contact (et de ses adresses mail en cascade)
  
  -ajout d'une adresse mail à un contact
  
  -ajout d'une adresse postale à un contact
  
  -Visualiser tous les contacts au format XML (http:/localhost:8080/xml)
  
  ou un seul contact (http:/localhost:8080/xml?action=contact&id=UnNuméro)
  
  *Made by Hugo Malglaive*
