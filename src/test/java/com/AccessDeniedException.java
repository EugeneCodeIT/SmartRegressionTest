package com;


import java.lang.*;

public class AccessDeniedException extends Exception
{
    public AccessDeniedException(String message)
    {
        super(message);
    }
}