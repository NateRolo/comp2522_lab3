package ca.bcit.comp2522.idevice;

/**
 * Represents an abstract base class for Apple devices.
 *
 * @author Jacob F
 * @author Nathan O
 * @version 1.0
 */
abstract class IDevice
{
    private final String purpose;

    /**
     * Constructs an {@code IDevice} object.
     */
    IDevice(final String purpose)
    {
        this.purpose = purpose;
    }

    /**
     * Retrieves the purpose of the device.
     *
     * @return the purpose of the device as a {@code String}.
     */
    final String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints the details of the device.
     * <p>
     * Must be implemented by subclasses to define specific details for each device.
     * </p>
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
