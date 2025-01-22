# language: pt

@Register
Funcionalidade: Realizar cadastro de novo usuário

  Cenário: CT01 - Cadastrar novo usuário com sucesso
    Dado que eu acesso o site do Seu Barriga
    E clico no menu "Novo Usuário"
    E preencho os campos obrigatórios
    Quando clico no botão "Cadastrar"
    Então vejo a mensagem "Usuário inserido com sucesso"
    E sou redirecionado para a página de login
