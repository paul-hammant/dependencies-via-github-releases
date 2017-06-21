package com.paulhammant.ghreleases;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.handler.ArtifactHandler;
import org.apache.maven.artifact.metadata.ArtifactMetadata;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.repository.layout.ArtifactRepositoryLayout;
import org.codehaus.plexus.component.annotations.Component;
import org.eclipse.aether.metadata.Metadata;
import org.eclipse.aether.spi.connector.layout.RepositoryLayout;

import java.net.URI;
import java.util.List;


@Component( role = ArtifactRepositoryLayout.class, hint = "github-releases" )
public class GitHubReleasesRepositoryLayout
    implements ArtifactRepositoryLayout, RepositoryLayout
{

    public GitHubReleasesRepositoryLayout() {
        System.out.println("GitHubReleasesRepositoryLayout--!");
        try {
            throw new UnsupportedOperationException("DEEBUG");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace(System.out);
        }
    }

    public URI getLocation(org.eclipse.aether.artifact.Artifact artifact, boolean b) {
        return null;
    }

    public URI getLocation(Metadata metadata, boolean b) {
        return null;
    }

    public List<Checksum> getChecksums(org.eclipse.aether.artifact.Artifact artifact, boolean b, URI uri) {
        return null;
    }

    public List<Checksum> getChecksums(Metadata metadata, boolean b, URI uri) {
        return null;
    }

    private static final char GROUP_SEPARATOR = '.';

    public String getId()
    {
        return "github-releases";
    }

    public String pathOf( Artifact artifact )
    {
        System.out.println("GitHubReleasesRepositoryLayout.pathOf--> " + artifact.getClassifier() + " " + artifact.getId() + " " + artifact.getType() + " " + artifact.getBaseVersion());
        StringBuilder path = new StringBuilder( 128 );
        path.append(artifact.getGroupId()).append("/");
        path.append(artifact.getArtifactId()).append("-").append(artifact.getClassifier());
        path.append("/archive/");
        path.append(artifact.getVersion()).append(".zip");

        return path.toString();
    }

    public String pathOfLocalRepositoryMetadata( ArtifactMetadata metadata, ArtifactRepository repository )
    {
        return pathOfRepositoryMetadata( metadata.getLocalFilename( repository ) );
    }

    private String pathOfRepositoryMetadata( String filename )
    {
        System.err.println("GitHubReleasesRepositoryLayout.pathOfRepositoryMetadata--> " +  filename);

        StringBuilder path = new StringBuilder( 128 );

        path.append( filename );

        return path.toString();
    }

    public String pathOfRemoteRepositoryMetadata( ArtifactMetadata metadata )
    {
        return pathOfRepositoryMetadata( metadata.getRemoteFilename() );
    }

    @Override
    public String toString()
    {
        return getId();
    }

}
