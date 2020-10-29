# Calculadora-Distribuida

Trabalho realizado para obtenção de nota na disciplina de Sistemas distribuidos, tendo como objetivo desenvolver um pequeno sistema distribuído de servidores utilizando sockets.

O sistema foi implementado em Java.

O sistema é composto por:
-Um servidor simples chamado de SimpleJavaServer que é responsável por realizar as operações de soma, subtração, multiplicação e divisão.
-Um servidor especialista chamado de JavaServerB que é responsável por realizar as operações de porcentagem, raiz quadrada e potenciação.
-Um cliente chamado de SimpleJavaClient que encaminhará as operações via sockets para os servidores citados acima.

É solicitado do usúario ate 3 informações, a depender da operação desejada. São elas: operador(oper), numero 1(num1) e numero 2(num2) que podem ser aplicadas das seguintes formas listadas abaixo.
Funcionamento das operações:
-Soma: num1 mais num2
-Subtração: num1 menos num2
-Multiplicação: num1 vezes num2
-Divisão: num1 dividido por num2
-Porcentagem: num2 por cento de num1
-Raiz quadrada: num1 elevado a 0.5
-Potenciação: num1 elevado a num2

O Servidor simples ocupa a porta 9999.
O Servidor especialista ocupa a porta 10000.
