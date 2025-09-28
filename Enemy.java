// Interface que representa o contrato para qualquer inimigo no jogo
// Todos os inimigos devem ser capazes de atacar o jogador e ter um tipo (nome)
public interface Enemy {
    void attack(Player player);   // ação de ataque contra o jogador
    String getType();             // retorna o tipo/nome do inimigo (útil para logs)
}