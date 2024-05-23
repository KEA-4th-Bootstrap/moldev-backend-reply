package org.bootstrap.reply.common.error;

public class ForbiddenException extends BaseErrorException {
    public static final ForbiddenException EXCEPTION = new ForbiddenException();

    public ForbiddenException() {
        super(GlobalErrorCode.MEMBER_FORBIDDEN);
    }
}
