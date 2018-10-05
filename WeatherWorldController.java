package WeatherWorld;

import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import javafx.fxml.Initializable;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class WeatherWorldController implements Initializable {
    
    int timeRun = 0;
    
    public Text Condition;
    public Text date;
    public Text time;
    public Text temprature;
    public Text location;
    public Text humidity;
    public Text wind;
    
    @FXML
    private void settingsbutton(ActionEvent event) throws Exception {
         Parent setting_page_parent = FXMLLoader.load(getClass().getResource("SettingsFX.fxml"));
         Scene setting_page_scene = new Scene(setting_page_parent);
         Stage settings_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         settings_stage.setScene(setting_page_scene);
         settings_stage.setResizable(false);
         settings_stage.show();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("right click!");
    }
    
    public class JavaApplication{
    public void calljavascript( int lengthInMeters){

        System.out.println(lengthInMeters);
    }
}   
    @FXML
    private WebView TFLTrain;
    @FXML
    private WebView TFLCar;
    @FXML
    private WebView TFLBus;
    @FXML
    private VBox Center;
    
    String id ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    
    String curTime = new SimpleDateFormat("HH").format(new Date());
    int currentTime = Integer.parseInt(curTime);
    
   
        if(currentTime > 6 && currentTime < 19)  {
            id = "londonsunny";
        }
        else{  
        id = "londoncloudynight";
    }
        
        Center.setId(id);
                
        WebEngine webEngine = TFLTrain.getEngine();
        webEngine.load("https://tfl.gov.uk/tfl/syndication/feeds/serviceboard-fullscreen.htm");
        
        WebEngine webEngine2 = TFLCar.getEngine();
        webEngine2.load("https://tfl.gov.uk/Widgets/RoadStatus");
        
        WebEngine webEngine3 = TFLBus.getEngine();
        webEngine3.load("http://m.countdown.tfl.gov.uk/");
        
        WeatherDoc doc = new WeatherDoc("44418","c");
        WeatherDisplay disp = new WeatherDisplay();
        
        String Country;
        
        if(disp.getCountry().equals("United Kingdom")){
         Country="UK";
        }
        else if (disp.getCountry().equals("France")){
         Country="France";
        }
        else{
         Country="US";
        }
        Condition.setText(disp.getCondition());
        temprature.setText(disp.getTemperature() + "°" + disp.getTemperatureUnit());
        location.setText(disp.getCity() + "," + Country);
        humidity.setText("Humidity: " + disp.getHumidity() + "%");
        wind.setText("Wind: " + disp.getWindSpeed()+ "mph");
    
        new Thread()
       {
         @Override
         public void run()
          {
             while(timeRun == 0)
               {
                   Calendar cal = new GregorianCalendar();
                   
                   int hour = cal.get(Calendar.HOUR);
                   int min = cal.get(Calendar.MINUTE);
                   int AM_PM = cal.get(Calendar.AM_PM);
                   
                   
                   String day_night = "";
                   String timee = "";
                   
                   if(AM_PM == 1)
                   {
                       day_night = "PM";
                   }
                   else
                   {
                       day_night = "AM";
                   }
                   
                   int test = 0;
                   
                   if(min < 10)
                   {
                       timee = hour + ":" + test + min + day_night;
                   }
                   
                   else
                   {
                      timee = hour + ":" + min + day_night;
                   }
                   
                     Calendar cal1 = Calendar.getInstance();
                      SimpleDateFormat sdf = new SimpleDateFormat("EEE");
                      String strDate = sdf.format(cal1.getTime());
                                        
                   time.setText(" " + strDate + " " + timee);
               }
          }
            
       }.start();
        
       
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date today = Calendar.getInstance().getTime(); 
        String reportDate = df.format(today);
        date.setText("    " + reportDate);
    }    
    

}