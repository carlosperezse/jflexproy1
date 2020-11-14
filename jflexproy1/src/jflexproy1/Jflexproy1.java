
package jflexproy1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Jflexproy1 {

    
    public static void main(String[] args) throws Exception {
        pantalla_jflex.main(args);
        //se quita
        /*
        try{
            generarLexer();
        }catch(Exception e){
            throw new Exception("Error al generar Archivo Lexer");
        }
        */
    }
    
    public static void generarLexer() throws Exception{
        // Ruta del archivo donde se encuentra el archivo lex.flex
        String[] ruta = {"C:\\Users\\CiPp9\\Documents\\NetBeansProjects\\jflexproy1\\src\\jflexproy1\\lex.flex"};
        try {
            jflex.Main.generate(ruta);
        }catch(Exception e){
            throw new Exception("Error al crear Archivo Lexer.java ");
        }
    }
    
    /*
    public static void main(String[] args) throws Exception {
       System.out.println("Generando Archivos Lexers");
        try{
           generar();
        }catch(Exception e){
           throw new Exception("Error al generar Archivo Lexer");
       }
     }
    */

    public static void generar() throws IOException, Exception{
        String rutaProy = "/Users/CiPp9/Documents/NetBeansProjects/jflexproy1";
        String[] ruta1 = {rutaProy+"/src/jflexproy1/lex.flex"};
        String[] ruta2 = {rutaProy+"/src/jflexproy1/LexerCup.flex"};
        String[] rutaS = {"-parser", "Sintax", rutaProy+"/src/jflexproy1/Sintax.cup"};

        jflex.Main.generate(ruta1);       
        jflex.Main.generate(ruta2);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(rutaProy+"/src/jflexproy1/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(rutaProy+"/sym.java"), 
                Paths.get(rutaProy+"/src/jflexproy1/sym.java")
        );
        Path rutaSin = Paths.get(rutaProy+"/src/jflexproy1/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(rutaProy+"/Sintax.java"), 
                Paths.get(rutaProy+"/src/jflexproy1/Sintax.java")
        );
    }

    
}
