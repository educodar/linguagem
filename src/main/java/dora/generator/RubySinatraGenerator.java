package dora.generator;

import dora.antlr.GrammarBaseVisitor;

import static dora.antlr.GrammarParser.RouteContext;
import static java.lang.String.format;

public class RubySinatraGenerator extends GrammarBaseVisitor<String> {
    @Override
    public String visitRoute(RouteContext ctx) {
        return format("get %s do end", ctx.STRING().getText());
    }
}
