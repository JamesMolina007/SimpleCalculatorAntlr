import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.Scanner;
public class Grammar{
    public static void main(String[] args) throws Exception{
        while(true){
            System.out.println("");
            System.out.println("0. Salir");
            System.out.println("1. Calcular Ecuacion");
            System.out.println("2. Mostrar Arbol De Ecuacion");
            System.out.print("Ingrese una opcion: ");
            int opcion = new Scanner(System.in).nextInt();
            if(opcion == 0)
                break;
            if(opcion == 1)
                calcularEcuacion(args[0]);
            else if(opcion == 2)
                mostrarArbol(args[0]);
        }
    }

    public static void calcularEcuacion(String args)throws Exception{
        ANTLRFileStream str = new ANTLRFileStream(args);
        GrammarLexer lexer = new GrammarLexer(str);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println("");
        System.out.println(new personalVisitor().visit(tree));
        System.out.println("");
    }

    public static void mostrarArbol(String args){
        try {
	        String cmd = "cmd /c start cmd.exe /K \"grun Grammar prog " + args + " -gui";
	        Runtime.getRuntime().exec(cmd); 
        } catch (Exception ex) {
	        System.out.println(ex);
        }
    }

}