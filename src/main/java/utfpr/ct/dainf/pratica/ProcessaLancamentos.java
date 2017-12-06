package utfpr.ct.dainf.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Linguagem Java
 * @author
 */
public class ProcessaLancamentos {
    private BufferedReader reader;
    private String linha = new String();
    
    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
    
    private String getNextLine() throws IOException {
        if((linha = reader.readLine())!= null)
            return linha;
        else
            return null;
    }
    
    private Lancamento processaLinha(String linha) throws ParseException {
        Lancamento a;
        Integer conta;
        String contastr = "";
        Date data = new Date();
        String datastr = "";
        String descricao = "";
        Double valor;
        String valorstr = "";
        int contador=1;
        
        while(contador<=86){
            if(contador<=6)
                contastr += linha.charAt(contador);
            else if(contador<=14)
                datastr += linha.charAt(contador);
            else if(contador<=74)
                descricao += linha.charAt(contador);
            else if(contador<=86)
                valorstr += linha.charAt(contador);
        }
        conta = Integer.parseInt(contastr);
        SimpleDateFormat sdf = new SimpleDateFormat(datastr);
        Date date = sdf.parse(datastr);
        valor = Double.parseDouble(contastr);
        return a = new Lancamento(conta, data, descricao, valor);
    }
    
    private Lancamento getNextLancamento() throws IOException, ParseException {
       return processaLinha(this.getNextLine());
    }
    
   /* public List<Lancamento> getLancamentos() throws IOException {
        ArrayList<Lancamento> a = new ArrayList();
        a = this.getNextLancamento();
        
    }*/
    
}