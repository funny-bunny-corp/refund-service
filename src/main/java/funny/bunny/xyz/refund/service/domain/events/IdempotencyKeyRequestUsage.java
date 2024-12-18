package funny.bunny.xyz.refund.service.domain.events;

import org.springframework.context.ApplicationEvent;

public class IdempotencyKeyRequestUsage extends ApplicationEvent {
  private final String idempotencyKey;
  public IdempotencyKeyRequestUsage(Object source,String idempotencyKey) {
    super(source);
    this.idempotencyKey = idempotencyKey;
  }
  public String getIdempotencyKey() {
    return idempotencyKey;
  }
}
