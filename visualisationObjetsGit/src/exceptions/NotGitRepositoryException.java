/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class NotGitRepositoryException extends Exception {

    /**
     * Creates a new instance of <code>NotGitRepositoryException</code> without
     * detail message.
     */
    public NotGitRepositoryException() {
    }

    /**
     * Constructs an instance of <code>NotGitRepositoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotGitRepositoryException(String msg) {
        super(msg);
    }
}
