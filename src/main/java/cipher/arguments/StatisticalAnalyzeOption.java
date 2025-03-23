package cipher.arguments;

public class StatisticalAnalyzeOption extends AbstractOption implements CipherOption {
    @Override
    public String[] requestArguments() {
        return new String[] {"STATISTICAL_ANALYZER"};
    }
}
