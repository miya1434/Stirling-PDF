package stirling.software.common.model.exception;

public class BackupNotFoundException extends RuntimeException {
    public BackupNotFoundException(String message) {
        super(message);
    }
}
