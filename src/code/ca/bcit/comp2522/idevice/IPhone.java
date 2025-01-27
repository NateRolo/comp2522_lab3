package ca.bcit.comp2522.idevice;

/**
 * Represents an iPhone, a type of IDevice used primarily for communication.
 * Provides details about the phone's carrier, remaining minutes, and purpose.
 */
public class IPhone extends IDevice
{
    private static final String IPHONE_PURPOSE             = "talking";
    private static final double MINIMUM_PHONE_PLAN_MINUTES = 0;

//    private final String purpose;

    private double phonePlanMinutesRemaining;
    private String carrier;

    /**
     * Constructs an {@code IPhone} object.
     *
     * @param phonePlanMinutes the initial number of minutes in the phone plan.
     * @param carrier          the carrier providing the phone plan.
     */
    public IPhone(final double phonePlanMinutes,
                  final String carrier)
    {
        validatePhonePlanMinutes(phonePlanMinutes);
        validateCarrier(carrier);

        this.phonePlanMinutesRemaining = phonePlanMinutes;
        this.carrier = carrier;
        purpose = IPHONE_PURPOSE;
    }

    /**
     * Retrieves the carrier for the phone plan.
     *
     * @return the carrier as a String.
     */
    public String getCarrier()
    {
        return carrier;
    }

    /**
     * Updates the carrier for the phone plan.
     *
     * @param carrier the new carrier as a String.
     */
    public void setCarrier(final String carrier)
    {
        validateCarrier(carrier);

        this.carrier = carrier;
    }

    /**
     * Retrieves the number of minutes remaining on the phone plan.
     *
     * @return the number of minutes as a double.
     */
    public double getPhonePlanMinutesRemaining()
    {
        return phonePlanMinutesRemaining;
    }

    /**
     * Adds minutes to the phone plan.
     *
     * @param minutesAdded the number of minutes to add as a double.
     */
    public void addMinutes(final double minutesAdded)
    {
        validatePhonePlanMinutes(minutesAdded);

        phonePlanMinutesRemaining += minutesAdded;
    }

    /**
     * Uses minutes from the phone plan.
     * <p>
     * If the number of minutes used exceeds the remaining minutes,
     * the remaining minutes are set to 0, and a message is printed.
     * </p>
     *
     * @param minutesUsed the number of minutes to use as a double.
     */
    public void useMinutes(final double minutesUsed)
    {
        validatePhonePlanMinutes(minutesUsed);

        phonePlanMinutesRemaining -= minutesUsed;

        if(phonePlanMinutesRemaining < MINIMUM_PHONE_PLAN_MINUTES)
        {
            phonePlanMinutesRemaining = MINIMUM_PHONE_PLAN_MINUTES;

            System.out.println("You have no minutes remaining.");
        }
    }

    /**
     * Compares this iPhone with another object for equality
     * based on the rounded remaining minutes.
     *
     * @param o the object to compare with this iPhone.
     * @return true if the object is an IPhone with the same rounded
     *         remaining minutes, false otherwise.
     */
    @Override
    public boolean equals(final Object o)
    {
        final double otherPhoneMinutesRounded;
        final double thisPhoneMinutesRounded;

        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        otherPhoneMinutesRounded = Math.floor(((IPhone) o)
                                   .getPhonePlanMinutesRemaining());

        thisPhoneMinutesRounded = Math.floor(phonePlanMinutesRemaining);

        return otherPhoneMinutesRounded == thisPhoneMinutesRounded;
    }


    /**
     * Returns the hash code for this iPhone.
     *
     * @return the hash code value as an int.
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String iDeviceDetails;
        final String iPhoneDetails;

        builder = new StringBuilder();
        iDeviceDetails = super.toString();

        builder.append(iDeviceDetails)
                .append("Phone plan minutes left: ")
                .append(phonePlanMinutesRemaining)
                .append("\n")
                .append("Carrier: ")
                .append(carrier)
                .append("\n");

        iPhoneDetails = builder.toString();

        return iPhoneDetails;
    }



    /**
     * Prints the details of the iPhone to the console.
     */
    @Override
    void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    /*
     * Validates the number of minutes in the phone plan.
     * <p>
     * Ensures that the provided value is not less than the minimum allowed
     * minutes. If invalid, an IllegalArgumentException is thrown.
     * </p>
     *
     * @param phonePlanMinutes the number of minutes to validate as a double.
     */
    private static void validatePhonePlanMinutes(final double phonePlanMinutes)
    {
        final boolean phonePlanMinuteLessThanMinimum;

        phonePlanMinuteLessThanMinimum = phonePlanMinutes < MINIMUM_PHONE_PLAN_MINUTES;

        if(phonePlanMinuteLessThanMinimum)
        {
            throw new IllegalArgumentException("Invalid minutes: " +
                                               phonePlanMinutes);
        }
    }

    /*
     * Validates the carrier name.
     * <p>
     * Ensures that the provided carrier name is not null or blank.
     * If invalid, an IllegalArgumentException is thrown.
     * </p>
     *
     * @param carrier the carrier name to validate as a String.
     */
    private static void validateCarrier(final String carrier)
    {
        if(carrier == null || carrier.isBlank())
        {
            throw new IllegalArgumentException("Invalid carrier: " +
                                               carrier);
        }
    }
}
