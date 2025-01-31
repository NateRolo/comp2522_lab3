package ca.bcit.comp2522.idevice;

/**
 * Defines shared properties of ©Apple® iDevices. Provides
 * method to get the purpose specific to the device and
 * an abstract method to return the details of the device.
 *
 * @author Nathan Oloresisimo
 * @author Jacob Fonseca
 * @version 1.0.2025
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
