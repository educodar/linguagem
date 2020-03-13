package dora;

import dora.antlr.GrammarLexer;
import dora.antlr.GrammarParser;
import dora.antlr.GrammarParser.RouteContext;
import dora.generator.RubySinatraGenerator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Application {
    public static void main(String[] args) {
        String program = "para'Batata'faça{}";

        GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GrammarParser parser = new GrammarParser(tokens);
        RouteContext context = parser.route();

        RubySinatraGenerator rubySinatraGenerator = new RubySinatraGenerator();
        String output = rubySinatraGenerator.visit(context);

        System.out.println(output);
    }
}
