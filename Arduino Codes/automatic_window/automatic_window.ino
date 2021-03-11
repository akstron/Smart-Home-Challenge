#include <Servo.h>

Servo servo;

void setup() {
  pinMode(A0,INPUT);
  servo.attach(2);  //D4
  servo.write(5);
  Serial.begin(9600);
  delay(5000);

}

void loop() {
 /* int val,flag=0;
      val=analogRead(A0);
      Serial.print("Sound=");
      Serial.println(val);//print the sound value to serial*/
/*if(val>170)
{
  servo.write(120);
  delay(3000);
  flag=1;
  }
  if(val<160)
  {
    servo.write(0);
    }
  */

  
  servo.write(90);
  delay(1000);
  servo.write(5);
 delay(1000);
}
