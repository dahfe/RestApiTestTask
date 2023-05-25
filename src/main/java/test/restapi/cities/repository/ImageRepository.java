package test.restapi.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.restapi.cities.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
