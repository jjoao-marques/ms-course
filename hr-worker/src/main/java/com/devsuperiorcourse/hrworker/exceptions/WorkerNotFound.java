package com.devsuperiorcourse.hrworker.exceptions;

public class WorkerNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public WorkerNotFound(String msg ) {
		super(msg);
	}

}
