package hu.infokristaly.homework4svnkit.tasks;

import org.tmatesoft.svn.core.SVNException;

/*
 * http://wiki.svnkit.com/Managing_A_Working_Copy
 */
public class Homework4SVNKit {
	
	public static void main(String[] args) {
		boolean isRecursive = true;
		String destPath = "/home/pzoli/munka/mplayer";
		int revision = 1;
		String url = "svn://svn.mplayerhq.hu/mplayer/trunk";
		try {
			CheckoutTask.checkout(url, revision, destPath, isRecursive);
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
