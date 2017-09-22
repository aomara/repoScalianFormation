package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Rib {

	private String num;
	private String iban;
	private int version;

	@Id
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Rib() {

	}

	public Rib(String num, String iban) {

		this.num = num;
		this.iban = iban;
	}

	public String toString() {
		return "Rib [num=" + num + ", iban=" + iban + "]";
	}

}
