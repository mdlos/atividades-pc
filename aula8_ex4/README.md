
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">Agendamento de Tarefas com ScheduledExecutorService - Executando uma Tarefa em um Executor Após um Atraso</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este documento descreve a execução de um programa Java que utiliza ScheduledExecutorService para agendar e executar tarefas com diferentes atrasos. 
O programa foi desenvolvido para testar o comportamento do agendador com vários cenários e garantir sua correta funcionalidade.

Descrição do Código

O programa consiste em duas classes principais:

Classe Task

Implementa a interface Callable<String>.
Formata e exibe a hora de início da execução da tarefa.
Retorna uma mensagem "Hello, world" após a execução.

Classe Main

Cria um ScheduledExecutorService com um pool de 1 thread.
Exibe o horário de início da execução.
Agenda tarefas com diferentes atrasos.
Aguarda a conclusão das tarefas e encerra o executor.
Exibe o horário de término da execução.

## 🗒️ Cenários teste

Cenário 1: Execução com 5 tarefas agendadas com atrasos de 1 a 5 segundos

=======

Cenário 2: Execução com 3 tarefas agendadas com atrasos de 2, 4 e 6 segundos

=======

Cenário 3: Execução com 1 tarefa agendada com atraso de 3 segundos

## 🔧 Conclusão:

O programa demonstrou que ScheduledExecutorService permite agendar tarefas para execução futura com sucesso. 
A implementação garante que as tarefas sejam executadas conforme os atrasos especificados e que o executor seja encerrado corretamente após a conclusão das tarefas. 
Os testes realizados validam o funcionamento adequado do sistema, permitindo aplicações futuras que exijam execução programada de tarefas.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

