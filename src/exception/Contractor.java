package exception;

public class Contractor
{
    private static Contractor defaultInstance = null;

    public Contractor()
    {}

    public static Contractor defaultContractor()
    {
        if(defaultInstance == null)
        {
            defaultInstance = new Contractor();
        }

        return defaultInstance;
    }

    public void invariantError(String service, String message)
    {
        System.err.println("Service '"+service+"': invariant error");
        System.err.println("  ==> "+message);
        throw new ContractError("Le contrat n'est pas respecté !");
    }

    public void preconditionError(String service, String method, String message)
    {
        System.err.println("Service '"+service+"' method '"+method+"': precondition error");
        System.err.println("  ==> "+message);
        throw new ContractError("Le contrat n'est pas respecté !");
    }

    public void postconditionError(String service, String method, String message)
    {
        System.err.println("Service '"+service+"' method '"+method+"': postcondition error");
        System.err.println("  ==> "+message);
        throw new ContractError("Le contrat n'est pas respecté !");
    }
}
