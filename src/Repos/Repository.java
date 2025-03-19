package Repos;

import Models.HasID;

import java.util.List;

public interface Repository <T extends HasID>{
        /**
         * Creates a new object in the repository.
         *
         * @param obj The object to create.
         */
        void create(T obj) ;

        /**
         * Retrieves an object from the repository by its ID.
         *
         * @param id The unique identifier of the object to retrieve.
         * @return The object with the specified ID, or null if not found.
         */
        T get(Integer id) ;

        /**
         * Updates an existing object in the repository.
         *
         * @param obj The object to update.
         */
        void update(T obj) ;

        /**
         * Deletes an object from the repository by its ID.
         *
         * @param id The unique identifier of the object to delete.
         */
        void delete(Integer id) ;

        /**
         * Retrieves all objects from the repository.
         *
         * @return A list of all objects in the repository.
         */
        List<T> getAll() ;
}
