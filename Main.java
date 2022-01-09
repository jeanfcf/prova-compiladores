import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import java.io.*;

class Main {

	public static void printTree(String prefix, ParseTree tree) {
		if (tree instanceof TerminalNode) {
			System.out.println(prefix + "'" + tree.getText() + "'");
			return;
		}
		String className = tree.getClass().getSimpleName().replace("Context", "");
		System.out.println(prefix + className + "[ " + tree.getText() + " ]");

		for (int c = 0; c < tree.getChildCount(); c++) {
			printTree(prefix + "|  ", tree.getChild(c));
		}

	}

	public static void main(String[] args) throws IOException {

		System.out.println("Executando o reconhecedor.");
		CharStream src = CharStreams.fromFileName("teste.imp");

		ImpLexer lexer = new ImpLexer(src);
		TokenStream tokens = new CommonTokenStream(lexer);
		ImpParser parser = new ImpParser(tokens);

		ParseTree tree = parser.start();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.out.println("entrada errada");
			return;
		}
		System.out.println("entrada valida. Arvore:");
		printTree("", tree);
		AnalisadorSemantico analisador = new AnalisadorSemantico();
		if (analisador.analise(tree) == false) {
			System.err.println("erros de tipos detectados");
			return;
		} else {
			System.out.println("Nenhum erro encontrado");
		}

		System.out.println("\n-------------------------------------\nINICIO INTERPRETADOR:\n-------------------------------------");
		Interpretador inter = new Interpretador();
		inter.avalie(tree);
		System.out.println("\n-------------------------------------\nINICIO COMPILADOR:\n-------------------------------------");
		Compilador compilador = new Compilador();
		compilador.compile(tree,null);

	}
}