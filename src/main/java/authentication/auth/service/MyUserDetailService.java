package authentication.auth.service;

import authentication.auth.domain.MyUserDetails;
import authentication.auth.domain.User;
import authentication.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {
    @Autowired
   UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Optional<User> user= userRepository.findByUserName(userName);
      user.orElseThrow(()->new UsernameNotFoundException("Not FOund:"+ userName));
   return    user.map(MyUserDetails::new).get();

    }
}
