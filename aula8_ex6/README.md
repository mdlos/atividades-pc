
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">TControle de Execução de Tarefas com ThreadPoolExecutor - Cancelando uma Tarefa em um Executor</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto demonstra o uso de ThreadPoolExecutor para gerenciar a execução de tarefas concorrentes em Java. 
A implementação utiliza a interface Callable para criar uma tarefa (Task) que executa um loop infinito, imprimindo uma mensagem periodicamente. 
A classe Main coordena a submissão e o cancelamento da tarefa, explorando diferentes cenários de execução.

Estrutura do Código

O projeto é composto por duas classes principais:

Classe Task (Task.java)
Implementa Callable<String>.
Executa um loop infinito imprimindo uma mensagem a cada 100ms.
Simula uma tarefa de longa duração.

Classe Main (Main.java)

Cria um ThreadPoolExecutor usando Executors.newCachedThreadPool().
Submete a Task ao executor.
Aguarda um tempo antes de cancelar a tarefa.
Verifica o status da tarefa após o cancelamento.
Finaliza o executor.

## 🗒️ Cenários teste

O código foi projetado para testar diferentes situações de execução e cancelamento de tarefas:

Cenário 1: Tarefa cancelada após 2 segundos

A tarefa inicia a execução.
Após 2 segundos, a tarefa é cancelada.
isCancelled() retorna true, indicando que a tarefa foi interrompida.
isDone() retorna true, pois a tarefa foi concluída ou cancelada.

=======

Cenário 2: Tarefa não cancelada

A tarefa é submetida e executada indefinidamente.
O cancelamento da tarefa é omitido.
O executor.shutdown() é chamado, mas a tarefa pode continuar em execução até que seja interrompida manualmente.

=======

Cenário 3: Tarefa cancelada imediatamente

A tarefa é submetida ao executor.
A tarefa é cancelada imediatamente.
isCancelled() retorna true.
isDone() retorna true.
O executor é finalizado corretamente.

## 🔧 Conclusão:

Este exercicio demonstra de forma eficaz o gerenciamento de tarefas concorrentes em Java, permitindo explorar diferentes estratégias de cancelamento e verificação de status. 
O uso do Future.cancel(true) permite interromper a tarefa em execução, e o shutdown() garante o encerramento adequado do executor.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

