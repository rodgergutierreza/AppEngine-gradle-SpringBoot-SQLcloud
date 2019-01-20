package helloworld.project.test.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<TestEntity, String> {

}
