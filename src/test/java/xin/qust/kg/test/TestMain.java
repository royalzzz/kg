package xin.qust.kg.test;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.international.pennchinese.ChineseGrammaticalStructure;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//@SpringBootTest
public class TestMain {

    @Test
    public void test() {
        LexicalizedParser lp = LexicalizedParser.loadModel(this.getClass().getClassLoader().getResource("xinhuaFactoredSegmenting.ser.gz").getPath());
        List<String> lines = Arrays.asList("烧碱具有极强的腐蚀性，尤其温度高、浓度高时腐蚀性更强。", "烧碱有关的各项装置时，均必须戴好必要的劳保用品，防止烧碱溶液外泄飞溅触及人体眼睛及皮肤而发生化学灼伤。");
        lines.stream().forEach(sentence -> {
            Tree tree = lp.parse(sentence);
            ChineseGrammaticalStructure gs = new ChineseGrammaticalStructure(tree);
            Collection<TypedDependency> tdl = gs.typedDependenciesCollapsed();

            System.out.println("sentence:"+sentence);
            tdl.stream().forEach(typedDependency -> {
                System.out.println("Governor Word: [" + typedDependency.gov() + "] Relation: [" + typedDependency.reln().getLongName() + "] Dependent Word: [" + typedDependency.dep() + "]");
            });
        });
    }
}
