git init: Inicializa um novo repositório Git vazio. É o primeiro comando a ser usado para começar a usar Git em um projeto.

git clone <url>: Cria uma cópia local de um repositório remoto. O URL pode ser de um repositório no GitHub, GitLab, Bitbucket, etc.

git add <arquivo>: Adiciona mudanças no arquivo especificado para a área de staging (preparação para commit). Pode usar . para adicionar todos os arquivos modificados.

git commit -m "<mensagem>": Cria um commit com as mudanças adicionadas à área de staging, acompanhadas de uma mensagem descritiva.

git status: Mostra o estado atual do repositório, incluindo arquivos modificados, arquivos adicionados para commit e arquivos não rastreados.

git log: Exibe o histórico de commits do repositório, mostrando a sequência de commits, mensagens, autores e datas.

git diff: Mostra as diferenças entre o estado atual dos arquivos e o último commit. Pode ser usado para ver alterações não adicionadas ao staging.

git branch: Lista todas as branches no repositório. Pode ser usado com um nome para criar uma nova branch ou mudar para uma branch existente.

git checkout <branch>: Muda para a branch especificada. Pode ser usado também para restaurar arquivos para o estado de um commit anterior.

git merge <branch>: Integra as mudanças de uma branch especificada à branch atual. Usado para combinar alterações feitas em diferentes branches.

git pull: Atualiza a branch local com as mudanças mais recentes do repositório remoto. É uma combinação de git fetch e git merge.

git push: Envia commits da branch local para o repositório remoto, atualizando-o com as últimas alterações.

git remote: Gerencia repositórios remotos. Usado para adicionar, remover ou listar repositórios remotos.
