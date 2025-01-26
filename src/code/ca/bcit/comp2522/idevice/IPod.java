package ca.bcit.comp2522.idevice;

/**
 * Represents an iPod, a specific type of IDevice used for playing music.
 * Provides details about the iPod's purpose, maximum volume in decibels,
 * and the number of songs stored.
 */
public class IPod extends IDevice
{
    private static final double MINIMUM_VOLUME_DECIBELS = 0;
    private static final double MINIMUM_SONGS_STORED = 0;

    private final String purpose;
    private final double maxVolumeDecibels;

    private int songsStored;

    /**
     * Constructs an {@code IPod} object.
     * <p>
     *     Instantiates a {@code purpose}, {@code maxVolumeDecibels} as a double,
     *     and {@code songsStored} as an int.
     * </p>
     *
     * @param songsStored the number of songs stored as an int.
     * @param maxVolumeDecibels the max volume of the IPod as a double.
     */
    public IPod(final int songsStored,
                final double maxVolumeDecibels)
    {
        validateSongsStored(songsStored);
        validateMaxVolumeDecibels(maxVolumeDecibels);

        this.songsStored = songsStored;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.purpose = "music";
    }

    /**
     * Retrieves the maximum volume of the iPod in decibels.
     *
     * @return the maximum volume of the iPod as a double.
     */
    public double getMaxVolumeDecibels()
    {
        return maxVolumeDecibels;
    }

    /**
     * Sets the number of songs stored on the IPod.
     *
     * @param songsStored as an int.
     */
    public void setSongsStored(final int songsStored)
    {
        validateSongsStored(songsStored);

        this.songsStored = songsStored;
    }

    /**
     * Retrieves the number of songs stored on the iPod.
     *
     * @return the number of songs stored as an int.
     */
    public int getSongsStored()
    {
        return songsStored;
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
        final String detailsAsString;
        final String deviceName;

        deviceName = this.getClass().getSimpleName();

        builder = new StringBuilder();

        builder.append("Device: ")
               .append(deviceName)
               .append("\n")
               .append("Purpose: ")
               .append(this.getPurpose())
               .append("\n")
               .append("Songs Stored: ")
               .append(songsStored)
               .append("\n")
               .append("Maximum decibel volume: ")
               .append(maxVolumeDecibels);

        detailsAsString = builder.toString();

        return detailsAsString;
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
        if(o == null)
        {
            return false;
        }

        if(!(o.getClass().equals(this.getClass())))
        {
            return false;
        }

        return ((IPod) o).getSongsStored() == this.getSongsStored();
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
     *
     * If songsStored is negative, throw IllegalArgumentException.
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
     *
     * If songsStored is negative, throw IllegalArgumentException.
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



