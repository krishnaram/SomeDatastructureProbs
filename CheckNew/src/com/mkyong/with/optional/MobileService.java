package com.mkyong.with.optional;

import java.util.Optional;

public class MobileService {

	public Integer getMobileScreenWidth(Optional<Mobile> mobile){
		return mobile.flatMap(Mobile::getDisplayFeatures)
				 .flatMap(DisplayFeatures::getResolution)
				 .map(ScreenResolution::getWidth)
				 .orElse(0);
	}
	
	public void getMobileScreenWidth2(Optional<Mobile> mobile){
		Optional<DisplayFeatures> resolution = mobile.flatMap(Mobile::getDisplayFeatures);
		
		resolution.ifPresent(r->System.out.println("Present"+r.getResolution().isPresent()));
	}

}
