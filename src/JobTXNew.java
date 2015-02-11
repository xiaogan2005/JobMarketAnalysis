
public class JobTXNew {
	
	private String id;
	private String name;
	private String title;
	private double salary;
	private String hire_date;
  
    public JobTXNew(String id, String title, double salary, String hire_date) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.hire_date = hire_date;
    }
    
    @Override
    public String toString() {
        return hire_date + "," + title + ", " + salary;
    }

}
