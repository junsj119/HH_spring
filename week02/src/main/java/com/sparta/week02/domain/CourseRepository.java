//인터페이스 - 클래스에서 멤버가 빠진, 메소드 모음집
package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//<클래스 이름, ID 자료형>
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}