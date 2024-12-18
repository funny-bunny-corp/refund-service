package funny.bunny.xyz.refund.service.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentOrderId {
  private String id;

  public PaymentOrderId(String id) {
    this.id = id;
  }

  public PaymentOrderId() {}

  public String getId() {
    return id;
  }

}


