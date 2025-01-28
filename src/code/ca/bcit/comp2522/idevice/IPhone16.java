package ca.bcit.comp2522.idevice;

public class IPhone16 extends IPhone
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
     */
    public IPhone16(final double phonePlanMinutes,
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

    public boolean checkForHighResCamera()
    {
        return hasHighResCamera;
    }

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

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

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
