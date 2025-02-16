
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Processamento Paralelo com CyclicBarrier - Sincronizando Tarefas em um Ponto Comum</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto implementa um sistema de busca paralela em uma matriz de inteiros utilizando a classe CyclicBarrier do Java.
O objetivo é contar a ocorrência de um número específico dentro da matriz e agregar os resultados de forma sincronizada.

Estrutura do Projeto

O código é composto pelas seguintes classes:

MatrixMock: Gera uma matriz de números aleatórios e contabiliza a ocorrência de um número alvo.
Results: Armazena os resultados parciais de cada thread.
Searcher: Implementa Runnable para buscar um número na matriz e armazenar os resultados.
Grouper: Implementa Runnable para processar e exibir o resultado final após a sincronização das threads.
Main: Configura e executa as threads, gerenciando a sincronização com CyclicBarrier.

## 🗒️ Cenários teste

Configuração do Cenário de Teste

Matriz com 10.000 linhas e 1.000 colunas.

O número a ser buscado é 5.
5 threads processando 2.000 linhas cada.

CyclicBarrier sincroniza as threads e executa o Grouper após a finalização.

Fluxo de Execução
A matriz é gerada aleatoriamente.
As threads Searcher iniciam e processam segmentos da matriz.
Cada Searcher armazena o resultado parcial e chama barrier.await().
Quando todas as threads atingem o barrier, Grouper soma os resultados.
O resultado final é exibido.

## 🔧 Conclusão:

O uso de CyclicBarrier garante sincronização eficiente entre as threads.
Cada thread processa uma parte independente da matriz, evitando condições de corrida.
O Grouper é executado apenas quando todas as threads terminam, garantindo um resultado preciso.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

