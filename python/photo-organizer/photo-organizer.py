# Código que é cópia (para aprendizado) do vídeo https://youtu.be/L8KFB0VyEwo (vídeo 1) e https://youtu.be/wuRJDHs-x94 (vídeo 2)

import os
import shutil
from datetime import datetime
from PIL import Image

class PhotoOrganizer:
    extensions = ['jpg', 'jpeg', 'JPG', 'JPEG', 'png', 'PNG']

    def folder_path_from_photo_date(self, file):
        date = self.photo_shooting_date(file)
        return date.strftime('%Y') + '/' + date.strftime('%Y-%m-%d')

    def photo_shooting_date(self, file):
        photo = Image.open(file)
        info = photo._getexif()
        if 36867 in info:
            date = info[36867]
            date = datetime.strptime(date, '%Y:%m:%d %H:%M:%S')
        else:
            date = datetime.fromtimestamp(os.path.getmtime(file))
        return date

    def move_photo(self, file):
        new_folder = self.folder_path_from_photo_date(file)
        if not os.path.exists(new_folder):
            os.makedirs(new_folder)
        shutil.move(file, new_folder + '/' + file)


    def organize(self):
        photos = [
            filename for filename in os.listdir('.')
                if os.path.isfile(filename) and any(filename.endswith(ext) for ext in self.extensions)
        ]
        for filename in photos:
            self.move_photo(filename)

PO = PhotoOrganizer()
PO.organize()

