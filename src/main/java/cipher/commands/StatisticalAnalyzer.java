package cipher.commands;

import cipher.entity.Result;
import cipher.entity.ResultCode;

public class StatisticalAnalyzer extends AbstractCommand implements Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result("Выбери ченить другое", ResultCode.ERROR);
    }
}
