
package apps;

import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;
import java.util.Scanner;

public class appTesteConta1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        int numero;
        String nome, email;
        float saldo, valordeposito;
        
        System.out.print("Numero da conta .....: ");
        numero = teclado.nextInt();
        
        System.out.print("Correntista .........: ");
        nome = teclado.next();
        
        System.out.print("E-mail ..............: ");
        email = teclado.next();
        
        System.out.print("Saldo Inicial .......: ");
        saldo = teclado.nextFloat();
        
        Conta contacomum = new ContaComum(numero, new Pessoa(nome, email), saldo);
        
        System.out.print("Valor do deposito ...: ");
        valordeposito = teclado.nextFloat();
        
        contacomum.depositar(valordeposito);
        
        System.out.print("Saldo atual .........: " + contacomum.getSaldo());
    }
    
}
