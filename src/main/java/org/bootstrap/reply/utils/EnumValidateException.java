package org.bootstrap.reply.utils;

import org.bootstrap.reply.common.error.BaseErrorException;
import org.bootstrap.reply.common.error.GlobalErrorCode;

public class EnumValidateException extends BaseErrorException {
    public static final BaseErrorException EXCEPTION = new EnumValidateException();

    public EnumValidateException() {
        super(GlobalErrorCode.INVALID_ENUM_CODE);
    }

}