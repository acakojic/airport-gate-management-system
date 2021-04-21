package org.airport.dto;

/**
 * For some specific messages where we need more info about error.
 * Sub error in General API error.
 *
 */
public class RestErrorSubError {
	
	private Object object;
	private String developerMessage;
    private String userMessage;
    
	/**
	 * Instantiates a new rest error sub error.
	 *
	 * @param object 			the object
	 * @param developerMessage 	the developer message
	 * @param userMessage 		the user message
	 */
	public RestErrorSubError(final Object object, final String developerMessage, final String userMessage) {
		this.object = object;
		this.developerMessage = developerMessage;
		this.userMessage = userMessage;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public Object getObject() {
		return this.object;
	}

	/**
	 * Sets the object.
	 *
	 * @param object the new object
	 */
	public void setObject(final Object object) {
		this.object = object;
	}

	/**
	 * Gets the developer message.
	 *
	 * @return the developer message
	 */
	public String getDeveloperMessage() {
		return this.developerMessage;
	}

	/**
	 * Sets the developer message.
	 *
	 * @param developerMessage the new developer message
	 */
	public void setDeveloperMessage(final String developerMessage) {
		this.developerMessage = developerMessage;
	}

	/**
	 * Gets the user message.
	 *
	 * @return the user message
	 */
	public String getUserMessage() {
		return this.userMessage;
	}

	/**
	 * Sets the user message.
	 *
	 * @param userMessage the new user message
	 */
	public void setUserMessage(final String userMessage) {
		this.userMessage = userMessage;
	}

	@Override
	public String toString() {
		return "RestErrorSubError{" +
				"object=" + object +
				", developerMessage='" + developerMessage + '\'' +
				", userMessage='" + userMessage + '\'' +
				'}';
	}
}
