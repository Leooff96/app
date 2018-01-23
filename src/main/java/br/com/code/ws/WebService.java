package br.com.code.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebService {

	
	public <T> T consume(String uri, Class<T> clazz, T request) {
		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> converters = 
			      new ArrayList<HttpMessageConverter<?>>();
			    converters.add(new MappingJackson2HttpMessageConverter());
			    
		restTemplate.setMessageConverters(converters);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<T> entity = new HttpEntity<T>(request, headers);
		ResponseEntity<T> result = restTemplate.exchange(uri, HttpMethod.GET, entity, clazz);
	//	restTemplate.postForEntity(uri, request, responseType)
		return result.getBody();
	}
}
