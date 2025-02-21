
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">Cálculo de Fatorial com ExecutorService - Executando Tarefas em um Executor que Retorna um Resultado</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto em Java demonstra o uso da API ExecutorService para executar cálculos de fatorial de maneira concorrente. 
As tarefas são submetidas a um ThreadPoolExecutor com um número configurável de threads. 
A implementação utiliza a interface Callable para permitir a recuperação de resultados por meio de Future.

Funcionalidades

Submissão de tarefas concorrentes para calcular fatoriais.
Utilização de ThreadPoolExecutor para controle do número de threads.
Monitoramento do progresso das tarefas.
Exibição dos resultados após a finalização de todas as tarefas.

## 🗒️ Cenários teste

O projeto pode ser configurado para utilizar diferentes tamanhos de pool de threads, alterando a linha:

ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(N);

Onde N pode ser:

1 para execução sequencial.
2 para execução concorrente limitada a duas threads.
4 para maior concorrência.

## 🔧 Conclusão:

Este exercicio demonstra como executar tarefas concorrentes em Java usando ExecutorService, permitindo otimização de recursos e maior eficiência na execução de cálculos intensivos.
A implementação modular facilita testes e ajustes para diferentes cenários de execução.


## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>

=======

