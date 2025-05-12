# Checkpoint da disciplina Códigos de Alta Performance
<h2>Descrição do Projeto</h2>

<p>
Um distribuidor de encomendas de produtos vendidos através de e-commerce decidiu automatizar todo
o processo de obtenção dos produtos comprados por um cliente em um “carrinho” físico, a fim de deixar apenas o
processo de fechamento da compra para um funcionário para posterior envio.
</p>

<p>
Supondo essa situação, um robô autômato deve ir até a prateleira onde o produto se encontra e, depois
de identificá-lo com visão computacional, depositá-lo no carrinho da encomenda recebida.
</p>

<p>
Cada encomenda recebida tem a lista dos produtos solicitados, armazenada em um arquivo texto (<code>.txt</code>).
O processo de atendimento é realizado com uma sequência de encomendas já solicitadas que devem
ser enfileiradas para atendimento.
</p>

<p>
A cada encomenda a ser atendida, um arquivo com a lista de produtos encomendados é lido, colocando
cada produto a ser colocado no carrinho em uma fila de produtos.
</p>

<p>
Em seguida, o robô vai retirando da fila um produto por vez para ser buscado e colocado no carrinho.
</p>

<p>
Como o distribuidor tem um volume grande de encomendas e, por consequência, uma alta taxa de
reposição de produtos nas prateleiras, pode acontecer de um produto não estar disponível
no momento da busca. Caso isso ocorra, o produto volta para o final da fila, a fim de não
atrasar a entrega da encomenda.
</p>

<p>
Quando todos os produtos são colocados no carrinho físico, o valor total a ser
pago pela compra é apresentado, como sinalização de término do atendimento de um cliente.
</p>

<h3>Tarefa</h3>

<p>
Desenvolver o sistema que simule o atendimento realizado
por um robô para coletar os produtos de encomendas de clientes. O programa deve conter um menu
com as seguintes opções:
</p>

<ul>
  <li><strong>0</strong> – Encerra o atendimento</li>
  <li><strong>1</strong> – Insere nova encomenda na fila de encomendas</li>
  <li><strong>2</strong> – Atende uma encomenda</li>
</ul>

<h3>Estrutura do Projeto Java</h3>

<ul>
  <li>Classe <code>FilaEncomendas</code>: fila sequencial que armazena objetos da classe <code>Encomenda</code>.</li>
  <li>Classe <code>Encomenda</code>: possui os atributos <code>clienteID</code> (ID do cliente) e <code>nomeArquivo</code> (nome do arquivo de produtos).</li>
  <li>Classe <code>FilaProdutos</code>: fila sequencial que armazena objetos da classe <code>Produto</code>.</li>
  <li>Classe <code>Produto</code>: possui os atributos:
    <ul>
      <li><strong>código</strong> (String)</li>
      <li><strong>descrição</strong> (String)</li>
      <li><strong>preço</strong> (double)</li>
      <li><strong>localização</strong> (String)</li>
    </ul>
  </li>
</ul>

<p>
As classes que implementam as filas devem ser criadas com base na modificação da classe <code>FilaInt</code> utilizada em aula, conforme feito no exercício 3 do conteúdo <strong>assunto3_FilasSequenciais</strong>.
</p>

