package com.ssg.sb02.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      //엔티티 객체를 위한 엔티티 클래스는 반드시 @Entity 를 적용해야 하고 @Id 를 필요로 한다.
      //게시물은 데이터베이스에 추가될때마다 생성되는 번호를 이용하므로 키 생성전략(key generated strategy 로 데이터베이스에서 알아서 결정하는 방식, mysql의 autoincrement)
      private  Long bno;

      @Column(length = 500, nullable = false)
      private String title;

      @Column(length = 1000, nullable = false)
      private String content;

      @Column(length = 50,nullable = false)
      private String writer;

      public void change(String title, String content){
              this.title = title;
              this.content = content;
      }
}
