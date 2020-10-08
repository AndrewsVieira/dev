from selenium import webdriver

url = "https://www.facebook.com"

driver = webdriver.Chrome()
driver.get(url)

print("entrou no facebook!!")