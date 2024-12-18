REM Задаем переменные
set SELENIUM_SERVER_JAR=selenium-server-4.27.0.jar
set GRID_HUB_PORT=4444
set NODE_PORT=5555

REM Запуск Selenium Hub
echo Запуск Selenium Hub на порту %GRID_HUB_PORT%...
start java -jar %SELENIUM_SERVER_JAR% hub

REM Задержка, чтобы хаб успел запуститься
timeout 5

REM Запуск Selenium Node
echo Запуск Selenium Node на порту %NODE_PORT%...
start java -Dwebdriver.chrome.driver=selenium-chrome-driver-4.27.0.jar -jar %SELENIUM_SERVER_JAR% node --hub http://localhost:%GRID_HUB_PORT%/grid/register
