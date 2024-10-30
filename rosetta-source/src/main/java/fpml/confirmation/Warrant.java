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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractBuilder;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractBuilderImpl;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.Warrant;
import fpml.confirmation.Warrant.WarrantBuilder;
import fpml.confirmation.Warrant.WarrantBuilderImpl;
import fpml.confirmation.Warrant.WarrantImpl;
import fpml.confirmation.meta.WarrantMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Defines the underlying asset when it is a warrant.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Warrant", builder=Warrant.WarrantBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Warrant extends ExchangeTradedContract {

	WarrantMeta metaData = new WarrantMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Warrant build();
	
	Warrant.WarrantBuilder toBuilder();
	
	static Warrant.WarrantBuilder builder() {
		return new Warrant.WarrantBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Warrant> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Warrant> getType() {
		return Warrant.class;
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
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WarrantBuilder extends Warrant, ExchangeTradedContract.ExchangeTradedContractBuilder {
		Warrant.WarrantBuilder setId(String id);
		Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId0);
		Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Warrant.WarrantBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Warrant.WarrantBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Warrant.WarrantBuilder setDescription(String description);
		Warrant.WarrantBuilder setCurrency(IdentifiedCurrency currency);
		Warrant.WarrantBuilder setExchangeId(ExchangeId exchangeId);
		Warrant.WarrantBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Warrant.WarrantBuilder setDefinition(ProductReference definition);
		Warrant.WarrantBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		Warrant.WarrantBuilder setMultiplier(BigDecimal multiplier);
		Warrant.WarrantBuilder setContractReference(String contractReference);
		Warrant.WarrantBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);

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
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
		}
		

		Warrant.WarrantBuilder prune();
	}

	/*********************** Immutable Implementation of Warrant  ***********************/
	class WarrantImpl extends ExchangeTradedContract.ExchangeTradedContractImpl implements Warrant {
		
		protected WarrantImpl(Warrant.WarrantBuilder builder) {
			super(builder);
		}
		
		@Override
		public Warrant build() {
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder toBuilder() {
			Warrant.WarrantBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Warrant.WarrantBuilder builder) {
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
			return "Warrant {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Warrant  ***********************/
	class WarrantBuilderImpl extends ExchangeTradedContract.ExchangeTradedContractBuilderImpl  implements Warrant.WarrantBuilder {
	
	
		public WarrantBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public Warrant.WarrantBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Warrant.WarrantBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Warrant.WarrantBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Warrant.WarrantBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Warrant.WarrantBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Warrant.WarrantBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Warrant.WarrantBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Warrant.WarrantBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public Warrant.WarrantBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public Warrant.WarrantBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("contractReference")
		public Warrant.WarrantBuilder setContractReference(String contractReference) {
			this.contractReference = contractReference==null?null:contractReference;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public Warrant.WarrantBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		
		@Override
		public Warrant build() {
			return new Warrant.WarrantImpl(this);
		}
		
		@Override
		public Warrant.WarrantBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Warrant.WarrantBuilder prune() {
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
		public Warrant.WarrantBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Warrant.WarrantBuilder o = (Warrant.WarrantBuilder) other;
			
			
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
			return "WarrantBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
