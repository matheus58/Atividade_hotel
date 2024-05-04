# Atividade_hotel

## Tutorial: Como integrar as branches no projeto

Após clonar o repositório, siga estes passos para garantir que o projeto funcione corretamente:

1. Após o processo de clone, é possível que o arquivo 'JRE System Library' não apareça automaticamente. Para corrigir isso, clique com o botão direito na pasta "SRC" e selecione "Build Path" > "Configure Build Path".

    ![Passo 1](https://github.com/matheus58/Atividade_hotel/assets/101297032/5e85e3bd-5508-4e65-ad3a-c26467200579)

2. Na janela que se abre, certifique-se de que a opção "JRE System" esteja ativada. Em seguida, clique em "Apply and Close".

    ![Passo 2](https://github.com/matheus58/Atividade_hotel/assets/101297032/3192fbe8-a724-4d8c-943f-2da8cfdf7405)

Além disso, para integrar as mudanças de diferentes branches em seu projeto, você pode seguir este guia:

1. Verificar a branch atual: Use o comando `git branch` para verificar em qual branch você está trabalhando atualmente.

2. Mudar para a branch de destino: Se você não estiver na branch onde deseja mesclar as mudanças, use o comando `git checkout nome-da-branch`.

3. Realizar o merge: Use o comando `git merge nome-da-outra-branch` para mesclar as mudanças da outra branch na branch atual.

4. Resolver conflitos (se necessário): Se houver conflitos durante o merge, resolva-os manualmente editando os arquivos em conflito, adicione-os ao índice e conclua o merge.

5. Verificar o resultado: Após o merge, verifique o resultado usando `git status` e `git log` para garantir que todas as mudanças tenham sido incorporadas corretamente.

Espero que isso ajude a garantir que seu projeto funcione corretamente e que você possa integrar as mudanças das diferentes branches de forma eficiente.

