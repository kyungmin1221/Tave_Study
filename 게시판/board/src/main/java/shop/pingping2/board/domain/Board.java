package shop.pingping2.board.domain;

// 게시판 글 정보들을 모아놓은 보드 테이블 //

import lombok.AccessLevel;
import lombok.*;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 외부에서의 생성을 열어 둘 필요가 없을 때 / 보안적으로 권장된다.
@Getter
@Entity
@Table(name = "board")  // 이거 보고 테이블 생성
public class Board extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10,nullable = false)
    private String writer;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(columnDefinition = "Text", nullable = false)
    private String content;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    // Java 디자인 패턴, 생성 시점에 값을 채워줌
    @Builder
    public Board(Long id, String title, String content, String writer, User user) {
        // Assert 구문으로 안전한 객체 생성 패턴을 구현
        Assert.hasText(writer, "writer must not be empty");
        Assert.hasText(title, "title must not be empty");
        Assert.hasText(content, "content must not be empty");

        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
