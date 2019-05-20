package eu.rjch.myfitnessbuddy.utility;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdsHandler {
	public AdsHandler() {
	}
	
	
	public void getAds(AdView view) {
		AdView adBanner = view;
		AdRequest ar = new AdRequest.Builder().build();
		adBanner.loadAd(ar);
	}
	
}
