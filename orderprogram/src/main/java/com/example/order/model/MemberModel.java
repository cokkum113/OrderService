//package com.example.order.model;
//
//import com.example.order.Entity.Member;
//import com.example.order.dto.MemberRes;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class MemberModel {
//    private Long memberId;
//    private String userName;
//
//    public static MemberModel createMember(String userName) {
//        MemberModel memberModel = new MemberModel();
//        memberModel.userName = userName;
//        return memberModel;
//    }
//    public MemberRes toResponse() {
//        return new MemberRes(
//                memberId,
//                userName
//        );
//    }
//
//    public Member toEntity() {
//        return Member.createMember(userName);
//    }
//
//    public static MemberModel valueOf(Member member) {
//        return new MemberModel(
//                member.getId(),
//                member.getName()
//        );
//    }
//}
