import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

class Interpretador {
	// Mapeamento: NomeVariavel --> Valor
	Map<String, Integer> vars = new HashMap<String, Integer>();
	int nosVisitados = 0;
	int conversoesInteiros = 0;

	int avalie(ParseTree t) {
		String tipo = t.getClass().getSimpleName().replace("Context", "");

//		System.out.println("Avaliando no do tipo: " + tipo)
		nosVisitados++;
		switch (tipo) {
		case "Start": {
			for (int c = 0; c < t.getChildCount() - 1; c++)
				avalie(t.getChild(c));
			return 0;
		}
		case "Dec": {
			String nomeVar = t.getChild(1).getText();
			ParseTree expr = t.getChild(3);
			vars.put(nomeVar, avalie(expr));
			System.out.println("declarando");
			System.out.println(vars);
			return 0;

		}
		case "Atrib": {
			String nomeVar = t.getChild(0).getText();
			ParseTree expr = t.getChild(2);

			if (vars.containsKey(nomeVar))
				vars.put(nomeVar, avalie(expr));
			else
				throw new RuntimeException("variavel " + nomeVar + " nao declarada");
			System.out.println("atribuindo");
			System.out.println(vars);
			return 0;
		}
		case "Var": {
			String nomeVar = t.getChild(0).getText();
			Integer valor = vars.get(nomeVar);
			if (valor == null) {
				throw new RuntimeException("Variavel " + nomeVar + " nao definida");
			}
			return valor;

		}
		case "Const": {
			String str = t.getText();
			conversoesInteiros++;
			return Integer.parseInt(str);

		}
		case "Group":
			return avalie(t.getChild(1));
		case "Op": {
			String op = t.getChild(1).getText();
			ParseTree esq = t.getChild(0);
			ParseTree dir = t.getChild(2);
			int vEsq = avalie(esq);
			int vDir = avalie(dir);
			if (op.equals("+"))
				return vEsq + vDir;
			if (op.equals("*"))
				return vEsq * vDir;
			if (op.equals("-"))
				return vEsq - vDir;
			if (op.equals("/"))
				return vEsq / vDir;
			if (op.equals("=="))
				return (vEsq == vDir) ? 1 : 0;
			if (op.equals("!="))
				return (vEsq != vDir) ? 1 : 0;
			if (op.equals("<"))
				return (vEsq < vDir) ? 1 : 0;
			if (op.equals(">"))
				return (vEsq > vDir) ? 1 : 0;
			if (op.equals("&&"))
				return (vEsq != 0 && vDir != 0) ? 1 : 0;
			if (op.equals("||"))
				return (vEsq != 0 || vDir != 0) ? 1 : 0;

		}
		case "For": {
			String nomeVar = t.getChild(1).getText();
			int numero1 = Integer.parseInt(t.getChild(3).getText());
			int numero2 = Integer.parseInt(t.getChild(5).getText());

			if (!vars.containsKey(nomeVar)) {
				for (int i = numero1; i <= numero2; i++) {
					int contador = 8;
					while (!t.getChild(contador).getText().equals("}")) {
						ParseTree expr = t.getChild(contador);
						vars.put(nomeVar, i);
						avalie(expr);
						contador++;
					}
				}
				vars.remove(nomeVar);
			} else {
				throw new RuntimeException("variavel " + nomeVar + " ja declarada");
			}

			return 0;

		}
		case "Elvis": {
			String nomeVar = t.getChild(2).getText();
			if (vars.containsKey(nomeVar)) {
				int valor = vars.get(nomeVar);
				if (valor > 0) {
					return valor;
				} else {
					return 0;
				}

			} else {
				throw new RuntimeException("variavel " + nomeVar + " nao declarada");
			}

		}
		case "Inc": {
			String nomeVar = t.getChild(0).getText();

			if (vars.containsKey(nomeVar)) {
				int valor = vars.get(nomeVar);
				vars.put(nomeVar, valor + 1);
			} else
				throw new RuntimeException("variavel " + nomeVar + " nao declarada");
			System.out.println("incremento");
			System.out.println(vars);
			return 0;

		}

		default:
			System.err.println("Nao sei avaliar nos: " + tipo);
			return 0;

		}
	}

}