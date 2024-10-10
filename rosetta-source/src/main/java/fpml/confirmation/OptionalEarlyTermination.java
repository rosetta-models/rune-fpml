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
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTermination.OptionalEarlyTerminationBuilder;
import fpml.confirmation.OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl;
import fpml.confirmation.OptionalEarlyTermination.OptionalEarlyTerminationImpl;
import fpml.confirmation.OptionalEarlyTerminationAdjustedDates;
import fpml.confirmation.SinglePartyOption;
import fpml.confirmation.meta.OptionalEarlyTerminationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining an early termination provision where either or both parties have the right to exercise.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionalEarlyTermination", builder=OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl.class, version="${project.version}")
public interface OptionalEarlyTermination extends RosettaModelObject {

	OptionalEarlyTerminationMeta metaData = new OptionalEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If optional early termination is not available to both parties then this component specifies the buyer and seller of the option.
	 */
	SinglePartyOption getSinglePartyOption();
	Exercise getExercise();
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	List<? extends ExerciseNotice> getExerciseNotice();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement prodcedure. If not specified, then physical settlement is applicable.
	 */
	CashSettlement getCashSettlement();
	/**
	 * An early termination provision to terminate the trade at fair value where one or both parties have the right to decide on termination.
	 */
	OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates();

	/*********************** Build Methods  ***********************/
	OptionalEarlyTermination build();
	
	OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder();
	
	static OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder() {
		return new OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionalEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionalEarlyTermination> getType() {
		return OptionalEarlyTermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("singlePartyOption"), processor, SinglePartyOption.class, getSinglePartyOption());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.class, getCashSettlement());
		processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.class, getOptionalEarlyTerminationAdjustedDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionalEarlyTerminationBuilder extends OptionalEarlyTermination, RosettaModelObjectBuilder {
		SinglePartyOption.SinglePartyOptionBuilder getOrCreateSinglePartyOption();
		SinglePartyOption.SinglePartyOptionBuilder getSinglePartyOption();
		Exercise.ExerciseBuilder getOrCreateExercise();
		Exercise.ExerciseBuilder getExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice(int _index);
		List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlement.CashSettlementBuilder getOrCreateCashSettlement();
		CashSettlement.CashSettlementBuilder getCashSettlement();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOrCreateOptionalEarlyTerminationAdjustedDates();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOptionalEarlyTerminationAdjustedDates();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(SinglePartyOption singlePartyOption);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExercise(Exercise exercise);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice0);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice1, int _idx);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(List<? extends ExerciseNotice> exerciseNotice2);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseNotice(List<? extends ExerciseNotice> exerciseNotice3);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(CashSettlement cashSettlement);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setOptionalEarlyTerminationAdjustedDates(OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("singlePartyOption"), processor, SinglePartyOption.SinglePartyOptionBuilder.class, getSinglePartyOption());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.CashSettlementBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder.class, getOptionalEarlyTerminationAdjustedDates());
		}
		

		OptionalEarlyTermination.OptionalEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of OptionalEarlyTermination  ***********************/
	class OptionalEarlyTerminationImpl implements OptionalEarlyTermination {
		private final SinglePartyOption singlePartyOption;
		private final Exercise exercise;
		private final List<? extends ExerciseNotice> exerciseNotice;
		private final Boolean followUpConfirmation;
		private final CalculationAgent calculationAgent;
		private final CashSettlement cashSettlement;
		private final OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates;
		
		protected OptionalEarlyTerminationImpl(OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder) {
			this.singlePartyOption = ofNullable(builder.getSinglePartyOption()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationAdjustedDates = ofNullable(builder.getOptionalEarlyTerminationAdjustedDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		public SinglePartyOption getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		public List<? extends ExerciseNotice> getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationAdjustedDates")
		public OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates() {
			return optionalEarlyTerminationAdjustedDates;
		}
		
		@Override
		public OptionalEarlyTermination build() {
			return this;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder() {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder) {
			ofNullable(getSinglePartyOption()).ifPresent(builder::setSinglePartyOption);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getOptionalEarlyTerminationAdjustedDates()).ifPresent(builder::setOptionalEarlyTerminationAdjustedDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTermination {" +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionalEarlyTermination  ***********************/
	class OptionalEarlyTerminationBuilderImpl implements OptionalEarlyTermination.OptionalEarlyTerminationBuilder {
	
		protected SinglePartyOption.SinglePartyOptionBuilder singlePartyOption;
		protected Exercise.ExerciseBuilder exercise;
		protected List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNotice = new ArrayList<>();
		protected Boolean followUpConfirmation;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlement.CashSettlementBuilder cashSettlement;
		protected OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDates;
	
		public OptionalEarlyTerminationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("singlePartyOption")
		public SinglePartyOption.SinglePartyOptionBuilder getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		public SinglePartyOption.SinglePartyOptionBuilder getOrCreateSinglePartyOption() {
			SinglePartyOption.SinglePartyOptionBuilder result;
			if (singlePartyOption!=null) {
				result = singlePartyOption;
			}
			else {
				result = singlePartyOption = SinglePartyOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise.ExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public Exercise.ExerciseBuilder getOrCreateExercise() {
			Exercise.ExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = Exercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		public List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice() {
			return exerciseNotice;
		}
		
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice(int _index) {
		
			if (exerciseNotice==null) {
				this.exerciseNotice = new ArrayList<>();
			}
			ExerciseNotice.ExerciseNoticeBuilder result;
			return getIndex(exerciseNotice, _index, () -> {
						ExerciseNotice.ExerciseNoticeBuilder newExerciseNotice = ExerciseNotice.builder();
						return newExerciseNotice;
					});
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement.CashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder getOrCreateCashSettlement() {
			CashSettlement.CashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationAdjustedDates")
		public OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOptionalEarlyTerminationAdjustedDates() {
			return optionalEarlyTerminationAdjustedDates;
		}
		
		@Override
		public OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOrCreateOptionalEarlyTerminationAdjustedDates() {
			OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder result;
			if (optionalEarlyTerminationAdjustedDates!=null) {
				result = optionalEarlyTerminationAdjustedDates;
			}
			else {
				result = optionalEarlyTerminationAdjustedDates = OptionalEarlyTerminationAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(SinglePartyOption singlePartyOption) {
			this.singlePartyOption = singlePartyOption==null?null:singlePartyOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice) {
			if (exerciseNotice!=null) this.exerciseNotice.add(exerciseNotice.toBuilder());
			return this;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice, int _idx) {
			getIndex(this.exerciseNotice, _idx, () -> exerciseNotice.toBuilder());
			return this;
		}
		@Override 
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(List<? extends ExerciseNotice> exerciseNotices) {
			if (exerciseNotices != null) {
				for (ExerciseNotice toAdd : exerciseNotices) {
					this.exerciseNotice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("exerciseNotice")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseNotice(List<? extends ExerciseNotice> exerciseNotices) {
			if (exerciseNotices == null)  {
				this.exerciseNotice = new ArrayList<>();
			}
			else {
				this.exerciseNotice = exerciseNotices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("calculationAgent")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent) {
			this.calculationAgent = calculationAgent==null?null:calculationAgent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(CashSettlement cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationAdjustedDates")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setOptionalEarlyTerminationAdjustedDates(OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates) {
			this.optionalEarlyTerminationAdjustedDates = optionalEarlyTerminationAdjustedDates==null?null:optionalEarlyTerminationAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		public OptionalEarlyTermination build() {
			return new OptionalEarlyTermination.OptionalEarlyTerminationImpl(this);
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder prune() {
			if (singlePartyOption!=null && !singlePartyOption.prune().hasData()) singlePartyOption = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			exerciseNotice = exerciseNotice.stream().filter(b->b!=null).<ExerciseNotice.ExerciseNoticeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (optionalEarlyTerminationAdjustedDates!=null && !optionalEarlyTerminationAdjustedDates.prune().hasData()) optionalEarlyTerminationAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSinglePartyOption()!=null && getSinglePartyOption().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getOptionalEarlyTerminationAdjustedDates()!=null && getOptionalEarlyTerminationAdjustedDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder o = (OptionalEarlyTermination.OptionalEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getSinglePartyOption(), o.getSinglePartyOption(), this::setSinglePartyOption);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::getOrCreateExerciseNotice);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getOptionalEarlyTerminationAdjustedDates(), o.getOptionalEarlyTerminationAdjustedDates(), this::setOptionalEarlyTerminationAdjustedDates);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationBuilder {" +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates +
			'}';
		}
	}
}
