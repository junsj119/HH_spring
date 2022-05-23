package com.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class MemoRequestDto {
    public String username;
    public String contents;

    public MemoRequestDto(String username, String contents){
        this.username = username;
        this.contents = contents;
    }
}
