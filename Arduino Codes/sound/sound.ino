void setup() {
  pinMode(A0,INPUT);
  
  Serial.begin(9600);
  // put your setup code here, to run once:

}

void loop() {int val;
      val=analogRead(A0);   //connect mic sensor to Analog 0
      Serial.print("Sound=");
      Serial.println(val);//print the sound value to serial
delay(100);
  // put your main code here, to run repeatedly:

}
