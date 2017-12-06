import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.pratica.Lancamento;
import utfpr.ct.dainf.pratica.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Pratica {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String path;
        Scanner scanner = new Scanner(System.in);
        ProcessaLancamentos lancamentos;
        List<Lancamento> lancamento;
        int conta = -1;
        
        System.out.println("Informe o caminho para o arquivo: ");
        path = scanner.next();
        
        lancamentos = new ProcessaLancamentos(path);
        lancamento = lancamentos.getLancamentos();
        
        do {
            
            System.out.println("Informe o número da conta: ");
            
            if(scanner.hasNextInt()) {
                conta = scanner.nextInt();
            } else {
                System.out.println("Informe apenas números!");
            }
            
            exibeLancamentosConta(lancamento, conta);
            
        } while(conta != 0);
    }
    
    //TAREFA 8
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        for(Lancamento temp : lancamentos){
            if(temp.getConta().equals(conta)){
                System.out.println(temp+"\n");
            }
        }
    }
 
}
