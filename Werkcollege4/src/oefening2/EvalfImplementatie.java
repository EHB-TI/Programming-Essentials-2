package oefening2;
import java.util.Calendar;

public class EvalfImplementatie extends Evalf {
	@Override
	protected Evalf getInstance() {
		if (instance == null) {
			instance = new EvalfImplementatie();
		}
		return instance;
	}

	public static void main(String[] args) {
		EvalfImplementatie evalf = new EvalfImplementatie();

		Docent mijnDocent = new Docent("Ruben", "Dejonckheere");
		MessageImplementatie message = new MessageImplementatie(Calendar
				.getInstance().getTime(), mijnDocent);
		Student student = new Student("Jan", "Janssens");
		System.out.println(evalf.post(message));
		message = new MessageImplementatie(Calendar.getInstance().getTime(),
				student);
		System.out.println(evalf.post(message));

	}

}
