package com.fundamentosplatzi.springboot.fundamentos.repository;

import com.fundamentosplatzi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.nombre like ?1%")
    List<User> findAndSort(String name, Sort sort);

    /*
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);
    List<User> findByNameLike(String nombre);
    @Query("SELECT new com.fundamentosplatzi.springboot.fundamentos.dto.UserDto(u.id, u.name, u.cumpleanos)" +
            " FROM User u " +
            "WHERE u.cumpleanos=:parametroFecha " +
            "  AND u.email=:parametroEmail ")
    Optional<UserDto> getAllByCumpleanosAndEmail(@Param("parametroFecha") LocalDate date,
                                                 @Param("parametroEmail") String email);
    */

    List<User> findAll();

}
