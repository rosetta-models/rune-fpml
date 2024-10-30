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
import fpml.confirmation.PartialExercise;
import fpml.confirmation.PartialExercise.PartialExerciseBuilder;
import fpml.confirmation.PartialExercise.PartialExerciseBuilderImpl;
import fpml.confirmation.PartialExercise.PartialExerciseImpl;
import fpml.confirmation.PartialExerciseModel;
import fpml.confirmation.meta.PartialExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartialExercise", builder=PartialExercise.PartialExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartialExercise extends RosettaModelObject {

	PartialExerciseMeta metaData = new PartialExerciseMeta();

	/*********************** Getter Methods  ***********************/
	PartialExerciseModel getPartialExerciseModel();

	/*********************** Build Methods  ***********************/
	PartialExercise build();
	
	PartialExercise.PartialExerciseBuilder toBuilder();
	
	static PartialExercise.PartialExerciseBuilder builder() {
		return new PartialExercise.PartialExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartialExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartialExercise> getType() {
		return PartialExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialExerciseModel"), processor, PartialExerciseModel.class, getPartialExerciseModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartialExerciseBuilder extends PartialExercise, RosettaModelObjectBuilder {
		PartialExerciseModel.PartialExerciseModelBuilder getOrCreatePartialExerciseModel();
		PartialExerciseModel.PartialExerciseModelBuilder getPartialExerciseModel();
		PartialExercise.PartialExerciseBuilder setPartialExerciseModel(PartialExerciseModel partialExerciseModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialExerciseModel"), processor, PartialExerciseModel.PartialExerciseModelBuilder.class, getPartialExerciseModel());
		}
		

		PartialExercise.PartialExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of PartialExercise  ***********************/
	class PartialExerciseImpl implements PartialExercise {
		private final PartialExerciseModel partialExerciseModel;
		
		protected PartialExerciseImpl(PartialExercise.PartialExerciseBuilder builder) {
			this.partialExerciseModel = ofNullable(builder.getPartialExerciseModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partialExerciseModel")
		public PartialExerciseModel getPartialExerciseModel() {
			return partialExerciseModel;
		}
		
		@Override
		public PartialExercise build() {
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			PartialExercise.PartialExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartialExercise.PartialExerciseBuilder builder) {
			ofNullable(getPartialExerciseModel()).ifPresent(builder::setPartialExerciseModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseModel, _that.getPartialExerciseModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialExerciseModel != null ? partialExerciseModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExercise {" +
				"partialExerciseModel=" + this.partialExerciseModel +
			'}';
		}
	}

	/*********************** Builder Implementation of PartialExercise  ***********************/
	class PartialExerciseBuilderImpl implements PartialExercise.PartialExerciseBuilder {
	
		protected PartialExerciseModel.PartialExerciseModelBuilder partialExerciseModel;
	
		public PartialExerciseBuilderImpl() {
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
		@RosettaAttribute("partialExerciseModel")
		public PartialExercise.PartialExerciseBuilder setPartialExerciseModel(PartialExerciseModel partialExerciseModel) {
			this.partialExerciseModel = partialExerciseModel==null?null:partialExerciseModel.toBuilder();
			return this;
		}
		
		@Override
		public PartialExercise build() {
			return new PartialExercise.PartialExerciseImpl(this);
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder prune() {
			if (partialExerciseModel!=null && !partialExerciseModel.prune().hasData()) partialExerciseModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartialExerciseModel()!=null && getPartialExerciseModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartialExercise.PartialExerciseBuilder o = (PartialExercise.PartialExerciseBuilder) other;
			
			merger.mergeRosetta(getPartialExerciseModel(), o.getPartialExerciseModel(), this::setPartialExerciseModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseModel, _that.getPartialExerciseModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialExerciseModel != null ? partialExerciseModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExerciseBuilder {" +
				"partialExerciseModel=" + this.partialExerciseModel +
			'}';
		}
	}
}
