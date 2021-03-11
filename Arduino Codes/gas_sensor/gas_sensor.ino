int a,b;
void setup() {
  // put your setup code here, to run once:
  pinMode(A0,INPUT);
  pinMode(10,INPUT);
  Serial.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  a=digitalRead(10);
  b=analogRead(A0);
 Serial.println(b);
 if(b>=750)
 digitalWrite(9,HIGH);
 else
 digitalWrite(9,LOW);


}
