package funny.bunny.xyz.refund.service.dtos.refund;

import funny.bunny.xyz.refund.service.domain.PaymentOrderId;

public record RequestRefund(String amount, String currency, PaymentOrderId paymentOrder) {}
