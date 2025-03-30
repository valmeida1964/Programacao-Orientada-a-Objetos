package classes;

import contas.Conta;
import excecoes.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transacao {
    
    private List<Movimento> movimentos;
    
    public Transacao(){
        movimentos = new ArrayList<>();
    }
    
    public void realizarTransacao(Date data, Conta conta, float valor, String historico, int operacao) throws SaldoInsuficienteException{
        Movimento movimento = new Movimento(data, conta, historico, valor, operacao);
        movimento.movimentar();
        this.movimentos.add(movimento);
    }
    public void estornaTransacao(){
        for(Movimento movimento: this.movimentos)
            movimento = null;
    }
    public List<Movimento> getMovimentos(){
        return this.movimentos;
    }
}
