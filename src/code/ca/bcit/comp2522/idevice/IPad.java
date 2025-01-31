package ca.bcit.comp2522.idevice;

/**
 * Represents an iPad, a specific type of IDevice used for learning.
 * Provides details about the iPad's purpose, case status,
 * and the version of iOS.
 *
 * @author Nathan Oloresisimo
 * @author Jacob Fonseca
 * @version 1.0.2025
 */
public class IPad extends IDevice
{

    private final String purpose;

    private boolean hasACase;
    private String iOSVersion;

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
    private static void validateIOSVersion(final String iOSVersion)
    {
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

    public String getIOSVersion()
    {
        return iOSVersion;
    }

    public void setIOSVersion(final String iOSVersion)
    {
        validateIOSVersion(iOSVersion);

        this.iOSVersion = iOSVersion;
    }

    public boolean iPadHasACase()
    {
        return hasACase;
    }

    public void setHasACase(final boolean hasACase)
    {
        this.hasACase = hasACase;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String        detailsAsString;
        final String deviceName;

        deviceName = this.getClass().getSimpleName();

        builder = new StringBuilder();

        builder.append("Device: ")
               .append(deviceName)
               .append("\n")
               .append("Purpose: ")
               .append(this.getPurpose())
               .append("\n")
               .append("Has a case: ")
               .append(hasACase)
               .append("\n")
               .append("iOS Version: ")
               .append(iOSVersion);

        detailsAsString = builder.toString();

        return detailsAsString;

    }

    @Override
    void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    @Override
    public boolean equals(final Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        return ((IPad) o).getIOSVersion().equals(this.getIOSVersion());
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
