package apps;

import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;
import contas.ContaEspecial;

public class appContas {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Fulano", "fulano@gmail.com");
        
        ContaComum c1 = new ContaComum(123456, p1, 150.00f);
        System.out.println("Numero de contas  até o momento: " + c1.getNumeroContas());

        ContaEspecial e1 = new ContaEspecial(123456, p1, 2500.00f, 5500.00f);
        System.out.println("Numero de contas  até o momento: " + e1.getNumeroContas());
        
        if(c1.movimentar(1000f, Conta.SACAR))
            System.out.println("Saque realizado com sucesso");
        else
            System.out.println("Impossivel realizar saque");
    }
    
}
