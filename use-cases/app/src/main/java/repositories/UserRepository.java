package repositories;

import entities.User;

public interface UserRepository {
    User get(String userId);

    void update(User user);

    void save(User user);
}
