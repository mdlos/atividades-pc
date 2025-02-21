
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">Teste de Agendador de Tarefas com ScheduledExecutorService - Executando uma Tarefa em um Executor Periodicamente</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto tem como objetivo testar e analisar o comportamento do ScheduledExecutorService em diferentes cenários de agendamento de tarefas em Java. 
Foram realizadas execuções periódicas com intervalos variados para avaliar a precisão e confiabilidade do agendador.

Estrutura do Código

O código é composto por duas classes principais:

Task

Implementa Runnable.
Exibe a data e hora da execução.
Simula uma tarefa com tempo de execução variável.

Main

Instancia ScheduledExecutorService.
Agenda tarefas com scheduleAtFixedRate.
Monitora o tempo restante para a próxima execução.
Finaliza o executor após determinado tempo.

## 🗒️ Cenários teste

Cenário 1: Intervalo de 2 segundos

A tarefa inicia após 1s e executa a cada 2s.
O tempo restante para a próxima execução é monitorado.
Execuções nos tempos esperados: (1s, 3s, 5s, etc.).

=======

Cenário 2: Intervalo de 3 segundos

A tarefa inicia após 1s e executa a cada 3s.
O tempo restante para a próxima execução é monitorado.
Execuções nos tempos esperados: (1s, 4s, 7s, etc.).

=======

Cenário 3: Intervalo de 1 segundo

A tarefa inicia após 1s e executa a cada 1s.
Execuções nos tempos esperados: (1s, 2s, 3s, etc.).

## 🔧 Conclusão:

ScheduledExecutorService é eficiente para tarefas periódicas.
Os intervalos foram mantidos com precisão.
shutdown() garante o encerramento adequado do executor.
O método é indicado para aplicações que exigem execuções regulares e previsíveis.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

