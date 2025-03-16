package cipher.commands;

import cipher.entity.Result;
import cipher.entity.ResultCode;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO something do
        return new Result("brute force all right", ResultCode.OK);
    }
}
