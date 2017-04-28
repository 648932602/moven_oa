package com.moven.model;

public class OrderItem extends BaseModel{
	private static final long serialVersionUID = -1913933419408596487L;
	private Integer id;
    private Integer productionId;
    private Double unitPrice;
    private Integer number;
    private Double total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductionId() {
		return productionId;
	}
	public void setProductionId(Integer productionId) {
		this.productionId = productionId;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

}