
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Sistema de Fila de Impressão - Controle de Acesso Concorrente a um Recurso</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto implementa um sistema de fila de impressão ( PrintQueue) que utiliza um Semaphore para controlar o acesso concorrente de múltiplas threads ao recurso de impressão.
O Semaphore garante que apenas um número limitado de threads possa acessar o recurso simultaneamente, proporcionando sincronização eficiente e evitando concorrência excessiva.

Estrutura do Código

O sistema é composto por três classes principais:

Job.java: Representa uma tarefa de impressão executada em uma thread separada.
PrintQueue.java: Implementa a fila de impressão e gerencia o acesso concorrente através de um semáforo.
Main.java: Inicializa o sistema e cria múltiplas threads para simular trabalhos de impressão.

## 🗒️ Cenários teste

Cenário 1: Semáforo com 2 Permissões (Semaphore(2))

Apenas 2 threads podem acessar o recurso de impressão simultaneamente.
Quando uma thread termina a impressão, outra é liberada.
Execução eficiente com controle de concorrência adequado.

=======

Cenário 2: Semáforo com 1 Permissão (Semaphore(1))

Apenas 1 thread pode acessar o recurso de cada vez, tornando a execução sequencial.
Funciona como um bloqueio exclusivo.
Tempo de execução total mais longo.

=======

Cenário 3: Semáforo com 3 Permissões (Semaphore(3))

Até 3 threads podem acessar o recurso simultaneamente.
Maior concorrência, reduzindo o tempo total de execução.
Pode haver maior sobrecarga no gerenciamento de threads.


## 🔧 Conclusão:

O uso de Semaphore permite um controle eficiente do acesso concorrente, evitando conflitos e garantindo a correta execução das tarefas de impressão. 
O sistema pode ser ajustado para otimizar o desempenho conforme a necessidade da aplicação.


## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

