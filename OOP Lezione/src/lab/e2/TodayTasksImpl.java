package lab.e2;

public class TodayTasksImpl implements TodayTasks {

	private String[] giornata;
	private static final int JUMP = 8;
	private static final int SIZE = 11;
	
	public TodayTasksImpl(){
		this.giornata = new String[SIZE];
	}
	
	@Override
	public boolean addTask(int startTime, int duration, String description) throws IllegalArgumentException{
		if (startTime<8 || duration<1 || description==null || startTime+duration>19){
			throw new IllegalArgumentException();
		}
		if(this.giornata[startTime-JUMP] == null){
			for(int i = startTime-JUMP; i<startTime-JUMP+duration; i++){
				if(this.giornata[i] != null){
					return false;
				}
			}
		}
		for(int i = startTime-JUMP; i<startTime-JUMP+duration; i++){
			this.giornata[i] = description;
		}
		
		return true;
	}

	@Override
	public String getTaskDescription(int time) {
		return this.giornata[time-JUMP];
	}

}
