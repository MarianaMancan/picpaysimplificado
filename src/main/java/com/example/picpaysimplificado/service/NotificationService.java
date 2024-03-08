package com.example.picpaysimplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.picpaysimplificado.domain.user.User;
import com.example.picpaysimplificado.dtos.NotificationDTO;

@Service
public class NotificationService {

	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User user,String message) throws Exception {
		
		String email = user.getEmail();
		NotificationDTO notificationRequest = new NotificationDTO(email,message);
	
		ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6",notificationRequest,String.class);
		
		if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
			System.out.println("erro ao enviar notificação");
			throw new Exception("Servico de notiificação fora do ar");
		}

	}
}
