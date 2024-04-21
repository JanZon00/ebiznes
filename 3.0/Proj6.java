import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Proj6 {

	public static WebDriver driver = null;
	
    public static void main(String[] args) {
      
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
        String baseUrl = "https://mnemonicacademy.pl/app/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try {
        	Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#1 WPROWADZ DANE DO LOGOWANIA
        System.out.println("LOGOWANIE...");
        WebElement loginField = driver.findElement(By.cssSelector("#login"));
        loginField.sendKeys("025");

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("testowehaslo");
        
        try {
        	Thread.sleep(1000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#2 ZALOGUJ DO PORTALU
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button > span"));
        loginButton.click();
        System.out.println("ZALOGOWANO");
        
        try {
        	Thread.sleep(1000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#3 PRZEJDZ DO USTAWIEN
        WebElement desiredMenuItem = driver.findElement(By.cssSelector("#main > div > nav > div.v-navigation-drawer__content > div.v-list.overflow-y-auto.v-sheet.theme--light > div:nth-child(5) > div.v-list-item__title.nav-list-item-title"));
        desiredMenuItem.click();
        System.out.println("USTAWIENIA");
        try {
        	Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }

        //#4 WPROWADZ STARE I NOWE HASLO
        WebElement firstPasswordField = driver.findElement(By.cssSelector("#input-88"));
        firstPasswordField.sendKeys("testowehaslo");

        WebElement secondPasswordField = driver.findElement(By.cssSelector("#input-92"));
        secondPasswordField.sendKeys("testowehaslo2");
        System.out.println("WPROWADZONO STARE I NOWE HASLO");
        
        try {
        	Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#5 ZATWIERDZ ZMIANE
        WebElement submitButton = driver.findElement(By.cssSelector("#main > div > div > div:nth-child(10) > div:nth-child(2) > button > span"));
        submitButton.click();
        System.out.println("ZMIANY ZATWIERDZONE");
        
        try {
        	Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#6 WYLOGUJ SIE
        WebElement logoutButton = driver.findElement(By.cssSelector("#main > div > nav > div.v-navigation-drawer__content > div.v-list.overflow-y-auto.v-sheet.theme--light > div:nth-child(9) > div.v-list-item__title.nav-list-item-title"));
        logoutButton.click();
        System.out.println("WYLOGOWANO");
        
        try {
        	Thread.sleep(1000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#7 WPROWADZ NOWE DANE DO LOGOWANIA
        WebElement loginField2 = driver.findElement(By.cssSelector("#login"));
        loginField2.sendKeys("025");

        WebElement passwordField2 = driver.findElement(By.cssSelector("#password"));
        passwordField2.sendKeys("testowehaslo2");
        System.out.println("WPROWADZONO DANE DO LOGOWANIA");
        
        try {
        	Thread.sleep(1000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#8 ZALOGUJ SIE
        WebElement loginButton2 = driver.findElement(By.cssSelector("#login-button > span"));
        loginButton2.click();
        System.out.println("ZALOGOWANO");
        
        try {
        	Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //#9 PRZEJDZ DO ZAKLADKI Z GRAMI
        String trainingGamesUrl = "https://mnemonicacademy.pl/app/training/numbers";
        driver.get(trainingGamesUrl);
        
        System.out.println("PRZESZEDLEM DO GRY W LICZBY");
	    try {
	    	Thread.sleep(3000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
        
        //#10 ROZPOCZNIJ GRE I CZEKAJ NA WYSWIETLENIE CYFR
        WebElement startNumbersGame = driver.findElement(By.cssSelector("#main > div > div > button > span"));
        startNumbersGame.click();
        
        System.out.println("ROZPOCZOLEM GRE I CZEKAM NA POJAWIENIE SIE CYFR");
	    try {
	    	Thread.sleep(10000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
        
        
        //#11 ZAPAMIETAJ CYFRY Z PIERWSZEGO RZEDU
        List<String> valuesList = new ArrayList<>();
        
        for (int i = 2; i <= 13; i++) {
            String cssSelector = "#memo > div:nth-child(1) > div:nth-child(" + i + ")";
            WebElement element = driver.findElement(By.cssSelector(cssSelector));
            String text = element.getText();
            valuesList.add(text);
        }
        
        System.out.println("ZAPAMIETALEM CYFRY");
	    try {
	    	Thread.sleep(1000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
        
	    WebElement finishGame1 = driver.findElement(By.cssSelector("#header-training-button > span"));
	    finishGame1.click();
	    
	    try {
	    	Thread.sleep(11000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
        //#12 WPISZ W POLA ZAPAMIETANE CYFRY
        for (int i = 0; i <= 11; i++) {
            String cssSelector = "#recall-input-" + i;
            WebElement recallField = driver.findElement(By.cssSelector(cssSelector));
            recallField.sendKeys(valuesList.get(i));
        }
        
        System.out.println("WPISALEM CYFRY");
	    try {
	    	Thread.sleep(2000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
        //#13 ZAKONCZ GRE
        WebElement finishGame2 = driver.findElement(By.cssSelector("#header-training-button > span"));
        finishGame2.click();
        
        System.out.println("OTRZYMALEM WYNIK GRY");
	    try {
	    	Thread.sleep(4000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    //#14 PRZEJDZ DO GLOWNEGO MENU
        String mainPageUrl = "https://mnemonicacademy.pl/app/";
        driver.get(mainPageUrl);
        
        System.out.println("JESTEM NA STRONIE GLOWNEJ");
	    try {
	    	Thread.sleep(2000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
        //#15 SPRAWDZ WYNIKI UCZNIOW
        WebElement studentResults = driver.findElement(By.cssSelector("#main > div > nav > div.v-navigation-drawer__content > div.v-list.overflow-y-auto.v-sheet.theme--light > div:nth-child(4) > div.v-list-item__title.nav-list-item-title"));
        studentResults.click();
        System.out.println("SPRAWDZAM WYNIKI");
	    try {
	    	Thread.sleep(3000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
  
	    //#16 SPRAWDZ PUNKTY
	    WebElement gameScores = driver.findElement(By.cssSelector("#main > div > nav > div.v-navigation-drawer__content > div.v-list.overflow-y-auto.v-sheet.theme--light > div:nth-child(3) > div.v-list-item__title.nav-list-item-title"));
        gameScores.click();
        System.out.println("SPRAWDZAM PUNKTY");
	    try {
	    	Thread.sleep(3000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    //#17 SPRAWDZ UZYTKOWNIKOW
	    WebElement Users = driver.findElement(By.cssSelector("#main > div > nav > div.v-navigation-drawer__content > div.v-list.overflow-y-auto.v-sheet.theme--light > div:nth-child(8) > div.v-list-item__title.nav-list-item-title"));
	    Users.click();
	    
	    try {
	    	Thread.sleep(1000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    //#18 STWORZ UZYTKOWNIKA
	    WebElement createUser = driver.findElement(By.cssSelector("#main > div > div > div.ma-2.v-card.v-card--flat.v-sheet.theme--light > div.v-card__title > button > span"));
	    createUser.click();
	    
	    try {
	    	Thread.sleep(1000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    //#19 WPROWADZ DANE NOWEGO UZYTKOWNIKA
	    WebElement userId = driver.findElement(By.cssSelector("#input-231"));
	    userId.sendKeys("027");
	    
	    WebElement userName = driver.findElement(By.cssSelector("#input-234"));
	    userName.sendKeys("test_user");
	    
	    WebElement userEmail = driver.findElement(By.cssSelector("#input-237"));
	    userEmail.sendKeys("test_user@gmail.com");
	    
	    try {
	    	Thread.sleep(1000);
	    	} catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    //#20 POTWIERDZ STWORZENIE UZYTKOWNIKA
	    WebElement confirmUserCreation = driver.findElement(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button:nth-child(3) > span"));
	    confirmUserCreation.click();
    }
}