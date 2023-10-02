package ku.cs.kafe.service;


import ku.cs.kafe.entity.Member_Sorasak_6210451560;
import ku.cs.kafe.model.SignupRequest_Sorasak_6210451560;
import ku.cs.kafe.repository.MemberRepository_Sorasak_6210451560;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignupService_Sorasak_6210451560 {


    @Autowired
    private MemberRepository_Sorasak_6210451560 repository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ModelMapper modelMapper;


    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createUser(SignupRequest_Sorasak_6210451560 user) {
        Member_Sorasak_6210451560 record = modelMapper.map(user, Member_Sorasak_6210451560.class);
//        Member record = new Member();
//        record.setName(user.getName());
//        record.setUsername(user.getUsername());
        record.setRole("ROLE_USER");


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public Member_Sorasak_6210451560 getUser(String username) {
        return repository.findByUsername(username);
    }
}
