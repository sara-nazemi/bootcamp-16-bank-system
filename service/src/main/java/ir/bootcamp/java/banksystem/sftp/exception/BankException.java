package ir.bootcamp.java.banksystem.sftp.exception;

public class BankException extends RuntimeException {
    public BankException() {
    }

    public BankException(String message) {
        super(message);
    }

    public BankException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankException(Throwable cause) {
        super(cause);
    }

    public BankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
