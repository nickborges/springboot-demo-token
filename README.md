# springboot-demo-auth
autenticação via JJWT


### AUTENTICAÇÃO:
- Habilitar o Spring Security com a dependência(JJWT)
- Habilitar a jpa
- Criar a Entity, Perfil que implementa GrantedAuthority:
    * GrantedAuthority = diz para o spring que é a classe que representa o perfil de acesso.
- Colocar na Entity Usuario, implements UserDetails
- Criar a classe de configuração, SecurityConfigurations
- Criar a classe de serviço, AutenticacaoService
- Criar o controller /auth

-Exemplos de chamada:
    * http://localhost:8082/
    * http://localhost:8080/auth { "email": "aluno@email.com", "password": "123456"}

- Observações:
    * Security: autenticação tradicional, com usuário e senha, sempre que o usuário efetua login, o servidor cria uma sessão para guardar essas informações e a cada requisição o servidor valida os dados desta requisição com a sessão armazenada em memória (precisando ter bastante espaço em memória para armezenar cada requisição). Isso não atende a boa prática(princípio) do modelo REST, o ideal é que a autenticação seja stateless(no caso do token).
    * Security JWT: Não cria uma sessão como no modo tradicional, usa o padrão Stateless ou “Sem estado”
    * Stateless ou Sem estado(é um protocolo de comunicação que considera cada requisição como uma transação independente que não está relacionada a qualquer requisição anterior, depois do retorno da requisição nenuma sessão é armazenada.)
    * OAuth2: