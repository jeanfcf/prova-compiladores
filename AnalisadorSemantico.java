import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

class AnalisadorSemantico {
	// Mapeamento NomeVariavel --> Tipo
	Map<String, String> vars = new HashMap<String, String>();

	int nosVisitados = 0;

	// Analisa Expressoes
	String tipoDe(ParseTree exp) {
		String tipo = exp.getClass().getSimpleName().replace("Context", "");
		switch (tipo) {
		case "Op": {
			ParseTree esq = exp.getChild(0);
			String op = exp.getChild(1).getText();
			ParseTree dir = exp.getChild(2);
			String tipoEsq = tipoDe(esq);
			String tipoDir = tipoDe(dir);
			if (tipoEsq.equals("error") || tipoDir.equals("error")) {
				return "error";
			}
			if (tipoEsq.equals("int") && op.equals("+") && tipoDir.equals("int"))
				return "int";
			if (tipoEsq.equals("string") && op.equals("+") && tipoDir.equals("string"))
				return "string";
			if (tipoEsq.equals("bool") && op.equals("||") && tipoDir.equals("bool"))
				return "bool";
			if (tipoEsq.equals(tipoDir) && op.equals("=="))
				return "bool";
			if (tipoEsq.equals("int") && (op.equals("<") || op.equals("<=") || op.equals(">") || op.equals("=>")
					|| op.equals("==") || op.equals("!=")) && tipoDir.equals("int"))
				return "bool";
			System.err.printf("nao sei o tipo de %s %s %s\n", tipoEsq, op, tipoDir);
			return "error";
		}
		case "Var": {
			String nomeVar = exp.getChild(0).getText();
			if (vars.containsKey(nomeVar))
				return vars.get(nomeVar);
			else {
				System.err.printf("Variavel %s nao foi declarada\n", nomeVar);
				return "error";
			}
		}
		case "Const": {
			String valor = exp.getChild(0).getText();
			if (valor.length() > 10) {
				System.err.printf("Constante %s muito grande\n", valor);
				return "error";
			}
			return "int";

		}
		case "CTrue":
		case "CFalse": {
			return "bool";
		}
		case "CString": {
			return "string";
		}
		case "Elvis": {
			return "int";
		}

		}
		return "error";
	}

	// Analisa Comandos e Declaracoes
	boolean analise(ParseTree t) {
		String tipo = t.getClass().getSimpleName().replace("Context", "");
		System.out.println("Avaliando no do tipo: " + tipo);
		nosVisitados++;
		switch (tipo) {
		case "Start": {
			for (int c = 0; c < t.getChildCount() - 1; c++)
				if (!analise(t.getChild(c)))
					return false;
			return true;
		}
		case "Dec": {
			String tipoD = t.getChild(0).getText();
			String nomeVar = t.getChild(1).getText();
			ParseTree expr = t.getChild(3);

			if (vars.containsKey(nomeVar)) {
				System.err.printf("Variavel %s ja declarada\n", nomeVar);
				return false;
			}
			String tipoExpr = tipoDe(expr);

			if (!tipoD.equals(tipoExpr)) {
				System.err.printf("Tipos: %s e %s, sao incompativeis\n", tipoD, tipoExpr);
				return false;
			}
			vars.put(nomeVar, tipoD);
			return true;

		}
		case "Atrib": {
			String nomeVar = t.getChild(0).getText();
			ParseTree expr = t.getChild(2);
			if (vars.containsKey(nomeVar) == false) {
				System.err.printf("Variavel %s nao declarada\n", nomeVar);
				return false;
			}
			String tipoVar = vars.get(nomeVar);
			String tipoExpr = tipoDe(expr);

			if (tipoExpr.equals("error"))
				return false;
			if (tipoVar.equals(tipoExpr) == false) {
				System.err.printf("Tipos %s, %s sao incompativeis\n", tipoVar, tipoExpr);
				return false;
			}

			return true;

		}
		case "If": {
			ParseTree expr = t.getChild(2);
			ParseTree com1 = t.getChild(4);
			ParseTree com2 = t.getChild(6);
			String tipoExpr = tipoDe(expr);
			if (!tipoExpr.equals("bool"))
				return false;

			return analise(com1) && (com2 == null || analise(com2));
		}
		case "Elvis": {
			String nomeVar = t.getChild(2).getText();
			if (vars.containsKey(nomeVar) == false) {
				System.err.printf("Variavel %s nao declarada\n", nomeVar);
				return false;
			}
			String tipoVar = vars.get(nomeVar);
			if (!tipoVar.equals("int")) {
				System.err.printf("Variavel %s nao é do tipo int\n", nomeVar);
				return false;
			}
			return true;
		}
		case "Inc": {
			String nomeVar = t.getChild(0).getText();
			if (vars.containsKey(nomeVar) == false) {
				System.err.printf("Variavel %s nao declarada\n", nomeVar);
				return false;
			}
			String tipoVar = vars.get(nomeVar);
			if (!tipoVar.equals("int")) {
				System.err.printf("Variavel %s nao é do tipo int\n", nomeVar);
				return false;
			}
			return true;
		}
		case "For": {
			String nomeVar = t.getChild(1).getText();
			int numero1 = Integer.parseInt(t.getChild(3).getText());
			int numero2 = Integer.parseInt(t.getChild(5).getText());
			if (numero1 >= numero2) {
				System.err.printf("Nao e possivel fazer um for com essas entradas\n", nomeVar);
				return false;
			}
			if (vars.containsKey(nomeVar) != false) {
				System.err.printf("Variavel %s do for ja declarada\n", nomeVar);
				return false;
			}

			vars.put(nomeVar, "int");
			return true;
		}

		default:
			System.err.println("Nao sei analisar: " + tipo);
			return false;

		}
	}

}