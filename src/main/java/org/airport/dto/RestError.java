/*
 *
 */
package org.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Api Error holder.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestError {

	private String messageTitle;
	private String messageDescription;
	private int subcode;

	private List<RestErrorSubError> errors;

	public void addError(RestErrorSubError error) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}

		this.errors.add(error);
	}

	public RestError(String messageTitle, String messageDescription, List<RestErrorSubError> errors) {
		this.messageDescription = messageDescription;
		this.messageTitle = messageTitle;
		this.errors = errors;
		this.subcode = 1;
	}

	public RestError(String messageTitle, String messageDescription) {
		this(messageTitle, messageDescription, 1);
	}

	public RestError(String messageTitle, String messageDescription, int subcode) {
		this.messageDescription = messageDescription;
		this.messageTitle = messageTitle;
		this.subcode = subcode;
	}


	@Override
	public String toString() {
		return "RestError{" +
				"messageTitle='" + messageTitle + '\'' +
				", messageDescription='" + messageDescription + '\'' +
				", subcode=" + subcode +
				", errors=" + errors +
				'}';
	}
}
