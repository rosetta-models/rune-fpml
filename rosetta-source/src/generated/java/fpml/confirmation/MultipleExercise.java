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
import fpml.confirmation.MultipleExercise;
import fpml.confirmation.MultipleExercise.MultipleExerciseBuilder;
import fpml.confirmation.MultipleExercise.MultipleExerciseBuilderImpl;
import fpml.confirmation.MultipleExercise.MultipleExerciseImpl;
import fpml.confirmation.PartialExerciseModel;
import fpml.confirmation.meta.MultipleExerciseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining multiple exercises. As defining in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount.
 * @version ${project.version}
 */
@RosettaDataType(value="MultipleExercise", builder=MultipleExercise.MultipleExerciseBuilderImpl.class, version="${project.version}")
public interface MultipleExercise extends RosettaModelObject {

	MultipleExerciseMeta metaData = new MultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	PartialExerciseModel getPartialExerciseModel();
	/**
	 * The maximum notional amount that can be exercised on a given exercise date.
	 */
	BigDecimal getMaximumNotionalAmount();
	/**
	 * The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
	 */
	BigDecimal getMaximumNumberOfOptions();

	/*********************** Build Methods  ***********************/
	MultipleExercise build();
	
	MultipleExercise.MultipleExerciseBuilder toBuilder();
	
	static MultipleExercise.MultipleExerciseBuilder builder() {
		return new MultipleExercise.MultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MultipleExercise> getType() {
		return MultipleExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialExerciseModel"), processor, PartialExerciseModel.class, getPartialExerciseModel());
		processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MultipleExerciseBuilder extends MultipleExercise, RosettaModelObjectBuilder {
		PartialExerciseModel.PartialExerciseModelBuilder getOrCreatePartialExerciseModel();
		PartialExerciseModel.PartialExerciseModelBuilder getPartialExerciseModel();
		MultipleExercise.MultipleExerciseBuilder setPartialExerciseModel(PartialExerciseModel partialExerciseModel);
		MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal maximumNotionalAmount);
		MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal maximumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialExerciseModel"), processor, PartialExerciseModel.PartialExerciseModelBuilder.class, getPartialExerciseModel());
			processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
		}
		

		MultipleExercise.MultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of MultipleExercise  ***********************/
	class MultipleExerciseImpl implements MultipleExercise {
		private final PartialExerciseModel partialExerciseModel;
		private final BigDecimal maximumNotionalAmount;
		private final BigDecimal maximumNumberOfOptions;
		
		protected MultipleExerciseImpl(MultipleExercise.MultipleExerciseBuilder builder) {
			this.partialExerciseModel = ofNullable(builder.getPartialExerciseModel()).map(f->f.build()).orElse(null);
			this.maximumNotionalAmount = builder.getMaximumNotionalAmount();
			this.maximumNumberOfOptions = builder.getMaximumNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("partialExerciseModel")
		public PartialExerciseModel getPartialExerciseModel() {
			return partialExerciseModel;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		public MultipleExercise build() {
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			MultipleExercise.MultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultipleExercise.MultipleExerciseBuilder builder) {
			ofNullable(getPartialExerciseModel()).ifPresent(builder::setPartialExerciseModel);
			ofNullable(getMaximumNotionalAmount()).ifPresent(builder::setMaximumNotionalAmount);
			ofNullable(getMaximumNumberOfOptions()).ifPresent(builder::setMaximumNumberOfOptions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseModel, _that.getPartialExerciseModel())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialExerciseModel != null ? partialExerciseModel.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExercise {" +
				"partialExerciseModel=" + this.partialExerciseModel + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of MultipleExercise  ***********************/
	class MultipleExerciseBuilderImpl implements MultipleExercise.MultipleExerciseBuilder {
	
		protected PartialExerciseModel.PartialExerciseModelBuilder partialExerciseModel;
		protected BigDecimal maximumNotionalAmount;
		protected BigDecimal maximumNumberOfOptions;
	
		public MultipleExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partialExerciseModel")
		public PartialExerciseModel.PartialExerciseModelBuilder getPartialExerciseModel() {
			return partialExerciseModel;
		}
		
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder getOrCreatePartialExerciseModel() {
			PartialExerciseModel.PartialExerciseModelBuilder result;
			if (partialExerciseModel!=null) {
				result = partialExerciseModel;
			}
			else {
				result = partialExerciseModel = PartialExerciseModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("partialExerciseModel")
		public MultipleExercise.MultipleExerciseBuilder setPartialExerciseModel(PartialExerciseModel partialExerciseModel) {
			this.partialExerciseModel = partialExerciseModel==null?null:partialExerciseModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		public MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal maximumNotionalAmount) {
			this.maximumNotionalAmount = maximumNotionalAmount==null?null:maximumNotionalAmount;
			return this;
		}
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		public MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal maximumNumberOfOptions) {
			this.maximumNumberOfOptions = maximumNumberOfOptions==null?null:maximumNumberOfOptions;
			return this;
		}
		
		@Override
		public MultipleExercise build() {
			return new MultipleExercise.MultipleExerciseImpl(this);
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder prune() {
			if (partialExerciseModel!=null && !partialExerciseModel.prune().hasData()) partialExerciseModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartialExerciseModel()!=null && getPartialExerciseModel().hasData()) return true;
			if (getMaximumNotionalAmount()!=null) return true;
			if (getMaximumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MultipleExercise.MultipleExerciseBuilder o = (MultipleExercise.MultipleExerciseBuilder) other;
			
			merger.mergeRosetta(getPartialExerciseModel(), o.getPartialExerciseModel(), this::setPartialExerciseModel);
			
			merger.mergeBasic(getMaximumNotionalAmount(), o.getMaximumNotionalAmount(), this::setMaximumNotionalAmount);
			merger.mergeBasic(getMaximumNumberOfOptions(), o.getMaximumNumberOfOptions(), this::setMaximumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseModel, _that.getPartialExerciseModel())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialExerciseModel != null ? partialExerciseModel.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExerciseBuilder {" +
				"partialExerciseModel=" + this.partialExerciseModel + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}
}
