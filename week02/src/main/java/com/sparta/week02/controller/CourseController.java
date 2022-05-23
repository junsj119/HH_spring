package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {      //@RequestBody 요청을 받는 녀석이란 걸 표시. 없으면 요청한 정보가 DTO에 안들어감
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    //수정
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {     // {} 안에 값을  PathVariable 붙은 친구한테 넣어준다
        return courseService.update(id, requestDto);
    }
    //삭제
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
}