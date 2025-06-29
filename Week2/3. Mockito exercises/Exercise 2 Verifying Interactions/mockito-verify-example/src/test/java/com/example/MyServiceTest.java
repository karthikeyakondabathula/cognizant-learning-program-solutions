package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyServiceTest {

@Test
public void testVerifyInteraction(){

ExternalApi mockApi = Mockito.mock(ExternalApi.class);

when(mockApi.getData()).thenReturn("Checking Call");

MyService service = new MyService(mockApi);

String result = service.fetchData();

System.out.println("Result fetched: "+result);

verify(mockApi).getData();

System.out.println("Verified that getData() was called");
}
}
