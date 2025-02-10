
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center"> Gerenciamento de Eventos com Fila e Threads - Criando e Executando uma Thread Daemon</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este projeto demonstra o gerenciamento de eventos em uma fila utilizando threads em Java. O sistema consiste em duas tarefas principais:

WriterTask: Gera eventos periodicamente e os adiciona à fila.
CleanerTask: Remove eventos antigos da fila após um determinado período.


Estrutura do Projeto

O projeto contém os seguintes arquivos:
CleanerTask.java: Thread responsável por limpar eventos antigos da fila.
Event.java: Classe que representa um evento com uma data e descrição.
WriterTask.java: Thread que gera eventos e os adiciona à fila.
Main.java: Classe principal que inicia as threads e executa o programa

Funcionamento

Geração de eventos: Três threads de WriterTask adicionam eventos à fila a cada segundo.
Limpeza de eventos: A thread CleanerTask verifica e remove eventos com mais de 10 segundos.

## 🗒️ Cenários teste

Cenário 1: Execução Normal

Descrição: Três threads geram eventos a cada segundo, enquanto a CleanerTask remove eventos com mais de 10 segundos.

Resultado: A fila cresce inicialmente, mas estabiliza quando os eventos mais antigos são removidos.


=======

Cenário 2: Aumento do Intervalo de Geração de Eventos

Descrição: O intervalo de geração de eventos foi alterado para 2 segundos.

Resultado: A fila cresce mais lentamente, pois os eventos levam mais tempo para serem adicionados.

=======

Cenário 3: Redução do Intervalo de Verificação do Cleaner

Descrição: O intervalo de verificação do CleanerTask foi reduzido para 500 milissegundos.

Resultado: Eventos antigos são removidos mais rapidamente, mantendo a fila menor.

=======

Cenário 4: Aumento do Limite de Idade dos Eventos

Descrição: O limite de idade dos eventos foi aumentado para 20 segundos.

Resultado: A fila cresce mais antes que os eventos sejam removidos, resultando em um tamanho maior.


## 🔧 Conclusão:

Os testes demonstraram que o comportamento do sistema é altamente influenciado pelos intervalos de geração e limpeza de eventos. 
Ajustando esses parâmetros, é possível controlar o tamanho da fila e a frequência de remoção de eventos para atender diferentes necessidades do sistema.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>


## 🎥 Demonstração: 

=======

