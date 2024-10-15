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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.ExtendibleProvision.ExtendibleProvisionBuilder;
import fpml.confirmation.ExtendibleProvision.ExtendibleProvisionBuilderImpl;
import fpml.confirmation.ExtendibleProvision.ExtendibleProvisionImpl;
import fpml.confirmation.ExtendibleProvisionAdjustedDates;
import fpml.confirmation.meta.ExtendibleProvisionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date.
 * @version ${project.version}
 */
@RosettaDataType(value="ExtendibleProvision", builder=ExtendibleProvision.ExtendibleProvisionBuilderImpl.class, version="${project.version}")
public interface ExtendibleProvision extends RosettaModelObject {

	ExtendibleProvisionMeta metaData = new ExtendibleProvisionMeta();

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
	 * The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
	 */
	ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates();

	/*********************** Build Methods  ***********************/
	ExtendibleProvision build();
	
	ExtendibleProvision.ExtendibleProvisionBuilder toBuilder();
	
	static ExtendibleProvision.ExtendibleProvisionBuilder builder() {
		return new ExtendibleProvision.ExtendibleProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtendibleProvision> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExtendibleProvision> getType() {
		return ExtendibleProvision.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.class, getExtendibleProvisionAdjustedDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtendibleProvisionBuilder extends ExtendibleProvision, RosettaModelObjectBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		Exercise.ExerciseBuilder getOrCreateExercise();
		Exercise.ExerciseBuilder getExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates();
		ExtendibleProvision.ExtendibleProvisionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		ExtendibleProvision.ExtendibleProvisionBuilder setExercise(Exercise exercise);
		ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder.class, getExtendibleProvisionAdjustedDates());
		}
		

		ExtendibleProvision.ExtendibleProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionImpl implements ExtendibleProvision {
		private final BuyerSellerModel buyerSellerModel;
		private final Exercise exercise;
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates;
		
		protected ExtendibleProvisionImpl(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.extendibleProvisionAdjustedDates = ofNullable(builder.getExtendibleProvisionAdjustedDates()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvision build() {
			return this;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			ExtendibleProvision.ExtendibleProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getExtendibleProvisionAdjustedDates()).ifPresent(builder::setExtendibleProvisionAdjustedDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvision {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionBuilderImpl implements ExtendibleProvision.ExtendibleProvisionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates;
	
		public ExtendibleProvisionBuilderImpl() {
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
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates() {
			ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder result;
			if (extendibleProvisionAdjustedDates!=null) {
				result = extendibleProvisionAdjustedDates;
			}
			else {
				result = extendibleProvisionAdjustedDates = ExtendibleProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public ExtendibleProvision.ExtendibleProvisionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseNotice")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice) {
			this.exerciseNotice = exerciseNotice==null?null:exerciseNotice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("followUpConfirmation")
		public ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates) {
			this.extendibleProvisionAdjustedDates = extendibleProvisionAdjustedDates==null?null:extendibleProvisionAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		public ExtendibleProvision build() {
			return new ExtendibleProvision.ExtendibleProvisionImpl(this);
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder prune() {
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (extendibleProvisionAdjustedDates!=null && !extendibleProvisionAdjustedDates.prune().hasData()) extendibleProvisionAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getExtendibleProvisionAdjustedDates()!=null && getExtendibleProvisionAdjustedDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtendibleProvision.ExtendibleProvisionBuilder o = (ExtendibleProvision.ExtendibleProvisionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getExtendibleProvisionAdjustedDates(), o.getExtendibleProvisionAdjustedDates(), this::setExtendibleProvisionAdjustedDates);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvisionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates +
			'}';
		}
	}
}
