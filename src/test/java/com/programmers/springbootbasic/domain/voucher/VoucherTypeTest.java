package com.programmers.springbootbasic.domain.voucher;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VoucherTypeTest {
    @Test
    void 정률할인_from_성공() {
        // given
        String type = "정률 할인";

        // when
        VoucherType voucherType = VoucherType.from(type);

        // then
        assertThat(voucherType).isEqualTo(VoucherType.PERCENT);
    }

    @Test
    void 정액할인_from_성공() {
        // given
        String type = "정액 할인";

        // when
        VoucherType voucherType = VoucherType.from(type);

        // then
        assertThat(voucherType).isEqualTo(VoucherType.FIX);
    }

    @Test
    void 잘못된값_from_에외발생() {
        // given
        String type = "뭔지 모름";

        // when && then
        assertThatThrownBy(() -> VoucherType.from(type))
                .isInstanceOf(IllegalArgumentException.class);
    }
}