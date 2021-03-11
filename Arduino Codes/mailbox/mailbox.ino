const int pingPin = 7; // Trigger Pin of Ultrasonic Sensor
const int echoPin = 6; // Echo Pin of Ultrasonic Sensor
int mail = 0;


void setup() {
  Serial.begin(9600);
  mail = 0;
}

void loop() {
  long duration, inches, cm;
  pinMode(pingPin, OUTPUT);
  digitalWrite(pingPin, LOW);
  delayMicroseconds(2);
  digitalWrite(pingPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(pingPin, LOW);
  pinMode(echoPin, INPUT);
  duration = pulseIn(echoPin, HIGH);
  cm = microsecondsToCentimeters(duration);
  if (cm < 10) {
    mail++;
    Serial.println("new mail !");
    Serial.print("NO OF MAILS =");
    Serial.println(mail);
    while (cm < 10) {
      //long duration, inches;
      pinMode(pingPin, OUTPUT);
      digitalWrite(pingPin, LOW);
      delayMicroseconds(2);
      digitalWrite(pingPin, HIGH);
      delayMicroseconds(10);
      digitalWrite(pingPin, LOW);
      pinMode(echoPin, INPUT);
      duration = pulseIn(echoPin, HIGH);
      Serial.println("done");
      cm = microsecondsToCentimeters(duration);
      //Serial.println(cm);
delay(1000);
      }
      Serial.println("done again");
      Serial.println(mail);
  }

}
long microsecondsToCentimeters(long microseconds) {
  return microseconds / 29 / 2;
}
