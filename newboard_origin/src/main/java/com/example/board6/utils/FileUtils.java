package com.example.board6.utils;

import java.util.UUID;

public class FileUtils {
    //get ext
    //get original name
    // get rd name
    public String getExt(String file){
        return file.substring(file.lastIndexOf(".")+1);
    }

    public String getOriginalFileName(String file){
        return file.substring(0,file.lastIndexOf(".")+1);
    }

    public String getRdUuidName(){
        return UUID.randomUUID().toString();
    }

}
