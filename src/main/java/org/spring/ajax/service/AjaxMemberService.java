package org.spring.ajax.service;

import lombok.RequiredArgsConstructor;
import org.spring.ajax.dto.AjaxMemberDto;
import org.spring.ajax.entity.AjaxMemberEntity;
import org.spring.ajax.repository.AjaxMemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AjaxMemberService {

    private final AjaxMemberRepository ajaxMemberRepository;

    @Transactional // 수정,추가,삭제시 반드시 *
    public int insertMember(AjaxMemberDto ajaxMemberDto) {
        // 회원이 있으면 exception 발생
        try{    //회원 없으면 정상 실행
            // Entity -> Dto
            ajaxMemberRepository.save(AjaxMemberEntity.toAjaxMemberEntity(ajaxMemberDto));
            return 1;
        }catch (Exception e){
            //회원 있으면 예외 발생
            return 0;
        }
    }
    public int findByUserNameDo(String userName) {

        Optional<AjaxMemberEntity> ajaxMemberEntityOptional =
                ajaxMemberRepository.findByUserName(userName);

        if(ajaxMemberEntityOptional.isPresent()){
            return 0; //있으면
        }else{
            return 1; //없으면
        }
    }

    public List<AjaxMemberDto> memberListDo() {

        List<AjaxMemberDto> ajaxMemberbers=new ArrayList<>();
        List<AjaxMemberEntity> ajaxMemberEntities=ajaxMemberRepository.findAll();
            // List<Entity> -> List<Dto> 변환
        for(AjaxMemberEntity ajaxMemberEntity:ajaxMemberEntities){
            ajaxMemberbers.add(AjaxMemberDto.toGetAjaxMemberDto(ajaxMemberEntity));
        }
        return ajaxMemberbers;
    }

    public AjaxMemberDto findByIdDo(Long id) {

        Optional<AjaxMemberEntity> ajaxMemberEntityOptional=
                ajaxMemberRepository.findById(id);
        if(ajaxMemberEntityOptional.isPresent()){
            //Entity -> Dto
            return AjaxMemberDto.toGetAjaxMemberDto(ajaxMemberEntityOptional.get());
        }else{
            return null;
        }
    }
}
