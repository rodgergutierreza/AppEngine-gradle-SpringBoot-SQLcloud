package helloworld.project.test.services.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import helloworld.project.test.domain.Test;
import helloworld.project.test.repository.test.TestDao;
import helloworld.project.test.repository.test.TestEntity;

@Service
public class TestServiceImpl implements TestServices {
	@Autowired
	private TestDao testDao;

	@Override
	public List<Test> getTest() {
		List<Test> tests = new ArrayList<>();
		List<TestEntity> testEntities = testDao.findAll();

		for (TestEntity testEntity : testEntities) {
			Test test = new Test();
			test.setValor(testEntity.getValor());
			tests.add(test);
		}
		return tests;
	}

}
