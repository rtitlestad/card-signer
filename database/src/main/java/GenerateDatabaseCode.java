import io.github.rtitlestad.cardsigner.database.CardDatabase;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;

import java.io.File;

public class GenerateDatabaseCode {

    public static void main(String[] args) throws Exception {
        new CardDatabase().initialiseSchema();

        GenerationTool.generate(new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.h2.Driver")
                        .withUrl(CardDatabase.DB_URL))
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withInputSchema("PUBLIC"))
                        .withGenerate(new Generate())
                        .withTarget(new Target()
                                .withDirectory(srcMainJavaDirectory())
                                .withPackageName("io.github.rtitlestad.cardsigner.database.generated"))));
    }

    private static String srcMainJavaDirectory() {
        String targetClassesDirectory = GenerateDatabaseCode.class.getResource(".").getPath();
        return new File(targetClassesDirectory + "../../src/main/java").toString();
    }
}
