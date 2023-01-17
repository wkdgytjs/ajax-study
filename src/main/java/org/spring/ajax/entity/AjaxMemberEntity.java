package org.spring.ajax.entity;

import lombok.*;
import org.spring.ajax.dto.AjaxMemberDto;

import javax.persistence.*;

@Builder // Dto <-> Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor // Dto <-> Entity
@ToString
@Entity
@Table(name = "ajax_td")
public class AjaxMemberEntity {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(nullable = false, unique = true) // not null
    private String userName;

    @Column(nullable = false)
    private String userPw;

    // Dto -> Entity
    public static AjaxMemberEntity toAjaxMemberEntity(AjaxMemberDto ajaxMemberDto){

        AjaxMemberEntity memberEntity=new AjaxMemberEntity();

        memberEntity.setId(ajaxMemberDto.getId());
        memberEntity.setUserName(ajaxMemberDto.getUserName());
        memberEntity.setUserPw(ajaxMemberDto.getUserPw());

        return memberEntity;
    }

}
