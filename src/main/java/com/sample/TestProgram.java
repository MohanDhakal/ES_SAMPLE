package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.sample.ItemCity.City;
import com.sample.ItemCity.Type;
import java.math.BigDecimal;

public class TestProgram {

	public static void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			ItemCity item1 = new ItemCity();
			item1.setPurchaseCity(City.Kathmandu);
			item1.setTypeofItem(Type.Medicines);
			item1.setSellPrice(new BigDecimal(10));
			kSession.insert(item1);

			ItemCity item2 = new ItemCity();
			item2.setPurchaseCity(City.Kathmandu);
			item2.setTypeofItem(Type.Grocery);
			item2.setSellPrice(new BigDecimal(10));
			kSession.insert(item2);

			ItemCity item3 = new ItemCity();
			item3.setPurchaseCity(City.Pokhara);
			item3.setTypeofItem(Type.Medicines);
			item3.setSellPrice(new BigDecimal(10));
			kSession.insert(item3);

			ItemCity item4 = new ItemCity();
			item4.setPurchaseCity(City.Pokhara);
			item4.setTypeofItem(Type.Grocery);
			item4.setSellPrice(new BigDecimal(10));
			kSession.insert(item4);

			kSession.fireAllRules();
			
			System.out.println(item1.getPurchaseCity().toString() + " " + item1.getLocalTax().intValue());

			System.out.println(item2.getPurchaseCity().toString() + " " + item2.getLocalTax().intValue());

			System.out.println(item3.getPurchaseCity().toString() + " " + item3.getLocalTax().intValue());

			System.out.println(item4.getPurchaseCity().toString() + " " + item4.getLocalTax().intValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
