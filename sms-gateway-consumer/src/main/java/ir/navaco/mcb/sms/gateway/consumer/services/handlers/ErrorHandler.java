package ir.navaco.mcb.sms.gateway.consumer.services.handlers;

public class ErrorHandler {
    private String status;

    public ErrorHandler(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
