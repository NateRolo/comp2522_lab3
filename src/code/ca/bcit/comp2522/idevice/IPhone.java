package ca.bcit.comp2522.idevice;


public class IPhone extends IDevice
{
    private static final String IPHONE_PURPOSE             = "talking";
    private static final double MINIMUM_PHONE_PLAN_MINUTES = 0;

    private final String purpose;

    private double phonePlanMinutesRemaining;
    private String carrier;

    public IPhone(final double phonePlanMinutes,
                  final String carrier)
    {
        validatePhonePlanMinutes(phonePlanMinutes);
        validateCarrier(carrier);

        this.phonePlanMinutesRemaining = phonePlanMinutes;
        this.carrier = carrier;
        this.purpose = IPHONE_PURPOSE;
    }

    public String getCarrier()
    {
        return carrier;
    }

    public void setCarrier(final String carrier)
    {
        validateCarrier(carrier);

        this.carrier = carrier;
    }

    public double getPhonePlanMinutesRemaining()
    {
        return phonePlanMinutesRemaining;
    }

    public void addMinutes(final double minutesAdded)
    {
        validatePhonePlanMinutes(minutesAdded);

        phonePlanMinutesRemaining += minutesAdded;
    }

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
     * based on the number of songs stored.
     *
     * @param o the object to compare with this iPod.
     * @return true if the object is an IPod with
     *             the same number of songs stored,
     *         false otherwise.
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
    void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

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

    private static void validateCarrier(final String carrier)
    {
        if(carrier == null || carrier.isBlank())
        {
            throw new IllegalArgumentException("Invalid carrier: " +
                                               carrier);
        }
    }


}
