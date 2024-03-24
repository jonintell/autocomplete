package com.bottomline.autocomplete.repository;


import java.util.List;

import com.bottomline.autocomplete.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NameRepository extends JpaRepository<Name, Long> {

}
