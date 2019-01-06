package pl.coderslab.warsztatkoncowytaskplanner.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.UserDto;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.User;
import pl.coderslab.warsztatkoncowytaskplanner.Repositories.UserRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService<UserDto, Long> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setDescription(dto.getDescription());
        userRepository.save(user);
        return user.toDto();
    }

    @Override
    public UserDto update(UserDto dto, Long id) {
        User user = userRepository.findUserById(id);
        user.setName(dto.getName());
        user.setDescription(dto.getDescription());
        userRepository.save(user);
        return user.toDto();
    }

    @Override
    public UserDto find(Long id) {
        User user = userRepository.findUserById(id);
        if (Objects.isNull(user)) {
            return null;
        }else {
            return user.toDto();
        }

    }

    @Override
    public Boolean remove(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
        return true;
    }

    @Override
    public Collection<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(User::toDto)
                .collect(Collectors.toList());
    }
}
