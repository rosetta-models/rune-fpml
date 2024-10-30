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
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilder;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilderImpl;
import fpml.confirmation.ExchangeTraded.ExchangeTradedImpl;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractBuilder;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractBuilderImpl;
import fpml.confirmation.ExchangeTradedContract.ExchangeTradedContractImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.ExchangeTradedContractMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An exchange traded derivative contract.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExchangeTradedContract", builder=ExchangeTradedContract.ExchangeTradedContractBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExchangeTradedContract extends ExchangeTraded {

	ExchangeTradedContractMeta metaData = new ExchangeTradedContractMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the contract multiplier that can be associated with the number of units.
	 */
	BigDecimal getMultiplier();
	/**
	 * Specifies the contract that can be referenced, besides the undelyer type.
	 */
	String getContractReference();
	/**
	 * The date when the contract expires.
	 */
	AdjustableOrRelativeDate getExpirationDate();

	/*********************** Build Methods  ***********************/
	ExchangeTradedContract build();
	
	ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder();
	
	static ExchangeTradedContract.ExchangeTradedContractBuilder builder() {
		return new ExchangeTradedContract.ExchangeTradedContractBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedContract> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedContract> getType() {
		return ExchangeTradedContract.class;
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
	interface ExchangeTradedContractBuilder extends ExchangeTradedContract, ExchangeTraded.ExchangeTradedBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		ExchangeTradedContract.ExchangeTradedContractBuilder setId(String id);
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId0);
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ExchangeTradedContract.ExchangeTradedContractBuilder setDescription(String description);
		ExchangeTradedContract.ExchangeTradedContractBuilder setCurrency(IdentifiedCurrency currency);
		ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeId(ExchangeId exchangeId);
		ExchangeTradedContract.ExchangeTradedContractBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ExchangeTradedContract.ExchangeTradedContractBuilder setDefinition(ProductReference definition);
		ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		ExchangeTradedContract.ExchangeTradedContractBuilder setMultiplier(BigDecimal multiplier);
		ExchangeTradedContract.ExchangeTradedContractBuilder setContractReference(String contractReference);
		ExchangeTradedContract.ExchangeTradedContractBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);

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
		

		ExchangeTradedContract.ExchangeTradedContractBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedContract  ***********************/
	class ExchangeTradedContractImpl extends ExchangeTraded.ExchangeTradedImpl implements ExchangeTradedContract {
		private final BigDecimal multiplier;
		private final String contractReference;
		private final AdjustableOrRelativeDate expirationDate;
		
		protected ExchangeTradedContractImpl(ExchangeTradedContract.ExchangeTradedContractBuilder builder) {
			super(builder);
			this.multiplier = builder.getMultiplier();
			this.contractReference = builder.getContractReference();
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("contractReference")
		public String getContractReference() {
			return contractReference;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public ExchangeTradedContract build() {
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder() {
			ExchangeTradedContract.ExchangeTradedContractBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedContract.ExchangeTradedContractBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getContractReference()).ifPresent(builder::setContractReference);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedContract _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContract {" +
				"multiplier=" + this.multiplier + ", " +
				"contractReference=" + this.contractReference + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedContract  ***********************/
	class ExchangeTradedContractBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl  implements ExchangeTradedContract.ExchangeTradedContractBuilder {
	
		protected BigDecimal multiplier;
		protected String contractReference;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
	
		public ExchangeTradedContractBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("contractReference")
		public String getContractReference() {
			return contractReference;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("contractReference")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setContractReference(String contractReference) {
			this.contractReference = contractReference==null?null:contractReference;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public ExchangeTradedContract.ExchangeTradedContractBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeTradedContract build() {
			return new ExchangeTradedContract.ExchangeTradedContractImpl(this);
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null) return true;
			if (getContractReference()!=null) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeTradedContract.ExchangeTradedContractBuilder o = (ExchangeTradedContract.ExchangeTradedContractBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeBasic(getContractReference(), o.getContractReference(), this::setContractReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedContract _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"contractReference=" + this.contractReference + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}
}
