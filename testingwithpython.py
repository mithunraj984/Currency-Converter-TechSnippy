
#Keep in mind that testing a Java application with Python Selenium might not be the best approach in the long run





from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the WebDriver
driver = webdriver.Chrome()
driver.get("http://your-java-app-url.com")

# Define the locators for the elements you want to interact with
input_amount_field_locator = (By.ID, "input_amount")
input_from_currency_locator = (By.ID, "input_from")
input_to_currency_locator = (By.ID, "input_to")
convert_button_locator = (By.ID, "convert_button")
output_result_locator = (By.ID, "output_result")

# Interact with the elements
amount_input = driver.find_element(*input_amount_field_locator)
amount_input.send_keys("100")

from_currency_input = driver.find_element(*input_from_currency_locator)
from_currency_input.send_keys("USD")

to_currency_input = driver.find_element(*input_to_currency_locator)
to_currency_input.send_keys("EUR")

convert_button = driver.find_element(*convert_button_locator)
convert_button.click()

# Wait for the result to be displayed
output_result = WebDriverWait(driver, 10).until(
    EC.visibility_of_element_located(output_result_locator)
)

# Check if the conversion is accurate
expected_result = 88.74  # Expected EUR value for 100 USD
assert float(output_result.text) == expected_result

# Close the browser
driver.quit()