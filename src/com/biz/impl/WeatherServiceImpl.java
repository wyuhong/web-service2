package com.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.biz.WeatherService;
import com.entity.TemperatureInfo;

@WebService(serviceName="WeatherService",portName="WeatherServicePort",targetNamespace="http://www.wuxianedu.com/ws/weather")
public class WeatherServiceImpl implements WeatherService{
	
	
	@WebMethod(operationName="getWeathers")
	public List<TemperatureInfo> getWeathers(String city, List<Date> dates) {
		List<TemperatureInfo> list = new  ArrayList<TemperatureInfo>();
		for(Date date : dates){
			list.add(getTemperature(city,date));
		}
		return list;
	}
	
	@WebMethod(exclude = true)
	public TemperatureInfo getTemperature(String city, Date date){
		//模拟根据城市和日期获取天气信息
		return new TemperatureInfo(city, date, 28,33,31,"晴");
	}
}
