package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor  //final이나 NUllof?? 애들을 생성자를 만들어준다.
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional      //sql쿼리가 일어나야 되는것을 스프링에게 알려주는 친구이다
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);        //찾은 친구를 memo에 올려놓고 바꿀 친구
        return memo.getId();
    }
}