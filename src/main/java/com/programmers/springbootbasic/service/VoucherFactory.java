package com.programmers.springbootbasic.service;

import com.programmers.springbootbasic.domain.voucher.VoucherType;
import com.programmers.springbootbasic.domain.voucher.FixedAmountVoucher;
import com.programmers.springbootbasic.domain.voucher.PercentDiscountVoucher;
import com.programmers.springbootbasic.domain.voucher.Voucher;

import java.time.LocalDateTime;
import java.util.UUID;

public class VoucherFactory {

    private VoucherFactory() {

    }

    public static Voucher of(VoucherType voucherType, String name, Long minimumPriceCondition, LocalDateTime createdDate, LocalDateTime expirationDate, int discount) {
        return switch (voucherType) {
            case PERCENT ->
                new PercentDiscountVoucher(UUID.randomUUID(), name, minimumPriceCondition, createdDate, expirationDate, discount);
            case FIX ->
                new FixedAmountVoucher(UUID.randomUUID(), name, minimumPriceCondition, createdDate, expirationDate, discount);
        };
    }
}