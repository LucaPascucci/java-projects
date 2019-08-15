package lab.e2;

public class TodayTasksImpl implements TodayTasks {

	private String[] giornata = new String[24];

	@Override
	public boolean addTask(int startTime, int duration, String description)
			throws IllegalArgumentException {
		if (startTime < 8 || startTime > 18 || description == null
				|| duration < 1 || startTime + duration > 19) {
			throw new IllegalArgumentException();
		}
		for (int i = startTime; i < startTime + duration; i++) {
			if (giornata[i] != null) {
				return false;
			}
		}
		for (int i = startTime; i < startTime + duration; i++) {
			giornata[i] = description;
		}
		return true;
	}

	@Override
	public String getTaskDescription(int time) throws IllegalArgumentException {
		if (time < 8 || time > 18) {
			throw new IllegalArgumentException();
		}
		return giornata[time];
	}

}