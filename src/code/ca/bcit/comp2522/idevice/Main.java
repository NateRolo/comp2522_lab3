package ca.bcit.comp2522.idevice;

public class Main
{
    public static void main(final String[] args)
    {
        final IPhone testPhone;
        final String phonePurpose;

        final IPod iPod;
        final String iPodPurpose;

        testPhone = new IPhone(12,
                               "Rogers");
        phonePurpose = testPhone.getPurpose();

        iPod = new IPod(12,
                        22);
        iPodPurpose = iPod.getPurpose();

        System.out.println(phonePurpose);
        System.out.println(iPodPurpose);

        iPod.printDetails();

    }
}
