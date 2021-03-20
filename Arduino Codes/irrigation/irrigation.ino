int M_Sensor = A6;
int relay=8;

void setup() {
  // put your setup code here, to run once:
  pinMode(8,OUTPUT);
  pinMode(A6,INPUT);
 
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  int Moisture = analogRead(M_Sensor); //Read Moisture Sensor Value 
  Serial.println(Moisture);

  if (Moisture> 600)   // for dry soil
  {
    digitalWrite(relay,LOW);
  }
  else //for Moist Soil
  { 
    digitalWrite(relay,HIGH);
  }
  delay(1000);
}
