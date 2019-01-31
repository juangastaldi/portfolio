package jgastaldi.portfolio.service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgastaldi.portfolio.dto.AssetsDTO;
import jgastaldi.portfolio.dto.AssetsProfitDTO;
import jgastaldi.portfolio.dto.PortfolioDTO;
import jgastaldi.portfolio.model.Assets;
import jgastaldi.portfolio.model.AssetsType;
import jgastaldi.portfolio.model.Person;
import jgastaldi.portfolio.model.Transaction;
import jgastaldi.portfolio.model.TransactionType;
import jgastaldi.portfolio.repository.AssetsRepository;
import jgastaldi.portfolio.repository.PriceRepository;
import jgastaldi.portfolio.repository.TransactionRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AssetsRepository assetsRepository;

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public PortfolioDTO builPorfolio(Person person) {
		List<AssetsDTO> assetsDTOList = assetsRepository.findPortfolioByPerson(person);
		List<Assets> assetsList = new ArrayList<Assets>();
		for (AssetsDTO dto : assetsDTOList) {
			Assets assets = new Assets();
			BeanUtils.copyProperties(dto, assets);
			assets.setPurchasePrice(getAssetsPurchasePrice(assets));
			assetsList.add(assets);
		}
		List<Assets> oldAssets = assetsRepository.findAllByPerson(person);
		assetsRepository.deleteAll(oldAssets);
		assetsRepository.saveAll(assetsList);
		PortfolioDTO portfolio = new PortfolioDTO(assetsList);
		return portfolio;
	}

	@Override
	public Double getAssetsPurchasePrice(Assets assets) {
		List<Transaction> buyHistory = transactionRepository.findByAssetsAndTransactionType(assets.getPerson(),
				assets.getAssetsType(), new TransactionType(1L));
		Double amount = assets.getAmount();
		Double price = 0.0;
		for (Transaction transaction : buyHistory) {
			if (transaction.getAmount() < amount) {
				price += transaction.getAmount() * transaction.getPrice();
				amount -= transaction.getAmount();
			} else {
				price += amount * transaction.getPrice();
				break;
			}
		}
		return price / assets.getAmount();
	}

	@Override
	public Double getPortfolioValue(Person person) {
		Double price = 0.0;
		List<Assets> assetsList = assetsRepository.findAllByPerson(person);
		for (Assets assets : assetsList) {
			if (assets.getAssetsType().getCurrency().equals(Currency.getInstance("EUR"))) {
				price += assets.getAmount() * priceRepository.getByAssetsType(assets.getAssetsType()).getBuyPrice()
						* priceRepository.getByAssetsType(new AssetsType(2L)).getBuyPrice();
			} else {
				price += assets.getAmount() * priceRepository.getByAssetsType(assets.getAssetsType()).getBuyPrice();
			}

		}
		return price;
	}

	@Override
	public List<AssetsProfitDTO> getPortfolioProfit(Person person) {
		List<Assets> assetsList = assetsRepository.findAllByPerson(person);
		List<AssetsProfitDTO> assetsProfit = new ArrayList<AssetsProfitDTO>();
		for (Assets assets : assetsList) {
			AssetsProfitDTO dto = new AssetsProfitDTO();
			BeanUtils.copyProperties(assets, dto);
			dto.setCurrentPrice(priceRepository.getByAssetsType(assets.getAssetsType()).getBuyPrice());
			dto.setProfit(dto.getAmount() * (dto.getCurrentPrice() - dto.getPurchasePrice()));
			assetsProfit.add(dto);
		}
		return assetsProfit;
	}
}
