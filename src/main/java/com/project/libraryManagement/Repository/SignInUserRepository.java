package com.project.libraryManagement.Repository;

import com.project.libraryManagement.Object.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface SignInUserRepository extends JpaRepository<Users, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Users u set u.delete = 'NO' where u.id = :id", nativeQuery = true)
    void deleteBookById(@Param("id") int id);


    @Query("Select u from  Users u  where u.delete <> 'NO'")
    List<Users> findAllUser();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="update Users u set u.first_name= :firstName, u.last_name=:lastName, u.address=:address where u.id = :id", nativeQuery = true)
    void updateUserDetails(String firstName, String lastName, String address, int id);

    @Query("Select u from  Users u  where u.id = :id and u.delete <> 'NO'")
    Optional<Users> findStudentById(int id);
}
