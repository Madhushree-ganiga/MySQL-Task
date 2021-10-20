
public interface MarketDetailsDAO {
	boolean save(MarketDetailsDTO dto);

	boolean update(MarketDetailsDTO dto);

	boolean getByLocation(MarketDetailsDTO dto);

	boolean getAll(MarketDetailsDTO dto);

	boolean deleteByName(MarketDetailsDTO dto);

}
