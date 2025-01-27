package ca.bcit.comp2522.idevice;

public class Main
{
    public static void main(final String[] args)
    {
        final IPhone testPhone;
        final String phonePurpose;

        final IPad   iPad;
        final String iPodPurpose;

        testPhone = new IPhone(12,
                               "Rogers");
        phonePurpose = testPhone.getPurpose();

         iPad        = new IPad(true,
                               "22.0.1");
        iPodPurpose = iPad.getPurpose();

        System.out.println(testPhone);
        System.out.println(iPad);



    }
}
