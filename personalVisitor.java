import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class personalVisitor extends GrammarBaseVisitor<Double>{
    @Override 
    public Double visitProg(GrammarParser.ProgContext ctx){ 
        return visit(ctx.expr()); 
    }
	
	@Override 
    public Double visitOperacionBinaria(GrammarParser.OperacionBinariaContext ctx){ 
        double izquierda = visit(ctx.expr(0));
        double derecha = visit(ctx.expr(1));
        String operador = ctx.op.getText();
        if(operador.equals("+"))
            return izquierda + derecha;
        else if(operador.equals("-"))
            return izquierda - derecha;
        else if(operador.equals("/"))
            return izquierda / derecha;
        else if(operador.equals("*"))
            return izquierda * derecha;
        return 0.0;
    }
	
	@Override 
    public Double visitNumero(GrammarParser.NumeroContext ctx){ 
        return Double.parseDouble(ctx.Num().getText());
    }
	
}