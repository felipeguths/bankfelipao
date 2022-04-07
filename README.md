# bankfelipao
Avaliação para Vaga de Desenvolvedor
1.	CENARIO
Sistema de Automação Bancaria que deve oferecer no mínimo as operações básicas de para Conta Corrente: Saldo, Saque, Depósito e Extrato, conforme as seguintes especificações:

1.1	Caso de Uso: Deposito Conta Corrente.

a)	Este caso de uso tem início quando o Cliente deseja realizar um depósito de valores em sua conta corrente.
b)	O Cliente insere as informações: agência, numero da conta corrente e valor a ser depositado.
c)	O Sistema avaliará se a agência existe (Exceção 1).
d)	O Sistema avaliará se a conta corrente existe (Exceção 2).
e)	O Sistema deverá efetivar o credito de valor no saldo da conta corrente informada.
f)	O Sistema deverá gravar um log da transação executada.
g)	O Sistema informa o Cliente que a transação foi executada com sucesso.

Exceção 1 – Agência Inexistente.
1.	O Sistema identifica que a Agência não existe e informa ao Cliente: Agência Inexistente.

Exceção 2 – Conta Corrente Inexistente.
1.	O Sistema identifica que a Conta Corrente não existe e informa ao Cliente: Conta Corrente Inexistente.

1.2	Caso de Uso: Sacar Conta Corrente.

a)	Este caso de uso tem início quando o Cliente deseja realizar um saque de valores em sua conta corrente.
b)	O Cliente insere as informações: agência, numero da conta corrente e valor a ser sacado.
c)	O Sistema avaliará se a agência existe (Exceção 1).
d)	O Sistema avaliará se a conta corrente existe (Exceção 2).
e)	O Sistema avaliará se a conta corrente possui saldo para sacar (Exceção 3).
f)	O Sistema deverá efetivar o débito do valor no saldo da conta corrente informada.
g)	O Sistema deverá gravar um log da transação executada.
h)	O Sistema informa o Cliente que a transação foi executada com sucesso.

Exceção 1 – Agência Inexistente.
1.	O Sistema identifica que a Agência não existe e informa ao Cliente: Agência Inexistente.

Exceção 2 – Conta Corrente Inexistente.
1.	O Sistema identifica que a Conta Corrente não existe e informa ao Cliente: Conta Corrente Inexistente.

Exceção 3 – Saldo Insuficiente.
1.	O Sistema identifica que a Conta Corrente não possui saldo para saque e informa ao Cliente: Saldo Insuficiente.

1.3	Caso de Uso: Consultar Saldo Conta Corrente.

a)	Este caso de uso tem início quando o Cliente deseja consultar um saldo de sua conta corrente.
b)	O Cliente insere as informações: agência e numero da conta corrente.
c)	O Sistema avaliará se a agência existe (Exceção 1).
d)	O Sistema avaliará se a conta corrente existe (Exceção 2).
e)	O Sistema deverá retornar o valor atual do saldo da conta corrente do cliente.

Exceção 1 – Agência Inexistente.
1.	O Sistema identifica que a Agência não existe e informa ao Cliente: Agência Inexistente.

Exceção 2 – Conta Corrente Inexistente.
1.	O Sistema identifica que a Conta Corrente não existe e informa ao Cliente: Conta Corrente Inexistente.

1.4	Caso de Uso: Consultar Extrato Conta Corrente.

a)	Este caso de uso tem início quando o Cliente deseja consultar um extrato de sua conta corrente.
b)	O Cliente insere as informações: agência, número da conta corrente, data inicial e data final.
c)	O Sistema avaliará se a agência existe (Exceção 1).
d)	O Sistema avaliará se a conta corrente existe (Exceção 2).
e)	O Sistema avaliará se a datas inicial e final são em sequencia e válidas (Exceção 3).
f)	O Sistema deverá retornar uma lista contendo: data (DD/MM/AAAA) e valor do Movimento (em casos de transações de Saque o valor deverá vir precedido de um sinal negativo (-).

Exceção 1 – Agência Inexistente.
2.	O Sistema identifica que a Agência não existe e informa ao Cliente: Agência Inexistente.

Exceção 2 – Conta Corrente Inexistente.
1.	O Sistema identifica que a Conta Corrente não existe e informa ao Cliente: Conta Corrente Inexistente.

Exceção 2 – Data Inicial e/ou Final inválidas.
1.	O Sistema identifica se a data final menor que a inicial e informa ao Cliente: Data final deve ser igual ou maior que a Data Inicial.
Sugestão 1: Para atender ao Sistema, o banco de dados da aplicação devera conter no mínimo as seguintes estruturas (TABELAS): Conta Corrente, Transação e Log de Transações.

Sugestão 2: A tabela de Transações poderá conter informações como: código de transação, descrição da transação e natureza da transação (Débito (-) ou Crédito (+)).

Sugestão 3: a tabela de Log de Transação deverá guardar no mínimo as seguintes informações: Data da transação, código da transação, agência da conta corrente, código da conta corrente e valor da transação.


2.	ATIVIDADES
2.1.	Criar uma solução baseada nos seguintes conceitos: Domain Driven Design (DDD), Clean Arq e SOLID/
2.2.	 A aplicação BACKEnd deve ser uma API RESTFul ou Grpc Service que implemente pelo menos 2 de alguns dos  seguintes Casos de Uso: Saque, Depositar, Extrato e Consultar Saldo Conta Corrente.
2.3.	O Banco de dados pode ser relacional ou NoSQL.
Observações: 
		A STACK DE DESENVOLVIMENTO FICA A CARGO DO DESENVOLVEDOR;
	O DESENVOLVEDOR DEVERA DISPONIBILIZAR A APLICAÇÃO RODANDO OU APRESENTAR A MESMA EXECUTANDO;
	SERA AVALIADO O DESENVOLVIMENTO MAS ACIMA DE TUDO A EXPLICAÇÃO DAS DECISÕES ARQUITETURAIS ADOTADAS;
	PODE COPIAR DE QUALQUER REPOSITORIO, SITE, ETC, MAS PRECISAR REFERENCIAR DE ONDE SE BASEOU E COMO\PORQUE USOU COMO BASE O REPO.
	
