package ca.bcit.comp2522.idevice;

/**
 * Represents an iPad, a type of IDevice used for learning.
 * Provides details about its purpose, case status, and iOS version.
 *
 * @author Nathan O
 * @version 1.0
 */
class IPad extends IDevice
{
    private static final String IPAD_PURPOSE = "learning";

    private boolean hasACase;
    private String iOSVersion;

    /**
     * Constructs an {@code IPad} object.
     *
     * @param hasACase    indicates if the iPad has a protective case.
     * @param iOSVersion  the iOS version of the iPad.
     */
    IPad(final boolean hasACase,
         final String iOSVersion)
    {
        super(IPAD_PURPOSE);

        validateIOSVersion(iOSVersion);

        this.hasACase = hasACase;
        this.iOSVersion = iOSVersion;

    }

    /**
     * Retrieves the current iOS version of the iPad.
     *
     * @return the iOS version as a String.
     */
    String getIOSVersion()
    {
        return iOSVersion;
    }

    /**
     * Updates the iOS version of the iPad.
     * <p>
     * Validates the provided iOS version before updating.
     * </p>
     *
     * @param iOSVersion the new iOS version to set as a String.
     */
    void setIOSVersion(final String iOSVersion)
    {
        validateIOSVersion(iOSVersion);

        this.iOSVersion = iOSVersion;
    }

    /**
     * Checks if the iPad has a protective case.
     *
     * @return true if the iPad has a case, false otherwise.
     */
    boolean iPadHasACase()
    {
        return hasACase;
    }

    /**
     * Updates the case status of the iPad.
     *
     * @param hasACase a boolean indicating if the iPad has a case.
     */
    void setHasACase(final boolean hasACase)
    {
        this.hasACase = hasACase;
    }

    /**
     * Provides a string representation of the iPad.
     * <p>
     * Includes details about the device type, purpose, case status,
     * and iOS version.
     * </p>
     *
     * @return a formatted string with the iPad's details.
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String        iPadDetails;
        final String        iDeviceDetails;

        builder = new StringBuilder();

        iDeviceDetails = super.toString();

        builder.append(iDeviceDetails)
               .append("Has a case: ")
               .append(hasACase)
               .append("\n")
               .append("iOS Version: ")
               .append(iOSVersion)
               .append("\n");

        iPadDetails = builder.toString();

        return iPadDetails;
    }

    /**
     * Prints the details of the iPad to the console.
     */
    @Override
    void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    /**
     * Checks if this iPad is equal to another object.
     * <p>
     * Two iPads are considered equal if their iOS versions are the same.
     * </p>
     *
     * @param o the object to compare to this iPad.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object o)
    {
        final boolean iPadsHaveSameOS;

        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        iPadsHaveSameOS = ((IPad) o).getIOSVersion().equals(this.getIOSVersion());

        return iPadsHaveSameOS;
    }

    /**
     * Returns the hash code of this iPad.
     *
     * @return the hash code value as an int.
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    /*
     * Validates the iOS version string.
     *
     * Ensures that the iOS version follows the format "X.Y" or "X.Y.Z",
     * where X, Y, and Z are positive integers. If the version is invalid,
     * an {@code IllegalArgumentException} is thrown.
     *
     * @param iOSVersion the iOS version to validate as a String.
     */
    private static void validateIOSVersion(final String iOSVersion)
    {
        if (iOSVersion == null || iOSVersion.isEmpty())
        {
            throw new IllegalArgumentException("iOS version cannot be " +
                                               "null or empty.");
        }

        final String iosVersionRegex = "(?i)ipadOS (1[0-9]|20|[1-9])";

        if (!iOSVersion.matches(iosVersionRegex))
        {
            throw new IllegalArgumentException("Invalid iOS version: " +
                                               iOSVersion);
        }
    }
}
