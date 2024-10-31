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
import fpml.confirmation.Fx;
import fpml.confirmation.Fx.FxBuilder;
import fpml.confirmation.Fx.FxBuilderImpl;
import fpml.confirmation.Fx.FxImpl;
import fpml.confirmation.FxRateAsset;
import fpml.confirmation.FxRateAsset.FxRateAssetBuilder;
import fpml.confirmation.FxRateAsset.FxRateAssetBuilderImpl;
import fpml.confirmation.FxRateAsset.FxRateAssetImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Identifies a simple underlying asset type that is an FX rate. Used for specifying FX rates in the pricing and risk model.
 * @version ${project.version}
 */
@RosettaDataType(value="Fx", builder=Fx.FxBuilderImpl.class, version="${project.version}")
public interface Fx extends FxRateAsset {

	FxMeta metaData = new FxMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Fx build();
	
	Fx.FxBuilder toBuilder();
	
	static Fx.FxBuilder builder() {
		return new Fx.FxBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Fx> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Fx> getType() {
		return Fx.class;
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
	interface FxBuilder extends Fx, FxRateAsset.FxRateAssetBuilder {
		Fx.FxBuilder setId(String id);
		Fx.FxBuilder addInstrumentId(InstrumentId instrumentId0);
		Fx.FxBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Fx.FxBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Fx.FxBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Fx.FxBuilder setDescription(String description);
		Fx.FxBuilder setCurrency(IdentifiedCurrency currency);
		Fx.FxBuilder setExchangeId(ExchangeId exchangeId);
		Fx.FxBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Fx.FxBuilder setDefinition(ProductReference definition);
		Fx.FxBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		Fx.FxBuilder setRateSource(FxSpotRateSource rateSource);

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
		

		Fx.FxBuilder prune();
	}

	/*********************** Immutable Implementation of Fx  ***********************/
	class FxImpl extends FxRateAsset.FxRateAssetImpl implements Fx {
		
		protected FxImpl(Fx.FxBuilder builder) {
			super(builder);
		}
		
		@Override
		public Fx build() {
			return this;
		}
		
		@Override
		public Fx.FxBuilder toBuilder() {
			Fx.FxBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Fx.FxBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Fx {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Fx  ***********************/
	class FxBuilderImpl extends FxRateAsset.FxRateAssetBuilderImpl  implements Fx.FxBuilder {
	
	
		public FxBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public Fx.FxBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Fx.FxBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Fx.FxBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Fx.FxBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Fx.FxBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Fx.FxBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Fx.FxBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Fx.FxBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Fx.FxBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Fx.FxBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public Fx.FxBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSource")
		public Fx.FxBuilder setRateSource(FxSpotRateSource rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		
		@Override
		public Fx build() {
			return new Fx.FxImpl(this);
		}
		
		@Override
		public Fx.FxBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fx.FxBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fx.FxBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Fx.FxBuilder o = (Fx.FxBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
