package enosphorous.pumpkins.local;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHelper{

/**
* Checks if language file is an .xml file
*
* @param Name of the file which needs to be checked.
* @return true when is, false when isn't
*/

public static boolean isXMLLanguageFile(String fileName){

return fileName.endsWith(".xml");
}

/**
* Gets the language from filename. EG. en_US.xml will return en_US
*
* @param Name of the file which needs to be checked.
* @return Language substring.
*/

public static String getLocaleFromFileName(String fileName){

return fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
}

/**
* Gets the language of the file
*
* @param Key of the language file
* @return language of the file
*/

public static String getLocalizationString(String key){

return LanguageRegistry.instance().getStringLocalization(key);
}
}