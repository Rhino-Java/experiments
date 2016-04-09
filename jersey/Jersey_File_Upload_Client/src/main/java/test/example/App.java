package test.example;

import java.io.IOException;

import test.example.client.FileUploadClient;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        new FileUploadClient().upload();
    }
}
