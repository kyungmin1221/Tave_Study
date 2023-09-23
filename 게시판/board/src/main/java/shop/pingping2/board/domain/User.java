package shop.pingping2.board.domain;

// Google OAuth2 로그인 한 사용자들에게 대한 정보를 저장하기 위한 User 테이블

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@Entity(name = "USER_TABLE")
@Entity
@Table(name ="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)      // 외부에서의 생성을 열어 둘 필요가 없을 때 / 보안적으로 권장된다.
public class User extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    


}


