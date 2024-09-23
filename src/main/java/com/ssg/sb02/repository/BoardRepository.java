package com.ssg.sb02.repository;

import com.ssg.sb02.domain.Board;
import com.ssg.sb02.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> , BoardSearch {
}

//JpaRepository 인터페이스를 상속할때에는 엔티티 타입과 @Id 타입을 지정해 주어야 한다.