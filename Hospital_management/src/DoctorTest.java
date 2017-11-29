import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class DoctorTest {

	@Test
	void TreatPatienttest() {
		Patient p = new Patient("pat", "pat");
		Doctor d = new Doctor("doc", "doc");
		p.AddRecord(new PatientRecord(LocalTime.now(), "Very sick", "crocin", d.getName()));
		d.TreatPatient(p);
		assert(2 == p.getPatientRecord().size());
		PatientRecord pr = p.getPatientRecord().remove(1);
		assert(pr.getDiagnosis().contains("Very sick"));
		
	}

}
