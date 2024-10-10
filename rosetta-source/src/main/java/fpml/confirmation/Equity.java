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
import fpml.confirmation.Equity;
import fpml.confirmation.Equity.EquityBuilder;
import fpml.confirmation.Equity.EquityBuilderImpl;
import fpml.confirmation.Equity.EquityImpl;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.EquityAsset.EquityAssetBuilder;
import fpml.confirmation.EquityAsset.EquityAssetBuilderImpl;
import fpml.confirmation.EquityAsset.EquityAssetImpl;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.EquityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Identifies the underlying asset when it is a listed equity.
 * @version ${project.version}
 */
@RosettaDataType(value="Equity", builder=Equity.EquityBuilderImpl.class, version="${project.version}")
public interface Equity extends EquityAsset {

	EquityMeta metaData = new EquityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Equity build();
	
	Equity.EquityBuilder toBuilder();
	
	static Equity.EquityBuilder builder() {
		return new Equity.EquityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Equity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Equity> getType() {
		return Equity.class;
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
	interface EquityBuilder extends Equity, EquityAsset.EquityAssetBuilder {
		Equity.EquityBuilder setId(String id);
		Equity.EquityBuilder addInstrumentId(InstrumentId instrumentId0);
		Equity.EquityBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Equity.EquityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Equity.EquityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Equity.EquityBuilder setDescription(String description);
		Equity.EquityBuilder setCurrency(IdentifiedCurrency currency);
		Equity.EquityBuilder setExchangeId(ExchangeId exchangeId);
		Equity.EquityBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Equity.EquityBuilder setDefinition(ProductReference definition);
		Equity.EquityBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);

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
		

		Equity.EquityBuilder prune();
	}

	/*********************** Immutable Implementation of Equity  ***********************/
	class EquityImpl extends EquityAsset.EquityAssetImpl implements Equity {
		
		protected EquityImpl(Equity.EquityBuilder builder) {
			super(builder);
		}
		
		@Override
		public Equity build() {
			return this;
		}
		
		@Override
		public Equity.EquityBuilder toBuilder() {
			Equity.EquityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Equity.EquityBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "Equity {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Equity  ***********************/
	class EquityBuilderImpl extends EquityAsset.EquityAssetBuilderImpl  implements Equity.EquityBuilder {
	
	
		public EquityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public Equity.EquityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Equity.EquityBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Equity.EquityBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Equity.EquityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public Equity.EquityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Equity.EquityBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Equity.EquityBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Equity.EquityBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Equity.EquityBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Equity.EquityBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public Equity.EquityBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		
		@Override
		public Equity build() {
			return new Equity.EquityImpl(this);
		}
		
		@Override
		public Equity.EquityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Equity.EquityBuilder prune() {
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
		public Equity.EquityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Equity.EquityBuilder o = (Equity.EquityBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "EquityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
