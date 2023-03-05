import os
import cv2
import numpy as np
from PIL import Image
import pickle
from sklearn.model_selection import train_test_split

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
image_dir = os.path.join(BASE_DIR, "images")

face_cascade = cv2.CascadeClassifier('cascades/data/haarcascade_frontalface_alt2.xml')
recognizer = cv2.face.LBPHFaceRecognizer_create()

current_id = 0
label_ids = {}
y_labels = []
x_train = []
x_test = []
y_train = []
y_test = []
i = 0

for root, dirs, files in os.walk(image_dir):
    for file in files:
        if file.endswith("png") or file.endswith("jpg") or file.endswith("JPG"):
            path = os.path.join(root, file)
            label = os.path.basename(root).replace(" ", "-").lower()
            i = i + 1

            if not label in label_ids:
                label_ids[label] = current_id
                current_id += 1
            id_ = label_ids[label]
            pil_image = Image.open(path).convert("L")
            image_array = np.array(pil_image, "uint8")
            faces = face_cascade.detectMultiScale(image_array, scaleFactor=1.5, minNeighbors=10)

            for (x, y, w, h) in faces:
                roi = image_array[y:y + h, x:x + w]
                if i % 5 == 0:  # use every 5th image for testing
                    x_test.append(roi)
                    y_test.append(id_)
                else:
                    x_train.append(roi)
                    y_train.append(id_)

with open("labelsLBPH.pickle", 'wb') as f:
    pickle.dump(label_ids, f)

recognizer.train(x_train, np.array(y_train))

# predict labels for test set
correct = 0
total = 0
for i in range(len(x_test)):
    id_, confidence = recognizer.predict(x_test[i])
    if id_ == y_test[i]:
        correct += 1
    total += 1

# calculate accuracy
accuracy = correct / total
print("Accuracy: {:.2f}%".format(accuracy * 100))

recognizer.save("trainner2.yml")
