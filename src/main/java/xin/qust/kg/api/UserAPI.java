package xin.qust.kg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.kg.domain.User;
import xin.qust.kg.repository.UserRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserAPI {

    private final UserRepository userRepository;

    public UserAPI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("add")
    public User add(String name, String gender){
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        return userRepository.save(user);
    }

    @RequestMapping("info")
    public User info(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(User::new);
    }

    @RequestMapping("test")
    public void test() {
        Optional<User> sona = userRepository.findById("8f492fcc-23a9-4251-84c2-4ec0250acbe5");
        if (sona.isPresent()) {
//            Set<String> nickNames = new HashSet<>();
//            nickNames.add("tuer");
//            nickNames.add("lap");
//            nickNames.add("wsn");
//            sona.get().setNickName(nickNames);
            sona.get().setWeight(89.36);
            userRepository.save(sona.get());
        }
    }
}
