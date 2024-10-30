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
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder;
import fpml.confirmation.MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilderImpl;
import fpml.confirmation.MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelImpl;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import fpml.confirmation.meta.MandatoryEarlyTerminationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MandatoryEarlyTerminationModel", builder=MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MandatoryEarlyTerminationModel extends RosettaModelObject {

	MandatoryEarlyTerminationModelMeta metaData = new MandatoryEarlyTerminationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A mandatory early termination provision to terminate the swap at fair value.
	 */
	MandatoryEarlyTermination getMandatoryEarlyTermination();
	MandatoryEarlyTerminationModelSequence getMandatoryEarlyTerminationModelSequence();

	/*********************** Build Methods  ***********************/
	MandatoryEarlyTerminationModel build();
	
	MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder toBuilder();
	
	static MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder builder() {
		return new MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTerminationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MandatoryEarlyTerminationModel> getType() {
		return MandatoryEarlyTerminationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.class, getMandatoryEarlyTermination());
		processRosetta(path.newSubPath("mandatoryEarlyTerminationModelSequence"), processor, MandatoryEarlyTerminationModelSequence.class, getMandatoryEarlyTerminationModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MandatoryEarlyTerminationModelBuilder extends MandatoryEarlyTerminationModel, RosettaModelObjectBuilder {
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination();
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination();
		MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder getOrCreateMandatoryEarlyTerminationModelSequence();
		MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder getMandatoryEarlyTerminationModelSequence();
		MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination mandatoryEarlyTermination);
		MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder setMandatoryEarlyTerminationModelSequence(MandatoryEarlyTerminationModelSequence mandatoryEarlyTerminationModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder.class, getMandatoryEarlyTermination());
			processRosetta(path.newSubPath("mandatoryEarlyTerminationModelSequence"), processor, MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder.class, getMandatoryEarlyTerminationModelSequence());
		}
		

		MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryEarlyTerminationModel  ***********************/
	class MandatoryEarlyTerminationModelImpl implements MandatoryEarlyTerminationModel {
		private final MandatoryEarlyTermination mandatoryEarlyTermination;
		private final MandatoryEarlyTerminationModelSequence mandatoryEarlyTerminationModelSequence;
		
		protected MandatoryEarlyTerminationModelImpl(MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder builder) {
			this.mandatoryEarlyTermination = ofNullable(builder.getMandatoryEarlyTermination()).map(f->f.build()).orElse(null);
			this.mandatoryEarlyTerminationModelSequence = ofNullable(builder.getMandatoryEarlyTerminationModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModelSequence")
		public MandatoryEarlyTerminationModelSequence getMandatoryEarlyTerminationModelSequence() {
			return mandatoryEarlyTerminationModelSequence;
		}
		
		@Override
		public MandatoryEarlyTerminationModel build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder toBuilder() {
			MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder builder) {
			ofNullable(getMandatoryEarlyTermination()).ifPresent(builder::setMandatoryEarlyTermination);
			ofNullable(getMandatoryEarlyTerminationModelSequence()).ifPresent(builder::setMandatoryEarlyTerminationModelSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationModelSequence, _that.getMandatoryEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationModelSequence != null ? mandatoryEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationModel {" +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination + ", " +
				"mandatoryEarlyTerminationModelSequence=" + this.mandatoryEarlyTerminationModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of MandatoryEarlyTerminationModel  ***********************/
	class MandatoryEarlyTerminationModelBuilderImpl implements MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder {
	
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination;
		protected MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder mandatoryEarlyTerminationModelSequence;
	
		public MandatoryEarlyTerminationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination() {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder result;
			if (mandatoryEarlyTermination!=null) {
				result = mandatoryEarlyTermination;
			}
			else {
				result = mandatoryEarlyTermination = MandatoryEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModelSequence")
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder getMandatoryEarlyTerminationModelSequence() {
			return mandatoryEarlyTerminationModelSequence;
		}
		
		@Override
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder getOrCreateMandatoryEarlyTerminationModelSequence() {
			MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder result;
			if (mandatoryEarlyTerminationModelSequence!=null) {
				result = mandatoryEarlyTerminationModelSequence;
			}
			else {
				result = mandatoryEarlyTerminationModelSequence = MandatoryEarlyTerminationModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination mandatoryEarlyTermination) {
			this.mandatoryEarlyTermination = mandatoryEarlyTermination==null?null:mandatoryEarlyTermination.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModelSequence")
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder setMandatoryEarlyTerminationModelSequence(MandatoryEarlyTerminationModelSequence mandatoryEarlyTerminationModelSequence) {
			this.mandatoryEarlyTerminationModelSequence = mandatoryEarlyTerminationModelSequence==null?null:mandatoryEarlyTerminationModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationModel build() {
			return new MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelImpl(this);
		}
		
		@Override
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder prune() {
			if (mandatoryEarlyTermination!=null && !mandatoryEarlyTermination.prune().hasData()) mandatoryEarlyTermination = null;
			if (mandatoryEarlyTerminationModelSequence!=null && !mandatoryEarlyTerminationModelSequence.prune().hasData()) mandatoryEarlyTerminationModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMandatoryEarlyTermination()!=null && getMandatoryEarlyTermination().hasData()) return true;
			if (getMandatoryEarlyTerminationModelSequence()!=null && getMandatoryEarlyTerminationModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder o = (MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTermination(), o.getMandatoryEarlyTermination(), this::setMandatoryEarlyTermination);
			merger.mergeRosetta(getMandatoryEarlyTerminationModelSequence(), o.getMandatoryEarlyTerminationModelSequence(), this::setMandatoryEarlyTerminationModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationModel _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationModelSequence, _that.getMandatoryEarlyTerminationModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationModelSequence != null ? mandatoryEarlyTerminationModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationModelBuilder {" +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination + ", " +
				"mandatoryEarlyTerminationModelSequence=" + this.mandatoryEarlyTerminationModelSequence +
			'}';
		}
	}
}
