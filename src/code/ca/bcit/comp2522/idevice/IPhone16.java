package ca.bcit.comp2522.idevice;

/**
 * Represents an iPhone 16 model.
 *<p>
 *     Extends the functionality of the base {@code IPhone}
 *     class by including attributes specific to the iPhone 16,
 *     such as high-resolution camera support
 *     and memory size.
 * </p>
 *
 * @author Nathan O
 * @version 1.0
 */
class IPhone16 extends IPhone
{
    private static final int LOW_TIER_MEMORY_SIZE_GB = 128;
    private static final int MID_TIER_MEMORY_SIZE_GB = 256;
    private static final int HIGH_TIER_MEMORY_SIZE_GB = 512;

    private final boolean hasHighResCamera;
    private final int     memorySizeGB;

    /**
     * Constructs an {@code IPhone16} object.
     *
     * @param phonePlanMinutes the initial number of minutes in the phone plan.
     * @param carrier          the carrier providing the phone plan.
     * @param hasHighResCamera whether the phone includes a high-resolution camera.
     * @param memorySizeGB     the memory size of the phone in gigabytes.
     */
    IPhone16(final double phonePlanMinutes,
             final String carrier,
             final boolean hasHighResCamera,
             final int memorySizeGB)
    {
        super(phonePlanMinutes,
              carrier);

        validateMemorySize(memorySizeGB);

        this.hasHighResCamera = hasHighResCamera;
        this.memorySizeGB = memorySizeGB;
    }

    /**
     * Checks whether the iPhone has a high-resolution camera.
     *
     * @return {@code true} if the phone includes a high-resolution camera,
     *         otherwise {@code false}.
     */
    boolean checkForHighResCamera()
    {
        return hasHighResCamera;
    }

    /**
     * Returns a string representation of the iPhone 16.
     *
     * @return a string containing details of the iPhone 16, including carrier,
     *         memory size, and whether it has a high-resolution camera.
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String iPhoneDetails;
        final String iPhone16Details;

        builder = new StringBuilder();
        iPhoneDetails = super.toString();

        builder.append(iPhoneDetails)
               .append("Has a high-resolution camera: ")
               .append(hasHighResCamera)
               .append("\n")
               .append("GB of memory: ")
               .append(memorySizeGB)
               .append("\n");

        iPhone16Details = builder.toString();

        return iPhone16Details;

    }

    /**
     * Prints the details of the iPhone16 to the console.
     */
    @Override
    void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    /**
     * Compares this {@code IPhone16} with another object for equality.
     *
     * @param o the object to compare with this {@code IPhone16}.
     * @return {@code true} if the given object is an {@code IPhone16} with
     *         the same phone plan minutes and high-resolution camera status,
     *         otherwise {@code false}.
     */
    @Override
    public boolean equals(final Object o)
    {
        final boolean otherPhoneHasHighResCamera;
        final boolean phonesHaveEqualMinutesRemaining;
        final boolean bothPhonesHaveHighResCamera;

        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        otherPhoneHasHighResCamera = ((IPhone16) o).checkForHighResCamera();

        phonesHaveEqualMinutesRemaining = super.equals(o);

        bothPhonesHaveHighResCamera = (this.hasHighResCamera ==
                                       otherPhoneHasHighResCamera);

        return phonesHaveEqualMinutesRemaining && bothPhonesHaveHighResCamera;
    }

    /**
     * Generates a hash code for this {@code IPhone16}.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    /*
     * Validates the given memory size for the iPhone 16.
     *
     * Ensures the memory size is one of the predefined tiers.
     *
     * @param memorySizeGB the memory size to validate, in gigabytes.
     */
    private static void validateMemorySize(final int memorySizeGB)
    {
        if((memorySizeGB == LOW_TIER_MEMORY_SIZE_GB) ||
           (memorySizeGB == MID_TIER_MEMORY_SIZE_GB) ||
           (memorySizeGB == HIGH_TIER_MEMORY_SIZE_GB))
        {
            return;
        }

        throw new IllegalArgumentException("Invalid memory size: " +
                                           memorySizeGB);
    }
}
