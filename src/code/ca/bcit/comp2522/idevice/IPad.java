package ca.bcit.comp2522.idevice;

public class IPad extends IDevice
{

    private final String purpose;
    private boolean hasACase;
    private final String iOSVersion;

    public IPad(final boolean hasACase,
                final String iOSVersion)
    {
        validateIOSVersion(iOSVersion);

        this.hasACase = hasACase;
        this.iOSVersion = iOSVersion;
        this.purpose = "learning";
    }

    /**
     * Validates the iOS version string.
     * <p>
     * Ensures that the iOS version follows the format "X.Y" or "X.Y.Z",
     * where X, Y, and Z are positive integers. If the version is invalid,
     * an {@code IllegalArgumentException} is thrown.
     * </p>
     *
     * @param iOSVersion the iOS version to validate as a String.
     */
    private static void validateIOSVersion(final String iOSVersion) {
        if (iOSVersion == null || iOSVersion.isEmpty()) {
            throw new IllegalArgumentException("iOS version cannot be null or empty.");
        }


        final String iosVersionRegex = "^\\d+\\.\\d+(\\.\\d+)?$";

        if (!iOSVersion.matches(iosVersionRegex)) {
            throw new IllegalArgumentException("Invalid iOS version format: " +
                                               iOSVersion + ". " +
                                               "Expected format is X.Y or X.Y.Z, " +
                                               "where X, Y, and Z are integers.");
        }



}
