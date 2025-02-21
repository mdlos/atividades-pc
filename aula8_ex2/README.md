
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">Validador de Usuário com ExecutorService - Executando Múltiplas Tarefas e Processando o Primeiro Resultado</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto implementa um sistema de validação de usuário utilizando Callable, ExecutorService e invokeAny(). 
O objetivo é simular a verificação de credenciais em múltiplos validadores (por exemplo, um banco de dados e um servidor LDAP) e retornar a primeira resposta bem-sucedida.

Estrutura do Projeto

O projeto é composto pelas seguintes classes:

TaskValidator: Implementa a interface Callable<String> para validar credenciais em um validador específico.
UserValidator: Simula a validação de um usuário em diferentes fontes (LDAP, banco de dados).
Main: Classe principal que gerencia a execução concorrente das validações e exibe os resultados.

Funcionamento

Dois validadores são criados: um para LDAP e outro para banco de dados.
Cada validador simula um tempo aleatório de processamento antes de retornar um resultado.
O ExecutorService executa ambas as tarefas simultaneamente e retorna a primeira resposta bem-sucedida.
Se ambos os validadores falharem, uma exceção é lançada.

## 🗒️ Cenários teste

Cenário 1: Validação bem-sucedida pelo validador LDAP
Cenário 2: Validação bem-sucedida pelo validador Database
Cenário 3: Nenhum validador bem-sucedido

## 🔧 Conclusão:

O exercicio demonstra a utilização eficiente de ExecutorService para processar validações concorrentes, melhorando a performance ao reduzir o tempo de espera para uma resposta válida. 
O método invokeAny() é ideal para cenários onde apenas o primeiro resultado bem-sucedido é necessário.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

