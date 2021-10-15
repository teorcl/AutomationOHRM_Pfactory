Feature:Llenar una nueva vacante con todos los campos y adjuntar un archivo
  como administrador crear una nueva vacante con todos los campos requeridos
  y adjuntar un archivo
  Background:
    Given el empleado administrativo se encuentra logueado en la web de OrangeHRM

  Scenario: Se crea una nueva vacante
    When el empleado quiere crear una nueva vacante
    Then el sistema deberia mostrar un mensaje Sucessfully saved.

 # Scenario: Se carga un archivo
  #  When el empleado quiere cargar un archivo
  #  Then el sistema debera mostrar un mensaje Sucessfully saved.