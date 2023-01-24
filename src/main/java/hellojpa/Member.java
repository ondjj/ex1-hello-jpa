package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER") --> 저장될 테이블 이름을 지정 할 수 있다.
public class Member {

    @Id
    private Long id;

//    @Column(name = "username") --> 저장될 컬럼 명을 지정 할 수 있다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
