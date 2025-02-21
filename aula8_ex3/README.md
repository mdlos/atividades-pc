
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">Execução das Tarefas Concorrentes - Executando Múltiplas Tarefas e Processando Todos os Resultados</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto implementa a execução de tarefas concorrentes em Java usando a interface Callable, a classe Future e um ExecutorService com invokeAll(). 
O código simula execuções paralelas de tarefas, cada uma com um tempo de execução aleatório e um valor de resultado gerado dinamicamente.

Estrutura do Código

Classe Result: Representa o resultado de uma tarefa, contendo o nome da tarefa e o valor calculado.
Classe Task: Implementa Callable<Result>, simulando o processamento de uma tarefa com tempo aleatório.
Classe Main: Gerencia a execução concorrente das tarefas usando um ExecutorService.

## 🗒️ Cenários teste

Cenário 1: Execução com 3 Tarefas

Descrição: Três tarefas são submetidas ao executor, cada uma com um tempo de processamento aleatório entre 0 e 10 segundos.

=======

Cenário 2: Execução com 5 Tarefas

Descrição: Cinco tarefas são submetidas ao executor, cada uma com um tempo de processamento aleatório entre 0 e 10 segundos.

=======

Cenário 3: Execução com 1 Tarefa

Descrição: Apenas uma tarefa é submetida ao executor.

## 🔧 Conclusão:

O código demonstrou o uso de ExecutorService para a execução concorrente de tarefas. O método invokeAll() aguarda a finalização de todas as tarefas antes de continuar, garantindo que os resultados possam ser processados corretamente. 
O uso de Future permite acessar os resultados de forma segura. 
A abordagem utilizada é eficiente para cenários onde é necessário aguardar a conclusão de todas as tarefas antes de prosseguir.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

