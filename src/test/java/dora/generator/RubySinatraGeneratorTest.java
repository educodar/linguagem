package dora.generator;

import dora.antlr.GrammarLexer;
import dora.antlr.GrammarParser;
import dora.antlr.GrammarParser.RouteContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RubySinatraGeneratorTest {
    private RubySinatraGenerator rubySinatraGenerator;

    @Before
    public void setUp() throws Exception {
        rubySinatraGenerator = new RubySinatraGenerator();
    }

    @Test
    public void shouldTranslateRoute() {
        RouteContext context = routeContext("para'Batata'faça{}");

        String output = rubySinatraGenerator.visitRoute(context);

        String expectedOutput = "get 'Batata' do end";
        assertThat(output, equalTo(expectedOutput));
    }

    private RouteContext routeContext(String snippet) {
        GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(snippet));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GrammarParser parser = new GrammarParser(tokens);
        return parser.route();
    }
}
