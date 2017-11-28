import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class DoctorTest {

	@Test
	void TreatPatienttest() {
		Patient p = new Patient("pat", "pat");
		Doctor d = new Doctor("doc", "doc");
		p.patientRecord.add(new PatientRecord(LocalTime.now(), "Very sick", "crocin", d.name));
		d.TreatPatient(p);
		assert(2 == p.patientRecord.size());
		
	}

}
