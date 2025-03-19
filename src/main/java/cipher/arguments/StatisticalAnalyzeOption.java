package cipher.arguments;

public class StatisticalAnalyzeOption extends CommonOption implements CipherOption {
    @Override
    public String[] requestArguments() {
        return new String[] {"STATISTICAL_ANALYZER"};
    }
}
