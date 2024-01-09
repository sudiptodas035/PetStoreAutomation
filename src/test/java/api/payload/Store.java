package api.payload;

import java.util.Date;



public class Store {

	int id;
	int petId;
	int quantity;
	Date dateAndTime;
	String status;
	boolean complete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getShipDate() {
		return dateAndTime;
	}

	public void setShipDate(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
