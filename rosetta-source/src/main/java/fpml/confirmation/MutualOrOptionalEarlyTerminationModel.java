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
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilderImpl;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelImpl;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import fpml.confirmation.meta.MutualOrOptionalEarlyTerminationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MutualOrOptionalEarlyTerminationModel", builder=MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilderImpl.class, version="${project.version}")
public interface MutualOrOptionalEarlyTerminationModel extends RosettaModelObject {

	MutualOrOptionalEarlyTerminationModelMeta metaData = new MutualOrOptionalEarlyTerminationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
	 */
	Boolean getMutualEarlyTermination();
	MutualOrOptionalEarlyTerminationModelSequence getMutualOrOptionalEarlyTerminationModelSequence();

	/*********************** Build Methods  ***********************/
	MutualOrOptionalEarlyTerminationModel build();
	
	MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder toBuilder();
	
	static MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder builder() {
		return new MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutualOrOptionalEarlyTerminationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MutualOrOptionalEarlyTerminationModel> getType() {
		return MutualOrOptionalEarlyTerminationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
		processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModelSequence"), processor, MutualOrOptionalEarlyTerminationModelSequence.class, getMutualOrOptionalEarlyTerminationModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutualOrOptionalEarlyTerminationModelBuilder extends MutualOrOptionalEarlyTerminationModel, RosettaModelObjectBuilder {
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder getOrCreateMutualOrOptionalEarlyTerminationModelSequence();
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder getMutualOrOptionalEarlyTerminationModelSequence();
		MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder setMutualEarlyTermination(Boolean mutualEarlyTermination);
		MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder setMutualOrOptionalEarlyTerminationModelSequence(MutualOrOptionalEarlyTerminationModelSequence mutualOrOptionalEarlyTerminationModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
			processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModelSequence"), processor, MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder.class, getMutualOrOptionalEarlyTerminationModelSequence());
		}
		

		MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder prune();
	}

	/*********************** Immutable Implementation of MutualOrOptionalEarlyTerminationModel  ***********************/
	class MutualOrOptionalEarlyTerminationModelImpl implements MutualOrOptionalEarlyTerminationModel {
		private final Boolean mutualEarlyTermination;
		private final MutualOrOptionalEarlyTerminationModelSequence mutualOrOptionalEarlyTerminationModelSequence;
		
		protected MutualOrOptionalEarlyTerminationModelImpl(MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder builder) {
			this.mutualEarlyTermination = builder.getMutualEarlyTermination();
			this.mutualOrOptionalEarlyTerminationModelSequence = ofNullable(builder.getMutualOrOptionalEarlyTerminationModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequence")
		public MutualOrOptionalEarlyTerminationModelSequence getMutualOrOptionalEarlyTerminationModelSequence() {
			return mutualOrOptionalEarlyTerminationModelSequence;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModel build() {
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder toBuilder() {
			MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder builder) {
			ofNullable(getMutualEarlyTermination()).ifPresent(builder::setMutualEarlyTermination);
			ofNullable(getMutualOrOptionalEarlyTerminationModelSequence()).ifPresent(builder::setMutualOrOptionalEarlyTerminationModelSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModelSequence, _that.getMutualOrOptionalEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModelSequence != null ? mutualOrOptionalEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModel {" +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"mutualOrOptionalEarlyTerminationModelSequence=" + this.mutualOrOptionalEarlyTerminationModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of MutualOrOptionalEarlyTerminationModel  ***********************/
	class MutualOrOptionalEarlyTerminationModelBuilderImpl implements MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder {
	
		protected Boolean mutualEarlyTermination;
		protected MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder mutualOrOptionalEarlyTerminationModelSequence;
	
		public MutualOrOptionalEarlyTerminationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequence")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder getMutualOrOptionalEarlyTerminationModelSequence() {
			return mutualOrOptionalEarlyTerminationModelSequence;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder getOrCreateMutualOrOptionalEarlyTerminationModelSequence() {
			MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder result;
			if (mutualOrOptionalEarlyTerminationModelSequence!=null) {
				result = mutualOrOptionalEarlyTerminationModelSequence;
			}
			else {
				result = mutualOrOptionalEarlyTerminationModelSequence = MutualOrOptionalEarlyTerminationModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder setMutualEarlyTermination(Boolean mutualEarlyTermination) {
			this.mutualEarlyTermination = mutualEarlyTermination==null?null:mutualEarlyTermination;
			return this;
		}
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequence")
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder setMutualOrOptionalEarlyTerminationModelSequence(MutualOrOptionalEarlyTerminationModelSequence mutualOrOptionalEarlyTerminationModelSequence) {
			this.mutualOrOptionalEarlyTerminationModelSequence = mutualOrOptionalEarlyTerminationModelSequence==null?null:mutualOrOptionalEarlyTerminationModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModel build() {
			return new MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelImpl(this);
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder prune() {
			if (mutualOrOptionalEarlyTerminationModelSequence!=null && !mutualOrOptionalEarlyTerminationModelSequence.prune().hasData()) mutualOrOptionalEarlyTerminationModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMutualEarlyTermination()!=null) return true;
			if (getMutualOrOptionalEarlyTerminationModelSequence()!=null && getMutualOrOptionalEarlyTerminationModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder o = (MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder) other;
			
			merger.mergeRosetta(getMutualOrOptionalEarlyTerminationModelSequence(), o.getMutualOrOptionalEarlyTerminationModelSequence(), this::setMutualOrOptionalEarlyTerminationModelSequence);
			
			merger.mergeBasic(getMutualEarlyTermination(), o.getMutualEarlyTermination(), this::setMutualEarlyTermination);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModelSequence, _that.getMutualOrOptionalEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModelSequence != null ? mutualOrOptionalEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModelBuilder {" +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"mutualOrOptionalEarlyTerminationModelSequence=" + this.mutualOrOptionalEarlyTerminationModelSequence +
			'}';
		}
	}
}
