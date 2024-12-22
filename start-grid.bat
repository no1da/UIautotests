start java -jar selenium-server-4.27.0.jar hub

timeout 5

start java -Dwebdriver.chrome.driver=selenium-chrome-driver-4.27.0.jar -jar selenium-server-4.27.0.jar node --hub http://localhost:4444/grid/register
