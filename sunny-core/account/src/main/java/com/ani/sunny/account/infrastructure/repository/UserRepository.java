package com.ani.sunny.account.infrastructure.repository;

import com.ani.sunny.account.infrastructure.domain.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhaoyu on 15-6-12.
 */
public interface UserRepository extends JpaRepository<UserDao, Long> {
    public UserDao findByHashUserId(Long hashUserId);
    public UserDao findByEmail(String email);
}
