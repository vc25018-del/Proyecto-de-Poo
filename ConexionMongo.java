package com.inmobiliaria.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Clase singleton que gestiona la conexión a MongoDB.
 * Encapsula el URI y devuelve la instancia de base de datos.
 */
public final class ConexionMongo {
    private static ConexionMongo instancia;
    private MongoClient cliente;
    private MongoDatabase database;
    // URI que indicó: mongodb://localhost:27017
    private final String MONGO_URI = "mongodb://localhost:27017";
    private final String DB_NAME = "inmobiliaria_db";

    private ConexionMongo() {
        cliente = MongoClients.create(MONGO_URI);
        database = cliente.getDatabase(DB_NAME);
    }

    public static ConexionMongo getInstancia() {
        if (instancia == null) {
            synchronized (ConexionMongo.class) {
                if (instancia == null) {
                    instancia = new ConexionMongo();
                }
            }
        }
        return instancia;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (cliente != null) {
            cliente.close();
        }
    }
}
teorhjgrlnhknkmktnhrlmmlrjoikoymnrmhornoojtyokmriohomronhlmhklohmkoj0oihjkkrohkomri oijhormoi
