package common.DTOs;

import java.io.Serializable;

public class ClaseGeneralDTO implements Serializable {

	protected static final long serialVersionUID = 1L;
	protected Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
