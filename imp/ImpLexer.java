// Generated from Imp.g4 by ANTLR 4.7.1
package imp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ATRIB=11, PV=12, ESCREVA=13, TYPE=14, TRUE=15, FALSE=16, VAR=17, 
		NUM=18, STRING=19, OP1=20, OP2=21, COMP=22, LOGICO=23, APAR=24, FPAR=25, 
		SPACES=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "ATRIB", "PV", "ESCREVA", "TYPE", "TRUE", "FALSE", "VAR", "NUM", 
		"STRING", "OP1", "OP2", "COMP", "LOGICO", "APAR", "FPAR", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'++'", "'for'", "'in'", "'..'", "'do'", "'{'", "'}'", "'\"Elvis\"'", 
		"':'", "'?'", "'='", "';'", "'escreva'", null, "'true'", "'false'", null, 
		null, null, null, null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ATRIB", 
		"PV", "ESCREVA", "TYPE", "TRUE", "FALSE", "VAR", "NUM", "STRING", "OP1", 
		"OP2", "COMP", "LOGICO", "APAR", "FPAR", "SPACES"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ImpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17q\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\6\22\177\n\22\r\22\16\22\u0080\3\23\5\23\u0084\n\23\3\23\6\23\u0087\n"+
		"\23\r\23\16\23\u0088\3\24\3\24\3\24\3\24\7\24\u008f\n\24\f\24\16\24\u0092"+
		"\13\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u009f"+
		"\n\27\3\30\3\30\3\30\3\30\5\30\u00a5\n\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\3\2\t\3\2c|\3\2\62;\3\2$$\4\2--//\4\2,,\61\61\4\2>>@@\5\2\13\f\17"+
		"\17\"\"\2\u00b7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5"+
		":\3\2\2\2\7>\3\2\2\2\tA\3\2\2\2\13D\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21"+
		"K\3\2\2\2\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2"+
		"\35p\3\2\2\2\37r\3\2\2\2!w\3\2\2\2#~\3\2\2\2%\u0083\3\2\2\2\'\u008a\3"+
		"\2\2\2)\u0095\3\2\2\2+\u0097\3\2\2\2-\u009e\3\2\2\2/\u00a4\3\2\2\2\61"+
		"\u00a6\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2\2\2\678\7-\2\289\7-\2\29"+
		"\4\3\2\2\2:;\7h\2\2;<\7q\2\2<=\7t\2\2=\6\3\2\2\2>?\7k\2\2?@\7p\2\2@\b"+
		"\3\2\2\2AB\7\60\2\2BC\7\60\2\2C\n\3\2\2\2DE\7f\2\2EF\7q\2\2F\f\3\2\2\2"+
		"GH\7}\2\2H\16\3\2\2\2IJ\7\177\2\2J\20\3\2\2\2KL\7$\2\2LM\7G\2\2MN\7n\2"+
		"\2NO\7x\2\2OP\7k\2\2PQ\7u\2\2QR\7$\2\2R\22\3\2\2\2ST\7<\2\2T\24\3\2\2"+
		"\2UV\7A\2\2V\26\3\2\2\2WX\7?\2\2X\30\3\2\2\2YZ\7=\2\2Z\32\3\2\2\2[\\\7"+
		"g\2\2\\]\7u\2\2]^\7e\2\2^_\7t\2\2_`\7g\2\2`a\7x\2\2ab\7c\2\2b\34\3\2\2"+
		"\2cd\7k\2\2de\7p\2\2eq\7v\2\2fg\7d\2\2gh\7q\2\2hi\7q\2\2iq\7n\2\2jk\7"+
		"u\2\2kl\7v\2\2lm\7t\2\2mn\7k\2\2no\7p\2\2oq\7i\2\2pc\3\2\2\2pf\3\2\2\2"+
		"pj\3\2\2\2q\36\3\2\2\2rs\7v\2\2st\7t\2\2tu\7w\2\2uv\7g\2\2v \3\2\2\2w"+
		"x\7h\2\2xy\7c\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2|\"\3\2\2\2}\177\t\2\2\2~"+
		"}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081$"+
		"\3\2\2\2\u0082\u0084\7/\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0087\t\3\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089&\3\2\2\2\u008a\u0090"+
		"\7$\2\2\u008b\u008f\n\4\2\2\u008c\u008d\7^\2\2\u008d\u008f\7$\2\2\u008e"+
		"\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7$\2\2\u0094(\3\2\2\2\u0095\u0096\t\5\2\2\u0096*\3\2\2\2\u0097"+
		"\u0098\t\6\2\2\u0098,\3\2\2\2\u0099\u009f\t\7\2\2\u009a\u009b\7?\2\2\u009b"+
		"\u009f\7?\2\2\u009c\u009d\7#\2\2\u009d\u009f\7?\2\2\u009e\u0099\3\2\2"+
		"\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f.\3\2\2\2\u00a0\u00a1"+
		"\7(\2\2\u00a1\u00a5\7(\2\2\u00a2\u00a3\7~\2\2\u00a3\u00a5\7~\2\2\u00a4"+
		"\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7*\2\2"+
		"\u00a7\62\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9\64\3\2\2\2\u00aa\u00ab\t\b"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\33\2\2\u00ad\66\3\2\2\2\13\2p\u0080"+
		"\u0083\u0088\u008e\u0090\u009e\u00a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}