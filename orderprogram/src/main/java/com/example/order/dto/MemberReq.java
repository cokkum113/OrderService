package com.example.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberReq {
    private String name;

    @Builder
    public MemberReq(String name) {
        this.name = name;
    }

}
