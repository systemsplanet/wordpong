package com.wordpong.api.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-21 22:07:29")
/** */
public final class PasswordChangeRequestMeta extends org.slim3.datastore.ModelMeta<com.wordpong.api.model.PasswordChangeRequest> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.wordpong.api.model.PasswordChangeRequest, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<com.wordpong.api.model.PasswordChangeRequest, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.wordpong.api.model.PasswordChangeRequest> email = new org.slim3.datastore.StringAttributeMeta<com.wordpong.api.model.PasswordChangeRequest>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.wordpong.api.model.PasswordChangeRequest, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.wordpong.api.model.PasswordChangeRequest, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.wordpong.api.model.PasswordChangeRequest> randomId = new org.slim3.datastore.StringAttributeMeta<com.wordpong.api.model.PasswordChangeRequest>(this, "randomId", "randomId");

    private static final org.slim3.datastore.CreationDate slim3_createdAtAttributeListener = new org.slim3.datastore.CreationDate();

    private static final PasswordChangeRequestMeta slim3_singleton = new PasswordChangeRequestMeta();

    /**
     * @return the singleton
     */
    public static PasswordChangeRequestMeta get() {
       return slim3_singleton;
    }

    /** */
    public PasswordChangeRequestMeta() {
        super("PasswordChangeRequest", com.wordpong.api.model.PasswordChangeRequest.class);
    }

    @Override
    public com.wordpong.api.model.PasswordChangeRequest entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.wordpong.api.model.PasswordChangeRequest model = new com.wordpong.api.model.PasswordChangeRequest();
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setKey(entity.getKey());
        model.setRandomId((java.lang.String) entity.getProperty("randomId"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.wordpong.api.model.PasswordChangeRequest m = (com.wordpong.api.model.PasswordChangeRequest) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("randomId", m.getRandomId());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.wordpong.api.model.PasswordChangeRequest m = (com.wordpong.api.model.PasswordChangeRequest) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.wordpong.api.model.PasswordChangeRequest m = (com.wordpong.api.model.PasswordChangeRequest) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.wordpong.api.model.PasswordChangeRequest) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
        com.wordpong.api.model.PasswordChangeRequest m = (com.wordpong.api.model.PasswordChangeRequest) model;
        m.setCreatedAt(slim3_createdAtAttributeListener.prePut(m.getCreatedAt()));
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.wordpong.api.model.PasswordChangeRequest m = (com.wordpong.api.model.PasswordChangeRequest) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreatedAt() != null){
            writer.setNextPropertyName("createdAt");
            encoder0.encode(writer, m.getCreatedAt());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRandomId() != null){
            writer.setNextPropertyName("randomId");
            encoder0.encode(writer, m.getRandomId());
        }
        writer.endObject();
    }

    @Override
    protected com.wordpong.api.model.PasswordChangeRequest jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.wordpong.api.model.PasswordChangeRequest m = new com.wordpong.api.model.PasswordChangeRequest();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("randomId");
        m.setRandomId(decoder0.decode(reader, m.getRandomId()));
        return m;
    }
}