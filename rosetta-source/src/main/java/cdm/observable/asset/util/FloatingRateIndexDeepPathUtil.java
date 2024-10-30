package cdm.observable.asset.util;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FloatingRateIndexDeepPathUtil {
	public Boolean chooseIsExchangeListed(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<Boolean>map("getIsExchangeListed", _interestRateIndex -> _interestRateIndex.getIsExchangeListed()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Boolean>map("getIsExchangeListed", _inflationIndex -> _inflationIndex.getIsExchangeListed()).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<AssetIdentifier>mapC("getIdentifier", _interestRateIndex -> _interestRateIndex.getIdentifier()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<AssetIdentifier>mapC("getIdentifier", _inflationIndex -> _inflationIndex.getIdentifier()).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public LegalEntity chooseProvider(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<LegalEntity>map("getProvider", _interestRateIndex -> _interestRateIndex.getProvider()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>map("getProvider", _inflationIndex -> _inflationIndex.getProvider()).get();
		}
		return null;
	}
	
	public List<LegalEntity> chooseRelatedExchange(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<LegalEntity>mapC("getRelatedExchange", _interestRateIndex -> _interestRateIndex.getRelatedExchange()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>mapC("getRelatedExchange", _inflationIndex -> _inflationIndex.getRelatedExchange()).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public FieldWithMetaString chooseName(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<FieldWithMetaString>map("getName", _interestRateIndex -> _interestRateIndex.getName()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<FieldWithMetaString>map("getName", _inflationIndex -> _inflationIndex.getName()).get();
		}
		return null;
	}
	
	public Period chooseIndexTenor(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<Period>map("getIndexTenor", _interestRateIndex -> _interestRateIndex.getIndexTenor()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Period>map("getIndexTenor", _inflationIndex -> _inflationIndex.getIndexTenor()).get();
		}
		return null;
	}
	
	public LegalEntity chooseExchange(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<LegalEntity>map("getExchange", _interestRateIndex -> _interestRateIndex.getExchange()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>map("getExchange", _inflationIndex -> _inflationIndex.getExchange()).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<Taxonomy>mapC("getTaxonomy", _interestRateIndex -> _interestRateIndex.getTaxonomy()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Taxonomy>mapC("getTaxonomy", _inflationIndex -> _inflationIndex.getTaxonomy()).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
	public AssetClassEnum chooseAssetClass(FloatingRateIndex floatingRateIndex) {
		final MapperS<InterestRateIndex> interestRateIndex = MapperS.of(floatingRateIndex).<InterestRateIndex>map("getInterestRateIndex", _floatingRateIndex -> _floatingRateIndex.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<AssetClassEnum>map("getAssetClass", _interestRateIndex -> _interestRateIndex.getAssetClass()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(floatingRateIndex).<InflationIndex>map("getInflationIndex", _floatingRateIndex -> _floatingRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<AssetClassEnum>map("getAssetClass", _inflationIndex -> _inflationIndex.getAssetClass()).get();
		}
		return null;
	}
	
}
