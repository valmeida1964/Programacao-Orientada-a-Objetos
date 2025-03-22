package contas;

import classes.Pessoa;


public final class ContaComum extends Conta implements Taxas{

    public ContaComum() {
    }

    public ContaComum(int numero, Pessoa correntista, float valor) {
        super(numero, correntista, valor);
    }
    
    @Override
    public boolean sacar(float valor){
        if(valor < this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
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
