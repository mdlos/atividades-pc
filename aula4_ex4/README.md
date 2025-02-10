
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Tratamento de Exceções em Threads - Processando Exceções Não Controladas em
uma Thread</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto demonstra o uso da interface UncaughtExceptionHandler para capturar e tratar exceções não tratadas em threads. Foram implementadas classes que simulam cenários reais de execução de threads com e sem exceções, permitindo a observação do comportamento do tratamento de erros em um ambiente multithreading.

O projeto é composto pelas seguintes classes:

1. ExceptionHandler

Implementa UncaughtExceptionHandler para capturar exceções não tratadas em threads.

Exibe informações detalhadas sobre a exceção, incluindo:
ID da thread
Tipo e mensagem da exceção
Stack trace

Estado da thread

2. Task

Implementa Runnable e simula uma tarefa que pode lançar uma exceção.
Tenta converter uma string inválida para um inteiro, gerando uma NumberFormatException.
Captura a exceção e a re-lança para testar o UncaughtExceptionHandler.

3. Main

Cria e inicia threads para testar o tratamento de exceções.
Define um UncaughtExceptionHandler para cada thread.

Testa dois cenários:

Thread com exceção: Simula erro ao converter uma string inválida.
Thread sem exceção: Executa normalmente sem erros.

## 🗒️ Cenários teste

Cenário 1: Thread com Exceção

Comportamento esperado:

A thread lança uma NumberFormatException.
O UncaughtExceptionHandler captura e exibe os detalhes da exceção.

=======
Cenário 2: Thread sem Exceção

Comportamento esperado:

A thread executa normalmente.
O UncaughtExceptionHandler não é acionado.


## 🔧 Conclusão:

O UncaughtExceptionHandler foi eficaz na captura de exceções não tratadas em threads.
Diferentes cenários foram testados para validar o comportamento do handler.
A abordagem garante que erros inesperados sejam registrados corretamente, facilitando a depuração em aplicações multithreading.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>


## 🎥 Demonstração: 

=======

