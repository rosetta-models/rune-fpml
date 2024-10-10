package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FxRateAsset;
import fpml.confirmation.FxRateAsset.FxRateAssetBuilder;
import fpml.confirmation.FxRateAsset.FxRateAssetBuilderImpl;
import fpml.confirmation.FxRateAsset.FxRateAssetImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.FxRateAssetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxRateAsset", builder=FxRateAsset.FxRateAssetBuilderImpl.class, version="${project.version}")
public interface FxRateAsset extends UnderlyingAssetType {

	FxRateAssetMeta metaData = new FxRateAssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Defines the source of the FX rate.
	 */
	FxSpotRateSource getRateSource();

	/*********************** Build Methods  ***********************/
	FxRateAsset build();
	
	FxRateAsset.FxRateAssetBuilder toBuilder();
	
	static FxRateAsset.FxRateAssetBuilder builder() {
		return new FxRateAsset.FxRateAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateAsset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRateAsset> getType() {
		return FxRateAsset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("rateSource"), processor, FxSpotRateSource.class, getRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateAssetBuilder extends FxRateAsset, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getRateSource();
		FxRateAsset.FxRateAssetBuilder setId(String id);
		FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId0);
		FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		FxRateAsset.FxRateAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		FxRateAsset.FxRateAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		FxRateAsset.FxRateAssetBuilder setDescription(String description);
		FxRateAsset.FxRateAssetBuilder setCurrency(IdentifiedCurrency currency);
		FxRateAsset.FxRateAssetBuilder setExchangeId(ExchangeId exchangeId);
		FxRateAsset.FxRateAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		FxRateAsset.FxRateAssetBuilder setDefinition(ProductReference definition);
		FxRateAsset.FxRateAssetBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxRateAsset.FxRateAssetBuilder setRateSource(FxSpotRateSource rateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("rateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getRateSource());
		}
		

		FxRateAsset.FxRateAssetBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateAsset  ***********************/
	class FxRateAssetImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements FxRateAsset {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final FxSpotRateSource rateSource;
		
		protected FxRateAssetImpl(FxRateAsset.FxRateAssetBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public FxSpotRateSource getRateSource() {
			return rateSource;
		}
		
		@Override
		public FxRateAsset build() {
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder toBuilder() {
			FxRateAsset.FxRateAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateAsset.FxRateAssetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateAsset _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateAsset {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rateSource=" + this.rateSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRateAsset  ***********************/
	class FxRateAssetBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements FxRateAsset.FxRateAssetBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected FxSpotRateSource.FxSpotRateSourceBuilder rateSource;
	
		public FxRateAssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxRateAsset.FxRateAssetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public FxRateAsset.FxRateAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public FxRateAsset.FxRateAssetBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FxRateAsset.FxRateAssetBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public FxRateAsset.FxRateAssetBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public FxRateAsset.FxRateAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public FxRateAsset.FxRateAssetBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxRateAsset.FxRateAssetBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSource")
		public FxRateAsset.FxRateAssetBuilder setRateSource(FxSpotRateSource rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxRateAsset build() {
			return new FxRateAsset.FxRateAssetImpl(this);
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateAsset.FxRateAssetBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRateSource()!=null && getRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateAsset.FxRateAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxRateAsset.FxRateAssetBuilder o = (FxRateAsset.FxRateAssetBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateAsset _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateAssetBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rateSource=" + this.rateSource +
			'}' + " " + super.toString();
		}
	}
}
