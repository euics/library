package eucis.libraryapp.service;

import eucis.libraryapp.entity.Users;
import eucis.libraryapp.repository.UserRepository;
import eucis.libraryapp.request.UserCreateRequest;
import eucis.libraryapp.request.UserDeleteRequest;
import eucis.libraryapp.request.UserUpdateRequest;
import jakarta.persistence.EntityExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        userRepository.save(new ModelMapper().map(request, Users.class));
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public void updateUser(UserUpdateRequest request) {
        Users findUser = userRepository.findById(request.getId())
                .orElseThrow(EntityExistsException::new);

        findUser.setName(request.getName());
        userRepository.save(findUser);
    }

    public void deleteUser(UserDeleteRequest request){
        Users findUser = userRepository.findById(request.getId())
                .orElseThrow(EntityExistsException::new);
        userRepository.deleteById(findUser.getId());
    }
}
