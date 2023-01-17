package org.spring.ajax.dto;

import lombok.*;
import org.spring.ajax.entity.AjaxMemberEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AjaxMemberDto {
    private Long id;
    private String userName;
    private String userPw;

    // Entity -> Dto
    public static AjaxMemberDto toAjaxMemberDto(AjaxMemberEntity ajaxMemberEntity){

        AjaxMemberDto ajaxMemberDto =new AjaxMemberDto();

        ajaxMemberDto.setUserName(ajaxMemberEntity.getUserName());
        ajaxMemberDto.setUserPw(ajaxMemberEntity.getUserPw());

        return ajaxMemberDto;

    }
    public static AjaxMemberDto toGetAjaxMemberDto(AjaxMemberEntity ajaxMemberEntity){

        AjaxMemberDto ajaxMemberDto =new AjaxMemberDto();

        ajaxMemberDto.setId(ajaxMemberEntity.getId());
        ajaxMemberDto.setUserName(ajaxMemberEntity.getUserName());
        ajaxMemberDto.setUserPw(ajaxMemberEntity.getUserPw());

        return ajaxMemberDto;

    }

}
