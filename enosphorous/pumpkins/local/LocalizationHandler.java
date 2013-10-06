package enosphorous.pumpkins.local;

import cpw.mods.fml.common.registry.LanguageRegistry;
import enosphorous.pumpkins.common.Reference;

public class LocalizationHandler{

public static void init(){
	
	if (Reference.FORCE_DEBUG){
		
		System.out.println("[CHATEAU ROMANI] Found and localized " + Reference.LANGUAGE_COUNT + " language(s).");
		
	}

/**
* For all files registered in Localizations.java, add them to the Localization Library.
* This way we can use this file to add localizations (names).
*/
for(String LocationFile: Localizations.localeFiles){

LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocaleFromFileName(LocationFile), LocalizationHelper.isXMLLanguageFile(LocationFile));
}
}
}