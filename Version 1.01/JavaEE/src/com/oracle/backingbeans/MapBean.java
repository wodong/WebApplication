package com.oracle.backingbeans;

import java.io.Serializable;  

import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.map.OverlaySelectEvent;  
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  
  
public class MapBean implements Serializable {  
  
    private MapModel simpleModel;  
  
    private Marker marker;  
  
    public MapBean() {  
        simpleModel = new DefaultMapModel(); 
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(53.3574521, 6.2217928);  
        LatLng coord2 = new LatLng(53.3578684, 6.2264598);  
        LatLng coord3 = new LatLng( 53.3583358, 6.2279726);  
        LatLng coord4 = new LatLng(53.3580476, 6.228391);  
          
        //Basic marker  
        simpleModel.addOverlay(new Marker(coord1, "Oracle Block P5"));  
        simpleModel.addOverlay(new Marker(coord2, "Oracle Block C"));  
        simpleModel.addOverlay(new Marker(coord3, "Oracle Block I"));  
        simpleModel.addOverlay(new Marker(coord4, "Oracle Block H"));  
    }  
  
    public MapModel getSimpleModel() {  
        return simpleModel;  
    }  
      
    public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));  
    }  
      
    public Marker getMarker() {  
        return marker;  
    }  
      
    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  

