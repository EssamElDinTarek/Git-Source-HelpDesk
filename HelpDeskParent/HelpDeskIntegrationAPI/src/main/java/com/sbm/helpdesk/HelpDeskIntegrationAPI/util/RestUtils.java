package com.sbm.helpdesk.HelpDeskIntegrationAPI.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class RestUtils<T>  {

	public ResponseEntity<T> addObj(T t) {
		try {
			if (t != null) {
				return new ResponseEntity<T>(t, HttpStatus.OK);
			} else {
				System.out.println(t.getClass().getName()+" is null");
				return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<T> getObj(T t) {
		try {
			if (t != null) {
				return new ResponseEntity<T>(t, HttpStatus.OK);
			} else {
				System.out.println(t.getClass().getName()+" is null");
				return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<T>> getObjList(List<T> list) {
		try {
			return new ResponseEntity<List<T>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<T>>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> getStringObj(String t) {
		try {
			return new ResponseEntity<String>(t, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
