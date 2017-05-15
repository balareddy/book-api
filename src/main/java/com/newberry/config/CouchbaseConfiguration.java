package com.newberry.config;

import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.List;

/**
 * Description: Sets the configuration for working with couchbase repositories.
 * <p>
 * Notice that this class has a bunch of setters.  Spring won't allow a non-default constructor
 * to be used for injection of a configuration class.  If we just annotate the fields with
 * to have them injected, then we can't test very easily.  Instead we just use setter injection,
 * which pleases Spring and makes for simple testing.
 *
 */

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.newberry.repository.couchbase"})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private String bucketName;
    private String bucketPassword;
    private String bucketUsername;
    private String uriList;

    @Override
    protected List<String> bootstrapHosts() {
        return Splitter.on(',').omitEmptyStrings().trimResults().splitToList(uriList);
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return bucketPassword;
    }

    /**
     * @return the username for the bucket
     */
    public String getBucketUsername() {
        return bucketUsername;
    }

    /**
     * @param bucketName Bucket name.
     */
    @Value("${couchbase.cluster.bucket:calltron}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * @param bucketPassword Bucket password
     */
    @Value("${couchbase.cluster.password:}")
    public void setBucketPassword(String bucketPassword) {
        this.bucketPassword = bucketPassword;
    }

    /**
     * @param bucketUsername Username
     */
    @Value("${couchbase.cluster.username:}")
    public void setBucketUsername(String bucketUsername) {
        this.bucketUsername = bucketUsername;
    }

    /**
     * @param uriList Comma separated list of host names
     */
    @Value("${couchbase.cluster.uriList:127.0.0.1}")
    public void setUriList(String uriList) {
        this.uriList = uriList;
    }
}
