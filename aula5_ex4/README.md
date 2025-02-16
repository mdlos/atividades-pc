
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Sincronização em Sistemas Multithreading - Organização de Atributos Independentes em Classes Sincronizadas</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este documento apresenta os testes realizados em dois cenários distintos para controle de concorrência na classe Cinema, que gerencia a venda e 
devolução de ingressos para duas salas de cinema. 
O objetivo é comparar o impacto da sincronização global da classe com a sincronização específica por atributo usando Locks
Os dois cenários analisados são:
Sincronização Global da Classe - Utiliza a palavra-chave synchronized em todos os métodos.
Sincronização Específica por Atributo - Utiliza ReentrantLock para cada sala de cinema separadamente.

## 🗒️ Cenários teste

Cenário 1: Sincronização Global da Classe

Descrição

Neste cenário, todos os métodos da classe Cinema são sincronizados globalmente, garantindo que apenas uma thread possa acessar qualquer método por vez. 
Isso previne condições de corrida, mas pode reduzir o desempenho devido ao bloqueio de threads concorrentes.

Comportamento Esperado

Apenas uma thread pode acessar qualquer método da classe por vez.
Condições de corrida são evitadas.
Pode ocorrer um gargalo de desempenho, pois threads que poderiam operar em cinemas diferentes são bloqueadas.

Resultados Obtidos

O sistema manteve consistência nos dados.
O desempenho foi afetado devido ao bloqueio global, reduzindo a paralelização.

=======

Cenário 2: Sincronização Específica por Atributo (Usando Locks)

Descrição

Neste cenário, cada atributo (
vacanciesCinema1 e vacanciesCinema2) tem seu próprio Lock, permitindo que threads operando em cinemas diferentes possam executar em paralelo, melhorando o desempenho sem comprometer a consistência dos dados.

Comportamento Esperado

Threads que operam em cinemas diferentes podem executar simultaneamente.
Redução de bloqueios desnecessários, melhorando o desempenho.
Manutenção da consistência dos dados.

Resultados Obtidos

O sistema manteve consistência nos dados.
O desempenho melhorou significativamente devido à paralelização de threads.

## 🔧 Conclusão:

A escolha da melhor abordagem depende dos requisitos do sistema. 
Para aplicações de alto desempenho com concorrência elevada, a sincronização específica por atributo é a melhor opção.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>


## 🎥 Demonstração: 

=======

