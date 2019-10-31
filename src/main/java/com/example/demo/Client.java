package com.example.demo;

import localhost.universities.GetUniversityRequest;
import localhost.universities.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {

    public GetUniversityResponse getUniversityResponse(String universityName){
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(universityName);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                        request,
                        new SoapActionCallback("http://localhost/universities"));

        return response;

    }

}
