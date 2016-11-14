int led_verde = 13;
int lecJava=0;
const int buzzerPin=9;

//   char notes[]={'c', 'd', 'e', 'f', 'g', 'a', 'b', 'C'}; //Intente pasarle las notas desde java, pero no funciono
  int frequencies [] = {262, 294, 330, 349, 392, 440, 494, 523}; //tabla de frecuencias
  



void setup() {
  // put your setup code here, to run once
  pinMode(buzzerPin,OUTPUT); //Lo marcamos como salida
  Serial.begin(9600);


}

void loop() {
      // put 
      
      if  (Serial.available()>0){//validacion dato entrada 
          lecJava = Serial.read();//leer una opcion desde java y asignarla a lecJava
          //Los valores van de 0 a 8. 0 a 7 las notas, 8 el apagado
          // Serial.print(lecJava); //Para ver que dato estas mandado en la consola.

          if(lecJava!=8){ 
            tone(buzzerPin,frequencies[lecJava]);
          }
          if(lecJava==8){ //Apagado
            noTone(buzzerPin);
          }
         
      }
      
}
