package com.library.service;

import com.library.repository.Shelf;

public class ReaderHelp {

private Shelf collection;

public void setCollection(Shelf c)
{ this.collection = c; }

public void doSomething ( )
{
System . out . println ("Trying to get some books..");
collection.listBooks();
}

}
