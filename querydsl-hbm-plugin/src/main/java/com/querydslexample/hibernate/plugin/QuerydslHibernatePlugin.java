package com.querydslexample.hibernate.plugin;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.hibernate.cfg.Configuration;

import com.mysema.query.jpa.codegen.HibernateDomainExporter;

/**
 * QuerydalHibernatePlugin generate QueryDSL required file from hibernate
 * mapping files
 *
 * @goal hibernate-export
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */
public class QuerydslHibernatePlugin extends AbstractMojo {

    /**
     * @parameter
     */
    private File targetFolder;

    /**
     * @parameter
     */
    private String prefix;

    /**
     * @parameter expression=false
     */
    private boolean unknownAsEntity;

    /**
     * @parameter
     */
    private File hibernateCfgFile;

    /**
     * @parameter expression="${project}" readonly=true required=true
     */
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log logger = this.getLog();
        try {
            if (!hibernateCfgFile.exists()) {
                logger.error("Could not find Hibernate Cfg File: " + hibernateCfgFile.toString());

                throw new MojoExecutionException("Could not find Hibernate Cfg File: " + hibernateCfgFile.toString());
            }

            Configuration theConfiguration = new Configuration();
            theConfiguration.configure(hibernateCfgFile);

            HibernateDomainExporter theExporter = new HibernateDomainExporter(
                            prefix, targetFolder, theConfiguration);
            theExporter.setUnknownAsEntity(unknownAsEntity);
            theExporter.execute();
        } catch (Exception e) {
            throw new MojoExecutionException(
                            "Failed to generate Querydsl classes from Hibernate Configuration "
                                            + hibernateCfgFile.toString(), e);
        }

        project.addCompileSourceRoot(targetFolder.toString());
    }
}
