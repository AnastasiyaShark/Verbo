package com.shark.App.repository;

import com.shark.App.model.user.Language;
import com.shark.App.model.user.LanguageE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Optional<Language> findByName (LanguageE language);
}
