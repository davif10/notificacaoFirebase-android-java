# notificacaoFirebase-android-java
 Aplicativo que mostra o uso de notificações.
 
 Pode ser usado para orientar o usuário sobre algum fato novo ou simplesmente algo que possa interessar o usuário.
Para utilizar o projeto e realizar os testes, é necessário criar um projeto no [Firebase](https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fconsole.firebase.google.com%2F%3Fhl%3Dpt-br&followup=https%3A%2F%2Fconsole.firebase.google.com%2F%3Fhl%3Dpt-br&hl=pt-br&flowName=GlifWebSignIn&flowEntry=ServiceLogin) e configurar seguindo o passo a passo. As bibliotecas já estão configuradas no gradle, mas é necessário trocar o arquivo do google-services.json para que tenha as configurações do seu projeto.
O recurso que está sendo utilizado é o [Cloud Messaging](https://firebase.google.com/docs/cloud-messaging?authuser=0) para o envio das notificações.
