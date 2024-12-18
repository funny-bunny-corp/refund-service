package funny.bunny.xyz.refund.service.domain.exception;

public class IdempotencyKeyAlreadyUsed extends RuntimeException{
  @Override
  public String getMessage() {
    return "Checkout request already sent";
  }
}
