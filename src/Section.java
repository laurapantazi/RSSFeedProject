
public class Section {
	int id;
	Section section;
	String description,answer,type;
	
	public Section(){	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		if(type.equals("true-false")){
			return "True-False";
		}
		else if(type.equals("simple-text"))
		{
		return "Simple Text";
		}
		return null;
	}
	public void setType(String type) {
		this.type = type;
	}
}
