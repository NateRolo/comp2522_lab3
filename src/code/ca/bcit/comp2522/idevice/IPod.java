package ca.bcit.comp2522.idevice;


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

    public double getMaxVolumeDecibels()
    {
        return maxVolumeDecibels;
    }

    public void setSongsStored(final int songsStored)
    {
        validateSongsStored(songsStored);

        this.songsStored = songsStored;
    }

    public int getSongsStored()
    {
        return songsStored;
    }

    @Override
    public void printDetails()
    {
        final String details;

        details = this.toString();

        System.out.println(details);
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;
        final String detailsAsString;

        builder = new StringBuilder();

        builder.append("Device: ")
               .append("IPod")
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

        if(((IPod)o).getSongsStored() == this.getSongsStored())
        {
            return true;
        }
        return false;
    }

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



