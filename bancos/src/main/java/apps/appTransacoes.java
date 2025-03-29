package apps;

import classes.Movimento;
import classes.Pessoa;
import classes.Transacao;
import contas.Conta;
import contas.ContaComum;
import java.text.SimpleDateFormat;
import java.util.Date;

public class appTransacoes {

    public static void main(String[] args) {
        
        Transacao transacoes = new Transacao();
        Pessoa    pessoa     = new Pessoa("Fulano","fulano@gmail.com");
        Conta     contacomum = new ContaComum(102030, pessoa,450.00f);
        
        float saldoanterior = contacomum.getSaldo();
        
        transacoes.realizarTransacao(new Date(), contacomum, 100.00f, "Deposito em dinheiro", Conta.DEPOSITAR);
        transacoes.realizarTransacao(new Date(), contacomum,  50.00f, "Pagamento conta luz", Conta.SACAR);
        transacoes.realizarTransacao(new Date(), contacomum, 120.00f, "Pagamento conta telefone", Conta.SACAR);
        transacoes.realizarTransacao(new Date(), contacomum, 850.00f, "Transferencia entre contas", Conta.DEPOSITAR);
        
        System.out.println("Emitindo Extrato da Conta Comum Numero: " + contacomum.getNumero());
        System.out.println("Correntista: "                            + contacomum.getCorrentista().getNome());
        System.out.println("Saldo anterior: "                         + saldoanterior);
        System.out.println("------------------");
        
        for(Movimento movimento: transacoes.getMovimentos()){
            System.out.println("Data: "      + new SimpleDateFormat("dd/MM/yyyy").format(movimento.getData()));
            System.out.println("Historico: " + movimento.getHistorico());
            System.out.println("Valor: "     + movimento.getValor());
            System.out.println("Operacao: "  + (movimento.getOperacao() == Conta.DEPOSITAR ? "Deposito" : "Saque"));
            System.out.println("------------------");
        }
            System.out.println("Saldo atual: " + contacomum.getSaldo());
        
    }
    
}
