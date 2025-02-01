package ca.bcit.comp2522.idevice;

/**
 * Represents an iPod, a specific type of IDevice used for playing music.
 * Provides details about the iPod's purpose, maximum volume in decibels,
 * and the number of songs stored.
 *
 * @author Jacob F
 * @author Nathan O
 * @author Jacob F
 * @version 1.0.2025
 */
class IPod extends IDevice
{
    private static final String IPOD_PURPOSE = "music";
    private static final double MINIMUM_VOLUME_DECIBELS = 0;
    private static final double MINIMUM_SONGS_STORED = 0;

    private final double maxVolumeDecibels;

    private int songsStored;

    /**
     * Constructs an {@code IPod} object.
     *
     * @param songsStored the number of songs stored as an int.
     * @param maxVolumeDecibels the max volume of the IPod as a double.
     */
    IPod(final int songsStored,
         final double maxVolumeDecibels)
    {
        super(IPOD_PURPOSE);

        validateSongsStored(songsStored);
        validateMaxVolumeDecibels(maxVolumeDecibels);

        this.songsStored = songsStored;
        this.maxVolumeDecibels = maxVolumeDecibels;
    }

    /**
     * Retrieves the maximum volume of the iPod in decibels.
     *
     * @return the maximum volume of the iPod as a double.
     */
    final double getMaxVolumeDecibels()
    {
        return maxVolumeDecibels;
    }

    /**
     * Sets the number of songs stored on the IPod.
     *
     * @param songsStored as an int.
     */
    final void setSongsStored(final int songsStored)
    {
        validateSongsStored(songsStored);

        this.songsStored = songsStored;
    }

    /**
     * Retrieves the number of songs stored on the iPod.
     *
     * @return the number of songs stored as an int.
     */
    final int getSongsStored()
    {
        return songsStored;
    }

    /**
     * Returns a string representation of the iPod,
     * including its type, purpose,
     * the number of songs stored,
     * and the maximum volume in decibels.
     *
     * @return a formatted string with the iPod's details.
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String iDeviceDetails;
        final String iPodDetails;

        builder = new StringBuilder();
        iDeviceDetails = super.toString();

        builder.append(iDeviceDetails)
               .append("Songs Stored: ")
               .append(songsStored)
               .append("\n")
               .append("Maximum decibel volume: ")
               .append(maxVolumeDecibels)
               .append("\n");

        iPodDetails = builder.toString();

        return iPodDetails;
    }

    /**
     * Prints the details of the iPod to the console.
     * Details include the type of device, its purpose,
     * the number of songs stored,
     * and the maximum volume in decibels.
     */
    @Override
    public void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    /**
     * Compares this iPod with another object for equality
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
        final boolean iPodsHaveEqualSongsStored;

        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        iPodsHaveEqualSongsStored = ((IPod) o).getSongsStored() ==
                                    this.getSongsStored();

        return iPodsHaveEqualSongsStored;
    }

    /**
     * Returns the hash code for this iPod.
     *
     * @return the hash code value as an int.
     */
    @Override
    public int hashCode()
    {
         return super.hashCode();
    }


    /*
     * Validates max volume in decibels of IPod.
     */
    private static void validateMaxVolumeDecibels(final double maxVolumeDecibels)
    {
        final boolean maxVolumeIsLessThanMinimum;

        maxVolumeIsLessThanMinimum = maxVolumeDecibels < MINIMUM_VOLUME_DECIBELS;

        if(maxVolumeIsLessThanMinimum)
        {
            throw new IllegalArgumentException("Max volume cannot be lower" +
                                               "than " + MINIMUM_VOLUME_DECIBELS);
        }
    }

    /*
     * Validates number of songs stored in IPod.
     */
    private static void validateSongsStored(final int songsStored)
    {
        final boolean songsStoredIsLessThanMinimum;

        songsStoredIsLessThanMinimum = songsStored < MINIMUM_SONGS_STORED;

        if(songsStoredIsLessThanMinimum)
        {
            throw new IllegalArgumentException("Songs stored cannot be lower" +
                                               "than " + MINIMUM_SONGS_STORED);
        }
    }
}



