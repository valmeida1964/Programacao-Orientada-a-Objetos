package contas;


import classes.Taxas;
import classes.Pessoa;
import excecoes.SaldoInsuficienteException;

public final class ContaEspecial extends Conta implements Taxas{
    
    private float limite;
    
    public ContaEspecial(){
        
    }
    
    public ContaEspecial(int numero, Pessoa correntista, float valor, float limite){
        super(numero, correntista, valor);
        this.setLimite(limite);
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
    
    @Override
    public void sacar(float valor) throws SaldoInsuficienteException {
        if(this.getSaldo() - valor >= this.getLimite())
            this.setSaldo(this.getSaldo() - valor);
        else
            throw new SaldoInsuficienteException(this.getSaldo(), valor);
    }
    
    @Override
    public float getTaxaManutencao(){
        return 15.00f;
    }
    
    @Override
    public void descontoTaxaManutencao(){
        this.setSaldo(this.getSaldo() - this.getTaxaManutencao());
    }

    
}
