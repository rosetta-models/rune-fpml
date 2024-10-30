package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.observable.asset.CalculationAgent;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionalEarlyTermination;
import cdm.product.template.OptionalEarlyTermination.OptionalEarlyTerminationBuilder;
import cdm.product.template.OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl;
import cdm.product.template.OptionalEarlyTermination.OptionalEarlyTerminationImpl;
import cdm.product.template.OptionalEarlyTerminationAdjustedDates;
import cdm.product.template.meta.OptionalEarlyTerminationMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  an early termination provision where either or both parties have the right to exercise.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="OptionalEarlyTermination", builder=OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl.class, version="6.0.0-dev.76")
public interface OptionalEarlyTermination extends RosettaModelObject {

	OptionalEarlyTerminationMeta metaData = new OptionalEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If optional early termination is not available to both parties then this component specifies the buyer and seller of the option. In FpML, this attribute is of type SinglePsrtyOption, which actually consists of the BuyerSeller.model.
	 */
	BuyerSeller getSinglePartyOption();
	/**
	 * Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
	 */
	Boolean getMutualEarlyTermination();
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
	 * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
	 */
	SettlementTerms getCashSettlement();
	/**
	 * An early termination provision to terminate the trade at fair value where one or both parties have the right to decide on termination.
	 */
	OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates();
	/**
	 * The exercise terms associated with the optional early termination, including details such as exercise style, exercise fees, and any other relevant conditions or terms.
	 */
	ExerciseTerms getExerciseTerms();

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
		processRosetta(path.newSubPath("singlePartyOption"), processor, BuyerSeller.class, getSinglePartyOption());
		processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, SettlementTerms.class, getCashSettlement());
		processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.class, getOptionalEarlyTerminationAdjustedDates());
		processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.class, getExerciseTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionalEarlyTerminationBuilder extends OptionalEarlyTermination, RosettaModelObjectBuilder {
		BuyerSeller.BuyerSellerBuilder getOrCreateSinglePartyOption();
		BuyerSeller.BuyerSellerBuilder getSinglePartyOption();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice(int _index);
		List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		SettlementTerms.SettlementTermsBuilder getOrCreateCashSettlement();
		SettlementTerms.SettlementTermsBuilder getCashSettlement();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOrCreateOptionalEarlyTerminationAdjustedDates();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOptionalEarlyTerminationAdjustedDates();
		ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms();
		ExerciseTerms.ExerciseTermsBuilder getExerciseTerms();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(BuyerSeller singlePartyOption);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setMutualEarlyTermination(Boolean mutualEarlyTermination);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice0);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice1, int _idx);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(List<? extends ExerciseNotice> exerciseNotice2);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseNotice(List<? extends ExerciseNotice> exerciseNotice3);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(SettlementTerms cashSettlement);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setOptionalEarlyTerminationAdjustedDates(OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseTerms(ExerciseTerms exerciseTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("singlePartyOption"), processor, BuyerSeller.BuyerSellerBuilder.class, getSinglePartyOption());
			processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, SettlementTerms.SettlementTermsBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder.class, getOptionalEarlyTerminationAdjustedDates());
			processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.ExerciseTermsBuilder.class, getExerciseTerms());
		}
		

		OptionalEarlyTermination.OptionalEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of OptionalEarlyTermination  ***********************/
	class OptionalEarlyTerminationImpl implements OptionalEarlyTermination {
		private final BuyerSeller singlePartyOption;
		private final Boolean mutualEarlyTermination;
		private final List<? extends ExerciseNotice> exerciseNotice;
		private final Boolean followUpConfirmation;
		private final CalculationAgent calculationAgent;
		private final SettlementTerms cashSettlement;
		private final OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates;
		private final ExerciseTerms exerciseTerms;
		
		protected OptionalEarlyTerminationImpl(OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder) {
			this.singlePartyOption = ofNullable(builder.getSinglePartyOption()).map(f->f.build()).orElse(null);
			this.mutualEarlyTermination = builder.getMutualEarlyTermination();
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationAdjustedDates = ofNullable(builder.getOptionalEarlyTerminationAdjustedDates()).map(f->f.build()).orElse(null);
			this.exerciseTerms = ofNullable(builder.getExerciseTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		public BuyerSeller getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
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
		public SettlementTerms getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationAdjustedDates")
		public OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates() {
			return optionalEarlyTerminationAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		public ExerciseTerms getExerciseTerms() {
			return exerciseTerms;
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
			ofNullable(getMutualEarlyTermination()).ifPresent(builder::setMutualEarlyTermination);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getOptionalEarlyTerminationAdjustedDates()).ifPresent(builder::setOptionalEarlyTerminationAdjustedDates);
			ofNullable(getExerciseTerms()).ifPresent(builder::setExerciseTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTermination {" +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionalEarlyTermination  ***********************/
	class OptionalEarlyTerminationBuilderImpl implements OptionalEarlyTermination.OptionalEarlyTerminationBuilder {
	
		protected BuyerSeller.BuyerSellerBuilder singlePartyOption;
		protected Boolean mutualEarlyTermination;
		protected List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNotice = new ArrayList<>();
		protected Boolean followUpConfirmation;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected SettlementTerms.SettlementTermsBuilder cashSettlement;
		protected OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDates;
		protected ExerciseTerms.ExerciseTermsBuilder exerciseTerms;
	
		public OptionalEarlyTerminationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("singlePartyOption")
		public BuyerSeller.BuyerSellerBuilder getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getOrCreateSinglePartyOption() {
			BuyerSeller.BuyerSellerBuilder result;
			if (singlePartyOption!=null) {
				result = singlePartyOption;
			}
			else {
				result = singlePartyOption = BuyerSeller.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		public List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
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
		public SettlementTerms.SettlementTermsBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateCashSettlement() {
			SettlementTerms.SettlementTermsBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = SettlementTerms.builder();
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
		@RosettaAttribute("exerciseTerms")
		public ExerciseTerms.ExerciseTermsBuilder getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms() {
			ExerciseTerms.ExerciseTermsBuilder result;
			if (exerciseTerms!=null) {
				result = exerciseTerms;
			}
			else {
				result = exerciseTerms = ExerciseTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(BuyerSeller singlePartyOption) {
			this.singlePartyOption = singlePartyOption==null?null:singlePartyOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setMutualEarlyTermination(Boolean mutualEarlyTermination) {
			this.mutualEarlyTermination = mutualEarlyTermination==null?null:mutualEarlyTermination;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseNotice")
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
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(SettlementTerms cashSettlement) {
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
		@RosettaAttribute("exerciseTerms")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseTerms(ExerciseTerms exerciseTerms) {
			this.exerciseTerms = exerciseTerms==null?null:exerciseTerms.toBuilder();
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
			exerciseNotice = exerciseNotice.stream().filter(b->b!=null).<ExerciseNotice.ExerciseNoticeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (optionalEarlyTerminationAdjustedDates!=null && !optionalEarlyTerminationAdjustedDates.prune().hasData()) optionalEarlyTerminationAdjustedDates = null;
			if (exerciseTerms!=null && !exerciseTerms.prune().hasData()) exerciseTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSinglePartyOption()!=null && getSinglePartyOption().hasData()) return true;
			if (getMutualEarlyTermination()!=null) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getOptionalEarlyTerminationAdjustedDates()!=null && getOptionalEarlyTerminationAdjustedDates().hasData()) return true;
			if (getExerciseTerms()!=null && getExerciseTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder o = (OptionalEarlyTermination.OptionalEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getSinglePartyOption(), o.getSinglePartyOption(), this::setSinglePartyOption);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::getOrCreateExerciseNotice);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getOptionalEarlyTerminationAdjustedDates(), o.getOptionalEarlyTerminationAdjustedDates(), this::setOptionalEarlyTerminationAdjustedDates);
			merger.mergeRosetta(getExerciseTerms(), o.getExerciseTerms(), this::setExerciseTerms);
			
			merger.mergeBasic(getMutualEarlyTermination(), o.getMutualEarlyTermination(), this::setMutualEarlyTermination);
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationBuilder {" +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}';
		}
	}
}
