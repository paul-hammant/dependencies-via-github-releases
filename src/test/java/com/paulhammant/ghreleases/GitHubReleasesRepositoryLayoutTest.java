package com.paulhammant.ghreleases;

import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GitHubReleasesRepositoryLayoutTest {

    @Test
    public void testPathOf() {
        GitHubReleasesRepositoryLayout ghrrl = new GitHubReleasesRepositoryLayout();
        // I'm not 100 sure hat type and classier are for normal jars.
        DefaultArtifact artifact = new DefaultArtifact("paul-hammant", "xstream", "1.4.3",
                "compile", "jar", "jar", new DefaultArtifactHandler());
        String foo = ghrrl.pathOf(artifact);
        assertThat(foo, equalTo("paul-hammant/xstream-jar/archive/1.4.3.zip"));
    }

}
