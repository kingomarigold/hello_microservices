package com.karthiksr.demo.util

class GenUtil {
	static def nullStr = ''
	
	public static def concatNames(firstName,middleName,lastName) {
		"${firstName} ${middleName?middleName:nullStr} ${lastName}".toString()
	}
}
