from selenium import webdriver

print("Vamos entrar na sua conta do Facebook e ver quantas notificações pendentes você possui.")

# entrada de dados
print("E-mail: ")
login = input()
print("Password: ")
password = input()

# entrando no site, preenchendo login e senha
driver = webdriver.Chrome(executable_path="./chromedriver")
url = "https://www.facebook.com/"
driver.get(url)
driver.find_element_by_id("email").send_keys(login)
driver.find_element_by_id("pass").send_keys(password)
driver.find_element_by_id("u_0_b").click()

# colhendo informação de quantas notificações
myPath = driver.find_element_by_xpath('//*[@id="mount_0_0"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/span/div/div[2]/span/span')
myPathText = myPath.text

# imprimindo quantas notificações
menssage = ""

if myPathText == "1":
    menssage = "Você possui " + myPathText + " notificação não lida."
elif myPathText == "0":
    menssage = "Você não possui notificações pendentes."
else:
    menssage = "Você possui " + myPathText + " notificações não lidas."

print(menssage)

# Fechando browser
driver.close()