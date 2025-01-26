package ca.bcit.comp2522.idevice;

public class Main
{
    public static void main(final String[] args)
    {
        final IPhone testPhone;
        final String phonePurpose;

        final IPad iPad;
        final String iPadPurpose;

        testPhone = new IPhone(12,
                               "Rogers");
        phonePurpose = testPhone.getPurpose();

        iPad = new IPad(true,
                        "12.1.2");
        iPadPurpose = iPad.getPurpose();

        System.out.println(phonePurpose);
        System.out.println(iPadPurpose);
    }
}
