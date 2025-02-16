
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Sistema de Fila de Impressão com Controle de Acesso Concorrente - Controle de Acesso Concorrente a Múltiplas Cópias de um Recurso</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este sistema simula uma fila de impressão onde múltiplas threads competem pelo acesso a um conjunto de impressoras. O controle do acesso concorrente é feito utilizando a classe Semaphore para limitar o número de threads que podem acessar as impressoras simultaneamente. Cada impressora é representada como um recurso compartilhado, e o acesso é coordenado para garantir que o número de threads simultâneas seja respeitado.

Funcionamento

O sistema é composto por três principais classes:

Job: Representa uma tarefa de impressão que é executada em uma thread separada. Cada tarefa solicita a impressão de um documento usando a fila de impressão.
PrintQueue: Controla o acesso às impressoras. Utiliza um semáforo para limitar o número de threads que podem imprimir simultaneamente e um Lock para garantir que o acesso ao array de impressoras seja seguro.
Main: Classe principal que inicializa o sistema de fila de impressão e cria várias threads para simular os trabalhos de impressão.

Processos:

Quando uma thread é criada, ela tenta adquirir uma permissão do semáforo. Se houver permissões disponíveis, ela consegue acesso a uma impressora.
Após concluir o trabalho de impressão, a thread libera a impressora, permitindo que outra thread acesse uma impressora disponível.
O tempo de impressão é simulado com um intervalo aleatório entre 0 e 9 segundos.

## 🗒️ Cenários teste

Cenário 1: Semáforo com 3 Permissões e 3 Impressoras
Configuração: Semaphore(3) e 3 impressoras disponíveis.

Resultado:

Apenas 3 threads podem acessar as impressoras simultaneamente.
Quando uma thread termina a impressão, outra thread é liberada para acessar uma impressora.

=======

Cenário 2: Semáforo com 2 Permissões e 3 Impressoras
Configuração: Semaphore(2) e 3 impressoras disponíveis.

Resultado:

Apenas 2 threads podem acessar as impressoras simultaneamente, independentemente de o número de impressoras ser maior.


=======

Cenário 3: Semáforo com 1 Permissão e 3 Impressoras
Configuração: Semaphore(1) e 3 impressoras disponíveis.

Resultado:

Apenas 1 thread pode acessar as impressoras por vez, similar a um lock exclusivo.

## 🔧 Conclusão:

O uso do Semaphore e do Lock garante que o acesso às impressoras seja controlado adequadamente, permitindo que apenas um número limitado de threads acessem os recursos simultaneamente. 
O sistema foi testado em diferentes cenários de semáforo, e os resultados confirmam que a solução lida corretamente com a concorrência, respeitando as permissões de acesso e gerenciando os recursos de forma eficiente.


## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

