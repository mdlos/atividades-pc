
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=02A6F4&height=120&section=header"/>
<h1 align="center">  ThreadLocal vs InheritableThreadLocal - Usando Variáveis Locais de Thread</h1>

<div align="center">  
  <img width=40% src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDA&color=02A6F4&style=for-the-badge"/>
</div>

## Objetivo do Projeto

Este documento descreve os testes realizados para demonstrar o funcionamento dos conceitos de ThreadLocal e InheritableThreadLocal no Java, incluindo o uso do método childValue para personalizar valores herdados.


## 🗒️ Cenários teste

1. Classe InheritableThreadLocalTest
A classe InheritableThreadLocalTest demonstra como o valor de uma variável de InheritableThreadLocal pode ser herdado por threads filhas. O valor inicial é definido na thread principal e herdado pelas threads filhas e netas. As modificações feitas nas threads filhas não afetam o valor na thread principal.

Resultados Esperados:
Thread principal exibe: hello
Thread filha herda o valor: hello
Thread neta herda e modifica o valor para: hello, wqf
Thread filha exibe o valor após a modificação: hello, wqf
Thread principal mantém o valor original: hello

Exemplo de Saída:

main : hello
inner : hello
inner-inner : hello
inner-inner : hello, wqf
inner : hello, wqf
main : hello

=======

2. Classe ThreadLocalTest
A classe ThreadLocalTest demonstra o uso de ThreadLocal, onde cada thread possui sua própria cópia de valor. O valor inicial é único para cada thread, e as alterações em uma thread não afetam outras threads.

Resultados Esperados:
Cada thread exibe valores únicos baseados no nome da thread.

Exemplo de Saída:

Thread name 1 : Thread-0
Thread name 2 : Thread-0
Thread name 1 : Thread-1
Thread name 2 : Thread-1

=======

3. Classe Main
A classe Main compara o comportamento de ThreadLocal e InheritableThreadLocal. O valor de ThreadLocal não é herdado pelas threads filhas, enquanto o valor de InheritableThreadLocal é herdado.

Resultados Esperados:
Main-1: ThreadLocal-VAL
Child-1: null (não herdado)
Main-2: InheritableThreadLocal-VAL
Child-2: InheritableThreadLocal-VAL (herdado)

Exemplo de Saída:

Main-1: ThreadLocal-VAL
Child-1: null
Main-2: InheritableThreadLocal-VAL
Child-2: InheritableThreadLocal-VAL

=======

4. Classe Main2_3

A classe Main2_3 demonstra o uso do método childValue em InheritableThreadLocal. Esse método permite personalizar o valor herdado pelas threads filhas, como mostrado no exemplo abaixo.

Resultados Esperados:
main begin: Lily
thread-begin: Child created from Lily (valor personalizado)
thread-end: Lucy (valor modificado na thread filha)
main end: Lily (valor original na thread principal)

Exemplo de Saída:

main begin=Lily
thread-begin=Child created from Lily
thread-end=Lucy
main end=Lily

## 🔧 Conclusão:

ThreadLocal: Cada thread tem sua própria cópia do valor, que não é compartilhada com outras threads.
InheritableThreadLocal: Permite que valores sejam herdados pela thread filha, mas sem afetar a thread principal ou outras threads.
childValue: Personaliza o valor herdado pelas threads filhas.
Esses testes confirmam o funcionamento correto desses conceitos no Java e ajudam a compreender os comportamentos de variáveis locais específicas para threads e de variáveis herdadas entre threads.

## 💻 Desenvolvedor
 
<table>
  <tr>
    <td align="center"><img style="" src="https://avatars.githubusercontent.com/u/72825281?v=4" width="100px;" alt=""/><br /><sub><b> Marcio Fonseca </b></sub></a><br />👨‍💻</a></td>
  </tr>
</table>


## 🎥 Demonstração: 

=======

