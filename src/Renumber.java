import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Renumber {
    public static void loadProgram(String nomeArquivo) {

        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+nomeArquivo; 
        Path path2 = Paths.get(nameComplete); 

        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){
            int num = 10;
            while(sc.hasNextLine()) { 
                String line = sc.nextLine(); 
                String[] tokens = line.split(" ");
                line = Integer.toString(num) + " " + line.substring(3,line.length());
                String aux = nomeArquivo.substring(0,5);
                String novoArquivo = currDir+"\\novosArquivos\\"+aux+"-rn.bas"; 
                
                Writer escrever;
                escrever = new BufferedWriter(new FileWriter(novoArquivo, true));;
                escrever.append(line + "\n");    
                escrever.close();
                num = num + 10;
            }    
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}

