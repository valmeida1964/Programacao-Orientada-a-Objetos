package excecoes;

public class SaldoInsuficienteException extends Exception{
    
    private float saldo;
    private float valor;

    public SaldoInsuficienteException(float saldo, float valor) {
        this.saldo = saldo;
        this.valor = valor;
    }
    
    @Override
    public String toString(){
       return "Saldo insuficiente para o saque. O saldo atual e R$ " + saldo + " e voce esta tentando sacar R$ " + valor;
    }
}
