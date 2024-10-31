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
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.ExchangeTradedOption;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionBuilder;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionBuilderImpl;
import fpml.confirmation.ExchangeTradedOption.ExchangeTradedOptionImpl;
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.ExerciseStyleEnum;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.ExchangeTradedOptionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An exchange traded option.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeTradedOption", builder=ExchangeTradedOption.ExchangeTradedOptionBuilderImpl.class, version="${project.version}")
public interface ExchangeTradedOption extends ExchangeTradedContract {

	ExchangeTradedOptionMeta metaData = new ExchangeTradedOptionMeta();

	/*********************** Getter Methods  ***********************/
	ExchangeTradedOptionSequence getExchangeTradedOptionSequence();
	/**
	 * Specifies whether the option allows the holder to buy or sell tne underlying asset.
	 */
	PutCallEnum getOptionType();
	/**
	 * Specifies the exercise style of the option {American, Bermuda, European}
	 */
	ExerciseStyleEnum getExerciseStyle();
	/**
	 * Underlyer of the option e.g. a listed future.
	 */
	ExchangeTradedContractUnderlyer getUnderlyer();
	/**
	 * Settlement method for the contract (Cash, Physical). This value is used to populate the &quot;Delivery Type&quot; field for regulatory reporting (CFTC, ESMA).
	 */
	SettlementTypeEnum getSettlementType();

	/*********************** Build Methods  ***********************/
	ExchangeTradedOption build();
	
	ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder();
	
	static ExchangeTradedOption.ExchangeTradedOptionBuilder builder() {
		return new ExchangeTradedOption.ExchangeTradedOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedOption> getType() {
		return ExchangeTradedOption.class;
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
	interface ExchangeTradedOptionBuilder extends ExchangeTradedOption, ExchangeTradedContract.ExchangeTradedContractBuilder {
		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder getOrCreateExchangeTradedOptionSequence();
		ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder getExchangeTradedOptionSequence();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer();
		ExchangeTradedOption.ExchangeTradedOptionBuilder setId(String id);
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId0);
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setDescription(String description);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setCurrency(IdentifiedCurrency currency);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeId(ExchangeId exchangeId);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setDefinition(ProductReference definition);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setMultiplier(BigDecimal multiplier);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setContractReference(String contractReference);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeTradedOptionSequence(ExchangeTradedOptionSequence exchangeTradedOptionSequence);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionType(PutCallEnum optionType);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExerciseStyle(ExerciseStyleEnum exerciseStyle);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setSettlementType(SettlementTypeEnum settlementType);

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
		

		ExchangeTradedOption.ExchangeTradedOptionBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedOption  ***********************/
	class ExchangeTradedOptionImpl extends ExchangeTradedContract.ExchangeTradedContractImpl implements ExchangeTradedOption {
		private final ExchangeTradedOptionSequence exchangeTradedOptionSequence;
		private final PutCallEnum optionType;
		private final ExerciseStyleEnum exerciseStyle;
		private final ExchangeTradedContractUnderlyer underlyer;
		private final SettlementTypeEnum settlementType;
		
		protected ExchangeTradedOptionImpl(ExchangeTradedOption.ExchangeTradedOptionBuilder builder) {
			super(builder);
			this.exchangeTradedOptionSequence = ofNullable(builder.getExchangeTradedOptionSequence()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.exerciseStyle = builder.getExerciseStyle();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
		}
		
		@Override
		@RosettaAttribute("exchangeTradedOptionSequence")
		public ExchangeTradedOptionSequence getExchangeTradedOptionSequence() {
			return exchangeTradedOptionSequence;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		public ExerciseStyleEnum getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public ExchangeTradedContractUnderlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public ExchangeTradedOption build() {
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder() {
			ExchangeTradedOption.ExchangeTradedOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedOption.ExchangeTradedOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangeTradedOptionSequence()).ifPresent(builder::setExchangeTradedOptionSequence);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getExerciseStyle()).ifPresent(builder::setExerciseStyle);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedOption _that = getType().cast(o);
		
			if (!Objects.equals(exchangeTradedOptionSequence, _that.getExchangeTradedOptionSequence())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeTradedOptionSequence != null ? exchangeTradedOptionSequence.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOption {" +
				"exchangeTradedOptionSequence=" + this.exchangeTradedOptionSequence + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedOption  ***********************/
	class ExchangeTradedOptionBuilderImpl extends ExchangeTradedContract.ExchangeTradedContractBuilderImpl  implements ExchangeTradedOption.ExchangeTradedOptionBuilder {
	
		protected ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder exchangeTradedOptionSequence;
		protected PutCallEnum optionType;
		protected ExerciseStyleEnum exerciseStyle;
		protected ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
	
		public ExchangeTradedOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exchangeTradedOptionSequence")
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder getExchangeTradedOptionSequence() {
			return exchangeTradedOptionSequence;
		}
		
		@Override
		public ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder getOrCreateExchangeTradedOptionSequence() {
			ExchangeTradedOptionSequence.ExchangeTradedOptionSequenceBuilder result;
			if (exchangeTradedOptionSequence!=null) {
				result = exchangeTradedOptionSequence;
			}
			else {
				result = exchangeTradedOptionSequence = ExchangeTradedOptionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		public ExerciseStyleEnum getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = ExchangeTradedContractUnderlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("id")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("contractReference")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setContractReference(String contractReference) {
			this.contractReference = contractReference==null?null:contractReference;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeTradedOptionSequence")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeTradedOptionSequence(ExchangeTradedOptionSequence exchangeTradedOptionSequence) {
			this.exchangeTradedOptionSequence = exchangeTradedOptionSequence==null?null:exchangeTradedOptionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseStyle")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExerciseStyle(ExerciseStyleEnum exerciseStyle) {
			this.exerciseStyle = exerciseStyle==null?null:exerciseStyle;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		
		@Override
		public ExchangeTradedOption build() {
			return new ExchangeTradedOption.ExchangeTradedOptionImpl(this);
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder prune() {
			super.prune();
			if (exchangeTradedOptionSequence!=null && !exchangeTradedOptionSequence.prune().hasData()) exchangeTradedOptionSequence = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangeTradedOptionSequence()!=null && getExchangeTradedOptionSequence().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getExerciseStyle()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeTradedOption.ExchangeTradedOptionBuilder o = (ExchangeTradedOption.ExchangeTradedOptionBuilder) other;
			
			merger.mergeRosetta(getExchangeTradedOptionSequence(), o.getExchangeTradedOptionSequence(), this::setExchangeTradedOptionSequence);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getExerciseStyle(), o.getExerciseStyle(), this::setExerciseStyle);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedOption _that = getType().cast(o);
		
			if (!Objects.equals(exchangeTradedOptionSequence, _that.getExchangeTradedOptionSequence())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeTradedOptionSequence != null ? exchangeTradedOptionSequence.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOptionBuilder {" +
				"exchangeTradedOptionSequence=" + this.exchangeTradedOptionSequence + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}
}
