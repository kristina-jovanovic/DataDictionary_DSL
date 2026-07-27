namespace DataDictionary.Transformation
{
    // Deli sekvencijalne id-jeve izlaznim kontrolama.
    // Jedan isti IdProvider se koristi kroz celu gradnju (deljeni brojac), pa
    // ako se id dodeljuje kontroli PRE rekurzije u njenu decu, dobija se
    // pre-order (dubinska) numeracija identicna ciljnom JSON-u (koren=1, pa 2,3,...).
    public sealed class IdProvider
    {
        private int _next;

        public IdProvider(int start = 1) => _next = start;

        // Vraca sledeci slobodan id i pomera brojac.
        public int Next() => _next++;
    }
}
