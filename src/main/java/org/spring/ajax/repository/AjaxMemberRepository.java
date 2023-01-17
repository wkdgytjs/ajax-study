package org.spring.ajax.repository;

import org.spring.ajax.entity.AjaxMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AjaxMemberRepository extends JpaRepository<AjaxMemberEntity,Long> {

    //@Modifying // 수정, 추가, 삭제시 반드시 붙여줘야함
    Optional<AjaxMemberEntity> findByUserName(String userName);
}
