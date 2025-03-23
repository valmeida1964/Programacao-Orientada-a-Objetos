package classes;

import contas.Conta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transacao {
    
    private List<Movimento> movimentos;
    
    public Transacao(){
        movimentos = new ArrayList<>();
    }
    
    public boolean realizarTransacao(Date data, Conta conta, float valor, String historico, int operacao){
        Movimento movimento = new Movimento(data, conta, historico, valor, operacao);
        if(!movimento.movimentar())
            return false;
        this.movimentos.add(movimento);
        return true;
    }
}
