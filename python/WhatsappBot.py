from selenium import webdriver
from time import sleep
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome(executable_path="./chromedriver")
contacts = ['andrewsVieira', 'Amor']
message = 'Oi!! Eu não to digitando nada! É tudo um programa que fiz'

driver.get('https://web.whatsapp.com/')
sleep(10)

def searchContact(contact):
    searchField = driver.find_element_by_xpath('//div[contains(@class, "copyable-text selectable-text")]')
    searchField.send_keys(contact)
    searchField.send_keys(Keys.ENTER)

def sendMessage(message):
    messageField = driver.find_elements_by_xpath('//div[contains(@class, "copyable-text selectable-text")]')
    messageField[1].send_keys(message)
    messageField[1].send_keys(Keys.ENTER)

for contact in contacts:
    searchContact(contact)
    sleep(3)
    sendMessage(message)
    sleep(3)

driver.close()
print("Mensagens enviadas!")
