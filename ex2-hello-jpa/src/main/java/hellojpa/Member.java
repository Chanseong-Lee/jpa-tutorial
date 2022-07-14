package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	
	@Id	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;
	
	@ManyToOne	//연관관계 어노테이션 : 현재 클래스 기준으로 다대일의 다이면 ManyToOne
	@JoinColumn(name = "TEAM_ID")	//join할 컬럼 지정
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
