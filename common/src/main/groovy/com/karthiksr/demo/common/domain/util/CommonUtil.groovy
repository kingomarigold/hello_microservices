package com.karthiksr.demo.common.domain.util

import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class CommonUtil {

	static def getStartOfDay(DateTime date) {
		date.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0).withZone(DateTimeZone.UTC)
	}
	
	static def getEndOfDay(DateTime date) {
		date.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999).withZone(DateTimeZone.UTC)
	}
}
