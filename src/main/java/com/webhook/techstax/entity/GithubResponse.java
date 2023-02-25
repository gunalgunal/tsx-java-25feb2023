package com.webhook.techstax.entity;

import java.util.List;

public class GithubResponse {

       private String sha;
       private String node_id;
       private Commit commit;
       private String url;
       private String html_url;
       private String comments_url;
       private GithubAuthor author;
       private GithubCommitter committer;
       private List<Parent> parents;

       public String getSha() {
              return sha;
       }

       public void setSha(String sha) {
              this.sha = sha;
       }

       public String getNode_id() {
              return node_id;
       }

       public void setNode_id(String node_id) {
              this.node_id = node_id;
       }

       public Commit getCommit() {
              return commit;
       }

       public void setCommit(Commit commit) {
              this.commit = commit;
       }

       public String getUrl() {
              return url;
       }

       public void setUrl(String url) {
              this.url = url;
       }

       public String getHtml_url() {
              return html_url;
       }

       public void setHtml_url(String html_url) {
              this.html_url = html_url;
       }

       public String getComments_url() {
              return comments_url;
       }

       public void setComments_url(String comments_url) {
              this.comments_url = comments_url;
       }

       public GithubAuthor getAuthor() {
              return author;
       }

       public void setAuthor(GithubAuthor author) {
              this.author = author;
       }

       public GithubCommitter getCommitter() {
              return committer;
       }

       public void setCommitter(GithubCommitter committer) {
              this.committer = committer;
       }

       public List<Parent> getParents() {
              return parents;
       }

       public void setParents(List<Parent> parents) {
              this.parents = parents;
       }
}
