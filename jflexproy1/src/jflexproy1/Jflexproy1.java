
package jflexproy1;

public class Jflexproy1 {

    
    public static void main(String[] args) throws Exception {
        pantalla_jflex.main(args);
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
    
}
