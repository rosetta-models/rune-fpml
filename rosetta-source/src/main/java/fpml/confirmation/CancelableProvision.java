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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CancelableProvision;
import fpml.confirmation.CancelableProvision.CancelableProvisionBuilder;
import fpml.confirmation.CancelableProvision.CancelableProvisionBuilderImpl;
import fpml.confirmation.CancelableProvision.CancelableProvisionImpl;
import fpml.confirmation.CancelableProvisionAdjustedDates;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.meta.CancelableProvisionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for &#39;walkaway&#39; cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CancelableProvision", builder=CancelableProvision.CancelableProvisionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CancelableProvision extends RosettaModelObject {

	CancelableProvisionMeta metaData = new CancelableProvisionMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	Exercise getExercise();
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	ExerciseNotice getExerciseNotice();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
	 */
	CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates();
	/**
	 * Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC&#39;s or they can be specified seperately.
	 */
	List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment();
	/**
	 * An initial fee for the cancelable option.
	 */
	SimplePayment getInitialFee();

	/*********************** Build Methods  ***********************/
	CancelableProvision build();
	
	CancelableProvision.CancelableProvisionBuilder toBuilder();
	
	static CancelableProvision.CancelableProvisionBuilder builder() {
		return new CancelableProvision.CancelableProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancelableProvision> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CancelableProvision> getType() {
		return CancelableProvision.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.class, getCancelableProvisionAdjustedDates());
		processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.class, getFinalCalculationPeriodDateAdjustment());
		processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.class, getInitialFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancelableProvisionBuilder extends CancelableProvision, RosettaModelObjectBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		Exercise.ExerciseBuilder getOrCreateExercise();
		Exercise.ExerciseBuilder getExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index);
		List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment();
		SimplePayment.SimplePaymentBuilder getOrCreateInitialFee();
		SimplePayment.SimplePaymentBuilder getInitialFee();
		CancelableProvision.CancelableProvisionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CancelableProvision.CancelableProvisionBuilder setExercise(Exercise exercise);
		CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment0);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment1, int _idx);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment2);
		CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment3);
		CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment initialFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder.class, getCancelableProvisionAdjustedDates());
			processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder.class, getFinalCalculationPeriodDateAdjustment());
			processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.SimplePaymentBuilder.class, getInitialFee());
		}
		

		CancelableProvision.CancelableProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of CancelableProvision  ***********************/
	class CancelableProvisionImpl implements CancelableProvision {
		private final BuyerSellerModel buyerSellerModel;
		private final Exercise exercise;
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates;
		private final List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment;
		private final SimplePayment initialFee;
		
		protected CancelableProvisionImpl(CancelableProvision.CancelableProvisionBuilder builder) {
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.cancelableProvisionAdjustedDates = ofNullable(builder.getCancelableProvisionAdjustedDates()).map(f->f.build()).orElse(null);
			this.finalCalculationPeriodDateAdjustment = ofNullable(builder.getFinalCalculationPeriodDateAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialFee = ofNullable(builder.getInitialFee()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		public ExerciseNotice getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		@RosettaAttribute("initialFee")
		public SimplePayment getInitialFee() {
			return initialFee;
		}
		
		@Override
		public CancelableProvision build() {
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			CancelableProvision.CancelableProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancelableProvision.CancelableProvisionBuilder builder) {
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getCancelableProvisionAdjustedDates()).ifPresent(builder::setCancelableProvisionAdjustedDates);
			ofNullable(getFinalCalculationPeriodDateAdjustment()).ifPresent(builder::setFinalCalculationPeriodDateAdjustment);
			ofNullable(getInitialFee()).ifPresent(builder::setInitialFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvision {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee +
			'}';
		}
	}

	/*********************** Builder Implementation of CancelableProvision  ***********************/
	class CancelableProvisionBuilderImpl implements CancelableProvision.CancelableProvisionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates;
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustment = new ArrayList<>();
		protected SimplePayment.SimplePaymentBuilder initialFee;
	
		public CancelableProvisionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
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
		public ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice() {
			ExerciseNotice.ExerciseNoticeBuilder result;
			if (exerciseNotice!=null) {
				result = exerciseNotice;
			}
			else {
				result = exerciseNotice = ExerciseNotice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates() {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder result;
			if (cancelableProvisionAdjustedDates!=null) {
				result = cancelableProvisionAdjustedDates;
			}
			else {
				result = cancelableProvisionAdjustedDates = CancelableProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index) {
		
			if (finalCalculationPeriodDateAdjustment==null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder result;
			return getIndex(finalCalculationPeriodDateAdjustment, _index, () -> {
						FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder newFinalCalculationPeriodDateAdjustment = FinalCalculationPeriodDateAdjustment.builder();
						return newFinalCalculationPeriodDateAdjustment;
					});
		}
		
		@Override
		@RosettaAttribute("initialFee")
		public SimplePayment.SimplePaymentBuilder getInitialFee() {
			return initialFee;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateInitialFee() {
			SimplePayment.SimplePaymentBuilder result;
			if (initialFee!=null) {
				result = initialFee;
			}
			else {
				result = initialFee = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CancelableProvision.CancelableProvisionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CancelableProvision.CancelableProvisionBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseNotice")
		public CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice) {
			this.exerciseNotice = exerciseNotice==null?null:exerciseNotice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("followUpConfirmation")
		public CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates) {
			this.cancelableProvisionAdjustedDates = cancelableProvisionAdjustedDates==null?null:cancelableProvisionAdjustedDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment) {
			if (finalCalculationPeriodDateAdjustment!=null) this.finalCalculationPeriodDateAdjustment.add(finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment, int _idx) {
			getIndex(this.finalCalculationPeriodDateAdjustment, _idx, () -> finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		@Override 
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments != null) {
				for (FinalCalculationPeriodDateAdjustment toAdd : finalCalculationPeriodDateAdjustments) {
					this.finalCalculationPeriodDateAdjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments == null)  {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			else {
				this.finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialFee")
		public CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment initialFee) {
			this.initialFee = initialFee==null?null:initialFee.toBuilder();
			return this;
		}
		
		@Override
		public CancelableProvision build() {
			return new CancelableProvision.CancelableProvisionImpl(this);
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder prune() {
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (cancelableProvisionAdjustedDates!=null && !cancelableProvisionAdjustedDates.prune().hasData()) cancelableProvisionAdjustedDates = null;
			finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustment.stream().filter(b->b!=null).<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (initialFee!=null && !initialFee.prune().hasData()) initialFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getCancelableProvisionAdjustedDates()!=null && getCancelableProvisionAdjustedDates().hasData()) return true;
			if (getFinalCalculationPeriodDateAdjustment()!=null && getFinalCalculationPeriodDateAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialFee()!=null && getInitialFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancelableProvision.CancelableProvisionBuilder o = (CancelableProvision.CancelableProvisionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getCancelableProvisionAdjustedDates(), o.getCancelableProvisionAdjustedDates(), this::setCancelableProvisionAdjustedDates);
			merger.mergeRosetta(getFinalCalculationPeriodDateAdjustment(), o.getFinalCalculationPeriodDateAdjustment(), this::getOrCreateFinalCalculationPeriodDateAdjustment);
			merger.mergeRosetta(getInitialFee(), o.getInitialFee(), this::setInitialFee);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee +
			'}';
		}
	}
}
