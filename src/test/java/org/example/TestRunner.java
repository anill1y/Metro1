package org.example;

public class TestRunner {
    public static void main(String[] args) {
        org.junit.platform.launcher.LauncherDiscoveryRequest request =
                org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request().build();

        org.junit.platform.launcher.Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
        launcher.execute(request);
    }
}
