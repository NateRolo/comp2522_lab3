package ca.bcit.comp2522.idevice;

public class IPod extends IDevice
{
    private static final double MINIMUM_VOLUME_DECIBELS = 0;
    private static final double MINIMUM_SONGS_STORED = 0;

    private final String purpose;
    private final int songsStored;
    private final double maxVolumeDecibels;


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

    @Override
    public void printDetails()
    {
        final StringBuilder detailsBuilder;
        final String details;

        detailsBuilder = new StringBuilder();

        detailsBuilder.append("Device: ")
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

        details = detailsBuilder.toString();

        System.out.println(details);
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
