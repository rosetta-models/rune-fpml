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
import fpml.confirmation.EquityAsset;
import fpml.confirmation.EquityAsset.EquityAssetBuilder;
import fpml.confirmation.EquityAsset.EquityAssetBuilderImpl;
import fpml.confirmation.EquityAsset.EquityAssetImpl;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilder;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilderImpl;
import fpml.confirmation.ExchangeTraded.ExchangeTradedImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.EquityAssetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An exchange traded equity asset.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityAsset", builder=EquityAsset.EquityAssetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityAsset extends ExchangeTraded {

	EquityAssetMeta metaData = new EquityAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	EquityAsset build();
	
	EquityAsset.EquityAssetBuilder toBuilder();
	
	static EquityAsset.EquityAssetBuilder builder() {
		return new EquityAsset.EquityAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityAsset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityAsset> getType() {
		return EquityAsset.class;
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
		processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.class, getExchangeIdentifierModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityAssetBuilder extends EquityAsset, ExchangeTraded.ExchangeTradedBuilder {
		EquityAsset.EquityAssetBuilder setId(String id);
		EquityAsset.EquityAssetBuilder addInstrumentId(InstrumentId instrumentId0);
		EquityAsset.EquityAssetBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		EquityAsset.EquityAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		EquityAsset.EquityAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		EquityAsset.EquityAssetBuilder setDescription(String description);
		EquityAsset.EquityAssetBuilder setCurrency(IdentifiedCurrency currency);
		EquityAsset.EquityAssetBuilder setExchangeId(ExchangeId exchangeId);
		EquityAsset.EquityAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		EquityAsset.EquityAssetBuilder setDefinition(ProductReference definition);
		EquityAsset.EquityAssetBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.ExchangeIdentifierModelBuilder.class, getExchangeIdentifierModel());
		}
		

		EquityAsset.EquityAssetBuilder prune();
	}

	/*********************** Immutable Implementation of EquityAsset  ***********************/
	class EquityAssetImpl extends ExchangeTraded.ExchangeTradedImpl implements EquityAsset {
		
		protected EquityAssetImpl(EquityAsset.EquityAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public EquityAsset build() {
			return this;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder toBuilder() {
			EquityAsset.EquityAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityAsset.EquityAssetBuilder builder) {
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
			return "EquityAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityAsset  ***********************/
	class EquityAssetBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl  implements EquityAsset.EquityAssetBuilder {
	
	
		public EquityAssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public EquityAsset.EquityAssetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public EquityAsset.EquityAssetBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public EquityAsset.EquityAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EquityAsset.EquityAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public EquityAsset.EquityAssetBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public EquityAsset.EquityAssetBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public EquityAsset.EquityAssetBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public EquityAsset.EquityAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public EquityAsset.EquityAssetBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public EquityAsset.EquityAssetBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		
		@Override
		public EquityAsset build() {
			return new EquityAsset.EquityAssetImpl(this);
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAsset.EquityAssetBuilder prune() {
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
		public EquityAsset.EquityAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityAsset.EquityAssetBuilder o = (EquityAsset.EquityAssetBuilder) other;
			
			
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
			return "EquityAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
