package com.amitverma.spring.rest.client;

import java.util.List;
import com.amitverma.spring.rest.to.StudentTO;
import com.amitverma.spring.rest.to.Students;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class StudentXMLClient {

	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// 1.Add the Student
		String url1 = "http://localhost:5555/Lab20/services/student/add/";
		url1 = url1 + "bbbb" + "/" + "bbb@gmail.com" + "/" + "33333";
		WebResource weres1 = client.resource(url1);
		weres1.post();

		// 2.Get All the Students
		String url2 = "http://localhost:5555/Lab20/services/student/getall.xml";
		WebResource webres2 = client.resource(url2);
		ClientResponse cresp1 = webres2.accept("text/xml").get(
				ClientResponse.class);
		Students sts = cresp1.getEntity(Students.class);
		List<StudentTO> list = sts.getStudList();
		System.out.println("No of Records: " + list.size());
		for (StudentTO sto : list)
			System.out.println(sto);

		// 3.Get Student By SID
		String url3 = "http://localhost:5555/Lab20/services/student/getbyid/";
		url3 = url3 + "1.xml";
		WebResource weres3 = client.resource(url3);
		ClientResponse cresp2 = weres3.accept("text/xml").get(
				ClientResponse.class);
		StudentTO sto = cresp2.getEntity(StudentTO.class);
		System.out.println(sto);

	}

}