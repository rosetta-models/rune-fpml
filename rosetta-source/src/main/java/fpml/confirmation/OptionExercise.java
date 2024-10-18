package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.ExerciseTimingEnum;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionExercise.OptionExerciseBuilder;
import fpml.confirmation.OptionExercise.OptionExerciseBuilderImpl;
import fpml.confirmation.OptionExercise.OptionExerciseImpl;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseSequence;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.OptionExerciseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing an option exercise. The OptionExercise type supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExercise", builder=OptionExercise.OptionExerciseBuilderImpl.class, version="${project.version}")
public interface OptionExercise extends AbstractEvent {

	OptionExerciseMeta metaData = new OptionExerciseMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getOptionSeller();
	PartyReference getOptionBuyer();
	/**
	 * Fully describes the original trade (prior to the exercise).
	 */
	Trade getOriginalTrade();
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	OptionExerciseSequence getOptionExerciseSequence();
	ExerciseTimingEnum getExerciseTiming();
	OptionExerciseAmountModel getOptionExerciseAmountModel();
	ExerciseSideEnum getExerciseSide();
	SettlementTypeEnum getSettlementType();
	SimplePayment getCashSettlement();
	PhysicalSettlement getPhysicalSettlement();
	NonNegativePayment getPayment();
	ClearingInstructions getClearingInstructions();

	/*********************** Build Methods  ***********************/
	OptionExercise build();
	
	OptionExercise.OptionExerciseBuilder toBuilder();
	
	static OptionExercise.OptionExerciseBuilder builder() {
		return new OptionExercise.OptionExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExercise> getType() {
		return OptionExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("optionSeller"), processor, PartyReference.class, getOptionSeller());
		processRosetta(path.newSubPath("optionBuyer"), processor, PartyReference.class, getOptionBuyer());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("optionExerciseSequence"), processor, OptionExerciseSequence.class, getOptionExerciseSequence());
		processor.processBasic(path.newSubPath("exerciseTiming"), ExerciseTimingEnum.class, getExerciseTiming(), this);
		processRosetta(path.newSubPath("optionExerciseAmountModel"), processor, OptionExerciseAmountModel.class, getOptionExerciseAmountModel());
		processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.class, getPhysicalSettlement());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.class, getClearingInstructions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseBuilder extends OptionExercise, AbstractEvent.AbstractEventBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOptionSeller();
		PartyReference.PartyReferenceBuilder getOptionSeller();
		PartyReference.PartyReferenceBuilder getOrCreateOptionBuyer();
		PartyReference.PartyReferenceBuilder getOptionBuyer();
		Trade.TradeBuilder getOrCreateOriginalTrade();
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		OptionExerciseSequence.OptionExerciseSequenceBuilder getOrCreateOptionExerciseSequence();
		OptionExerciseSequence.OptionExerciseSequenceBuilder getOptionExerciseSequence();
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOrCreateOptionExerciseAmountModel();
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOptionExerciseAmountModel();
		SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement();
		SimplePayment.SimplePaymentBuilder getCashSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment();
		NonNegativePayment.NonNegativePaymentBuilder getPayment();
		ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions();
		ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions();
		OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		OptionExercise.OptionExerciseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		OptionExercise.OptionExerciseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		OptionExercise.OptionExerciseBuilder setOptionSeller(PartyReference optionSeller);
		OptionExercise.OptionExerciseBuilder setOptionBuyer(PartyReference optionBuyer);
		OptionExercise.OptionExerciseBuilder setOriginalTrade(Trade originalTrade);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		OptionExercise.OptionExerciseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		OptionExercise.OptionExerciseBuilder setOptionExerciseSequence(OptionExerciseSequence optionExerciseSequence);
		OptionExercise.OptionExerciseBuilder setExerciseTiming(ExerciseTimingEnum exerciseTiming);
		OptionExercise.OptionExerciseBuilder setOptionExerciseAmountModel(OptionExerciseAmountModel optionExerciseAmountModel);
		OptionExercise.OptionExerciseBuilder setExerciseSide(ExerciseSideEnum exerciseSide);
		OptionExercise.OptionExerciseBuilder setSettlementType(SettlementTypeEnum settlementType);
		OptionExercise.OptionExerciseBuilder setCashSettlement(SimplePayment cashSettlement);
		OptionExercise.OptionExerciseBuilder setPhysicalSettlement(PhysicalSettlement physicalSettlement);
		OptionExercise.OptionExerciseBuilder setPayment(NonNegativePayment payment);
		OptionExercise.OptionExerciseBuilder setClearingInstructions(ClearingInstructions clearingInstructions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("optionSeller"), processor, PartyReference.PartyReferenceBuilder.class, getOptionSeller());
			processRosetta(path.newSubPath("optionBuyer"), processor, PartyReference.PartyReferenceBuilder.class, getOptionBuyer());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("optionExerciseSequence"), processor, OptionExerciseSequence.OptionExerciseSequenceBuilder.class, getOptionExerciseSequence());
			processor.processBasic(path.newSubPath("exerciseTiming"), ExerciseTimingEnum.class, getExerciseTiming(), this);
			processRosetta(path.newSubPath("optionExerciseAmountModel"), processor, OptionExerciseAmountModel.OptionExerciseAmountModelBuilder.class, getOptionExerciseAmountModel());
			processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.SimplePaymentBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.PhysicalSettlementBuilder.class, getPhysicalSettlement());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.ClearingInstructionsBuilder.class, getClearingInstructions());
		}
		

		OptionExercise.OptionExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExercise  ***********************/
	class OptionExerciseImpl extends AbstractEvent.AbstractEventImpl implements OptionExercise {
		private final PartyReference optionSeller;
		private final PartyReference optionBuyer;
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final OptionExerciseSequence optionExerciseSequence;
		private final ExerciseTimingEnum exerciseTiming;
		private final OptionExerciseAmountModel optionExerciseAmountModel;
		private final ExerciseSideEnum exerciseSide;
		private final SettlementTypeEnum settlementType;
		private final SimplePayment cashSettlement;
		private final PhysicalSettlement physicalSettlement;
		private final NonNegativePayment payment;
		private final ClearingInstructions clearingInstructions;
		
		protected OptionExerciseImpl(OptionExercise.OptionExerciseBuilder builder) {
			super(builder);
			this.optionSeller = ofNullable(builder.getOptionSeller()).map(f->f.build()).orElse(null);
			this.optionBuyer = ofNullable(builder.getOptionBuyer()).map(f->f.build()).orElse(null);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionExerciseSequence = ofNullable(builder.getOptionExerciseSequence()).map(f->f.build()).orElse(null);
			this.exerciseTiming = builder.getExerciseTiming();
			this.optionExerciseAmountModel = ofNullable(builder.getOptionExerciseAmountModel()).map(f->f.build()).orElse(null);
			this.exerciseSide = builder.getExerciseSide();
			this.settlementType = builder.getSettlementType();
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionSeller")
		public PartyReference getOptionSeller() {
			return optionSeller;
		}
		
		@Override
		@RosettaAttribute("optionBuyer")
		public PartyReference getOptionBuyer() {
			return optionBuyer;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("optionExerciseSequence")
		public OptionExerciseSequence getOptionExerciseSequence() {
			return optionExerciseSequence;
		}
		
		@Override
		@RosettaAttribute("exerciseTiming")
		public ExerciseTimingEnum getExerciseTiming() {
			return exerciseTiming;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public OptionExerciseAmountModel getOptionExerciseAmountModel() {
			return optionExerciseAmountModel;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public SimplePayment getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public PhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("payment")
		public NonNegativePayment getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public ClearingInstructions getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public OptionExercise build() {
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			OptionExercise.OptionExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExercise.OptionExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionSeller()).ifPresent(builder::setOptionSeller);
			ofNullable(getOptionBuyer()).ifPresent(builder::setOptionBuyer);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getOptionExerciseSequence()).ifPresent(builder::setOptionExerciseSequence);
			ofNullable(getExerciseTiming()).ifPresent(builder::setExerciseTiming);
			ofNullable(getOptionExerciseAmountModel()).ifPresent(builder::setOptionExerciseAmountModel);
			ofNullable(getExerciseSide()).ifPresent(builder::setExerciseSide);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(optionSeller, _that.getOptionSeller())) return false;
			if (!Objects.equals(optionBuyer, _that.getOptionBuyer())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(optionExerciseSequence, _that.getOptionExerciseSequence())) return false;
			if (!Objects.equals(exerciseTiming, _that.getExerciseTiming())) return false;
			if (!Objects.equals(optionExerciseAmountModel, _that.getOptionExerciseAmountModel())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionSeller != null ? optionSeller.hashCode() : 0);
			_result = 31 * _result + (optionBuyer != null ? optionBuyer.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (optionExerciseSequence != null ? optionExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (exerciseTiming != null ? exerciseTiming.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModel != null ? optionExerciseAmountModel.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExercise {" +
				"optionSeller=" + this.optionSeller + ", " +
				"optionBuyer=" + this.optionBuyer + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"optionExerciseSequence=" + this.optionExerciseSequence + ", " +
				"exerciseTiming=" + this.exerciseTiming + ", " +
				"optionExerciseAmountModel=" + this.optionExerciseAmountModel + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExercise  ***********************/
	class OptionExerciseBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements OptionExercise.OptionExerciseBuilder {
	
		protected PartyReference.PartyReferenceBuilder optionSeller;
		protected PartyReference.PartyReferenceBuilder optionBuyer;
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected OptionExerciseSequence.OptionExerciseSequenceBuilder optionExerciseSequence;
		protected ExerciseTimingEnum exerciseTiming;
		protected OptionExerciseAmountModel.OptionExerciseAmountModelBuilder optionExerciseAmountModel;
		protected ExerciseSideEnum exerciseSide;
		protected SettlementTypeEnum settlementType;
		protected SimplePayment.SimplePaymentBuilder cashSettlement;
		protected PhysicalSettlement.PhysicalSettlementBuilder physicalSettlement;
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		protected ClearingInstructions.ClearingInstructionsBuilder clearingInstructions;
	
		public OptionExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionSeller")
		public PartyReference.PartyReferenceBuilder getOptionSeller() {
			return optionSeller;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionSeller() {
			PartyReference.PartyReferenceBuilder result;
			if (optionSeller!=null) {
				result = optionSeller;
			}
			else {
				result = optionSeller = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionBuyer")
		public PartyReference.PartyReferenceBuilder getOptionBuyer() {
			return optionBuyer;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionBuyer() {
			PartyReference.PartyReferenceBuilder result;
			if (optionBuyer!=null) {
				result = optionBuyer;
			}
			else {
				result = optionBuyer = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("optionExerciseSequence")
		public OptionExerciseSequence.OptionExerciseSequenceBuilder getOptionExerciseSequence() {
			return optionExerciseSequence;
		}
		
		@Override
		public OptionExerciseSequence.OptionExerciseSequenceBuilder getOrCreateOptionExerciseSequence() {
			OptionExerciseSequence.OptionExerciseSequenceBuilder result;
			if (optionExerciseSequence!=null) {
				result = optionExerciseSequence;
			}
			else {
				result = optionExerciseSequence = OptionExerciseSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseTiming")
		public ExerciseTimingEnum getExerciseTiming() {
			return exerciseTiming;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOptionExerciseAmountModel() {
			return optionExerciseAmountModel;
		}
		
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOrCreateOptionExerciseAmountModel() {
			OptionExerciseAmountModel.OptionExerciseAmountModelBuilder result;
			if (optionExerciseAmountModel!=null) {
				result = optionExerciseAmountModel;
			}
			else {
				result = optionExerciseAmountModel = OptionExerciseAmountModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public SimplePayment.SimplePaymentBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement() {
			SimplePayment.SimplePaymentBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			PhysicalSettlement.PhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = PhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		public NonNegativePayment.NonNegativePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions() {
			ClearingInstructions.ClearingInstructionsBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = ClearingInstructions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionExercise.OptionExerciseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("optionSeller")
		public OptionExercise.OptionExerciseBuilder setOptionSeller(PartyReference optionSeller) {
			this.optionSeller = optionSeller==null?null:optionSeller.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionBuyer")
		public OptionExercise.OptionExerciseBuilder setOptionBuyer(PartyReference optionBuyer) {
			this.optionBuyer = optionBuyer==null?null:optionBuyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalTrade")
		public OptionExercise.OptionExerciseBuilder setOriginalTrade(Trade originalTrade) {
			this.originalTrade = originalTrade==null?null:originalTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifier")
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionExercise.OptionExerciseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("optionExerciseSequence")
		public OptionExercise.OptionExerciseBuilder setOptionExerciseSequence(OptionExerciseSequence optionExerciseSequence) {
			this.optionExerciseSequence = optionExerciseSequence==null?null:optionExerciseSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseTiming")
		public OptionExercise.OptionExerciseBuilder setExerciseTiming(ExerciseTimingEnum exerciseTiming) {
			this.exerciseTiming = exerciseTiming==null?null:exerciseTiming;
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public OptionExercise.OptionExerciseBuilder setOptionExerciseAmountModel(OptionExerciseAmountModel optionExerciseAmountModel) {
			this.optionExerciseAmountModel = optionExerciseAmountModel==null?null:optionExerciseAmountModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseSide")
		public OptionExercise.OptionExerciseBuilder setExerciseSide(ExerciseSideEnum exerciseSide) {
			this.exerciseSide = exerciseSide==null?null:exerciseSide;
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public OptionExercise.OptionExerciseBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public OptionExercise.OptionExerciseBuilder setCashSettlement(SimplePayment cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalSettlement")
		public OptionExercise.OptionExerciseBuilder setPhysicalSettlement(PhysicalSettlement physicalSettlement) {
			this.physicalSettlement = physicalSettlement==null?null:physicalSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public OptionExercise.OptionExerciseBuilder setPayment(NonNegativePayment payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public OptionExercise.OptionExerciseBuilder setClearingInstructions(ClearingInstructions clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		
		@Override
		public OptionExercise build() {
			return new OptionExercise.OptionExerciseImpl(this);
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder prune() {
			super.prune();
			if (optionSeller!=null && !optionSeller.prune().hasData()) optionSeller = null;
			if (optionBuyer!=null && !optionBuyer.prune().hasData()) optionBuyer = null;
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (optionExerciseSequence!=null && !optionExerciseSequence.prune().hasData()) optionExerciseSequence = null;
			if (optionExerciseAmountModel!=null && !optionExerciseAmountModel.prune().hasData()) optionExerciseAmountModel = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionSeller()!=null && getOptionSeller().hasData()) return true;
			if (getOptionBuyer()!=null && getOptionBuyer().hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionExerciseSequence()!=null && getOptionExerciseSequence().hasData()) return true;
			if (getExerciseTiming()!=null) return true;
			if (getOptionExerciseAmountModel()!=null && getOptionExerciseAmountModel().hasData()) return true;
			if (getExerciseSide()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionExercise.OptionExerciseBuilder o = (OptionExercise.OptionExerciseBuilder) other;
			
			merger.mergeRosetta(getOptionSeller(), o.getOptionSeller(), this::setOptionSeller);
			merger.mergeRosetta(getOptionBuyer(), o.getOptionBuyer(), this::setOptionBuyer);
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getOptionExerciseSequence(), o.getOptionExerciseSequence(), this::setOptionExerciseSequence);
			merger.mergeRosetta(getOptionExerciseAmountModel(), o.getOptionExerciseAmountModel(), this::setOptionExerciseAmountModel);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getExerciseTiming(), o.getExerciseTiming(), this::setExerciseTiming);
			merger.mergeBasic(getExerciseSide(), o.getExerciseSide(), this::setExerciseSide);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(optionSeller, _that.getOptionSeller())) return false;
			if (!Objects.equals(optionBuyer, _that.getOptionBuyer())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(optionExerciseSequence, _that.getOptionExerciseSequence())) return false;
			if (!Objects.equals(exerciseTiming, _that.getExerciseTiming())) return false;
			if (!Objects.equals(optionExerciseAmountModel, _that.getOptionExerciseAmountModel())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionSeller != null ? optionSeller.hashCode() : 0);
			_result = 31 * _result + (optionBuyer != null ? optionBuyer.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (optionExerciseSequence != null ? optionExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (exerciseTiming != null ? exerciseTiming.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModel != null ? optionExerciseAmountModel.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseBuilder {" +
				"optionSeller=" + this.optionSeller + ", " +
				"optionBuyer=" + this.optionBuyer + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"optionExerciseSequence=" + this.optionExerciseSequence + ", " +
				"exerciseTiming=" + this.exerciseTiming + ", " +
				"optionExerciseAmountModel=" + this.optionExerciseAmountModel + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}' + " " + super.toString();
		}
	}
}
