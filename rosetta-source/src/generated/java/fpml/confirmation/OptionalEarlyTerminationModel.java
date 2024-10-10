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
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder;
import fpml.confirmation.OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilderImpl;
import fpml.confirmation.OptionalEarlyTerminationModel.OptionalEarlyTerminationModelImpl;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;
import fpml.confirmation.meta.OptionalEarlyTerminationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionalEarlyTerminationModel", builder=OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilderImpl.class, version="${project.version}")
public interface OptionalEarlyTerminationModel extends RosettaModelObject {

	OptionalEarlyTerminationModelMeta metaData = new OptionalEarlyTerminationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An option for either or both parties to terminate the swap at fair value.
	 */
	OptionalEarlyTermination getOptionalEarlyTermination();
	OptionalEarlyTerminationModelSequence getOptionalEarlyTerminationModelSequence();

	/*********************** Build Methods  ***********************/
	OptionalEarlyTerminationModel build();
	
	OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder toBuilder();
	
	static OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder builder() {
		return new OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionalEarlyTerminationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionalEarlyTerminationModel> getType() {
		return OptionalEarlyTerminationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.class, getOptionalEarlyTermination());
		processRosetta(path.newSubPath("optionalEarlyTerminationModelSequence"), processor, OptionalEarlyTerminationModelSequence.class, getOptionalEarlyTerminationModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionalEarlyTerminationModelBuilder extends OptionalEarlyTerminationModel, RosettaModelObjectBuilder {
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination();
		OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder getOrCreateOptionalEarlyTerminationModelSequence();
		OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder getOptionalEarlyTerminationModelSequence();
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder setOptionalEarlyTermination(OptionalEarlyTermination optionalEarlyTermination);
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder setOptionalEarlyTerminationModelSequence(OptionalEarlyTerminationModelSequence optionalEarlyTerminationModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.OptionalEarlyTerminationBuilder.class, getOptionalEarlyTermination());
			processRosetta(path.newSubPath("optionalEarlyTerminationModelSequence"), processor, OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder.class, getOptionalEarlyTerminationModelSequence());
		}
		

		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionalEarlyTerminationModel  ***********************/
	class OptionalEarlyTerminationModelImpl implements OptionalEarlyTerminationModel {
		private final OptionalEarlyTermination optionalEarlyTermination;
		private final OptionalEarlyTerminationModelSequence optionalEarlyTerminationModelSequence;
		
		protected OptionalEarlyTerminationModelImpl(OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder builder) {
			this.optionalEarlyTermination = ofNullable(builder.getOptionalEarlyTermination()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationModelSequence = ofNullable(builder.getOptionalEarlyTerminationModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModelSequence")
		public OptionalEarlyTerminationModelSequence getOptionalEarlyTerminationModelSequence() {
			return optionalEarlyTerminationModelSequence;
		}
		
		@Override
		public OptionalEarlyTerminationModel build() {
			return this;
		}
		
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder toBuilder() {
			OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder builder) {
			ofNullable(getOptionalEarlyTermination()).ifPresent(builder::setOptionalEarlyTermination);
			ofNullable(getOptionalEarlyTerminationModelSequence()).ifPresent(builder::setOptionalEarlyTerminationModelSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationModelSequence, _that.getOptionalEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModelSequence != null ? optionalEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationModel {" +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationModelSequence=" + this.optionalEarlyTerminationModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionalEarlyTerminationModel  ***********************/
	class OptionalEarlyTerminationModelBuilderImpl implements OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder {
	
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination;
		protected OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder optionalEarlyTerminationModelSequence;
	
		public OptionalEarlyTerminationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination() {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder result;
			if (optionalEarlyTermination!=null) {
				result = optionalEarlyTermination;
			}
			else {
				result = optionalEarlyTermination = OptionalEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModelSequence")
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder getOptionalEarlyTerminationModelSequence() {
			return optionalEarlyTerminationModelSequence;
		}
		
		@Override
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder getOrCreateOptionalEarlyTerminationModelSequence() {
			OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder result;
			if (optionalEarlyTerminationModelSequence!=null) {
				result = optionalEarlyTerminationModelSequence;
			}
			else {
				result = optionalEarlyTerminationModelSequence = OptionalEarlyTerminationModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder setOptionalEarlyTermination(OptionalEarlyTermination optionalEarlyTermination) {
			this.optionalEarlyTermination = optionalEarlyTermination==null?null:optionalEarlyTermination.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationModelSequence")
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder setOptionalEarlyTerminationModelSequence(OptionalEarlyTerminationModelSequence optionalEarlyTerminationModelSequence) {
			this.optionalEarlyTerminationModelSequence = optionalEarlyTerminationModelSequence==null?null:optionalEarlyTerminationModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public OptionalEarlyTerminationModel build() {
			return new OptionalEarlyTerminationModel.OptionalEarlyTerminationModelImpl(this);
		}
		
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder prune() {
			if (optionalEarlyTermination!=null && !optionalEarlyTermination.prune().hasData()) optionalEarlyTermination = null;
			if (optionalEarlyTerminationModelSequence!=null && !optionalEarlyTerminationModelSequence.prune().hasData()) optionalEarlyTerminationModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionalEarlyTermination()!=null && getOptionalEarlyTermination().hasData()) return true;
			if (getOptionalEarlyTerminationModelSequence()!=null && getOptionalEarlyTerminationModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder o = (OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder) other;
			
			merger.mergeRosetta(getOptionalEarlyTermination(), o.getOptionalEarlyTermination(), this::setOptionalEarlyTermination);
			merger.mergeRosetta(getOptionalEarlyTerminationModelSequence(), o.getOptionalEarlyTerminationModelSequence(), this::setOptionalEarlyTerminationModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationModelSequence, _that.getOptionalEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModelSequence != null ? optionalEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationModelBuilder {" +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationModelSequence=" + this.optionalEarlyTerminationModelSequence +
			'}';
		}
	}
}
