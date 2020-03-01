package ithuba.skilrock.common;

import java.util.Objects;

public class Locators {

	public static Locators locators = null;
	public static Locators.Login locatorsLogin = null;
	public static Locators.LottoPlay LocatorsLottoPlay = null;

	private Locators() {
	}

	public static Locators getInstance() {
		return Objects.isNull(locators) ? locators = new Locators() : locators;
	}

	public static Locators.Login getLoginInstance() {
		return Objects.isNull(locatorsLogin) ? locatorsLogin = new Locators().new Login() : locatorsLogin;
	}

	public static Locators.LottoPlay getLottoPlayInstance() {
		return Objects.isNull(LocatorsLottoPlay) ? LocatorsLottoPlay = new Locators().new LottoPlay()
				: LocatorsLottoPlay;
	}

	public class Login {
		private Login() {
		}

		public String welcomePopup = "//*[@id=\"home_welcome\"]/div/div/div/div[1]/a/span";
		public String userName = "//*[@id=\"userName_email\"]";
		public String passWord = "//*[@id=\"password\"]";
		public String loggging = "//*[@id=\"login-form-1\"]/div/div/fieldset/div[4]/button";
	}

	public class LottoPlay {
		private LottoPlay() {
		}

	}
}
