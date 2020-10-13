from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep

url = 'https://www.gmail.com'
driver = webdriver.Chrome(executable_path='./chromedriver')
driver.get(url)


email = ""
password = ""
toEmail = ""
message = ""

sendEmail = driver.find_element_by_id('identifierId')
sendEmail.send_keys(email)
sendEmail.send_keys(Keys.ENTER)
sleep(2)

sendPass = driver.find_element_by_css_selector('input.whsOnd.zHQkBf')
sendPass.send_keys(password)
sendPass.send_keys(Keys.ENTER)
sleep(5)

btnWrite = driver.find_element_by_css_selector('div.T-I.T-I-KE.L3')
btnWrite.click()
sleep(2)

driver.send_keys(Keys.F12)

to = driver.find_element_by_id(':9h')
to.send_keys(toEmail)
sleep(2)
