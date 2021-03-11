#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <ArduinoJson.h>

// WiFi Parameters
const char* ssid = "aks";
const char* password = "12345678";

void setup() {
  Serial.begin(9600);
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting...");
  }
  Serial.println("connected");
  pinMode(D7, OUTPUT);
  pinMode(2, OUTPUT);
  digitalWrite(D7, 0);
 
 
}

void loop() {
  // Check WiFi Status
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;  //Object of class HTTPClient
    http.begin("http://unpunishable-accrue.000webhostapp.com/authentication/status.php?id=1");
    //Serial.println("done");
    int httpCode = http.GET();
    //Check the returning code                                                                  
    if (httpCode > 0) {
      //Serial.println("done again");
      // Parsing
      const size_t bufferSize = JSON_OBJECT_SIZE(2) + JSON_OBJECT_SIZE(3) + JSON_OBJECT_SIZE(5) + JSON_OBJECT_SIZE(8) + 370;
      DynamicJsonBuffer jsonBuffer(bufferSize);
      JsonObject& root = jsonBuffer.parseObject(http.getString());
      int id = root["id"]; // 1
      const char* state = root["status"]; 
      Serial.print("ID:");
      Serial.println(id);
      Serial.print("Status:");
      Serial.println(state);
      String led = root["status"];
      digitalWrite(2, LOW); 
      delay(200);   
      digitalWrite(2, HIGH);  
      delay(200);                         
      if (led=="ON" ){ 
        digitalWrite(D7, 1);  
            Serial.print("ON");       
          }
  else {
      digitalWrite(D7, 0); 
      Serial.print("OFF");
    }     
    }
    http.end(); 
  }
  delay(200);
}
