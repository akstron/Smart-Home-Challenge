#!/usr/bin/env python3

import face_recognition
import cv2
import numpy as np
from selenium import webdriver
import speech_recognition as sr
import pyaudio

from selenium.webdriver.chrome.options import Options

CHROME_PATH = '/usr/bin/google-chrome'
CHROMEDRIVER_PATH = '/usr/bin/chromedriver'
WINDOW_SIZE = "1920,1080"

chrome_options = Options()  
chrome_options.add_argument("--headless")  
chrome_options.add_argument("--window-size=%s" % WINDOW_SIZE)
chrome_options.binary_location = CHROME_PATH

driver = webdriver.Chrome(executable_path=CHROMEDRIVER_PATH,chrome_options=chrome_options)  

C=0
verified=0

video_capture = cv2.VideoCapture(0)

master1_image = face_recognition.load_image_file("/home/aayush/Desktop/HOME_CAM/ayush.jpg")
master1_face_encoding = face_recognition.face_encodings(master1_image)[0]

master2_image = face_recognition.load_image_file("/home/aayush/Desktop/HOME_CAM/SHUARABH.jpg")
master2_face_encoding = face_recognition.face_encodings(master2_image)[0]

known_face_encodings = [
    master1_face_encoding,
    master2_face_encoding]

known_face_names = [
    "AAYUSH",
    "SHUARABH"
]


while True:
    face_locations = []
    face_encodings = []
    face_names = []

    ret, frame = video_capture.read()    
    small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)
    rgb_small_frame = small_frame[:, :, ::-1]

    face_locations = face_recognition.face_locations(rgb_small_frame)
    face_encodings = face_recognition.face_encodings(rgb_small_frame, face_locations)

    for face_encoding in face_encodings:
        
            known_matches = face_recognition.compare_faces(known_face_encodings, face_encoding,tolerance=0.4)
            
            if True in known_matches:
                first_known_match_index = known_matches.index(True)
                name = known_face_names[first_known_match_index]
                if (name=="AAYUSH"):
                    C=C+1
                    
                if C==7:
                    
                    r1= sr.Recognizer()
                    r2= sr.Recognizer()
                    
                    with sr.Microphone() as source:
                        
                        while True:
                            try:
                                print("speak now")
                                audio=r1.listen(source)
                                if (len(r2.recognize_google(audio))!=0):
                                    print(r2.recognize_google(audio))
                                    if (r2.recognize_google(audio)=="password 123"):
                                        driver.get("http://192.168.43.224/on")
                                        driver.get_screenshot_as_file("capture.png")
                                        driver.close()
                                        print("Access Granted !!")
                                        verified=1
                                break
                            except:
                                print("sry speak again")
                            else:
                                print(C)
                    
                
            else:
                name="UNKNOWN"
            
            face_names.append(name)

    ret, feed = video_capture.read()

    

    for (top, right, bottom, left), name in zip(face_locations, face_names):

        top *= 4
        right *= 4
        bottom *= 4
        left *= 4
      
        
        if (verified==1 and name=="AAYUSH"):
            feed=cv2.rectangle(frame, (left, top), (right, bottom), (0, 100, 0), 2)
            feed=cv2.rectangle(feed, (left, bottom - 35), (right, bottom), (0, 100, 0), cv2.FILLED)
            font = cv2.FONT_HERSHEY_DUPLEX
            eed=cv2.putText(feed, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
            feed=cv2.rectangle(feed, (0,0), (350,50), (255, 0, 0), cv2.FILLED)
            feed=cv2.putText(feed,"ACCESS GRANTED !", (30,30), font, 1.0, (0, 255,0), 1)
        elif C==6:
            ret, feed= video_capture.read()
            feed=cv2.rectangle(feed, (20, 20), (610,460), (0, 100, 0), 2)
            feed=cv2.rectangle(feed, (200,200), (480,280), (0, 0, 255), cv2.FILLED)
            font = cv2.FONT_HERSHEY_DUPLEX
            feed=cv2.putText(feed," SPEAK UR PWS", (200,240), font, 1.0, (0, 255,0), 1)          
        else:
            feed=cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
            feed=cv2.rectangle(feed, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
            font = cv2.FONT_HERSHEY_DUPLEX
            feed=cv2.putText(feed, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
        
    cv2.imshow('Video', feed)
            

    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break


video_capture.release()
cv2.destroyAllWindows()
quit()
