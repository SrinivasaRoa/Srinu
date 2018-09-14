package com.station.Station;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.station.Station.models.Station;
import com.station.Station.repo.StationRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class StationRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private StationRepository stationRepository;

	@Test
	public void whenFindAll() {
		// given
		Station station = new Station();
		station.setName("S1");
		station.setHdEnabled(true);
		station.setCallSign("Sign");
		entityManager.persist(station);
		entityManager.flush();
		Station station1 = new Station();
		station1.setName("S11");
		station1.setHdEnabled(true);
		station1.setCallSign("Sign1");
		entityManager.persist(station1);
		entityManager.flush();
		List<Station> stationList = stationRepository.findByHdEnabled(true);
		assertThat(stationList.size()).isEqualTo(2);
		Station stationFindById = stationRepository.findByStationId(stationList.get(0).getStationId());
		assertThat(stationFindById).isNotEqualTo(null);
		Station stationFindByName = stationRepository.findByName(stationList.get(0).getName());
		assertThat(stationFindByName).isNotEqualTo(null);

	}

}
