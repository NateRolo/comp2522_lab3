package ca.bcit.comp2522.idevice;

/**
 *
 * @author Nathan O
 */
abstract class IDevice
{
    static String purpose;

    IDevice()
    {
    }

    String getPurpose()
    {
        return purpose;
    }

    abstract void printDetails();

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
