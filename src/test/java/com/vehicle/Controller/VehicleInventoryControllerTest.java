package com.vehicle.Controller;

import com.vehicle.Entity.VehicleInventory;
import com.vehicle.Service.VehicleInventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value =VehicleInventoryController.class, secure = false)
public class VehicleInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleInventoryService vehicleInventoryService;

    VehicleInventory mockVehicleInventory = new VehicleInventory("AirPlane", 2, 12, 3);

    String exampleVehicleInventoryJson = "{\"type\" : \"AirPlane\", \"available\" : 2, \"inUse\" : 12, \"inMaintainance\" : 3}";

    @Test
    public void testAddInventory() throws Exception{
        Mockito.when(vehicleInventoryService.save(Mockito.any(VehicleInventory.class))).thenReturn(mockVehicleInventory);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/vehicle/addInventory")
                .accept(MediaType.APPLICATION_JSON).content(exampleVehicleInventoryJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
