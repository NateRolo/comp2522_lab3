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
}
