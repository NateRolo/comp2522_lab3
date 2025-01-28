package ca.bcit.comp2522.idevice;

/**
 * Represents an abstract base class for Apple devices.
 * <p>
 *     Provides a foundation for device-related classes with common functionality
 *     such as retrieving the device purpose and printing device details.
 *     All devices extending this class must implement the {@code printDetails()} method.
 * </p>
 *
 * @author Nathan O
 * @version 1.0
 */
abstract class IDevice
{
    static String purpose;

    /**
     * Constructs an {@code IDevice} object.
     */
    IDevice()
    {
    }

    /**
     * Retrieves the purpose of the device.
     *
     * @return the purpose of the device as a {@code String}.
     */
    String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints the details of the device.
     *
     * Must be implemented by subclasses to define specific details for each device.
     */
    abstract void printDetails();

    /**
     * Returns a string representation of the device.
     *
     * @return a string containing the name of the device and its purpose.
     */
    @Override
    public String toString()
    {
        final String deviceName;
        final StringBuilder builder;
        final String detailsAsAString;

        deviceName = this.getClass().getSimpleName();

        builder = new StringBuilder();

        builder.append("Device: ")
                .append(deviceName)
                .append("\n")
                .append("Purpose: ")
                .append(this.getPurpose())
                .append("\n");

        detailsAsAString = builder.toString();

        return detailsAsAString;
    }
}
