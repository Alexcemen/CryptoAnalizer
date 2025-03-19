package cipher;

import cipher.arguments.*;
import cipher.exeptions.AppException;

public enum CipherOptions {
    ENCODE(new EncodeOption()),
    DECODE(new DecodeOption()),
    BRUTE_FORCE(new BruteForceOption()),
    STATISTICAL_ANALYZER(new StatisticalAnalyzeOption());

    private final CipherOption cipherOption;

    CipherOptions(CipherOption cipherOption) {
        this.cipherOption = cipherOption;
    }

    public static CipherOption find(String cipherOptionName) {
        try {
            CipherOptions value = CipherOptions.valueOf(cipherOptionName.toUpperCase());
            return value.cipherOption;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + cipherOptionName, e);
        }
    }
}
