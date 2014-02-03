package com.jag.util;

import java.io.File;
import java.io.FilePermission;
import java.security.Permission;

/**
 * Author: harrynoob
 */
public final class JagSecurity extends SecurityManager {

    private static final File HOME_DIRECTORY = new File(System.getProperty("user.home"));

    @Override
    public void checkPermission(Permission p) throws SecurityException {
        if (p instanceof FilePermission) {
            FilePermission fp = (FilePermission) p;
            File file = new File(fp.getName());
            if (isSubFolder(file, HOME_DIRECTORY)) {
                System.out.println("[JagSecurity] Allowing "
                        + fp.getActions()
                        + " to file "
                        + file.getAbsolutePath());
            }
        }
    }

    private boolean isSubFolder(File toCheck, File toFind) {
        return toCheck.getAbsolutePath().startsWith(toFind.getAbsolutePath());
    }

}
