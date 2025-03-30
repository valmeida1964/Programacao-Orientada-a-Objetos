
package apps;

import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;
import excecoes.SaldoInsuficienteException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class appTesteConta1 {

    public static void main(String[] args) throws SaldoInsuficienteException {

        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.FRENCH);
        
        int numero = 0;
        String nome, email;
        float saldo = 0, valorsaque = 0;
        
        System.out.print("Numero da conta .....: ");
        try{
        numero = teclado.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Informe um valor numerico, valido, para o numero da conta, ex:123456");
            System.exit(0);
        }
        
        System.out.print("Correntista .........: ");
        nome = teclado.next();
        
        System.out.print("E-mail ..............: ");
        email = teclado.next();
        
        System.out.print("Saldo Inicial .......: ");
        try{
            saldo = teclado.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Informe um valor monetario, valido, para o saldo inicial ex:1234,56");
            System.exit(0);
        }
        
        Conta contacomum = new ContaComum(numero, new Pessoa(nome, email), saldo);
        
        System.out.print("Valor do saque ......: ");
        valorsaque = teclado.nextFloat();

        try{
            contacomum.sacar(valorsaque);
        }
        catch(SaldoInsuficienteException e){
            System.out.println("Falha na tentativa de saque: " + e);
        }

        System.out.printf("Saldo atual .........: %.2f\n", contacomum.getSaldo());
    }
   
}
