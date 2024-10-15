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
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.ExchangeTradedOption;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionBuilder;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionBuilderImpl;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionImpl;
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.ExerciseStyleEnum;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.OptionElement;
import fpml.confirmation.OptionElement.OptionElementBuilder;
import fpml.confirmation.OptionElement.OptionElementBuilderImpl;
import fpml.confirmation.OptionElement.OptionElementImpl;
import fpml.confirmation.ProductReference;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.OptionElementMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Identifies the underlying asset when it is a listed option contract.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionElement", builder=OptionElement.OptionElementBuilderImpl.class, version="${project.version}")
public interface OptionElement extends ExchangeTradedOption {

	OptionElementMeta metaData = new OptionElementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	OptionElement build();
	
	OptionElement.OptionElementBuilder toBuilder();
	
	static OptionElement.OptionElementBuilder builder() {
		return new OptionElement.OptionElementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionElement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionElement> getType() {
		return OptionElement.class;
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
		processRosetta(path.newSubPath("exchangeTradedOptionSequence"), processor, ExchangeTradedOptionSequence.class, getExchangeTradedOptionSequence());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("exerciseStyle"), ExerciseStyleEnum.class, getExerciseStyle(), this);
		processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionElementBuilder extends OptionElement, ExchangeTradedOption.ExchangeTradedOptionBuilder {
		OptionElement.OptionElementBuilder setId(String id);
		OptionElement.OptionElementBuilder addInstrumentId(InstrumentId instrumentId0);
		OptionElement.OptionElementBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		OptionElement.OptionElementBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		OptionElement.OptionElementBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		OptionElement.OptionElementBuilder setDescription(String description);
		OptionElement.OptionElementBuilder setCurrency(IdentifiedCurrency currency);
		OptionElement.OptionElementBuilder setExchangeId(ExchangeId exchangeId);
		OptionElement.OptionElementBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		OptionElement.OptionElementBuilder setDefinition(ProductReference definition);
		OptionElement.OptionElementBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		OptionElement.OptionElementBuilder setMultiplier(BigDecimal multiplier);
		OptionElement.OptionElementBuilder setContractReference(String contractReference);
		OptionElement.OptionElementBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		OptionElement.OptionElementBuilder setExchangeTradedOptionSequence(ExchangeTradedOptionSequence exchangeTradedOptionSequence);
		OptionElement.OptionElementBuilder setOptionType(PutCallEnum optionType);
		OptionElement.OptionElementBuilder setExerciseStyle(ExerciseStyleEnum exerciseStyle);
		OptionElement.OptionElementBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer);
		OptionElement.OptionElementBuilder setSettlementType(SettlementTypeEnum settlementType);

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
			processRosetta(path.newSubPath("exchangeTradedOptionSequence"), processor, ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder.class, getExchangeTradedOptionSequence());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("exerciseStyle"), ExerciseStyleEnum.class, getExerciseStyle(), this);
			processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		}
		

		OptionElement.OptionElementBuilder prune();
	}

	/*********************** Immutable Implementation of OptionElement  ***********************/
	class OptionElementImpl extends ExchangeTradedOption.ExchangeTradedOptionImpl implements OptionElement {
		
		protected OptionElementImpl(OptionElement.OptionElementBuilder builder) {
			super(builder);
		}
		
		@Override
		public OptionElement build() {
			return this;
		}
		
		@Override
		public OptionElement.OptionElementBuilder toBuilder() {
			OptionElement.OptionElementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionElement.OptionElementBuilder builder) {
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
			return "OptionElement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionElement  ***********************/
	class OptionElementBuilderImpl extends ExchangeTradedOption.ExchangeTradedOptionBuilderImpl  implements OptionElement.OptionElementBuilder {
	
	
		public OptionElementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public OptionElement.OptionElementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public OptionElement.OptionElementBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public OptionElement.OptionElementBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public OptionElement.OptionElementBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public OptionElement.OptionElementBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public OptionElement.OptionElementBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public OptionElement.OptionElementBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public OptionElement.OptionElementBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public OptionElement.OptionElementBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public OptionElement.OptionElementBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public OptionElement.OptionElementBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public OptionElement.OptionElementBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("contractReference")
		public OptionElement.OptionElementBuilder setContractReference(String contractReference) {
			this.contractReference = contractReference==null?null:contractReference;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public OptionElement.OptionElementBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeTradedOptionSequence")
		public OptionElement.OptionElementBuilder setExchangeTradedOptionSequence(ExchangeTradedOptionSequence exchangeTradedOptionSequence) {
			this.exchangeTradedOptionSequence = exchangeTradedOptionSequence==null?null:exchangeTradedOptionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public OptionElement.OptionElementBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseStyle")
		public OptionElement.OptionElementBuilder setExerciseStyle(ExerciseStyleEnum exerciseStyle) {
			this.exerciseStyle = exerciseStyle==null?null:exerciseStyle;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public OptionElement.OptionElementBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public OptionElement.OptionElementBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		
		@Override
		public OptionElement build() {
			return new OptionElement.OptionElementImpl(this);
		}
		
		@Override
		public OptionElement.OptionElementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionElement.OptionElementBuilder prune() {
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
		public OptionElement.OptionElementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionElement.OptionElementBuilder o = (OptionElement.OptionElementBuilder) other;
			
			
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
			return "OptionElementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
