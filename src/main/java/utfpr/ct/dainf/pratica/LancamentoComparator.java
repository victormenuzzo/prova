package utfpr.ct.dainf.pratica;

import java.util.Comparator;

/**
 * Linguagem Java
 * @author
 */
public class LancamentoComparator implements Comparator<Lancamento>{
    public int compare(Lancamento lancamento1, Lancamento lancamento2){
        int retorno = lancamento1.getConta() - lancamento2.getConta();
        
        //uma conta maior que a outra
        if(retorno != 0){
            return retorno;
        }
        //contas iguais, comparar por data
        else{
            return lancamento1.getData().compareTo(lancamento2.getData());
        }
    }
}
