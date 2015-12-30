package hu.infokristaly.homework4svnkit.tasks;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/*
 * checkout mplayer
 */
public class CheckoutTask {
	private static SVNClientManager ourClientManager;

	@SuppressWarnings("deprecation")
	public static long checkout(String url, int revision, String destPath,
			boolean isRecursive) throws SVNException {
		ISVNOptions options = SVNWCUtil.createDefaultOptions(true);

		ISVNAuthenticationManager authManager = SVNWCUtil
				.createDefaultAuthenticationManager();

		ourClientManager = SVNClientManager.newInstance(options, authManager);

		SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
		updateClient.setIgnoreExternals(false);
		SVNURL target = SVNURL.parseURIEncoded(url);

		File destDir = new File(destPath);
		destDir.mkdirs( );
		return updateClient.doCheckout(target, destDir, SVNRevision.HEAD, SVNRevision.HEAD
			, isRecursive);
	}
}
