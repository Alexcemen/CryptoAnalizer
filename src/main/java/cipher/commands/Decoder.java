package cipher.commands;

import cipher.entity.Result;
import cipher.entity.ResultCode;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO something do
        return new Result("decode all right", ResultCode.OK);
    }
}
