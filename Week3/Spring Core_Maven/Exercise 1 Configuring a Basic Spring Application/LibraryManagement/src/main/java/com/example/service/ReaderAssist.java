package com.example.service;

import com.example.repository.BookDepot;

public class ReaderAssist
{

private BookDepot repoFriend;

public void setRepoFriend ( BookDepot f )
{this.repoFriend = f;}

public void helpFindBooks( )
{
System . out . println ("ReaderAssist activated. Finding your books..." );
repoFriend . showBooks( );
}

}
