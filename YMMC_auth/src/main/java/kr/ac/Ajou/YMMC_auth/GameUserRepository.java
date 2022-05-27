package kr.ac.Ajou.YMMC_auth;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freaky_guys.youdrivemecrazy_server.domain.gameuser;


public interface GameUserRepository extends JpaRepository<gameuser,Long>{

	gameuser findByEmail(String email);
	List<gameuser> findAll();
	//gameuser selectGameuser(String email, String password);

}
