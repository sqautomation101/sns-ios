package base;

import io.appium.java_client.AppiumDriver;
import pages.*;

public class PageManager {


    private final AppiumDriver driver;

    private LoginPage loginPage;
    private SSOMenuPage ssoMenuPage;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private GuestUserPage guestUserPage;
    private ShopPage shopPage;
    private VouchersPage vouchersPage;
    private QRandScanPage qrAndscanPage;
    private AccountPage accountPage;
    private ManageCardsPage manageCardsPage;
    private PointsHistoryPage pointsHistoryPage;
    private InboxPage inboxPage;
    private RoadToPrestigePage roadToPrestige;
    private OfflineVirtualCardPage offlineVirtualCard;
    private CardComponent cardComponent;
    private CardLinkingPage cardLinkingPage;
    private CardBlockingPage cardBlockingPage;


    public PageManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppiumDriver getDriver() {
        return driver;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) loginPage = new LoginPage(driver);
        return loginPage;
    }

    public SSOMenuPage getSSOMenuPage() {
        if (ssoMenuPage == null) ssoMenuPage = new SSOMenuPage(driver);
        return ssoMenuPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) homePage = new HomePage(driver);
        return homePage;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) registrationPage = new RegistrationPage(driver);
        return registrationPage;
    }

    public GuestUserPage getGuestUserPage() {
        if (guestUserPage == null) guestUserPage = new GuestUserPage(driver);
        return guestUserPage;
    }

    public ShopPage getShopPage() {
        if (shopPage == null) shopPage = new ShopPage(driver);
        return shopPage;
    }

    public VouchersPage getVouchersPage() {
        if (vouchersPage == null) vouchersPage = new VouchersPage(driver);
        return vouchersPage;
    }

    public QRandScanPage getQrAndscanPage() {
        if (qrAndscanPage == null) qrAndscanPage = new QRandScanPage(driver);
        return qrAndscanPage;
    }


    public AccountPage getAccountPage() {
        if (accountPage == null) accountPage = new AccountPage(driver);
        return accountPage;
    }

    public ManageCardsPage getManageCardsPage() {
        if (manageCardsPage == null) manageCardsPage = new ManageCardsPage(driver);
        return manageCardsPage;
    }

    public PointsHistoryPage getPointsHistoryPage() {
        if (pointsHistoryPage == null) pointsHistoryPage = new PointsHistoryPage(driver);
        return pointsHistoryPage;
    }

    public InboxPage getInboxPage() {
        if (inboxPage == null) inboxPage = new InboxPage(driver);
        return inboxPage;
    }

    public RoadToPrestigePage getRoadToPrestigePage() {
        if (roadToPrestige == null) roadToPrestige = new RoadToPrestigePage(driver);
        return roadToPrestige;
    }

    public OfflineVirtualCardPage getOfflineVirtualCard() {
        if (offlineVirtualCard == null) offlineVirtualCard = new OfflineVirtualCardPage(driver);
        return offlineVirtualCard;
    }

    public CardComponent getCardComponent() {
        if (cardComponent == null) cardComponent = new CardComponent(driver);
        return cardComponent;
    }

    public CardLinkingPage getCardLinkingPage() {
        if (cardLinkingPage == null) cardLinkingPage = new CardLinkingPage(driver);
        return cardLinkingPage;
    }

    public CardBlockingPage getCardBlockingPage() {
        if (cardBlockingPage == null) cardBlockingPage = new CardBlockingPage(driver);
        return cardBlockingPage;
    }
}
