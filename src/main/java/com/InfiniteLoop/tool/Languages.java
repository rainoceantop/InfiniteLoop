package com.InfiniteLoop.tool;

import java.util.EnumMap;

public enum Languages {
 JAVA,PHP,PYTHON,JAVASCRIPT,GO,C,CSHARP,CPP,
 SWIFT,H5,CSS3,KOTLIN,NODEJS,NET,RUBY,SQL,OBJECTIVEC,
 R,VISUALBASIC,PERL;

     public static EnumMap<Languages, String> getLanguageMap() {
         EnumMap<Languages,String> enumMap = new EnumMap<Languages, String>(Languages.class);
         for(Languages languages : Languages.values()){
            enumMap.put(languages, languages.toString().toLowerCase());
         }
         enumMap.put(CSHARP,"c#");
         enumMap.put(CPP,"c++");
         enumMap.put(NODEJS,"node.js");
         enumMap.put(NET,".net");
         enumMap.put(OBJECTIVEC,"objective-c");
         enumMap.put(VISUALBASIC,"visual basic");
         return enumMap;
     }
 }
