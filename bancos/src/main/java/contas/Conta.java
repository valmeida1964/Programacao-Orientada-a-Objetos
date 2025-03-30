package contas;

import classes.Pessoa;
import excecoes.SaldoInsuficienteException;

/**
 * A classe <b>Conta</b> define um tipo abstrato ´para a criação da estrutura de classes de contas bancarias
 * @author Vagner de Lima Almeida
 * @since Março 2025
 * @version 1.0
 */
public abstract class Conta {
    
    protected int numero;
    protected Pessoa correntista;
    protected float saldo;
    private static int numero_contas;
    
    public final static int SACAR = 0;
    public final static int DEPOSITAR = 1;
    
    
    public Conta() {
        incrementaContas();
    }
    
    public Conta(int numero, Pessoa correntista, float valor) {
        this();
        this.setNumero(numero);
        this.setCorrentista(correntista);
        this.setSaldo(valor);
    }
 
    public final int getNumero() {
        return numero;
    }

    public final void setNumero(int numero) {
        this.numero = numero;
    }

    public final Pessoa getCorrentista() {
        return correntista;
    }

    public final void setCorrentista(Pessoa correntista) {
        this.correntista = correntista;
    }

    public final float getSaldo() {
        return saldo;
    }

    public final void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public int getNumeroContas(){
        return Conta.numero_contas;
    }
    
    public final void depositar(float valor){
        this.setSaldo(this.getSaldo() + valor);
    }
    
    public abstract void sacar(float valor) throws SaldoInsuficienteException;
    
    private static void incrementaContas(){
        ++numero_contas;
    }
    
    public void movimentar(float valor, int operacao) throws SaldoInsuficienteException{
  
        switch(operacao){
            case DEPOSITAR -> this.depositar(valor);
            case SACAR -> this.sacar(valor);
        }
       
    }
}
