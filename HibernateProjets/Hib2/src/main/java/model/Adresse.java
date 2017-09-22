package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
private String rue;
private int num, cp;


public Adresse(String rue, int num, int cp) {
	super();
	this.rue = rue;
	this.num = num;
	this.cp = cp;
}


public String getRue() {
	return rue;
}
public void setRue(String rue) {
	this.rue = rue;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getCp() {
	return cp;
}
public void setCp(int cp) {
	this.cp = cp;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + cp;
	result = prime * result + num;
	result = prime * result + ((rue == null) ? 0 : rue.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Adresse other = (Adresse) obj;
	if (cp != other.cp)
		return false;
	if (num != other.num)
		return false;
	if (rue == null) {
		if (other.rue != null)
			return false;
	} else if (!rue.equals(other.rue))
		return false;
	return true;
}
@Override
public String toString() {
	return "Adresse [rue=" + rue + ", num=" + num + ", cp=" + cp + "]";
}



}
