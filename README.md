# 🧾 Orçamento Service

Um microserviço desenvolvido com **Quarkus**, **Jakarta**, **Panache** e **MicroProfile Reactive Messaging**, responsável por **gerenciar orçamentos** e **emitir eventos de domínio** de forma assíncrona.

---

## 🚀 Tecnologias Utilizadas

- **Quarkus** (Java moderno, rápido e nativo)
- **Jakarta Persistence (JPA)** com **Hibernate ORM Panache**
- **MicroProfile Reactive Messaging**
- **Kafka** (para mensageria assíncrona)
- **RESTEasy Reactive** (para endpoints HTTP)
- **Mapper** (para mapeamento entre Domain ↔ Entity ↔ Event)
- **PostgreSQL** (persistência)



## 3️⃣ Workflow completo da aplicação

1️⃣ Criar Pedido

Input: JSON via REST (PedidoController).

Use Case: CriarPedidoUseCase

Domain: Cria Pedido e valida status/valores.

Gateway: Persiste pedido (PedidoRepository) e publica evento PedidoCriadoEvent no Kafka.

2️⃣ Gerar Orçamento

Input: Evento PedidoCriadoEvent consumido do Kafka.

Use Case: GerarOrcamentoUseCase

Domain: Cria Orcamento associado ao pedido, calcula valor total, define status inicial (GERADO).

Gateway: Persiste Orcamento e publica evento OrcamentoGeradoEvent.

3️⃣ Aprovar Orçamento

Input: Evento OrcamentoGeradoEvent (ou diretamente chamada da UI)

Use Case: AprovarOrcamentoUseCase

Domain: Valida se pedido pode ser aprovado, muda status do orçamento para ACEITO.

Gateway: Persiste mudanças e publica evento OrcamentoAprovadoEvent.

4️⃣ Processar Pagamento

Input: Evento OrcamentoAprovadoEvent ou ação do cliente via UI

Use Case: ProcessarPagamentoUseCase

Domain: Cria Pagamento, define status inicial PENDENTE

Gateway: Persiste pagamento e, se sucesso, publica PagamentoConfirmadoEvent.

5️⃣ Atualizar Status do Pedido

Input: Evento PagamentoConfirmadoEvent

Use Case: AtualizarStatusPedidoUseCase

Domain: Muda status do Pedido para APROVADO.

Gateway: Persiste mudança e, opcionalmente, publica evento PedidoAprovadoEvent para notificação ou relatórios.

🔁 Observações Importantes

Cada passo é atomizado em um use case → manutenção fácil e testes unitários isolados.

Consumers do Kafka nunca contêm regras de negócio → apenas repassam eventos.

Gateways (JPA/Kafka) ficam somente na camada de infra.

Você pode adicionar Notificações ao cliente, Fila de compensação, ou Jobs agendados como “listeners” de eventos, sem tocar na camada de domain.