import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

class Compilador {
	// Mapeamento: NomeVariavel --> Endereço
	// Endereço: 0..31 : Registrador
	// 32.. : Memória

	HashMap<String, Integer> vars = new HashMap<String, Integer>();
	int memoriaLivre = 32;
	int indiceLabel = 1;

	void compile(ParseTree t, Integer regDest) {
		String tipo = t.getClass().getSimpleName().replace("Context", "");
		switch (tipo) {
		case "Start": {
			for (int c = 0; c < t.getChildCount() - 1; c++)
				compile(t.getChild(c), null);
			return;
		}
		case "Dec": {
			String nomeVar = t.getChild(1).getText();
			ParseTree valorInicial = t.getChild(3);
			int enderecoVar = memoriaLivre++;
			vars.put(nomeVar, enderecoVar);

			compile(valorInicial, 1);
			System.out.printf("store r1, (%d) \n", enderecoVar);

			return;
		}
		case "Atrib": {
			String nomeVar = t.getChild(0).getText();
			ParseTree valor = t.getChild(2);
			int enderecoVar = vars.get(nomeVar);
			compile(valor, 1);
			System.out.printf("store r1, (%d) \n", enderecoVar);

			return;
		}

		case "CTrue": {
			System.out.printf("mov r%d, 1\n", regDest);
			return;
		}
		case "CFalse": {
			System.out.printf("mov r%d, 0\n", regDest);
			return;
		}
		case "Const": {
			String valor = t.getChild(0).getText();
			System.out.printf("mov r%d, %s\n", regDest, valor);
			return;
		}
		case "Var": {
			String nomeVar = t.getChild(0).getText();
			int enderecoVar = vars.get(nomeVar);
			System.out.printf("load r%d, (%d) \n", regDest, enderecoVar, nomeVar);
			return;
		}
		case "Op": {
			ParseTree esq = t.getChild(0);
			String op = t.getChild(1).getText();
			ParseTree dir = t.getChild(2);
			compile(esq, regDest);
			compile(dir, regDest + 1);
			if (op.equals("+"))
				System.out.printf("add r%d, r%d, r%d\n", regDest, regDest, regDest + 1);
			else if (op.equals("-"))
				System.out.printf("sub r%d, r%d, r%d\n", regDest, regDest, regDest + 1);
			else if (op.equals("*"))
				System.out.printf("mul r%d, r%d, r%d\n", regDest, regDest, regDest + 1);
			else
				System.out.printf("//Nao sei como compilar o operador %s\n", op);
			return;
		}
		case "Elvis": {
			String nomeVar = t.getChild(2).getText();
			int enderecoVar = vars.get(nomeVar);
			System.out.printf("load r1, (%d)\n", enderecoVar);
			System.out.printf("mov r2,0\n");
			System.out.printf("gt r1,r1,r2\n");
			System.out.printf("store r1,(%d)\n", enderecoVar);
			return;
		}
		case "For": {
			String nomeVar = t.getChild(1).getText();
			int numero1 = Integer.parseInt(t.getChild(3).getText());
			int numero2 = Integer.parseInt(t.getChild(5).getText());

			int enderecoVar = memoriaLivre++;
			vars.put(nomeVar, enderecoVar);

			System.out.printf("mov r1,%d \n", numero1);
			System.out.printf("mov r2,%d \n", numero2);
			System.out.printf("store r1,(%d) \n", enderecoVar);
			System.out.printf("mov r3,r1 \n");
			System.out.printf("inicioFor: le r3,r3,r2 \n");
			System.out.printf("jump Z r3, fimfor \n");

			int contador = 8;
			while (!t.getChild(contador).getText().equals("}")) {
				ParseTree expr = t.getChild(contador);
				compile(expr, null);
				contador++;
			}

			vars.remove(nomeVar);
			System.out.printf("mov r4,1 \n");
			System.out.printf("add r3,r3,r4 \n");
			System.out.printf("jump inicioFor \n");
			System.out.printf("fimfor: Stop \n");

			return;
		}
		case "Inc": {
			String nomeVar = t.getChild(0).getText();
			int enderecoVar = vars.get(nomeVar);
			System.out.printf("load r1, (%d)\n", enderecoVar);
			System.out.printf("mov r2,1\n");
			System.out.printf("add r1,r1,r2\n");
			System.out.printf("store r1,(%d)\n", enderecoVar);

			return;
		}
		default:
			System.out.printf("Nao sei compilar %s ainda\n", t.getText());
		}
	}
}