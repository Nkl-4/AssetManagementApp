package com.cg.ama.exception;

public class AssetNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public AssetNotFoundException(String message) {
		super(message);
	}
}
