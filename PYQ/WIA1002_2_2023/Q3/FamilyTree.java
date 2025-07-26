/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */

/*
    Assumption: one parent can have multiple children
    - Build a custom N-ary tree
*/
import java.util.LinkedList;

public class FamilyTree {
    private LinkedList<Node> nodes;
    
    static class Node{
        Patient patient;
        Node parent; // upward traversal
        
        public Node(Patient patient){
            this.patient = patient;
            this.parent = null;
        }
    }
    
    public FamilyTree(){
        this.nodes = new LinkedList<>();
    }
    
    public void add(Patient p){
        this.nodes.add(new Node(p));
    }
    
    public Node findPatientNode(Patient p){
        for (Node node : nodes) {
            if (node.patient.equals(p)) {
                return node;
            }
        }
        return null;
    }
    
    public void addParentRelationship(Patient patient, Patient parent){
        Node patientNode = findPatientNode(patient);
        Node parentNode = findPatientNode(parent);
        patientNode.parent = parentNode; // Create pointer that points to parentNode
    }
    
    /**
     * Traverses upward from the given patient to find the closest ancestor
     * (parent, grandparent) who has a non-null past medical record
     * Skips the current patient and starts from their parent
     * do-while loop to ensure the search starts with the parent
     * and continues to traverse upward until either
     * - an ancestor with a medical record is found or
     * - the root of the family tree (null parent) is reached
     * @param p the patient
     * @return the closest ancestor with a medical record otherwise null
     */
    public Patient findClosestAncestorWithMedicalRecord(Patient p){
        Node current = findPatientNode(p);
        if(current == null) return null;
        
        do {
            current = current.parent;
        } while (current != null && current.patient.getPastMedicalRecord() == null);
        
        return current == null ? null : current.patient;
    }
}
