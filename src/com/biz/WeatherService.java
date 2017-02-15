package com.biz;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entity.TemperatureInfo;

@WebService(serviceName="WeatherService",portName="WeatherServicePort",targetNamespace="http://www.wuxianedu.com/ws/weather")
public interface WeatherService {
	@WebMethod
	List<TemperatureInfo> getWeathers(String city,List<Date> dates);
}
