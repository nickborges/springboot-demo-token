# springboot-demo-token
autenticação via JJWT


### AUTENTICAÇÃO:
- Habilitar o Spring Security com a dependência(JJWT)
- Habilitar o jpa
- Criar a Entity, Perfil que implementa GrantedAuthority:
    * GrantedAuthority = diz para o spring que é a classe que representa o perfil de acesso.
- Colocar na Entity User, implements UserDetails
- Criar a classe de configuração, SecurityConfigurations
- Criar a classe de serviço, AutenticacaoService
- Criar o Controller:
    * AuthenticationManager: cria a autenticação e geração do token (deve sobrescrever o método authenticationManager na classe SecurityConfigurations para que possa ser injetado no controller)
- Criar a classe ExceptionsHandler: para capturar AuthenticationException captura o erro ao tentar gerar o token (retornar 400)
- Criar a classe TokenService: para gerar o token

- Exemplo de chamada para gerar o Token:
    ````
      curl --location --request POST 'http://localhost:8083/auth' \
      --header 'Authorization: Basic dXNlckBnbWFpbC5jb206JDJhJDEwJFFVOVpLRWpmZTVJUXRMaTdNU0x6SXV1Z3Zwcko3RERNMVYub21GczZha2ZyaUhWbG5jejVT' \
      --header 'Content-Type: application/json' \
      --data-raw '{
        "email": "user@gmail.com", 
        "password": "abcd"
      }'
    ````

- Observações:
    * Security: autenticação tradicional, com usuário e senha, sempre que o usuário efetua login, o servidor cria uma sessão para guardar essas informações e a cada requisição o servidor valida os dados desta requisição com a sessão armazenada em memória (precisando ter bastante espaço em memória para armezenar cada requisição). Isso não atende a boa prática(princípio) do modelo REST, o ideal é que a autenticação seja stateless(no caso do token).
    * Security JWT: Não cria uma sessão como no modo tradicional, usa o padrão Stateless ou “Sem estado”
    * Stateless ou Sem estado(é um protocolo de comunicação que considera cada requisição como uma transação independente que não está relacionada a qualquer requisição anterior, depois do retorno da requisição nenuma sessão é armazenada.)
    * OAuth2: