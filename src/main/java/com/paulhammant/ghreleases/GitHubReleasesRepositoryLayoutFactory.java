package com.paulhammant.ghreleases;

import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.spi.connector.layout.RepositoryLayout;
import org.eclipse.aether.spi.connector.layout.RepositoryLayoutFactory;
import org.eclipse.aether.transfer.NoRepositoryLayoutException;

public class GitHubReleasesRepositoryLayoutFactory implements RepositoryLayoutFactory {
    public RepositoryLayout newInstance(RepositorySystemSession repositorySystemSession, RemoteRepository remoteRepository) throws NoRepositoryLayoutException {
        return new GitHubReleasesRepositoryLayout();
    }

    public float getPriority() {
        return 0;
    }
}
