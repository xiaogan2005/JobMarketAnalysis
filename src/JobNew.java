
public class JobNew {
	
	private String id;
	private String agency;
	private String posting_type;
	private int no_of_positions;
	private String business_title;
	private String civil_service_title;
	private String title_code_no;
	private String level;
	private double salary_range_from;
	private double salary_range_to;
	private String salary_frequency;
	private double salary_avg;
	private String work_location;
	private String division_work_unit;
	private String job_description;
	private String minimum_qual_requirements;
	private String preferred_skills;
	private String additional_information;
	private String to_apply;
	private String hours_shift;
	private String residency_requirement;
	private String posting_date;
	private String posting_updated;
	
    public JobNew(String id, String agency, int no_of_positions, double salary_avg, String posting_date) {
        this.id = id;
        this.agency = agency;
        this.no_of_positions = no_of_positions;
        this.salary_avg = salary_avg;
        this.posting_date = posting_date;
    }
        
    @Override
    public String toString() {
        return id + ", " + agency + ", " + no_of_positions + ", " + salary_avg + ", "
                                      + posting_date;
    }
	
/*	public JobNew(String preferred_skills) {
        this.preferred_skills = preferred_skills;
    }
    @Override
    public String toString() {
        return preferred_skills;
    }*/

}
